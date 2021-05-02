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
        String nome="lionel-messi";
        Scanner ler = new Scanner(new FileInputStream("C:\\Users\\isabe\\Documents\\GitHub\\ID\\tp\\src\\main\\p.txt"));

        String novo=Wrappers.Obtem_Nacionalidade(nome);
        System.out.println(novo);
        /*while (ler.hasNextLine()) {
            String linha=ler.nextLine();
            nome = Wrappers.Obtem_Nacionalidade(linha);
            System.out.println(nome);
        }
*/

    }

}
