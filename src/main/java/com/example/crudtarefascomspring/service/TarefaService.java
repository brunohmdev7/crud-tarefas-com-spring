package com.example.crudtarefascomspring.service;

import com.example.crudtarefascomspring.repository.ITarefaRepository;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {
    private final ITarefaRepository tarefaRepository;

    public TarefaService(ITarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }
}
