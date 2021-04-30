
package main;

import java.io.IOException;
import static main.Wrappers.Obtem_Nome;



public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String nome;
        nome = Obtem_Nome("Cristiano Ronaldo");
        System.out.println(nome);
    }
    
}
