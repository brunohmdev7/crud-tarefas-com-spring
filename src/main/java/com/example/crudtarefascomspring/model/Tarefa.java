package com.example.crudtarefascomspring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tarefas")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String descricao;
    private boolean concluida;

    public long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean getConcluida() {
        return concluida;
    }

    public String isConcluida() {
        if (this.concluida == true) {
            return "Sim";
        } else {
            return "Não";
        }
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public Tarefa() {}

    public Tarefa(String descricao, boolean concluida) {
        this.descricao = descricao;
        this.concluida = concluida;
    }
}