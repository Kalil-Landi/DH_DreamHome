package com.example.dh_dreamhome.model;

public class Prioridades {

    private int priPrioridade;
    private String priNome;

    public Prioridades() {
    }

    public Prioridades(int priPrioridade, String priNome) {
        this.priPrioridade = priPrioridade;
        this.priNome = priNome;
    }

    public int getPriPrioridade() {
        return priPrioridade;
    }

    public void setPriPrioridade(int priPrioridade) {
        this.priPrioridade = priPrioridade;
    }

    public String getPriNome() {
        return priNome;
    }

    public void setPriNome(String priNome) {
        this.priNome = priNome;
    }
}
