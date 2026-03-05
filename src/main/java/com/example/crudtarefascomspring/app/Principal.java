package com.example.crudtarefascomspring.app;

import com.example.crudtarefascomspring.service.TarefaService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

// atualizar os métodos no switch com funções modularizadas + derived queries

@Component
public class Principal {

    private final TarefaService tarefaService;

    public Principal(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    public void exibirMenu() {
        Scanner teclado = new Scanner(System.in);
        int opcao = -1;

        while (opcao != -1) {
            System.out.println("""=== CRUD DE TAREFAS ===
                                    1. Adicionar nova tarefa
                                    2. Listar todas as tarefas
                                    3. Atualizar a descrição de uma tarefa
                                    4. Concluir uma tarefa
                                    5. Deletar uma tarefa
                                    -1. Sair""");
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Descreva sua tarefa: ");
                    String descricao = teclado.nextLine();
                    tarefaRepo.criarTarefa(descricao);
                    break;
                case 2:
                    tarefaRepo.listarTarefas();
                    tarefaRepo.retornarAoMenu();
                    break;
                case 3:
                    System.out.println("Digite a posição que deseja atualizar:");
                    int posicao = teclado.nextInt();
                    posicao -= 1;
                    teclado.nextLine(); // limpa o "\n" do nextInt();
                    System.out.println("Descreva sua nova tarefa: ");
                    String descricaoNova = teclado.nextLine();
                    tarefaRepo.atualizarDescricao(posicao, descricaoNova);
                    break;
                case 4:
                    System.out.println("Digite a posição que deseja atualizar:");
                    posicao = teclado.nextInt();
                    posicao -= 1;
                    tarefaRepo.marcarConcluida(posicao);
                    teclado.nextLine();
                    break;
                case 5:
                    System.out.println("Digite a posição da tarefa que deseja excluir:");
                    posicao = teclado.nextInt();
                    posicao -= 1;
                    tarefaRepo.excluirTarefa(posicao);
                    teclado.nextLine();
                    break;
                case -1:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

    }
}