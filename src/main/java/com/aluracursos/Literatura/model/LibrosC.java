package com.aluracursos.Literatura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
public class LibrosC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String tituloLibro;
    @Enumerated(EnumType.STRING)
    private Categoria idioma;
    private Double numeroDescargas;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "autor_id", unique = true)
    private AutorC autor;

    public LibrosC(){

    }
    public LibrosC(LibrosR librosR) {

        this.tituloLibro = librosR.tituloLibro();
        this.idioma = Categoria.fromString(librosR.idiomas().getFirst());
        this.numeroDescargas = librosR.numeroDescargas();

    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public Categoria getIdioma() {
        return idioma;
    }

    public void setIdioma(Categoria idioma) {
        this.idioma = idioma;
    }

    public Double getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(Double numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    public AutorC getAutorDelLibro() {
        return autor;
    }

    public void setAutorDelLibro(AutorC autorDelLibro) {
        this.autor = autorDelLibro;
        if (autor != null && autor.getLibroDelAutor() != this) {
            autor.setLibroDelAutor(this);
        }
    }

    @Override
    public String toString() {
        return "LibrosC{" +
                "id=" + id +
                ", tituloLibro='" + tituloLibro + '\'' +
                ", idioma=" + idioma +
                ", numeroDescargas=" + numeroDescargas +
                ", autor=" + autor.getNombre() +
                '}';
    }
}
