/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.util.List;
import net.sf.saxon.s9api.DocumentBuilder;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.XPathCompiler;
import net.sf.saxon.s9api.XPathSelector;
import net.sf.saxon.s9api.XdmItem;
import net.sf.saxon.s9api.XdmNode;
import net.sf.saxon.s9api.XdmValue;

/**
 *
 * @author abs
 */
public class XPathFunctions {

    static XdmValue executaXpath(String xp, String xmlFile) throws SaxonApiException {
        XdmValue resultado = null;
        File f = new File(xmlFile);
        if (f.exists()) {
            Processor proc = new Processor(false);
            XPathCompiler xpath = proc.newXPathCompiler();

            DocumentBuilder builder = proc.newDocumentBuilder();

            XdmNode xml = builder.build(new File(xmlFile));
            XPathSelector selector = xpath.compile(xp).load();

            selector.setContextItem(xml);
            resultado = selector.evaluate();
        }
        return resultado;
    }

    static String listaResultadoNome(XdmValue lista) {
        StringBuilder texto = new StringBuilder();
        //System.out.println("RESULTADO DA PESQUISA XPATH:");
       
        for(int i=0;i<13;i++){ 
            XdmItem item=lista.itemAt(i);
            System.out.println(item.getStringValue());
            texto = texto.append(item.getStringValue()).append("\n\n");
        }
        return texto.toString();
    }
    static String listaResultado(XdmValue lista) {
        StringBuilder texto = new StringBuilder();
        //System.out.println("RESULTADO DA PESQUISA XPATH:");
       
        
        for (XdmItem item : lista) {
         //   System.out.println(item.getStringValue());
           texto = texto.append(item.getStringValue()).append("\n\n");
            
       }
        return texto.toString();
    }

}
