package com.treinamento;

import com.treinamento.api.entities.Empresa;
import com.treinamento.api.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ApiTreinamentoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiTreinamentoApplication.class, args);
    }


}
