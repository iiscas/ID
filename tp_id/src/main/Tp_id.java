/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jdom2.Document;


/**
 *
 * @author isabe
 */
public class Tp_id {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static String Obtem_Nome(String pesquisa) throws FileNotFoundException, IOException {

       
        HttpRequestFunctions.httpRequest1("https://en.wikipedia.org/wiki/", pesquisa, "jogadores.txt");

        String er ="<p><b>[a-zA-Z\\s]+<//b>";
        Pattern p = Pattern.compile(er);
        Scanner ler = new Scanner(new FileInputStream("jogadores.txt"));
        
        Matcher m;

        while (ler.hasNextLine()) {

            String linha = ler.nextLine();
            m = p.matcher(linha);
           // System.out.println("aqui");
            while (m.find()) {
                System.out.println("aqui");
                ler.close();
                return m.group(1);
            }

        }
        ler.close();
        return null;
    }
    public static void main(String[] args) throws IOException {
        String nome;
        nome = Obtem_Nome("Cristiano Ronaldo");
        System.out.println(nome);
    }
    
}
