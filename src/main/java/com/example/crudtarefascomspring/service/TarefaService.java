package com.example.crudtarefascomspring.service;

import com.example.crudtarefascomspring.model.Tarefa;
import com.example.crudtarefascomspring.repository.ITarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {
    private final ITarefaRepository tarefaRepository;

    public void adicionarTarefaNoBanco(Tarefa tarefa) {
        tarefaRepository.save(tarefa);
    }

    public List<Tarefa> retornaTodasTarefas() { return tarefaRepository.findAll(); }

    public List<Tarefa> retornaConcluidas() { return tarefaRepository.findAllByConcluidaIs(true); }

    public List<Tarefa> retornaNaoConcluidas() { return tarefaRepository.findAllByConcluidaIs(false); }

    public Tarefa buscaPorId(long id) { return tarefaRepository.findFirstById(id); }

    public TarefaService(ITarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }
}
