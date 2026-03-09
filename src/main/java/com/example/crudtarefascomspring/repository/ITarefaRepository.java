package com.example.crudtarefascomspring.repository;

import com.example.crudtarefascomspring.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITarefaRepository extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findAll();

    List<Tarefa> findAllByConcluidaIs(Boolean concluida);
}
