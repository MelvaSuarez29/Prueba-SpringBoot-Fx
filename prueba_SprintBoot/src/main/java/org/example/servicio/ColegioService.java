package org.example.servicio;

import org.example.model.Colegio;
import org.example.model.ColegioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColegioService {

    @Autowired
    private ColegioRepository colegioRepository;

    public List<Colegio> listarColegios(){
        return colegioRepository.findAll();
    }
    public Optional<Colegio> buscarColegioPorId(Integer id) {
        return colegioRepository.findById(id);
    }
    public Colegio insetar(Colegio colegio) {
        return colegioRepository.save(colegio);
    }
    public Colegio actualizar(Colegio colegio){
        return colegioRepository.save(colegio);
    }
    public void eliminar(Integer id){
        colegioRepository.deleteById(id);
    }
}
