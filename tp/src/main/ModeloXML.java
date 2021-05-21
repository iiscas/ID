package main;

import java.util.Iterator;
import java.util.List;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.XdmValue;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;

public class ModeloXML {

    public static Document adicionaJogador(Jogador j, Document doc) {
        int count1 = 0;
        Element raiz;
        if (doc == null) {
            raiz = new Element("jogadores"); //cria <jogadores>
            doc = new Document(raiz);
        } else {
            raiz = doc.getRootElement();

            Element jogador = new Element("jogador");
            Element nCompleto = new Element("nomecompleto").addContent(j.getNomeCompleto());
            jogador.addContent(nCompleto);
            Element alcunha = new Element("alcunha").addContent(j.getAlcunha());
            jogador.addContent(alcunha);
            Element nacionalidade = new Element("nacionalidade").addContent(j.getNacionalidade());
            jogador.addContent(nacionalidade);

            Element foto = new Element("foto").addContent(j.getFoto());
            jogador.addContent(foto);
            Element dataN = new Element("datanascimento").addContent(j.getDataNasc());
            jogador.addContent(dataN);
            Element idade = new Element("idade").addContent(Integer.toString(j.getIdade()));
            jogador.addContent(idade);
            Element altura = new Element("altura").addContent(j.getAltura());
            jogador.addContent(altura);
            Element peso = new Element("peso").addContent(j.getPeso());
            jogador.addContent(peso);
            Element pe = new Element("pepreferido").addContent(j.getPe());
            jogador.addContent(pe);
            Element estado = new Element("estadoatual").addContent(j.getEstadoAtual());
            jogador.addContent(estado);
            Element pos = new Element("posicao").addContent(j.getPosicao());
            jogador.addContent(pos);

            Element contrato = new Element("valorcontrato").addContent(j.getContrato());
            jogador.addContent(contrato);
            Element sel = new Element("selecao").addContent(j.getSelecao());
            jogador.addContent(sel);
            for (int i = 0; i < j.clubesAnteriores.size(); i++) {

                Element clubesAnt = new Element("clubesanteriores").addContent(String.valueOf(j.clubesAnteriores.get(i)));
                jogador.addContent(clubesAnt);

            }
            Element clube = new Element("clubeatual").addContent(j.getClubeAtual());
            jogador.addContent(clube);
            for (int i = 0; i < j.trofeus.size(); i++) {

                Element trofeus = new Element("trofeus").addContent(String.valueOf(j.trofeus.get(i)));
                jogador.addContent(trofeus);

            }

            

            raiz.addContent(jogador);
            return doc;
        }

        return doc;

    }
}
