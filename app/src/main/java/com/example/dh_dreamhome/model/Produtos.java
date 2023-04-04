package com.example.dh_dreamhome.model;

import android.graphics.Bitmap;

public class Produtos {

    private int pdtID;
    private int pdtProjeto;
    private String pdtDescricao;
    private String pdtCodigo;
    private String pdtLoja;
    private Double pdtPreco;
    private int pdtQuantidade;
    private Double pdtTotal;
    private Bitmap pdtImagem;
    private String pdtEspaco;
    private String pdtPessoa;
    private String pdtPrioridade;
    private Boolean pdtJaComprou;

    public Produtos() {
    }

    public Produtos(int pdtID, int pdtProjeto, String pdtDescricao, String pdtCodigo,
                    String pdtLoja, Double pdtPreco, int pdtQuantidade, Double pdtTotal,
                    Bitmap pdtImagem, String pdtEspaco, String pdtPessoa, String pdtPrioridade,
                    Boolean pdtJaComprou) {
        this.pdtID = pdtID;
        this.pdtProjeto = pdtProjeto;
        this.pdtDescricao = pdtDescricao;
        this.pdtCodigo = pdtCodigo;
        this.pdtLoja = pdtLoja;
        this.pdtPreco = pdtPreco;
        this.pdtQuantidade = pdtQuantidade;
        this.pdtTotal = pdtTotal;
        this.pdtImagem = pdtImagem;
        this.pdtEspaco = pdtEspaco;
        this.pdtPessoa = pdtPessoa;
        this.pdtPrioridade = pdtPrioridade;
        this.pdtJaComprou = pdtJaComprou;
    }

    public int getPdtID() {
        return pdtID;
    }

    public void setPdtID(int pdtID) {
        this.pdtID = pdtID;
    }

    public int getPdtProjeto() {
        return pdtProjeto;
    }

    public void setPdtProjeto(int pdtProjeto) {
        this.pdtProjeto = pdtProjeto;
    }

    public String getPdtDescricao() {
        return pdtDescricao;
    }

    public void setPdtDescricao(String pdtDescricao) {
        this.pdtDescricao = pdtDescricao;
    }

    public String getPdtCodigo() {
        return pdtCodigo;
    }

    public void setPdtCodigo(String pdtCodigo) {
        this.pdtCodigo = pdtCodigo;
    }

    public String getPdtLoja() {
        return pdtLoja;
    }

    public void setPdtLoja(String pdtLoja) {
        this.pdtLoja = pdtLoja;
    }

    public Double getPdtPreco() {
        return pdtPreco;
    }

    public void setPdtPreco(Double pdtPreco) {
        this.pdtPreco = pdtPreco;
    }

    public int getPdtQuantidade() {
        return pdtQuantidade;
    }

    public void setPdtQuantidade(int pdtQuantidade) {
        this.pdtQuantidade = pdtQuantidade;
    }

    public Double getPdtTotal() { return pdtTotal; }

    public void setPdtTotal(Double pdtTotal) { this.pdtTotal = pdtTotal; }

    public Bitmap getPdtImagem() {
        return pdtImagem;
    }

    public void setPdtImagem(Bitmap pdtImagem) {
        this.pdtImagem = pdtImagem;
    }

    public String getPdtEspaco() {
        return pdtEspaco;
    }

    public void setPdtEspaco(String pdtEspaco) {
        this.pdtEspaco = pdtEspaco;
    }

    public String getPdtPessoa() {
        return pdtPessoa;
    }

    public void setPdtPessoa(String pdtPessoa) {
        this.pdtPessoa = pdtPessoa;
    }

    public String getPdtPrioridade() {
        return pdtPrioridade;
    }

    public void setPdtPrioridade(String pdtPrioridade) {
        this.pdtPrioridade = pdtPrioridade;
    }

    public Boolean getPdtJaComprou() {
        return pdtJaComprou;
    }

    public void setPdtJaComprou(Boolean pdtJaComprou) {
        this.pdtJaComprou = pdtJaComprou;
    }
}
