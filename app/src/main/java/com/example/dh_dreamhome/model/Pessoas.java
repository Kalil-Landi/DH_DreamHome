package com.example.dh_dreamhome.model;

public class Pessoas {

    private int pesID;
    private String pesNome;
    private Convidados pesConvidado;

    public Pessoas() {
    }

    public Pessoas(int pesID, String pesNome, Convidados pesConvidado) {
        this.pesID = pesID;
        this.pesNome = pesNome;
        this.pesConvidado = pesConvidado;
    }

    public int getPesID() {
        return pesID;
    }

    public void setPesID(int pesID) {
        this.pesID = pesID;
    }

    public String getPesNome() {
        return pesNome;
    }

    public void setPesNome(String pesNome) {
        this.pesNome = pesNome;
    }

    public Convidados getPesConvidado() {
        return pesConvidado;
    }

    public void setPesConvidado(Convidados pesConvidado) {
        this.pesConvidado = pesConvidado;
    }
}
