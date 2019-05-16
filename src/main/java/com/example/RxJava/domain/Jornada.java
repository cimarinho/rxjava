package com.example.RxJava.domain;

public class Jornada {

    private Simulacao simulacao;

    private ControleJornada controleJornada;

    private String servico;

    private String valorSimular;

    private String valorControle;

    public String getValorControle() {
        return valorControle;
    }

    public void setValorControle(String valorControle) {
        this.valorControle = valorControle;
    }

    public String getValorSimular() {
        return valorSimular;
    }

    public void setValorSimular(String valorSimular) {
        this.valorSimular = valorSimular;
    }

    public Simulacao getSimulacao() {
        return simulacao;
    }

    public void setSimulacao(Simulacao simulacao) {
        this.simulacao = simulacao;
    }

    public ControleJornada getControleJornada() {
        return controleJornada;
    }

    public void setControleJornada(ControleJornada controleJornada) {
        this.controleJornada = controleJornada;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }
}
