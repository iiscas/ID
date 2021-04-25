/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author isabe
 */
public class Jogador {
    String nome,alcunha,fotografia,nacionalidade,pePref,posicao,clubeAtual,clubesAnteriores;
    String selecao,premios,estadoAtual,empresário;
    int ranking,valorContrato,idade,dataNascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAlcunha() {
        return alcunha;
    }

    public void setAlcunha(String alcunha) {
        this.alcunha = alcunha;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getPePref() {
        return pePref;
    }

    public void setPePref(String pePref) {
        this.pePref = pePref;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getClubeAtual() {
        return clubeAtual;
    }

    public void setClubeAtual(String clubeAtual) {
        this.clubeAtual = clubeAtual;
    }

    public String getClubesAnteriores() {
        return clubesAnteriores;
    }

    public void setClubesAnteriores(String clubesAnteriores) {
        this.clubesAnteriores = clubesAnteriores;
    }

    public String getSelecao() {
        return selecao;
    }

    public void setSelecao(String selecao) {
        this.selecao = selecao;
    }

    public String getPremios() {
        return premios;
    }

    public void setPremios(String premios) {
        this.premios = premios;
    }

    public String getEstadoAtual() {
        return estadoAtual;
    }

    public void setEstadoAtual(String estadoAtual) {
        this.estadoAtual = estadoAtual;
    }

    public String getEmpresário() {
        return empresário;
    }

    public void setEmpresário(String empresário) {
        this.empresário = empresário;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getValorContrato() {
        return valorContrato;
    }

    public void setValorContrato(int valorContrato) {
        this.valorContrato = valorContrato;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(int dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Jogador(String nome, String alcunha, String fotografia, String nacionalidade, String pePref, String posicao, String clubeAtual, String clubesAnteriores, String selecao, String premios, String estadoAtual, String empresário, int ranking, int valorContrato, int idade, int dataNascimento) {
        this.nome = nome;
        this.alcunha = alcunha;
        this.fotografia = fotografia;
        this.nacionalidade = nacionalidade;
        this.pePref = pePref;
        this.posicao = posicao;
        this.clubeAtual = clubeAtual;
        this.clubesAnteriores = clubesAnteriores;
        this.selecao = selecao;
        this.premios = premios;
        this.estadoAtual = estadoAtual;
        this.empresário = empresário;
        this.ranking = ranking;
        this.valorContrato = valorContrato;
        this.idade = idade;
        this.dataNascimento = dataNascimento;
    }
    
}
