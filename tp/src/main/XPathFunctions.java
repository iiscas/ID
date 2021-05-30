package main;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import net.sf.saxon.s9api.DocumentBuilder;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.XPathCompiler;
import net.sf.saxon.s9api.XPathSelector;
import net.sf.saxon.s9api.XdmItem;
import net.sf.saxon.s9api.XdmNode;
import net.sf.saxon.s9api.XdmValue;
import org.xml.sax.SAXException;


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
        ArrayList<String> ids = new ArrayList<String>();
        
        ids.add(0, "Nome completo"); ids.add(1, "Nacionalidade");
        ids.add(2, "Foto"); ids.add(3, "Data Nascimento"); ids.add(4, "Idade");
        ids.add(5, "Altura"); ids.add(6, "Peso");
        ids.add(7, "Pe preferido"); ids.add(8, "Estado Atual");
        ids.add(9, "Posicao"); ids.add(10, "Valor do contrato");
        ids.add(11, "Selecao"); ids.add(12, "Clube Atual");
        ids.add(13, "Trofeu"); ids.add(14, "Trofeu");
        ids.add(15, "Trofeu"); ids.add(16, "Trofeu");
        ids.add(17, "Clube Anterior");ids.add(18, "Clube Anterior");
        ids.add(19, "Clube Anterior"); ids.add(20, "Clube Anterior");
        
        for (int i = 0; i < lista.size(); i++) {
            XdmItem item = lista.itemAt(i);
            System.out.println(item.getStringValue());
            texto = texto.append(ids.get(i)).append("  --  ").append(item.getStringValue()).append("\n\n");
        }
        return texto.toString();
    }

    static String listaResultado(XdmValue lista) {
        StringBuilder texto = new StringBuilder();
        for (XdmItem item : lista) {
            texto = texto.append(item.getStringValue()).append("\n\n");
        }
        return texto.toString();
    }

}
