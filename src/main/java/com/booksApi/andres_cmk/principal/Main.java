package com.booksApi.andres_cmk.principal;

import com.booksApi.andres_cmk.DTO.Datos;
import com.booksApi.andres_cmk.DTO.DatosLibros;
import com.booksApi.andres_cmk.entities.Autor;
import com.booksApi.andres_cmk.entities.Libro;
import com.booksApi.andres_cmk.services.AutorServices.AutorService;
import com.booksApi.andres_cmk.services.LibrosServices.LibroService;
import com.booksApi.andres_cmk.services.servicesAPI.ApiConsumption;
import com.booksApi.andres_cmk.services.servicesAPI.ConvierteDatos;
import com.booksApi.andres_cmk.view.ViewMenu;
import org.springframework.stereotype.Component;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class Main {

    private final ConvierteDatos convierteDatos = new ConvierteDatos();
    private final ApiConsumption consumption = new ApiConsumption();

    private final LibroService libroService;
    private final AutorService autorService;

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final Map<String, String> mapIdiomas = Map.of("español", "es","en", "ingles","fr","frances","pt","portugues");

    public Main(LibroService libroService, AutorService autorService) {
        this.libroService = libroService;
        this.autorService = autorService;
    }

    public void execute() throws IOException {

        int opcion = 0;

        while (opcion != -1) {
            ViewMenu.getMenu();
            System.out.println("Ingrese una opcion: ");
            opcion = Integer.parseInt(br.readLine());
            switch (opcion) {
                case 0:
                    System.out.println("Gracias por usar la aplicacion :3" + "\n" +
                            "Que tengas un excelente dia!!!");
                    return;
                case 1:
                    System.out.println("Ingrese el nombre del libro: ");
                    var libroNombre = br.readLine();
                    this.getLibroByName(libroNombre);
                    break;
                case 2:
                    List<Libro> listaLibros = libroService.getAll();
                    for (Libro libro : listaLibros) {
                        ViewMenu.outFormatLibro(libro);
                    }
                    break;
                case 3:
                    List<Autor> listaAutores = autorService.listar();
                    for (Autor autor : listaAutores) {
                        ViewMenu.outFormatAutor(autor);
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el año: ");
                    int anio = Integer.parseInt(br.readLine());
                    this.getAutorByFecha(anio);
                    break;
                case 5:
                    mapIdiomas.forEach((k,v) -> System.out.println(k+"- " + v + "\n"));
                    System.out.println("Ingresa el idioma: ");
                    String idioma = br.readLine();
                    this.libroPorIdioma(idioma);
                    break;
                default:
                    System.out.println("La opcion que ingreso no existe");
                    break;
            }
        }
        br.close();
    }

    public void getLibroByName(String libro) {

        var json = consumption.getDataByBook(libro);

        var datos = convierteDatos.obtenerDatos(json, Datos.class);

        Optional<DatosLibros> libroBuscar = datos.libros().stream()
                .filter(l -> l.titulo().toUpperCase().contains(libro.toUpperCase()))
                .findFirst();
        if (libroBuscar.isPresent()) {
            System.out.println("libro encontrado");
            ViewMenu.outFormat(libroBuscar.get());
            libroService.add(libroBuscar.get());

        } else {
            System.out.println("Libro no encontrado");
        }

    }

    public void getAutorByFecha(int anio) {
        List<Autor> list = autorService.listarAutorPorAño(anio);
        list.forEach(ViewMenu::outFormatAutor);
    }

    public void libroPorIdioma(String idioma){
        List<Libro> listLibros = libroService.listLibroLenguage(idioma);
        listLibros.forEach(ViewMenu::outFormatLibro);
    }

}

        // top 10 libros mas descargados.

        /*
        System.out.println("top 10 de los libros:");

        datos.libros().stream()
                .sorted(Comparator.comparing(DatosLibros::numeroDescargas).reversed())
                .limit(10)
                .map(libro -> libro.titulo().toUpperCase())
                .forEach(System.out::println);

        // data por nombre.

        System.out.println();

        System.out.print("Ingrese el nombre del libro: ");

        String nameBookUsuer = br.readLine();
        var result = consumption.getDataByBook(nameBookUsuer.replace(" ","+"));
        var datosBusqueda = convierteDatos.obtenerDatos(result, Datos.class);

        Optional<DatosLibros> libroBuscar = datosBusqueda.libros().stream()
                .filter(libro -> libro.titulo().toUpperCase().contains(nameBookUsuer.toUpperCase()))
                .findFirst();
        if(libroBuscar.isPresent()) {
            System.out.println("libro encontrado");
            System.out.println(libroBuscar.get());
        }else {
            System.out.println("Libro no encontrado");
        }
        // estadisticas
        System.out.println("Estadisticas");

        DoubleSummaryStatistics est = datosBusqueda.libros().stream()
                .filter(d -> d.numeroDescargas() > 0)
                .collect(Collectors.summarizingDouble(DatosLibros::numeroDescargas));

        System.out.println("Media de descargas: " + est.getAverage());
        System.out.println("Cantidad Maxima de descargas: " + est.getMax());
        System.out.println("Cantidad Minima de descargas: " + est.getMin());
        System.out.println("Cantidad de registros evaluados para los datos estadisticos: " + est.getCount());
        */


