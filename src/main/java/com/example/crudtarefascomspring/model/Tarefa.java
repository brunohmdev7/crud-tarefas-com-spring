package com.example.crudtarefascomspring.model;

import java.util.UUID;

public class Tarefa {
    private UUID id;
    private String descricao;
    private boolean concluida;

    public UUID getId() {
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

    public Tarefa() {
        this.id = UUID.randomUUID();
    }

    public Tarefa(String descricao, boolean concluida) {
        this.id = UUID.randomUUID();
        this.descricao = descricao;
        this.concluida = concluida;
    }
}