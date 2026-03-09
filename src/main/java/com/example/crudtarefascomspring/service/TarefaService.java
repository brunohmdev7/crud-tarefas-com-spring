package com.example.crudtarefascomspring.service;

import com.example.crudtarefascomspring.model.Tarefa;
import com.example.crudtarefascomspring.repository.ITarefaRepository;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {
    private final ITarefaRepository tarefaRepository;

    // adiciona a tarefa no banco por meio do tarefaRepository
    public void adicionarTarefa(Tarefa tarefa) {
        tarefaRepository.save(tarefa);
    }

    public TarefaService(ITarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }
}
