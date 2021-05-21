package main;

import java.util.ArrayList;

public class Jogador {

    String alcunha, nomeCompleto, altura, dataNasc, peso, empresario, estadoAtual, foto, nacionalidade, pe, posicao, ranking, clubeAtual, selecao, contrato;
    ArrayList<String> clubesAnteriores, trofeus;
    int idade;

    public Jogador(String alcunha, String nomeCompleto, String altura, String dataNasc, String peso, String empresario, String estadoAtual, String foto, String nacionalidade, String pe, String posicao, String ranking, String clubeAtual, String selecao, String contrato, ArrayList<String> clubesAnteriores, ArrayList<String> trofeus, int idade) {
        this.alcunha = alcunha;
        this.nomeCompleto = nomeCompleto;
        this.altura = altura;
        this.dataNasc = dataNasc;
        this.peso = peso;
        this.empresario = empresario;
        this.estadoAtual = estadoAtual;
        this.foto = foto;
        this.nacionalidade = nacionalidade;
        this.pe = pe;
        this.posicao = posicao;
        this.ranking = ranking;
        this.clubeAtual = clubeAtual;
        this.selecao = selecao;
        this.contrato = contrato;
        this.clubesAnteriores = clubesAnteriores;
        this.trofeus = trofeus;
        this.idade = idade;
    }

    public String getClubeAtual() {
        return clubeAtual;
    }

    public void setClubeAtual(String clubeAtual) {
        this.clubeAtual = clubeAtual;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getAlcunha() {
        return alcunha;
    }

    public void setAlcunha(String alcunha) {
        this.alcunha = alcunha;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEmpresario() {
        return empresario;
    }

    public void setEmpresario(String empresario) {
        this.empresario = empresario;
    }

    public String getEstadoAtual() {
        return estadoAtual;
    }

    public void setEstadoAtual(String estadoAtual) {
        this.estadoAtual = estadoAtual;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getPe() {
        return pe;
    }

    public void setPe(String pe) {
        this.pe = pe;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public String getSelecao() {
        return selecao;
    }

    public void setSelecao(String selecao) {
        this.selecao = selecao;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public ArrayList<String> getClubesAnteriores() {
        return clubesAnteriores;
    }

    public void setClubesAnteriores(ArrayList<String> clubesAnteriores) {
        this.clubesAnteriores = clubesAnteriores;
    }

    public ArrayList<String> getTrofeus() {
        return trofeus;
    }

    public void setTrofeus(ArrayList<String> trofeus) {
        this.trofeus = trofeus;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}
