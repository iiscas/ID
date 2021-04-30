package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        String nome;
        Scanner ler = new Scanner(new FileInputStream("C:\\Users\\isabe\\Documents\\GitHub\\ID\\tp\\src\\main\\p.txt"));

        while (ler.hasNextLine()) {
            String linha=ler.nextLine();
            nome = Wrappers.Obtem_Nome(linha);
            System.out.println(nome);
        }

    }

}
