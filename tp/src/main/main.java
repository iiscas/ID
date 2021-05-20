package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // String nome="lionel-messi";
         String nome;
        Scanner ler = new Scanner(new FileInputStream("players.txt"));
          ArrayList<String> Clubes = new ArrayList<String>();
          
        //String novo=Wrappers.Obtem_Nacionalidade(nome);
        //System.out.println(novo);
        while (ler.hasNextLine()) {
            String linha=ler.nextLine();
           // nome = Wrappers.Obtem_Fotografia(linha);
            //nome = Wrappers.Obtem_Nome(linha);
            //nome = Wrappers.Obtem_Nacionalidade(linha);
            //nome = Wrappers.Obtem_ClubeAtual(linha);
            //nome = Wrappers.Obtem_Empresario(linha);
           // nome = Wrappers.Obtem_NomeCompleto(linha);
           // nome = Wrappers.Obtem_Alcunha(linha);
          // nome = Wrappers.Obtem_Selecao(linha);
           // nome=Wrappers.Obtem_Ranking(linha);
           // nome=Wrappers.Obtem_ValorContrato(linha);
            //nome=Wrappers.Obtem_Numero(linha);
            //nome = Wrappers.Obtem_PePreferido(linha);
            //nome=Wrappers.Obtem_Altura(linha);
            //nome=Wrappers.Obtem_DataNascimento(linha);
            Clubes = Wrappers.Obtem_ClubeAnterior(linha);
            
            System.out.println(Clubes);
            //System.out.println("\n");
           // nome = Wrappers.getLinkZeroZero(linha);
            //System.out.println(nome);
            //System.out.println("\n");
        }
        /*
        String nome = Wrappers.getLinkZeroZero("Cristiano Ronaldo");
        System.out.println(nome);
        String nome = Wrappers.Obtem_Nome("Cristiano Ronaldo");
        System.out.println(nome);
*/

    }

}
