package com.booksApi.andres_cmk.entities;

import com.booksApi.andres_cmk.DTO.DatosAutor;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Integer fechaNacimiento;

    private Integer fechaFallecimiento;

    @OneToMany(targetEntity = Libro.class, fetch = FetchType.EAGER, mappedBy = "autor")
    private List<Libro> listaLibros;

    public Autor(){}

    public Autor(DatosAutor datosAutor){
        this.nombre = datosAutor.nombre();
        this.fechaFallecimiento = Integer.valueOf(datosAutor.fechaFallecimiento());
        this.fechaNacimiento = Integer.valueOf(datosAutor.fechaNacimiento());
    }

    // Getter y Setter


    public List<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(List<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public Integer getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(Integer fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    public Integer getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Integer fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
