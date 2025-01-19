package com.booksApi.andres_cmk.services.LibrosServices;

import com.booksApi.andres_cmk.DTO.DatosAutor;
import com.booksApi.andres_cmk.DTO.DatosLibros;
import com.booksApi.andres_cmk.entities.Autor;
import com.booksApi.andres_cmk.entities.Libro;
import com.booksApi.andres_cmk.repository.AutorRepository;
import com.booksApi.andres_cmk.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private  AutorRepository autorRepository;

    @Autowired
    private  LibroRepository libroRepository;


    @Override
    public List<Libro> getAll() {
        return libroRepository.findAll();
    }


    @Override
    public void add(DatosLibros datosLibros){
        if(datosLibros.datosAutors().isEmpty()){
            throw new RuntimeException("no hay autores");
        }


        Optional<Libro> libroExistente = libroRepository.findByTitulo(datosLibros.titulo());
        if (libroExistente.isPresent()) {
            System.out.println("El libro ya existe en la base de datos");
            return;
        }

        DatosAutor datosAutor = datosLibros.datosAutors().get(0);



        Autor autor = autorRepository.findByNombre(datosAutor.nombre())
                .orElseGet(()-> {
                    Autor nuevo = new Autor(datosAutor);
                    autorRepository.save(nuevo);
                    return nuevo;
                });

        Libro libro = new Libro(datosLibros, autor);
        libroRepository.save(libro);
        System.out.println("Libro guardado");
    }

    @Override
    public List<Libro> listLibroLenguage(String idioma) {
        return libroRepository.listLibroPorIdioma(idioma);
    }
}
