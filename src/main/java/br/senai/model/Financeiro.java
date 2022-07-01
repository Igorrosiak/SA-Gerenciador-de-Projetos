package br.senai.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "financeiro")
public class Financeiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @NotNull
    private long idOperacao;

    private double valorGasto;

    private double valorInserido;

    @ManyToOne
    @JoinColumn(name="projeto_id")
    private Projeto projeto;

    @Size(max = 50)
    private String finalidade;

    public long getIdOperacao() {
        return idOperacao;
    }

    public void setIdOperacao(long idOperacao) {
        this.idOperacao = idOperacao;
    }

    public double getValorGasto() {
        return valorGasto;
    }

    public void setValorGasto(double valorGasto) {
        this.valorGasto = valorGasto;
    }

    public double getValorInserido() {
        return valorInserido;
    }

    public void setValorInserido(double valorInserido) {
        this.valorInserido = valorInserido;
    }

    public String getFinalidade() {
        return finalidade;
    }
    
    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }

    public Projeto getProjeto() {return projeto;}

    public void setProjeto(Projeto projeto) {this.projeto = projeto;}

    @Override
    public String toString() {
        return "Financeiro{" +
                "idOperacao=" + idOperacao +
                ", valorGasto=" + valorGasto +
                ", valorInserido=" + valorInserido +
                ", finalidade='" + finalidade +
                '}';
    }
}

