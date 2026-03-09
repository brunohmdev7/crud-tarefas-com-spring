package com.example.crudtarefascomspring.app;

import com.example.crudtarefascomspring.model.Tarefa;
import com.example.crudtarefascomspring.service.TarefaService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// atualizar os métodos no switch com funções modularizadas + derived queries

@Component
public class Principal {
    Scanner teclado = new Scanner(System.in);
    private final TarefaService tarefaService;

    public Principal(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    public void exibirMenu() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("""
                                    \n=== CRUD DE TAREFAS ===
                                    1. Adicionar nova tarefa
                                    2. Listar todas as tarefas
                                    3. Listar tarefas concluídas
                                    4. Listar tarefas em andamento
                                    5. Atualizar a descrição de uma tarefa
                                    6. Concluir uma tarefa
                                    7. Deletar uma tarefa
                                    0. Sair
                                """);
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    adicionarNovaTarefa();
                    break;
                case 2:
                    listarTodasTarefas();
                    break;
                case 3:
                    listarTarefasConcluidas();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

    }

    private void adicionarNovaTarefa() {
        System.out.println("Descreva a tarefa que deseja adicionar: ");
        teclado.nextLine();
        String descricaoNovaTarefa = teclado.nextLine();
        Tarefa novaTarefa = new Tarefa(descricaoNovaTarefa, false);
        tarefaService.adicionarTarefa(novaTarefa);
    }

    private void listarTodasTarefas() {
        List<Tarefa> tarefas = tarefaService.retornaTodasTarefas();
        int contador = 1;

        if (tarefas.size() == 0) {
            System.out.println("Não há tarefas concluídas no momento.");
        } else {
            for (Tarefa tarefa : tarefas) {
                System.out.println("Tarefa " + contador + " - " + tarefa.getDescricao());
                contador++;
            }
        }
    }

    private void listarTarefasConcluidas() {
        List<Tarefa> concluidas = tarefaService.retornaConcluidas();
        int contador = 1;

        if (concluidas.size() == 0) {
            System.out.println("Não há tarefas concluídas no momento.");
        } else {
            for (Tarefa concluida : concluidas) {
                System.out.println("Tarefa " + contador + " - " + concluida.getDescricao());
                contador++;
            }
        }
    }
}