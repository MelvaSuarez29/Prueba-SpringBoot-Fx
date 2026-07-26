package com.epn;

import com.epn.model.Colegio;
import com.epn.service.ColegioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ColegioController {

    @Autowired
    private ColegioService colegioService;

    @GetMapping("/examen")
    public String inicio() {
        return "Corrección Examen Melva Suarez";
    }

    @GetMapping("/colegio")
    public List<Colegio> listarColegios() {
        return colegioService.listarColegios();
    }

    @GetMapping("/Colegio/{id}")
    public ResponseEntity<Colegio> buscarColegio(@PathVariable Integer id) {
        return colegioService.buscarColegio(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/Colegio")
    public ResponseEntity<Colegio> insertarColegio(@RequestBody Colegio colegio) {
        Colegio nuevoColegio = colegioService.insertar(colegio);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoColegio);
    }

    @PutMapping("/Colegio/{id}")
    public ResponseEntity<Colegio> actualizarColegio(@PathVariable Integer id, @RequestBody Colegio colegio) {
        try {
            Colegio colegioActualizado = colegioService.actualizar(id, colegio);
            return ResponseEntity.ok(colegioActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/Colegio/{id}")
    public ResponseEntity<Void> eliminarColegio(@PathVariable Integer id) {
        try {
            colegioService.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}