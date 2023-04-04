package com.example.dh_dreamhome.model;

import java.util.List;

public class Projetos {

    private int pjtID;
    private String pjtNome;
    private String pjtUsuarioCriador;
    private String pjtDataCriacao;
    private List<Espacos> pjtEspacos;
    private List<Pessoas> pjtPessoas;
    private List<Prioridades> pjtPrioridades;
    private List<Convidados> pjtConvidados;

    public Projetos() {
    }
}
