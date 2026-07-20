package org.example;

import org.example.model.Colegio;
import org.example.model.ColegioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestColegios  {

    @Autowired
    private ColegioRepository colegioRepository;

    static void main(String[] args) {
        SpringApplication.run(TestColegios.class, args);

    }

    public void run(String... args) throws Exception {
        for (Colegio c : colegioRepository.findAll()) {
            System.out.println(c);
        }
    }
}
