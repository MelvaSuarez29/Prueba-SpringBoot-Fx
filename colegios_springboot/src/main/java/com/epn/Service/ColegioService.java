package com.epn.service;

import com.epn.model.Colegio;
import com.epn.model.ColegioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColegioService {

    @Autowired
    private ColegioRepository colegioRepository;

    public List<Colegio> listarColegios() {
        return colegioRepository.findAll();
    }

    public Optional<Colegio> buscarColegio(Integer id) {
        return colegioRepository.findById(id);
    }

    public Colegio insertar(Colegio colegio) {
        return colegioRepository.save(colegio);
    }

    public Colegio actualizar(Integer id, Colegio colegio) {
        if (!colegioRepository.existsById(id)) {
            throw new RuntimeException("Colegio no encontrado con ID: " + id);
        }
        colegio.setId(id);
        return colegioRepository.save(colegio);
    }

    public void eliminar(Integer id) {
        if (!colegioRepository.existsById(id)) {
            throw new RuntimeException("Colegio no encontrado con ID: " + id);
        }
        colegioRepository.deleteById(id);
    }
}