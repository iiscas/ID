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

        String er = "href=\"(/[^/]*/profil/spieler/[^\"]*)\"";

        Pattern p = Pattern.compile(er);
        Matcher m;
        Scanner ler = new Scanner(new FileInputStream("transfer.txt"));

        while (ler.hasNextLine()) {

            String linha = ler.nextLine();
            m = p.matcher(linha);

            if (m.find()) {

                ler.close();

                return "https://www.transfermarkt.pt" + m.group(1);
            }
        }

        ler.close();
        return null;

    }

    public static String Obtem_Alcunha(String pesquisa) throws FileNotFoundException, IOException {

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

    public static String Obtem_NomeCompleto(String pesquisa) throws IOException {

        String link = getLinkTransfer(pesquisa);
        //System.out.println(link);

        HttpRequestFunctions.httpRequest1("https://pt.wikipedia.org/wiki/", pesquisa, "jogadores.txt");

        String er = "<th style=\\\"[a-z\\-\\:\\s\\;]+\\\">Nome completo";
        String er1 = "</th>";
        String er2 = "<td[^>]*>([a-zA-ZÀ-ÿ\\s]+)";

        Pattern p = Pattern.compile(er);
        Pattern p1 = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);

        Scanner ler = new Scanner(new FileInputStream("jogadores.txt"));

        Matcher m, m1, m2;

        while (ler.hasNextLine()) {

            String linha = ler.nextLine();

            m = p.matcher(linha);

            if (m.find()) {
                linha = ler.nextLine();
                m1 = p1.matcher(linha);

                if (m1.find()) {
                    linha = ler.nextLine();
                    m2 = p2.matcher(linha);

                    if (m2.find()) {
                        ler.close();
                        return m2.group(1);
                    }
                }
            }

        }
        ler.close();
        return null;
    }

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
        //System.out.println(link);

        HttpRequestFunctions.httpRequest1(link, "", "jogadores.txt");

        String er = "<meta name=\\\"description\\\" content=\\\"[a-zA-Z\\s,0-9]+:\\s([a-zA-ZÀ-ÿ]+)\\b";
        String er1 = "&nbsp;&nbsp;([^<]*)</td>";

        Pattern p = Pattern.compile(er);
        Pattern p1 = Pattern.compile(er1);
        Scanner ler = new Scanner(new FileInputStream("jogadores.txt"));

        Matcher m, m1;

        while (ler.hasNextLine()) {

            String linha = ler.nextLine();
            m = p.matcher(linha);
            m1 = p1.matcher(linha);

            if (m.find()) {
                ler.close();
                return m.group(1);
            } else if (m1.find()) {
                ler.close();
                return m1.group(1);
            }

        }
        ler.close();
        return null;
    }

    public static String Obtem_PePreferido(String pesquisa) throws IOException {

        String link = getLinkTransfer(pesquisa);
        //System.out.println(link);

        HttpRequestFunctions.httpRequest1(link, "", "jogadores.txt");

        String er = "\\s+<th>Pé:</th>";
        String er1 = "\\s+<td>([^<]+)</td>";

        Pattern p = Pattern.compile(er);
        Pattern p1 = Pattern.compile(er1);

        Scanner ler = new Scanner(new FileInputStream("jogadores.txt"));

        Matcher m, m1;

        while (ler.hasNextLine()) {

            String linha = ler.nextLine();
            m = p.matcher(linha);

            if (m.find()) {
                
                linha = ler.nextLine();
                m1 = p1.matcher(linha);
                System.out.println(linha);
                if (m1.find()) {
                    ler.close();
                    return m1.group(1);
                }
            }

        }
        ler.close();
        return null;
    }

    public static String Obtem_Posicao(String pesquisa) throws IOException {

        //done
        String link = getLinkTransfer(pesquisa);
        //System.out.println(link);

        HttpRequestFunctions.httpRequest1(link, "", "jogadores.txt");

        String er = "<span class=\\\"dataItem\\\">Posição:</span>";
        String er1 = "[\\s]*<span class=\\\"dataValue\\\">[\\s]*";
        String er2 = "\\s+([À-ÿA-Z-a-z\\s]+)\\b\\s+</span>";

        Pattern p = Pattern.compile(er);
        Pattern p1 = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);

        Scanner ler = new Scanner(new FileInputStream("jogadores.txt"));

        Matcher m, m1, m2;

        while (ler.hasNextLine()) {

            String linha = ler.nextLine();
            m = p.matcher(linha);

            if (m.find()) {
                linha = ler.nextLine();
                m1 = p1.matcher(linha);

                if (m1.find()) {

                    linha = ler.nextLine();
                    m2 = p2.matcher(linha);

                    if (m2.find()) {
                        ler.close();
                        return m2.group(1);
                    }
                }

            }

        }

        ler.close();
        return null;
    }

    public static String Obtem_ClubeAtual(String pesquisa) throws IOException {

        //done
        String link = getLinkTransfer(pesquisa);
        //System.out.println(link);

        HttpRequestFunctions.httpRequest1(link, "", "jogadores.txt");

        String er = "Clube atual:";
        String er1 = "\\s+</th>";
        String er2 = "\\s+<td>";
        String er3 = "\\s+<a title=\\\"[a-zA-Z\\s\\-]+\\\" class=\\\"+[a-zA-Z0-9\\s\\\"=/><:\\.\\-]+\\?[a-z=0-9\\\"\\s]+([a-zA-Z-\\s]+)\\\"";
        String er4 = "<a class=\\\"[a-zA-Z\\s\\-\\_]+\\\" id=\\\"+[a-zA-Z0-9\\s\\\"=/><:\\.\\-]+\\?[a-z=0-9\\\"\\s]+[a-zA-Z-\\s=\\\"\\&]+\\;\\\"\\salt=\\\"([À-ÿA-Za-z\\s\\-]+)\\\"";

        Pattern p = Pattern.compile(er);
        Pattern p1 = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);
        Pattern p3 = Pattern.compile(er3);
        Pattern p4 = Pattern.compile(er4);

        Scanner ler = new Scanner(new FileInputStream("jogadores.txt"));

        Matcher m, m1, m2, m3, m4;

        while (ler.hasNextLine()) {

            String linha = ler.nextLine();
            m = p.matcher(linha);

            if (m.find()) {
                linha = ler.nextLine();
                m1 = p1.matcher(linha);

                if (m1.find()) {

                    linha = ler.nextLine();
                    m2 = p2.matcher(linha);

                    if (m2.find()) {
                        linha = ler.nextLine();
                        m3 = p3.matcher(linha);
                        m4 = p4.matcher(linha);

                        if (m3.find()) {
                            ler.close();
                            return m3.group(1);
                        } else if (m4.find()) {
                            ler.close();
                            return m4.group(1);
                        }
                    }

                }

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

        String er = "<title>[^\"]+</title>";
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

        String er = "<title>[^\"]+</title>";
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

        String er = "<title>[^\"]+</title>";
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

        String link = getLinkTransfer(pesquisa);
        String retornar = "Informação indisponível";
        //System.out.println(link);

        HttpRequestFunctions.httpRequest1(link, "", "jogadores.txt");

        String er = "<th>Empresários:</th>";
        String er1 = "\\s+<td>";
        String er2 = "\\s+<a href=\\\"[^>]*>([À-ÿ0-9A-Za-z\\.\\s\\']+)</a>";

        Pattern p = Pattern.compile(er);
        Pattern p1 = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);

        Scanner ler = new Scanner(new FileInputStream("jogadores.txt"));

        Matcher m, m1, m2;

        while (ler.hasNextLine()) {

            String linha = ler.nextLine();
            m = p.matcher(linha);

            if (m.find()) {
                linha = ler.nextLine();
                m1 = p1.matcher(linha);

                if (m1.find()) {

                    linha = ler.nextLine();
                    m2 = p2.matcher(linha);

                    if (m2.find()) {
                        ler.close();
                        return m2.group(1);
                    }
                }
            }

        }

        ler.close();
        return retornar;
    }

    public static String Obtem_Idade(String pesquisa) throws IOException {

        String link = getLinkTransfer(pesquisa);

        HttpRequestFunctions.httpRequest1(link, "", "jogadores.txt");

        String er = "<meta name=\\\"description\\\" content=\\\"[a-zA-Z\\s,]+([0-9]+)[a-zA-Z\\s,]+\\b";
        String er1 = "<th>Idade:</th>";
        String er2 = "<td>([0-9]+)</td>";
        String er3 = "<span class=\\\"dataItem\\\">Falecido:</span>";
        String er4 = "<span itemprop=\\\"deathDate\\\" class=\\\"dataValue\\\">[0-9\\s\\.]+\\s\\(([0-9]+)\\)</span>";

        Pattern p = Pattern.compile(er);
        Pattern p1 = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);
        Pattern p3 = Pattern.compile(er3);
        Pattern p4 = Pattern.compile(er4);

        Scanner ler = new Scanner(new FileInputStream("jogadores.txt"));

        Matcher m, m1, m2, m3, m4;

        while (ler.hasNextLine()) {

            String linha = ler.nextLine();
            m = p.matcher(linha);
            m1 = p1.matcher(linha);
            m3 = p3.matcher(linha);

            if (m.find()) {
                ler.close();
                return m.group(1);

            } else if (m1.find()) {

                linha = ler.nextLine();
                m2 = p2.matcher(linha);

                if (m2.find()) {

                    ler.close();
                    return m2.group(1);
                }
            } else if (m3.find()) {

                linha = ler.nextLine();
                m4 = p4.matcher(linha);

                if (m4.find()) {

                    ler.close();
                    return m4.group(1);
                }
            }

        }
        ler.close();
        return null;
    }

    public static String Obtem_Ranking(String pesquisa) throws IOException {
        HttpRequestFunctions.httpRequest1("https://en.wikipedia.org/wiki/", pesquisa, "jogadores.txt");

        String er = "<title>[^\"]+</title>";
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

    public static String Obtem_ValorContrato(String pesquisa) throws IOException {
        HttpRequestFunctions.httpRequest1("https://en.wikipedia.org/wiki/", pesquisa, "jogadores.txt");

        String er = "<title>[^\"]+</title>";
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
        HttpRequestFunctions.httpRequest2(link, "", "zerozero_google.txt");

        String er = "<span>Nascimento</span>([0-9-]+)<span class=\\\"small\\\">";

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
