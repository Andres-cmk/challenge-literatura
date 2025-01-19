package com.booksApi.andres_cmk.services.LibrosServices;

import com.booksApi.andres_cmk.DTO.DatosLibros;
import com.booksApi.andres_cmk.entities.Libro;

import java.util.List;

public interface LibroService {
    List<Libro> getAll();
    void add(DatosLibros datosLibros);
    List<Libro> listLibroLenguage(String idioma);
}
