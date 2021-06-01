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

    static String listaResultado(XdmValue lista) {
        StringBuilder texto = new StringBuilder();
        for (XdmItem item : lista) {
            texto = texto.append(item.getStringValue()).append("\n");
        }
        return texto.toString();
    }
   

}
