package main;

import java.util.Iterator;
import java.util.List;
import static main.XMLJDomFunctions.escreverDocumentoParaFicheiro;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.XdmValue;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;

public class ModeloXML {

    public static Document adicionaJogador(Jogador j, Document doc) throws SaxonApiException {

        Element raiz;
        XdmValue res = null;

        if (doc == null) {
            raiz = new Element("jogadores"); //cria <jogadores>
            doc = new Document(raiz);
        } else {
            raiz = doc.getRootElement();

            String xp = "//jogador[@nome ='" + j.getAlcunha() + "']";
            res = XPathFunctions.executaXpath(xp, "jogador.xml");

            if (res != null && res.size() > 0) {
                System.out.println("Jogador já existe!");
                return null;
            }
        }

        Element jogador = new Element("jogador");
        Attribute nome = new Attribute("nome", j.getAlcunha());
        jogador.setAttribute(nome);

        Element nCompleto = new Element("nomeCompleto").addContent(j.getNomeCompleto());
        jogador.addContent(nCompleto);

        Element nacionalidade = new Element("nacionalidade").addContent(j.getNacionalidade());
        jogador.addContent(nacionalidade);

        Element foto = new Element("foto").addContent(j.getFoto());
        jogador.addContent(foto);

        Element dataN = new Element("dataNascimento").addContent(j.getDataNasc());
        jogador.addContent(dataN);

        Element idade = new Element("idade").addContent(Integer.toString(j.getIdade()));
        jogador.addContent(idade);

        Element altura = new Element("altura").addContent(j.getAltura());
        jogador.addContent(altura);

        Element peso = new Element("peso").addContent(j.getPeso());
        jogador.addContent(peso);

        Element pe = new Element("pePreferido").addContent(j.getPe());
        jogador.addContent(pe);

        Element estado = new Element("estadoAtual").addContent(j.getEstadoAtual());
        jogador.addContent(estado);

        Element pos = new Element("posicao").addContent(j.getPosicao());
        jogador.addContent(pos);

        Element contrato = new Element("valorContrato").addContent(j.getContrato());
        jogador.addContent(contrato);

        Element sel = new Element("selecao").addContent(j.getSelecao());
        jogador.addContent(sel);

        Element clubesAnteriores = new Element("clubesAnterirores");
        for (int i = 0; i < j.clubesAnteriores.size(); i++) {

            Element clubesAnt = new Element("clubeAnterior").addContent(String.valueOf(j.clubesAnteriores.get(i)));
            clubesAnteriores.addContent(clubesAnt);
        }

        Element clube = new Element("clubeAtual").addContent(j.getClubeAtual());
        jogador.addContent(clube);

        Element trofeus = new Element("trofeus");
        for (int i = 0; i < j.trofeus.size(); i++) {

            Element trofeu = new Element("trofeu").addContent(String.valueOf(j.trofeus.get(i)));
            trofeus.addContent(trofeu);
        }

        jogador.addContent(trofeus);
        jogador.addContent(clubesAnteriores);

        raiz.addContent(jogador);

        return doc;

    }

    public static Document removeJogadorNome(String nome, Document doc) {

        Element raiz;
        if (doc == null) {
            System.out.println("Ficheiro não existe, nada a remover");
            return null;
        } else {
            raiz = doc.getRootElement();
        }
        List Jogadores = raiz.getChildren("jogador");
        boolean found = false;
        for (int i = 0; i < Jogadores.size(); i++) {

            Element Jogador = (Element) Jogadores.get(i);
            //System.out.println("Nome a procurar "+ nome);
            //System.out.println(Jogador.getAttributeValue("nome"));

            if (Jogador.getAttributeValue("nome").equals(nome)) {
                Jogador.getParent().removeContent(Jogador);
                System.out.println("Jogador" + nome + " foi removido com sucesso!");
                found = true;
            }

        }
        if (!found) {
            System.out.println("Jogador " + nome + " não foi encontrado");
            return null;
        }
        return doc;

    }

    public static Document alteraIdade(String nome, int novaIdade, Document doc) {
        Element raiz;
        if (doc == null) {
            System.out.println("Ficheiro não existe, nada a alterar");
            return null;
        } else {
            raiz = doc.getRootElement();
        }
        List Jogadores = raiz.getChildren("jogador");
        boolean found = false;
        for (int i = 0; i < Jogadores.size(); i++) {

            Element Jogador = (Element) Jogadores.get(i);

            if (Jogador.getAttributeValue("nome").equals(nome)) {
                System.out.println("Jogador " + nome + " tem " + Jogador.getChildText("idade") + " anos");
                Jogador.getChild("idade").setText(Integer.toString(novaIdade));
                found = true;
            }

        }
        if (!found) {
            System.out.println("Jogador " + nome + " não foi encontrado");
            return null;
        } else {
            System.out.println("Idade alterada!");
        }
        return doc;
    }

    public static Document alteraNacionalidade(String nome, String novaNacionalidade, Document doc) {
        Element raiz;
        if (doc == null) {
            System.out.println("Ficheiro não existe, nada a alterar");
            return null;
        } else {
            raiz = doc.getRootElement();
        }
        List Jogadores = raiz.getChildren("jogador");
        boolean found = false;
        for (int i = 0; i < Jogadores.size(); i++) {

            Element Jogador = (Element) Jogadores.get(i);

            if (Jogador.getAttributeValue("nome").equals(nome)) {
                System.out.println("Jogador " + nome + " tem nacionalidade: " + Jogador.getChildText("nacionalidade"));
                Jogador.getChild("nacionalidade").setText(novaNacionalidade);
                found = true;
            }

        }
        if (!found) {
            System.out.println("Jogador " + nome + " não foi encontrado");
            return null;
        } else {
            System.out.println("Nacionalidade alterada!");
        }
        return doc;
    }

    public static Document alteraClubeAtual(String nome, String novoClube, Document doc) {
        Element raiz;
        if (doc == null) {
            System.out.println("Ficheiro não existe, nada a alterar");
            return null;
        } else {
            raiz = doc.getRootElement();
        }
        List Jogadores = raiz.getChildren("jogador");
        boolean found = false;
        for (int i = 0; i < Jogadores.size(); i++) {

            Element Jogador = (Element) Jogadores.get(i);

            if (Jogador.getAttributeValue("nome").equals(nome)) {
                //System.out.println("Jogador " + nome + " tem nacionalidade: " + Jogador.getChildText("nacionalidade"));
                Jogador.getChild("clubeAtual").setText(novoClube);
                found = true;
            }

        }
        if (!found) {
            System.out.println("Jogador " + nome + " não foi encontrado");
            return null;
        } else {
            System.out.println("Clube atual alterado!");
        }
        return doc;
    }

    public static Document alteraEstado(String nome, String novoEstado, Document doc) {
        Element raiz;
        if (doc == null) {
            System.out.println("Ficheiro não existe, nada a alterar");
            return null;
        } else {
            raiz = doc.getRootElement();
        }
        List Jogadores = raiz.getChildren("jogador");
        boolean found = false;
        for (int i = 0; i < Jogadores.size(); i++) {

            Element Jogador = (Element) Jogadores.get(i);

            if (Jogador.getAttributeValue("nome").equals(nome)) {
                //System.out.println("Jogador " + nome + " tem nacionalidade: " + Jogador.getChildText("nacionalidade"));
                Jogador.getChild("estadoAtual").setText(novoEstado);
                found = true;
            }

        }
        if (!found) {
            System.out.println("Jogador " + nome + " não foi encontrado");
            return null;
        } else {
            System.out.println("Estado Atual alterado!");
        }
        return doc;
    }
}
