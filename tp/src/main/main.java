package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.jdom2.Document;

public class main {

    public static void main(String[] args) throws IOException {

        //String nome;
        Scanner ler = new Scanner(new FileInputStream("players.txt"));
        //ArrayList<String> Clubes = new ArrayList<String>();
        //ArrayList<String> Trofeus = new ArrayList<String>();

        //String novo=Wrappers.Obtem_Nacionalidade(nome);
        //System.out.println(novo);
        /* while (ler.hasNextLine()) {
            String linha = ler.nextLine();
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
            //Clubes = Wrappers.Obtem_ClubeAnterior(linha);
            //Trofeus = Wrappers.Obtem_Trofeus(linha);
            //nome = Wrappers.Obtem_Peso(linha);
            //nome=Wrappers.Obtem_EstadoAtual(linha);
            nome = Wrappers.getLinkZeroZero(linha); //nao está a encontrar os links de todos
            System.out.println(nome);
            //System.out.println("\n");
            // nome = Wrappers.getLinkZeroZero(linha);
            //System.out.println(nome);
            //System.out.println("\n");
         */
      /*  ArrayList<Jogador> all = new ArrayList();
        while (ler.hasNextLine()) {
            String nome = ler.nextLine();
            System.out.println(nome);
            Jogador x;
            x = Wrappers.novoJogador(nome);
            all.add(x);
        }

        for (int i = 0; i < all.size(); i++) {
            //Inicializa Doc XML
            Document doc = XMLJDomFunctions.lerDocumentoXML("jogador.xml");
            //Chama a função para adicionar o livro ao XML
            doc = ModeloXML.adicionaJogador(all.get(i), doc);
            //grava o ficheiro XML em disco
            XMLJDomFunctions.escreverDocumentoParaFicheiro(doc, "jogador.xml");
        }
*/
        Jogador a;
        a= Wrappers.novoJogador("Cristiano Ronaldo");
        
            System.out.println(a.getNacionalidade());
             System.out.println(a.getAlcunha());
             
        Document doc = XMLJDomFunctions.lerDocumentoXML("jogador.xml");
            //Chama a função para adicionar o livro ao XML
            doc = ModeloXML.adicionaJogador(a, doc);
            
            //grava o ficheiro XML em disco
            XMLJDomFunctions.escreverDocumentoParaFicheiro(doc, "jogador.xml");
    }

}
