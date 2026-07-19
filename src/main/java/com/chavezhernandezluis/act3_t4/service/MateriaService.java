package com.chavezhernandezluis.act3_t4.service;
import com.chavezhernandezluis.act3_t4.entidades.Materia;
import com.chavezhernandezluis.act3_t4.entidades.Profesor;
import com.chavezhernandezluis.act3_t4.repository.MateriaRepository;
import com.chavezhernandezluis.act3_t4.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private ProfesorRepository profesorRepository;

    public List<Materia> listarTodas() {
        return materiaRepository.findAll();
    }

    public Optional<Materia> buscarPorId(Long id) {
        return materiaRepository.findById(id);
    }

    public Materia guardar(Materia materia) {
        return materiaRepository.save(materia);
    }

    public void eliminar(Long id) {
        materiaRepository.deleteById(id);
    }

    public List<Profesor> listarProfesores() {
        return profesorRepository.findAll();
    }

    public Profesor guardarProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }
}