package com.booksApi.andres_cmk.view;

import com.booksApi.andres_cmk.DTO.DatosAutor;
import com.booksApi.andres_cmk.DTO.DatosLibros;
import com.booksApi.andres_cmk.entities.Autor;
import com.booksApi.andres_cmk.entities.Libro;

import java.util.stream.Collectors;

public class ViewMenu {
    public static void getMenu(){
        System.out.println("--------------------------------------" + "\n\n" +

                                "\t BIENVENIDO A LA BIBLIOTECA :)" + "\n" +

                        "OPCIONES: " + "\n" +

                        "(1) Buscar libro por titulo.\n" +
                        "(2) Listar libros registrados.\n" +
                        "(3) Listar Autores registrados.\n" +
                        "(4) Listar autores vivos en un años determinado. \n" +
                        "(5) Listar libros por idioma.\n" +
                        "(0) Salir.\n\n" +

                        "-------------------------------------------");
    }

    public static void outFormat(DatosLibros datosLibros){
        String string = "-------------LIBRO------------\n" +
                "Titulo: " + datosLibros.titulo() + "\n" +
                "Autor: " + datosLibros.datosAutors().stream().map(DatosAutor::nombre)
                .collect(Collectors.joining(","))+ "\n" +
                "Idioma: " + datosLibros.idiomas().get(0) + "\n" +
                "Numero de descargas: " + datosLibros.numeroDescargas() + "\n" +
                         "-------------------------------";
        System.out.println(string);
        System.out.println();
    }

    public static void outFormatLibro(Libro libro){
        String string = "-------------LIBRO------------\n" +
                "Titulo: " + libro.getTitulo() + "\n" +
                "Autor: " + libro.getAutor().getNombre() + "\n" +
                "Idioma: " + libro.getLenguage() + "\n" +
                "Numero de descargas: " + libro.getNumeroDescargas() + "\n" +
                "-------------------------------";
        System.out.println(string);
        System.out.println();
    }

    public static void outFormatAutor(Autor autor){
        String string = "-----------AUTOR----------------\n" +
                "Autor: " + autor.getNombre() + "\n" +
                "Fecha de Nacimiento: " + autor.getFechaNacimiento()+ "\n" +
                "Fecha de fallecimiento: " + autor.getFechaFallecimiento() + "\n"+
                "Libros: [" + autor.getListaLibros().stream().map(Libro::getTitulo).collect(Collectors.joining(",")) + "]\n" +
                        "-------------------------------------";
        System.out.println(string);
        System.out.println();
    }


}
