package com.example.crudtarefascomspring;

import com.example.crudtarefascomspring.app.Principal;
import com.example.crudtarefascomspring.service.TarefaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudTarefasComSpringApplication implements CommandLineRunner {

    private final Principal principal;

    public CrudTarefasComSpringApplication(Principal principal) {
        this.principal = principal;
    }

    public static void main(String[] args) {
        SpringApplication.run(CrudTarefasComSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        principal.exibirMenu();
    }
}
