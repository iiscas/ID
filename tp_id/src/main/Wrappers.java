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
import java.util.regex.Pattern;

/**
 *
 * @author isabe
 */
public class Wrappers {

    public static String Obtem_Nome(String pesquisa) throws FileNotFoundException, IOException {

        HttpRequestFunctions.httpRequest1("https://www.bertrand.pt/pesquisa/", pesquisa, "jogadores.txt");

        String er = "[a-zA-Z]+";
        Pattern p = Pattern.compile(er);
        Scanner ler = new Scanner(new FileInputStream("jogadores.txt"));
        
        return null;
    }

    public static String Obtem_Alcunha(String pesquisa) {
        return null;
    }

    public static String Obtem_Fotografia(String pesquisa) {
        return null;
    }

    public static String Obtem_Nacionalidade(String pesquisa) {
        return null;
    }

    public static String Obtem_PePreferido(String pesquisa) {
        return null;
    }

    public static String Obtem_Posicao(String pesquisa) {
        return null;
    }

    public static String Obtem_ClubeATual(String pesquisa) {
        return null;
    }

    public static String Obtem_ClubeAnterior(String pesquisa) {
        return null;
    }

    public static String Obtem_Selecao(String pesquisa) {
        return null;
    }

    public static String Obtem_Premios(String pesquisa) {
        return null;
    }

    public static String Obtem_EstadoAtual(String pesquisa) {
        return null;
    }

    public static String Obtem_Empresario(String pesquisa) {
        return null;
    }

    public static int Obtem_Idade(String pesquisa) {
        return 0;
    }

    public static int Obtem_Ranking(String pesquisa) {
        return 0;
    }

    public static double Obtem_ValorContrato(String pesquisa) {
        return 0;
    }

    public static LocalDate Obtem_DataNascimento(String pesquisa) {
        return null;

    }
}
