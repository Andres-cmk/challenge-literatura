package com.booksApi.andres_cmk.repository;

import com.booksApi.andres_cmk.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<Libro,Long> {

    @Query(value = "SELECT * FROM libro WHERE lenguage = :idioma",nativeQuery = true)
    List<Libro> listLibroPorIdioma(@Param("idioma") String idoma);

    Optional<Libro> findByTitulo(String titulo);

}
