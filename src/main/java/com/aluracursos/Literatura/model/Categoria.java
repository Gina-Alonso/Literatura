package com.aluracursos.Literatura.model;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

public enum Categoria {
    EN(Collections.singletonList("en")),
    ES(Collections.singletonList("es")),
    PT(Collections.singletonList("pt"));
    private String categoriaIdioma;

    Categoria(List<String> idiomas){
        this.categoriaIdioma = idiomas.getFirst();
    }

    public static Categoria fromString(String text){
        for (Categoria categoria: Categoria.values()){
            if (categoria.categoriaIdioma.equalsIgnoreCase(text)){
                return categoria;
            }
        }
        throw new IllegalArgumentException("No se encontro el idioma");
    }
}
