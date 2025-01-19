package com.booksApi.andres_cmk.repository;

import com.booksApi.andres_cmk.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNombre(String nombre);

    @Query(value = "SELECT * FROM autor WHERE autor.fecha_nacimiento <= :anio AND (autor.fecha_fallecimiento IS NULL OR autor.fecha_fallecimiento >= :anio)", nativeQuery = true)
    List<Autor> findAutoresVivosEnAnio(@Param("anio") int anio);


}
