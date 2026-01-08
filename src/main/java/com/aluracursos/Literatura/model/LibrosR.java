package com.aluracursos.Literatura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LibrosR(
        @JsonAlias("title") String tituloLibro,
        @JsonAlias("authors") List<AutorR> autorRList,
        @JsonAlias("languages") List<String> idiomas,
        @JsonAlias("download_count") Double numeroDescargas
) {

}
