/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Wrappers {

    public static String getLinkTransfer(String nome) throws IOException {

        String link = "https://www.transfermarkt.pt/schnellsuche/ergebnis/schnellsuche?query=";
        HttpRequestFunctions.httpRequest1(link, nome, "transfer.txt");

        String er = "href=\"/([a-z-]+/profil/spieler/[0-9]+)\">";

        Pattern p = Pattern.compile(er);
        Matcher m;
        Scanner ler = new Scanner(new FileInputStream("transfer.txt"));

        while (ler.hasNextLine()) {

            String linha = ler.nextLine();
            m = p.matcher(link);

            if (m.find()) {
                ler.close();
                System.out.println("https://www.transfermarkt.pt/" + m.group(1));
                return "https://www.transfermarkt.pt/" + m.group(1);
            }
        }
        
        
        ler.close();
        return null;

    }
     public static String getLinkZeroZero(String nome) throws IOException {

        String link = "https://www.google.com/search?q=";
        
        HttpRequestFunctions.httpRequest1(link, nome + "zerozero", "zerozero_google.txt");

        String er = "href=\"(https://www\\.zerozero\\.pt/jogador\\.php\\?id=[0-9]+)";

        Pattern p = Pattern.compile(er);
        Matcher m;
        Scanner ler = new Scanner(new FileInputStream("zerozero_google.txt"));

        while (ler.hasNextLine()) {

            String linha = ler.nextLine();
            m = p.matcher(link);

            if (m.find()) {
                ler.close();
                System.out.println(m.group(1));
                return  m.group(1);
            }
        }
        
        
        ler.close();
        return null;

    }

    public static String Obtem_Nome(String pesquisa) throws FileNotFoundException, IOException {

        HttpRequestFunctions.httpRequest1("https://en.wikipedia.org/wiki/", pesquisa, "jogadores.html");

        String er = "<title>([A-Za-zÀ-ÿ\\s]+)"; //ainda há alguns jogadores a não dar

        Pattern p = Pattern.compile(er);
        Scanner ler = new Scanner(new FileInputStream("jogadores.html"));
        Matcher m;

        while (ler.hasNextLine()) {

            String linha = ler.nextLine();
            m = p.matcher(linha);

            while (m.find()) {
                ler.close();
                return m.group(1); //devolve cristiano sem title antes, se for m.group() devolve o title tb
            }

        }
        ler.close();
        return null;
    }

    /*public static String Obtem_Alcunha(String pesquisa) throws IOException {
         HttpRequestFunctions.httpRequest1("https://en.wikipedia.org/wiki/", pesquisa, "jogadores.txt");

        String er ="<h1[a-zA-Z\\s=\\\"]+>"+pesquisa+"</h1>";
        Pattern p = Pattern.compile(er);
        Scanner ler = new Scanner(new FileInputStream("jogadores.txt"));
        
        Matcher m;

        while (ler.hasNextLine()) {

            String linha = ler.nextLine();
            m = p.matcher(linha);

            while (m.find()) {
                ler.close();
                return m.group(1);
            }

        }
        ler.close();
        return null;
    }*/
    public static String Obtem_Fotografia(String pesquisa) throws IOException {
        
        
        HttpRequestFunctions.httpRequest1("https://en.wikipedia.org/wiki/", pesquisa, "jogadores.txt");

        String er = "<meta property=\"og:image\" content=\"https://upload.wikimedia.org/wikipedia/commons/[a-zA-Z0-9]+[/]+[a-zA-Z0-9]+[/]([a-zA-Z0-9\\S]+)\"/>";
        Pattern p = Pattern.compile(er);
        Scanner ler = new Scanner(new FileInputStream("jogadores.txt"));

        Matcher m;

        while (ler.hasNextLine()) {

            String linha = ler.nextLine();
            m = p.matcher(linha);

            while (m.find()) {
                ler.close();
                return m.group(1);
            }

        }
        ler.close();
        return null;
    }

    public static String Obtem_Nacionalidade(String pesquisa) throws IOException {
        //funciona bem pelo regex supostamente
        
        String link = getLinkTransfer(pesquisa);

        
        HttpRequestFunctions.httpRequest1(link, "", "jogadores.html");

        String er = "<meta name=\\\"description\\\" content=\\\"[a-zA-Z\\s,0-9]+:\\s([a-zA-Z]+)\\b";
        Pattern p = Pattern.compile(er);
        Scanner ler = new Scanner(new FileInputStream("jogadores.html"));

        Matcher m;

        while (ler.hasNextLine()) {

            String linha = ler.nextLine();
            m = p.matcher(linha);

            while (m.find()) {
                ler.close();
                return m.group(2);
            }

        }
        ler.close();
        return null;
    }

    public static String Obtem_PePreferido(String pesquisa) throws IOException {
        
        //supostamente a regex esta bem
        
       String link = getLinkZeroZero(pesquisa);
        HttpRequestFunctions.httpRequest2(link,"", "zerozero_google.txt");

        String er = "<span>Pé preferencial<\\/span>([a-zA-Z]+)<\\/div>";
        Pattern p = Pattern.compile(er);
        Scanner ler = new Scanner(new FileInputStream("jogadores.txt"));

        Matcher m;

        while (ler.hasNextLine()) {

            String linha = ler.nextLine();
            m = p.matcher(linha);

            while (m.find()) {
                ler.close();
                return m.group(1);
            }

        }
        ler.close();
        return null;
    }

    public static String Obtem_Posicao(String pesquisa) throws IOException {

        
        String link = getLinkZeroZero(pesquisa);
        HttpRequestFunctions.httpRequest2(link,"", "zerozero_google.txt");

        String er = "<span>Posição</span><tr><td class=\"label\"></td><td>([^<]+)</td>";
        Pattern p = Pattern.compile(er);
        Scanner ler = new Scanner(new FileInputStream("jogadores.txt"));

        Matcher m;

        while (ler.hasNextLine()) {

            String linha = ler.nextLine();
            m = p.matcher(linha);

            while (m.find()) {
                ler.close();
                return m.group(1);
            }

        }
        ler.close();
        return null;
    }

    public static String Obtem_ClubeATual(String pesquisa) throws IOException {
        HttpRequestFunctions.httpRequest1("https://en.wikipedia.org/wiki/", pesquisa, "jogadores.txt");

        String er = "<span>Clube atual<\\/span><div class=\"micrologo_and_text\"><div class=\\\"image\\\"><a href=\"\\/pais.php\\?id=[0-9]+\\\"><img src=[a-zA-ZÀ-ÿ\\s\\w\\d\\:\\/\\-\\_\\\"\\.\\=\\;]+><\\/a><\\/div><div class=\"text\">([a-zA-Z\\s])+<\\/div>";
        Pattern p = Pattern.compile(er);
        Scanner ler = new Scanner(new FileInputStream("jogadores.txt"));

        Matcher m;

        while (ler.hasNextLine()) {

            String linha = ler.nextLine();
            m = p.matcher(linha);

            while (m.find()) {
                ler.close();
                return m.group(1);
            }

        }
        ler.close();
        return null;
    }
    
    public static String Obtem_ClubeAnterior(String pesquisa) {
        return null;
    }

    public static String Obtem_Selecao(String pesquisa) throws IOException {
         HttpRequestFunctions.httpRequest1("https://en.wikipedia.org/wiki/", pesquisa, "jogadores.txt");

        String er ="<title>[^\"]+</title>";
        Pattern p = Pattern.compile(er);
        Scanner ler = new Scanner(new FileInputStream("jogadores.txt"));
        
        Matcher m;

        while (ler.hasNextLine()) {

            String linha = ler.nextLine();
            m = p.matcher(linha);

            while (m.find()) {
                ler.close();
                return m.group(1);
            }

        }
        ler.close();
        return null;
    }

    public static String Obtem_Premios(String pesquisa) throws IOException {
         HttpRequestFunctions.httpRequest1("https://en.wikipedia.org/wiki/", pesquisa, "jogadores.txt");

        String er ="<title>[^\"]+</title>";
        Pattern p = Pattern.compile(er);
        Scanner ler = new Scanner(new FileInputStream("jogadores.txt"));
        
        Matcher m;

        while (ler.hasNextLine()) {

            String linha = ler.nextLine();
            m = p.matcher(linha);

            while (m.find()) {
                ler.close();
                return m.group(1);
            }

        }
        ler.close();
        return null;
    }

    public static String Obtem_EstadoAtual(String pesquisa) throws FileNotFoundException, IOException {
         HttpRequestFunctions.httpRequest1("https://en.wikipedia.org/wiki/", pesquisa, "jogadores.txt");

        String er ="<title>[^\"]+</title>";
        Pattern p = Pattern.compile(er);
        Scanner ler = new Scanner(new FileInputStream("jogadores.txt"));
        
        Matcher m;

        while (ler.hasNextLine()) {

            String linha = ler.nextLine();
            m = p.matcher(linha);

            while (m.find()) {
                ler.close();
                return m.group(1);
            }

        }
        ler.close();
        return null;
    }

    public static String Obtem_Empresario(String pesquisa) throws FileNotFoundException, IOException {
        String link = getLinkZeroZero(pesquisa);
        HttpRequestFunctions.httpRequest2(link,"", "zerozero_google.txt");

        String er ="<span>Agente</span><a href=[a-z0-9\\s\\.\\?=\\\"]+>([a-zA-Z\\s]+)</a>";
        Pattern p = Pattern.compile(er);
        Scanner ler = new Scanner(new FileInputStream("jogadores.txt"));
        
        Matcher m;

        while (ler.hasNextLine()) {

            String linha = ler.nextLine();
            m = p.matcher(linha);

            while (m.find()) {
                ler.close();
                return m.group(1);
            }

        }
        ler.close();
        return null;
    }

    public static String Obtem_Idade(String pesquisa) throws IOException {
        
       String link = getLinkTransfer(pesquisa);

        
        HttpRequestFunctions.httpRequest1(link, "", "jogadores.html");

        String er ="<meta name=\\\"description\\\" content=\\\"[a-zA-Z\\s,]+([0-9]+)[a-zA-Z\\s,]+\\b";
        
        Pattern p = Pattern.compile(er);
        Scanner ler = new Scanner(new FileInputStream("jogadores.txt"));
        
        Matcher m;

        while (ler.hasNextLine()) {

            String linha = ler.nextLine();
            m = p.matcher(linha);

            while (m.find()) {
                ler.close();
                return m.group(1);
            }

        }
        ler.close();
        return null;
    }

    public static int Obtem_Ranking(String pesquisa) throws IOException {
         HttpRequestFunctions.httpRequest1("https://en.wikipedia.org/wiki/", pesquisa, "jogadores.txt");

        String er ="<title>[^\"]+</title>";
        Pattern p = Pattern.compile(er);
        Scanner ler = new Scanner(new FileInputStream("jogadores.txt"));
        
        Matcher m;

        while (ler.hasNextLine()) {

            String linha = ler.nextLine();
            m = p.matcher(linha);

            while (m.find()) {
                ler.close();
                return m.group(1);
            }

        }
        ler.close();
        return null;
    }

    public static double Obtem_ValorContrato(String pesquisa) throws IOException {
        HttpRequestFunctions.httpRequest1("https://en.wikipedia.org/wiki/", pesquisa, "jogadores.txt");

        String er ="<title>[^\"]+</title>";
        Pattern p = Pattern.compile(er);
        Scanner ler = new Scanner(new FileInputStream("jogadores.txt"));
        
        Matcher m;

        while (ler.hasNextLine()) {

            String linha = ler.nextLine();
            m = p.matcher(linha);

            while (m.find()) {
                ler.close();
                return m.group(1);
            }

        }
        ler.close();
        return null;
    }

    public static String Obtem_DataNascimento(String pesquisa) throws IOException {
         String link = getLinkZeroZero(pesquisa);
        HttpRequestFunctions.httpRequest2(link,"", "zerozero_google.txt");

        String er ="<span>Nascimento</span>([0-9-]+)<span class=\\\"small\\\">";

        Pattern p = Pattern.compile(er);
        Scanner ler = new Scanner(new FileInputStream("jogadores.txt"));
        
        Matcher m;

        while (ler.hasNextLine()) {

            String linha = ler.nextLine();
            m = p.matcher(linha);

            while (m.find()) {
                ler.close();
                return m.group(1);
            }

        }
        ler.close();
        return null;

    }
    
}
