package com.example.crudtarefascomspring.app;

import com.example.crudtarefascomspring.model.Tarefa;
import com.example.crudtarefascomspring.service.TarefaService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

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
                    listarTarefasEmAndamento();
                    break;
                case 5:
                    atualizarDescricao();
                    break;
                case 6:
                    concluirTarefa();
                    break;
                case 7:
                    deletarTarefa();
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
        tarefaService.adicionarTarefaNoBanco(novaTarefa);
    }

    private void listarTodasTarefas() {
        List<Tarefa> tarefas = tarefaService.retornaTodasTarefas();
        int contador = 1;

        if (tarefas.size() == 0) {
            System.out.println("Não há tarefas no momento.");
        } else {
            for (Tarefa tarefa : tarefas) {
                System.out.println("Tarefa " + contador + " - " + tarefa.getDescricao() + " - " + tarefa.isConcluidaPorExtenso()
                + " - ID: " + tarefa.getId());
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

    private void listarTarefasEmAndamento() {
        List<Tarefa> naoConcluidas = tarefaService.retornaNaoConcluidas();
        int contador = 1;

        if (naoConcluidas.size() == 0) {
            System.out.println("Não há tarefas em andamento no momento.");
        } else {
            for (Tarefa naoConcluida : naoConcluidas) {
                System.out.println("Tarefa " + contador + " - " + naoConcluida.getDescricao());
                contador++;
            }
        }
    }

    private void atualizarDescricao() {
        listarTodasTarefas();

        System.out.println("Digite o ID da tarefa que você deseja alterar: ");
        long idTarefa = teclado.nextInt();
        teclado.nextLine();
        Tarefa tarefa = tarefaService.buscaPorId(idTarefa);
        System.out.println("Agora digite a descrição nova: ");
        String novaDescricao = teclado.nextLine();
        tarefa.setDescricao(novaDescricao);
        tarefa.setConcluida(false);
        tarefaService.adicionarTarefaNoBanco(tarefa);
    }

    private void concluirTarefa() {
        listarTarefasEmAndamento();

        System.out.println("Digite o número da tarefa que você deseja alterar: ");
        long idTarefa = teclado.nextInt();
        teclado.nextLine();
        Tarefa tarefa = tarefaService.buscaPorId(idTarefa);
        tarefa.setConcluida(true);
        tarefaService.adicionarTarefaNoBanco(tarefa);

    }

    private void deletarTarefa() {
        listarTodasTarefas();
        System.out.println("Digite o número da tarefa que você deseja deletar: ");
        long idTarefa = teclado.nextInt();
        teclado.nextLine();
        tarefaService.deletaPorId(idTarefa);
        System.out.println("Tarefa deletada com sucesso!");
    }
}