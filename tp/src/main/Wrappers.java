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
     public static String Obtem_Nome(String pesquisa) throws FileNotFoundException, IOException {

       
        HttpRequestFunctions.httpRequest1("https://en.wikipedia.org/wiki/", pesquisa, "jogadores.txt");

        String er ="<p><b>[a-zA-Z\\s]+<//b>";
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

    public static String Obtem_Alcunha(String pesquisa) throws IOException {
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
    }

    /*public static String Obtem_Fotografia(String pesquisa) throws IOException {
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

    public static String Obtem_Nacionalidade(String pesquisa) throws IOException {
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

    public static String Obtem_PePreferido(String pesquisa) throws IOException {
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

    public static String Obtem_Posicao(String pesquisa) throws IOException {
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

    public static String Obtem_ClubeATual(String pesquisa) throws IOException {
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

    public static int Obtem_Idade(String pesquisa) throws IOException {
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

    public static LocalDate Obtem_DataNascimento(String pesquisa) throws IOException {
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
*/
}
