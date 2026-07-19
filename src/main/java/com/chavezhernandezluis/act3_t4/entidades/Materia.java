package com.chavezhernandezluis.act3_t4.entidades;

import jakarta.persistence.*;

@Entity
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int creditos;
    private int semestre;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    public Materia() {}

    public Materia(String nombre, int creditos, int semestre, Profesor profesor) {
        this.nombre = nombre;
        this.creditos = creditos;
        this.semestre = semestre;
        this.profesor = profesor;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getCreditos() { return creditos; }
    public void setCreditos(int creditos) { this.creditos = creditos; }

    public int getSemestre() { return semestre; }
    public void setSemestre(int semestre) { this.semestre = semestre; }

    public Profesor getProfesor() { return profesor; }
    public void setProfesor(Profesor profesor) { this.profesor = profesor; }
}