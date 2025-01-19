package com.booksApi.andres_cmk.services.AutorServices;

import com.booksApi.andres_cmk.entities.Autor;

import java.util.List;

public interface AutorService {
    List<Autor> listar();
    List<Autor> listarAutorPorAño(int anio);
}
