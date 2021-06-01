package main;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;
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

    public static String getLinkZeroZero(String nome) throws IOException {
        String link = "https://www.zerozero.pt/search.php?inputString=" + nome.replace(" ", "+") + "&op=all";
        HttpRequestFunctions.httpRequest2(link, "", "zero.txt");

        String ER1 = "<a href=\"(jogador\\.php\\?id=[0-9]+&search=1)\">";
        Pattern p1 = Pattern.compile(ER1);

        Matcher m1;

        Scanner input = new Scanner(new FileInputStream("zero.txt"));
        while (input.hasNextLine()) {
            String linha = input.nextLine();
            m1 = p1.matcher(linha);

            if (m1.find()) {
                input.close();
                return "https://www.zerozero.pt/" + m1.group(1);
            }
        }
        input.close();
        return null;
    }

    public static String Obtem_Alcunha(String pesquisa) throws FileNotFoundException, IOException {

        HttpRequestFunctions.httpRequest1("https://pt.wikipedia.org/wiki/", pesquisa, "jogadores.txt");
        String alcunha;
        String x = "Nao disponivel";
        String er = "<title>([A-Za-zÀ-ÿ]+)(\\s[A-Za-zÀ-ÿ]+)";

        Pattern p = Pattern.compile(er);
        Scanner ler = new Scanner(new FileInputStream("jogadores.txt"));
        Matcher m;

        while (ler.hasNextLine()) {

            String linha = ler.nextLine();
            m = p.matcher(linha);

            while (m.find()) {
                ler.close();
                alcunha = m.group(1) + m.group(2);
                return alcunha; //devolve cristiano sem title antes, se for m.group() devolve o title tb
            }

        }
        ler.close();
        return x;
    }

    public static String Obtem_NomeCompleto(String pesquisa) throws IOException {

        HttpRequestFunctions.httpRequest1("https://pt.wikipedia.org/wiki/", pesquisa, "jogadores.txt");

        String er = "<th[^>]*>Nome completo";
        String er1 = "</th>";
        String er2 = "<td[^>]*>([a-zA-ZÀ-ÿ\\s]+)";
        String x = "Nao disponivel";

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
        return x;
    }

    public static String Obtem_Fotografia(String pesquisa) throws IOException {

        String link = getLinkTransfer(pesquisa);

        HttpRequestFunctions.httpRequest1(link, "", "jogadores.txt");
        String x = "Nao disponivel";
        String er = "<meta property=\"og:image\" content=\"([^\"]+)[^>]+>";
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
        return x;
    }

    public static String Obtem_Nacionalidade(String pesquisa) throws IOException {

        String link = getLinkTransfer(pesquisa);

        HttpRequestFunctions.httpRequest1(link, "", "jogadores.txt");

        String er = "<meta name=\"description\" content=\"[a-zA-Z\\s,0-9]+:\\s([a-zA-ZÀ-ÿ]+)\\b";
        String er1 = "&nbsp;&nbsp;([^<]*)</td>";
        String x = "Nao disponivel";

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
        return x;
    }

    public static String Obtem_PePreferido(String pesquisa) throws IOException {

        String link = getLinkTransfer(pesquisa);

        HttpRequestFunctions.httpRequest1(link, "", "jogadores.txt");

        String er = "\\s+<th>Pé:</th>";
        String er1 = "<td>([a-z]*)</td>";
        String x = "Nao disponivel";

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

                if (m1.find()) {
                    ler.close();
                    return m1.group(1);
                }
            }

        }
        ler.close();
        return x;
    }

    public static String Obtem_Posicao(String pesquisa) throws IOException {

        String link = getLinkTransfer(pesquisa);

        HttpRequestFunctions.httpRequest1(link, "", "jogadores.txt");

        String er = "<span class=\"dataItem\">Posição:</span>";
        String er1 = "[\\s]*<span class=\"dataValue\">[\\s]*";
        String er2 = "\\s+([À-ÿA-Z-a-z\\s]+)\\b\\s+</span>";
        String x = "Nao disponivel";

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
        return x;
    }

    public static String Obtem_ClubeAtual(String pesquisa) throws IOException {

        String link = getLinkTransfer(pesquisa);

        HttpRequestFunctions.httpRequest1(link, "", "jogadores.txt");

        String x = "Nao disponivel";
        String er = "Clube atual:";
        String er1 = "\\s+</th>";
        String er2 = "\\s+<td>";
        String er3 = "\\s+<a title=\"[a-zA-Z\\s\\-]+\" class=\"+[a-zA-Z0-9\\s\"=/><:\\.\\-]+\\?[a-z=0-9\"\\s]+([a-zA-Z-\\s]+)\"";
        String er4 = "<a class=\"[a-zA-Z\\s\\-\\_]+\" id=\"+[a-zA-Z0-9\\s\"=/><:\\.\\-]+\\?[a-z=0-9\"\\s]+[a-zA-Z-\\s=\"\\&]+\\;\"\\salt=\"([À-ÿA-Za-z\\s\\-]+)\"";

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
        return x;
    }

    public static ArrayList<String> Obtem_ClubeAnterior(String pesquisa) throws IOException {

        ArrayList<String> Clubes = new ArrayList<String>();

        String link = getLinkTransfer(pesquisa);

        HttpRequestFunctions.httpRequest1(link, "", "jogadores.txt");

        //String er = "<td class[^>]+><a class=[^>]+>([^<]+)<\\/a><\\/td>";
        String er = "<td class=\"hauptlink no-border-links vereinsname\"><a class=\"vereinprofil_tooltip\" id=\"([0-9])+\" href=\"([^\"]+)\">([^<]+)</a></td>";

        Pattern p = Pattern.compile(er);
        Scanner ler = new Scanner(new FileInputStream("jogadores.txt"));

        Matcher m;
        int i = 0;
        while (ler.hasNextLine() && i < 4) {

            String linha = ler.nextLine();
            m = p.matcher(linha);

            if (m.find()) {

                Clubes.add(m.group(3));
                i++;
            }
        }

        ler.close();
        return Clubes;
    }

    public static String Obtem_Selecao(String pesquisa) throws IOException {

        String link = getLinkTransfer(pesquisa);
        String x = "Não convocado";

        HttpRequestFunctions.httpRequest1(link, "", "jogadores.txt");

        String er0 = "<th colspan=\"[0-9]+\" >Seleção nacional</th>";
        String er = "<a class=[^>]*>([^<]+)</a>";

        Pattern p1 = Pattern.compile(er);
        Pattern p0 = Pattern.compile(er0);
        Matcher m0, m1;

        Scanner ler = new Scanner(new FileInputStream("jogadores.txt"));

        while (ler.hasNextLine()) {

            String linha = ler.nextLine();
            m0 = p0.matcher(linha);

            if (m0.find()) {
                while (ler.hasNextLine()) {

                    linha = ler.nextLine();
                    m1 = p1.matcher(linha);

                    if (m1.find()) {

                        ler.close();
                        return m1.group(1);
                    }
                }
            }

        }
        ler.close();
        return x;
    }

    public static String Obtem_EstadoAtual(String pesquisa) throws FileNotFoundException, IOException {

        String link = getLinkZeroZero(pesquisa);

        String x = "Nao disponivel";
        HttpRequestFunctions.httpRequest2(link, "", "jogadores.txt");

        String er = "<span>Situação</span>([^<0-9-]+)[^>]+>";

        Pattern p = Pattern.compile(er);
        Scanner ler = new Scanner(new FileInputStream("jogadores.txt"), "windows-1252");

        Matcher m;

        while (ler.hasNextLine()) {

            String linha = ler.nextLine();
            m = p.matcher(linha);

            if (m.find()) {
                ler.close();
                return m.group(1);

            }

        }

        ler.close();
        return x;
    }

    public static String Obtem_Empresario(String pesquisa) throws FileNotFoundException, IOException {

        String link = getLinkTransfer(pesquisa);
        String x = "Nao disponivel";

        HttpRequestFunctions.httpRequest1(link, "", "jogadores.txt");

        String er = "<th>Empresários:</th>";
        String er1 = "\\s+<td>";
        String er2 = "\\s+<a href=\"[^>]*>([À-ÿ0-9A-Za-z\\.\\s\\']+)</a>";

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
        return x;
    }

    public static int Obtem_Idade(String pesquisa) throws IOException {

        String link = getLinkTransfer(pesquisa);

        HttpRequestFunctions.httpRequest1(link, "", "jogadores.txt");

        String er = "<meta name=\"description\" content=\"[a-zA-Z\\s,]+([0-9]+)[a-zA-Z\\s,]+\\b";
        String er1 = "<th>Idade:</th>";
        String er2 = "<td>([0-9]+)</td>";
        String er3 = "<span class=\"dataItem\">Falecido:</span>";
        String er4 = "<span itemprop=\"deathDate\" class=\"dataValue\">[0-9\\s\\.]+\\s\\(([0-9]+)\\)</span>";

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
                return Integer.parseInt(m.group(1));

            } else if (m1.find()) {

                linha = ler.nextLine();
                m2 = p2.matcher(linha);

                if (m2.find()) {

                    ler.close();
                    return Integer.parseInt(m2.group(1));
                }
            } else if (m3.find()) {

                linha = ler.nextLine();
                m4 = p4.matcher(linha);

                if (m4.find()) {

                    ler.close();
                    return Integer.parseInt(m4.group(1));
                }
            }

        }
        ler.close();
        return -1;
    }

    public static String Obtem_Ranking(String pesquisa) throws IOException {

        String link = getLinkTransfer(pesquisa);
        String x = "Nao disponivel";

        HttpRequestFunctions.httpRequest1(link, "", "jogadores.txt");

        String er = "<span class=\"dataRN\">([^<]+)</span>";
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
        return x;
    }

    public static String Obtem_ValorContrato(String pesquisa) throws IOException {

        String link = getLinkTransfer(pesquisa);

        HttpRequestFunctions.httpRequest1(link, "", "jogadores.txt");

        String er = "<meta name=\"description\" content=\"[^V]+[V]*[^V]+ Valor de Mercado:\\s([0-9\\s\\,a-zA-Z€]+)";
        String x = "Nao disponivel";
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
        return x;
    }

    public static String Obtem_DataNascimento(String pesquisa) throws IOException {

        HttpRequestFunctions.httpRequest1("https://pt.wikipedia.org/wiki/", pesquisa, "jogadores.txt");

        String er = "<td[^>]*><a[^N]+Nascimentos\"[^\"]+\"([^\"]+)\"[^<]+</a>([\\sde]+)[^>]+>([0-9]+)</a>";
        String x = "Nao disponivel";

        Pattern p = Pattern.compile(er);
        Scanner ler = new Scanner(new FileInputStream("jogadores.txt"));

        Matcher m;

        while (ler.hasNextLine()) {

            String linha = ler.nextLine();
            m = p.matcher(linha);

            while (m.find()) {
                ler.close();
                String data = m.group(1) + m.group(2) + m.group(3);
                return data;
            }

        }
        ler.close();
        return x;

    }

    public static String Obtem_Altura(String pesquisa) throws FileNotFoundException, IOException {

        HttpRequestFunctions.httpRequest1("https://pt.wikipedia.org/wiki/", pesquisa, "jogadores.txt");

        String er = "<th[^>]*>Altura";
        String er1 = "</th>";
        String er2 = "<td[^>]*>([0-9\\s\\,m]+)";
        String x = "Nao disponivel";

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
        return x;
    }

    public static ArrayList<String> Obtem_Trofeus(String pesquisa) throws IOException {

        ArrayList<String> Trofeus = new ArrayList<String>();

        String link = getLinkTransfer(pesquisa);

        HttpRequestFunctions.httpRequest1(link, "", "jogadores.txt");

        String er = "<img src=\"[^\"]+\"\\stitle=\"([^\"]+)\"\\salt=\"[^\"]+\"\\sclass=\"dataErfolgImage\" />";

        Pattern p = Pattern.compile(er);
        Scanner ler = new Scanner(new FileInputStream("jogadores.txt"));

        Matcher m;
        int i = 0;
        while (ler.hasNextLine() && i < 4) {

            String linha = ler.nextLine();
            m = p.matcher(linha);
            //System.out.println(linha);

            if (m.find()) {

                Trofeus.add(m.group(1));
                //System.out.println(linha);
                i++;
            }

        }

        ler.close();
        return Trofeus;
    }

    public static String Obtem_Peso(String pesquisa) throws IOException {

        String link = getLinkZeroZero(pesquisa);
        String x = "Nao disponivel";

        HttpRequestFunctions.httpRequest1(link, "", "jogadores.txt");

        String er = "<span>Peso</span>([0-9\\skg]+)</div>";

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

        return x;

    }

    public static Jogador novoJogador(String nome) throws IOException {
        Jogador a;

        String alcunha = Obtem_Alcunha(nome);
        String altura = Obtem_Altura(nome);
        String clubeAtual = Obtem_ClubeAtual(nome);
        String data = Obtem_DataNascimento(nome);
        String agente = Obtem_Empresario(nome);
        String estado = Obtem_EstadoAtual(nome);
        String foto = Obtem_Fotografia(nome);
        int idade = Obtem_Idade(nome);
        String nac = Obtem_Nacionalidade(nome);
        String nCompleto = Obtem_NomeCompleto(nome);
        String pe = Obtem_PePreferido(nome);
        String pos = Obtem_Posicao(nome);
        String rank = Obtem_Ranking(nome);
        String sel = Obtem_Selecao(nome);
        String contrato = Obtem_ValorContrato(nome);
        String peso = Obtem_Peso(nome);
        ArrayList<String> clubeAnt = Obtem_ClubeAnterior(nome);
        ArrayList<String> trofeus = Obtem_Trofeus(nome);

        a = new Jogador(alcunha, nCompleto, altura, data, peso, agente, estado, foto, nac, pe, pos, rank, clubeAtual, sel, contrato, clubeAnt, trofeus, idade);
        return a;

    }
}
