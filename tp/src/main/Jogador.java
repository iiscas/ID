/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author isabe
 */
public class Jogador {

    String nome, alcunha, fotografia, nacionalidade, pePref, posicao, clubeAtual,dataNascimento;
    String valorContrato,selecao, premios, estadoAtual,ranking,  empresário;
    ArrayList<String>  clubesAnteriores;
    int idade;

    public Jogador(String nome, String alcunha, String fotografia, String nacionalidade, String pePref, String posicao, String clubeAtual, String dataNascimento, String valorContrato, String selecao, String premios, String estadoAtual, String ranking, String empresário, ArrayList<String> clubesAnteriores, int idade) {
        this.nome = nome;
        this.alcunha = alcunha;
        this.fotografia = fotografia;
        this.nacionalidade = nacionalidade;
        this.pePref = pePref;
        this.posicao = posicao;
        this.clubeAtual = clubeAtual;
        this.dataNascimento = dataNascimento;
        this.valorContrato = valorContrato;
        this.selecao = selecao;
        this.premios = premios;
        this.estadoAtual = estadoAtual;
        this.ranking = ranking;
        this.empresário = empresário;
        this.clubesAnteriores = clubesAnteriores;
        this.idade = idade;
    }

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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getValorContrato() {
        return valorContrato;
    }

    public void setValorContrato(String valorContrato) {
        this.valorContrato = valorContrato;
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

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public String getEmpresário() {
        return empresário;
    }

    public void setEmpresário(String empresário) {
        this.empresário = empresário;
    }

    public ArrayList<String> getClubesAnteriores() {
        return clubesAnteriores;
    }

    public void setClubesAnteriores(ArrayList<String> clubesAnteriores) {
        this.clubesAnteriores = clubesAnteriores;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    

}
