package com.chavezhernandezluis.act3_t4.controller;
import com.chavezhernandezluis.act3_t4.entidades.Materia;
import com.chavezhernandezluis.act3_t4.entidades.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.chavezhernandezluis.act3_t4.service.*;

@RestController
@RequestMapping("/api/materias")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    // READ - todas
    @GetMapping
    public List<Materia> listar() {
        return materiaService.listarTodas();
    }

    // READ - una por id
    @GetMapping("/{id}")
    public Materia obtener(@PathVariable Long id) {
        return materiaService.buscarPorId(id).orElse(null);
    }

    // CREATE
    @PostMapping
    public Materia crear(@RequestBody Materia materia) {
        return materiaService.guardar(materia);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Materia actualizar(@PathVariable Long id, @RequestBody Materia datosNuevos) {
        Materia materia = materiaService.buscarPorId(id).orElseThrow();
        materia.setNombre(datosNuevos.getNombre());
        materia.setCreditos(datosNuevos.getCreditos());
        materia.setSemestre(datosNuevos.getSemestre());
        materia.setProfesor(datosNuevos.getProfesor());
        return materiaService.guardar(materia);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        materiaService.eliminar(id);
    }
}