/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.XdmValue;

/**
 *
 * @author isabe
 */
public class PesquisasXPATH {

    public static ArrayList PesquisaJogadorNome(String pesquisa) throws SaxonApiException {

        String xp = "//jogador[@nome ='" + pesquisa + "']";

        System.out.println(xp);
        
        XdmValue res = XPathFunctions.executaXpath(xp, "jogador.xml");

        String s = XPathFunctions.listaResultado(res);
        
        System.out.println(s);
        
        ArrayList<String> jogador = new ArrayList();

        if (res == null) {
            System.out.println("Ficheiro XML não existe");
        } else if (res.size() == 0) {
            System.out.println("Sem resultados");
        } else {
            jogador.add(s);
        }
        return jogador;
    }
}
