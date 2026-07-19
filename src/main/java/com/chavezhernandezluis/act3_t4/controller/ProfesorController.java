package com.chavezhernandezluis.act3_t4.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.chavezhernandezluis.act3_t4.entidades.Materia;
import com.chavezhernandezluis.act3_t4.entidades.Profesor;
import java.util.List;
import com.chavezhernandezluis.act3_t4.service.*;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    @Autowired
    private MateriaService materiaService;

    @GetMapping
    public List<Profesor> listar() {
        return materiaService.listarProfesores();
    }

    @PostMapping
    public Profesor crear(@RequestBody Profesor profesor) {
        return materiaService.guardarProfesor(profesor);
    }
}