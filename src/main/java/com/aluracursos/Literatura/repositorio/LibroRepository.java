package com.aluracursos.Literatura.repositorio;

import com.aluracursos.Literatura.model.AutorC;
import com.aluracursos.Literatura.model.Categoria;
import com.aluracursos.Literatura.model.LibrosC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LibroRepository extends JpaRepository<LibrosC, Long> {
    @Query("SELECT DISTINCT l FROM LibrosC l JOIN FETCH l.autor a WHERE a.nombre ILIKE %:nombreAutor%")
    List<LibrosC> buscarLibroPorAutor(@Param("nombreAutor") String nombreAutor);
    @Query("SELECT a FROM AutorC a")
    List<AutorC> buscarAuoresRegistrados();
    @Query("SELECT a FROM AutorC a WHERE a.anioNacimiento<=:anio AND a.anioFallecimiento >=:anio")
    List<AutorC> autorVivoPorAnio(Integer anio);
    List<LibrosC> findByidioma(Categoria idioma);
    List<LibrosC> findTop5ByOrderByNumeroDescargasDesc();
}
