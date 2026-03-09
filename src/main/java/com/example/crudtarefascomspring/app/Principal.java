package com.example.crudtarefascomspring.app;

import com.example.crudtarefascomspring.model.Tarefa;
import com.example.crudtarefascomspring.service.TarefaService;
import org.springframework.stereotype.Component;

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
                                    === CRUD DE TAREFAS ===
                                    1. Adicionar nova tarefa
                                    2. Listar todas as tarefas
                                    3. Atualizar a descrição de uma tarefa
                                    4. Concluir uma tarefa
                                    5. Deletar uma tarefa
                                    0. Sair
                                """);
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    adicionarNovaTarefa();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
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
}