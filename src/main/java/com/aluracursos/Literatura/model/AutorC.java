package com.aluracursos.Literatura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores")
public class AutorC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nombre;
    private Integer anioNacimiento;
    private Integer anioFallecimiento;
    @OneToOne(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private LibrosC libroDelAutor;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(Integer anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public Integer getAnioFallecimiento() {
        return anioFallecimiento;
    }

    public void setAnioFallecimiento(Integer anioFallecimiento) {
        this.anioFallecimiento = anioFallecimiento;
    }

    public LibrosC getLibroDelAutor() {
        return libroDelAutor;
    }

    public void setLibroDelAutor(LibrosC librosDelAutor) {
        this.libroDelAutor = librosDelAutor;
        if (libroDelAutor != null && libroDelAutor.getAutorDelLibro() != this) {
            libroDelAutor.setAutorDelLibro(this);
        }

    }

    public AutorC() {
    }

    public AutorC(AutorR autorR) {
        this.nombre = autorR.nombre();
        this.anioNacimiento = autorR.anioNacimiento();
        this.anioFallecimiento = autorR.anioFallecimiento();
    }

    @Override
    public String toString() {
        return "\n•••••Autor•••••" +
                "\n►Nombre: "+nombre+
                "\n►Anio de Nacimiento: " + anioNacimiento +
                "\n►Anio de Fallecimiento: " + anioFallecimiento +
                "\n►LibroDelAutor: " + libroDelAutor.getTituloLibro();
    }
}
