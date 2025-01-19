package com.booksApi.andres_cmk.entities;

import com.booksApi.andres_cmk.DTO.DatosLibros;
import jakarta.persistence.*;



@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lib_id;

    private String titulo;

    private String lenguage;

    private Double numeroDescargas;

    @ManyToOne(targetEntity = Autor.class)
    private Autor autor;

    public Libro() {}

    public Libro(DatosLibros datosLibros, Autor autor){
        this.titulo = datosLibros.titulo();
        this.lenguage = datosLibros.idiomas().get(0);
        this.numeroDescargas = datosLibros.numeroDescargas();
        if (datosLibros.datosAutors() != null && !datosLibros.datosAutors().isEmpty()) {
            this.autor = autor;
        } else {
            throw new IllegalArgumentException("El libro debe tener al menos un autor.");
        }
    }


    // Getter y Setter


    public Double getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(Double numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    public Long getLib_id() {
        return lib_id;
    }

    public void setLib_id(Long lib_id) {
        this.lib_id = lib_id;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getLenguage() {
        return lenguage;
    }

    public void setLenguage(String lenguage) {
        this.lenguage = lenguage;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
