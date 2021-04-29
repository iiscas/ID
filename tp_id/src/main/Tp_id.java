/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import static main.Wrappers.Obtem_Alcunha;


/**
 *
 * @author isabe
 */
public class Tp_id {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        String nome;
        nome = Obtem_Alcunha("Cristiano Ronaldo");
        System.out.println(nome);
    }
    
}
