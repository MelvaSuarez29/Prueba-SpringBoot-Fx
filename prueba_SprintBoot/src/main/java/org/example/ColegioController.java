package org.example;

import org.example.model.Colegio;
import org.example.model.ColegioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ColegioController {

    @Autowired
    private ColegioRepository colegioRepository;

    @GetMapping("/colegio")
    public List<Colegio> listarColegios() {
        return colegioRepository.findAll();
    }
    @GetMapping("/colegio/{id}")
    public Colegio buscarColegio(@PathVariable Integer id) {
        return colegioRepository.findById(id).orElse(null);
    }
    @PostMapping("/colegio")
    public Colegio insertarColegio(@RequestBody Colegio colegio) {
        return colegioRepository.save(colegio);
    }
    @PutMapping("/colegio")
    public Colegio updateColegio(@RequestBody Colegio colegio) {
        return colegioRepository.save(colegio);
    }
    @DeleteMapping("/colegio/{id}")
    public void deleteColegio(@RequestParam("id") Integer id) {
        colegioRepository.deleteById(id);
    }

}
