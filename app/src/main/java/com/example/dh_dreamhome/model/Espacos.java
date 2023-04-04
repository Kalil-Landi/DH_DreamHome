package com.example.dh_dreamhome.model;

import java.util.List;

public class Espacos {

    private int espID;
    private String espNome;
    private List<Pessoas> espPessoas;

    public Espacos() {
    }

    public Espacos(int espID, String espNome, List<Pessoas> espPessoas) {
        this.espID = espID;
        this.espNome = espNome;
        this.espPessoas = espPessoas;
    }

    public int getEspID() {
        return espID;
    }

    public void setEspID(int espID) {
        this.espID = espID;
    }

    public String getEspNome() {
        return espNome;
    }

    public void setEspNome(String espNome) {
        this.espNome = espNome;
    }

    public List<Pessoas> getEspPessoas() {
        return espPessoas;
    }

    public void setEspPessoas(List<Pessoas> espPessoas) {
        this.espPessoas = espPessoas;
    }
}
