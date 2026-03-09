package com.example.crudtarefascomspring.repository;

import com.example.crudtarefascomspring.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITarefaRepository extends JpaRepository<Tarefa, Long> {

}
