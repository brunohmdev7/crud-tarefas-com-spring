package com.example.crudtarefascomspring.repository;

import com.example.crudtarefascomspring.model.Tarefa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TarefaRepository {
    private List<Tarefa> tarefas =  new ArrayList<Tarefa>();

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void buscaPorPosicaoExistente (int posicao) {
        for (int i = 0; i < tarefas.size(); i++) {
            if (posicao > (tarefas.size() - 1) || posicao < 0) {
                System.out.println("❌ Erro ao encontrar tarefa!");
            }
        }
    }

    public void criarTarefa(String descricao) {
        try {
            Tarefa tarefa = new Tarefa();
            tarefa.setDescricao(descricao);
            tarefas.add(tarefa);
            System.out.println("✅ Tarefa criada com sucesso!");
        } catch (Exception e) {
            System.out.println("❌ Erro ao criar tarefa!");
        }
    }

    public void listarTarefas() {
        System.out.println("========================");
        System.out.println("=== LISTA DE TAREFAS ===");
        System.out.println("========================\n");
        for (int i = 0 ; i  < tarefas.size() ; i++) {
            System.out.println("Tarefa " + (i + 1));
            System.out.println(tarefas.get(i).getDescricao());
            System.out.println(tarefas.get(i).isConcluida());
            System.out.println("========================\n");
        }
    }

    public void atualizarDescricao(int posicao, String novaDescricao) {
        try {
            this.buscaPorPosicaoExistente(posicao);
            for (int i = 0 ; i  < tarefas.size() ; i++) {
                if (tarefas.get(posicao) == tarefas.get(i)) {
                    tarefas.get(posicao).setDescricao(novaDescricao);
                    System.out.println("✅ Descrição atualizada com sucesso!");
                }
            }
        } catch (Exception e) {
            System.out.println("❌ Erro ao atualizar descricao!");
        }
    }

    public void marcarConcluida(int posicao) {
        this.buscaPorPosicaoExistente(posicao);
        for (int i = 0 ; i  < tarefas.size() ; i++) {
            if (tarefas.get(posicao) == tarefas.get(i)) {
                tarefas.get(posicao).setConcluida(true);
                System.out.println("✅ Tarefa concluída com sucesso!");
            }
        }
    }

    public void excluirTarefa(int posicao) {
        boolean removeu = tarefas.removeIf(tarefa -> tarefas.get(posicao).equals(tarefa));
        if (removeu) {
            System.out.println("✅ Tarefa removida com sucesso!");
        } else {
            System.out.println("❌ Não foi possível excluir tarefa!");
        }
    }

    public void exibirMenu() {
        System.out.println("=== MENU DE TAREFAS ===");
        System.out.println("Digite 1 para adicionar novo tarefa");
        System.out.println("Digite 2 para listar todas as tarefas");
        System.out.println("Digite 3 para atualizar a descrição de uma tarefa");
        System.out.println("Digite 4 para concluir uma tarefa");
        System.out.println("Digite 5 para excluir uma tarefa");
        System.out.println("Digite -1 para encerrar o programa\n");
    }

    public void retornarAoMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite qualquer tecla para retornar ao menu");
        sc.nextLine();
    }
}