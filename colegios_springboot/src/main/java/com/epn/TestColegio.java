package com.epn;

import com.epn.model.Colegio;
import com.epn.model.ColegioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestColegio implements CommandLineRunner {
    @Autowired
    private ColegioRepository colegioRepository;
    public static void main(String[] args) {
        SpringApplication.run(TestColegio.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        for(Colegio colegio : colegioRepository.findAll()) {
            System.out.println(colegio);
        }
    }
}
