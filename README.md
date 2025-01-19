![badge_literalura](https://github.com/user-attachments/assets/21ae4059-3f85-4dff-b6a0-2fb2309c541a)


# Books API

## Descripción

Este proyecto es una API para la gestión de libros, autores y la relación entre ellos. Permite realizar operaciones de creación, lectura, actualización y eliminación (CRUD) sobre libros y autores, con un enfoque en la consulta de autores vivos en un año determinado. La API está construida usando **Spring Boot** y utiliza **JPA** (Java Persistence API) para la persistencia de datos en una base de datos relacional.

El proyecto también ofrece la posibilidad de buscar libros por idioma y obtener información detallada sobre los autores, incluyendo aquellos que están vivos en un año específico.

## Tecnologías

- **Java 17**: Lenguaje de programación utilizado.
- **Spring Boot**: Framework para crear aplicaciones backend.
- **JPA (Java Persistence API)**: Para la persistencia de datos en la base de datos.
- **Hibernate**: Implementación de JPA para la gestión de la base de datos.
- **MySQL**: Base de datos relacional para almacenar información de libros y autores.
- **Maven**: Herramienta para la gestión de dependencias y construcción del proyecto.

## Funcionalidades

- **Gestión de libros**: Puedes agregar, modificar, eliminar y consultar libros por título y idioma.
- **Gestión de autores**: Los autores se pueden agregar, listar y consultar. Se puede verificar si un autor está vivo en un año determinado.
- **Consulta de libros por idioma**: Puedes consultar todos los libros que están disponibles en un idioma específico.
- **Consulta de autores vivos en un año**: Permite obtener los autores que están vivos en un año determinado, considerando su fecha de nacimiento y fallecimiento.

## Instrucciones de instalación

### Requisitos previos

- **Java 17**: Asegúrate de tener instalada la versión de Java 17 en tu máquina.
- **MySQL**: Instala MySQL y crea una base de datos para el proyecto.

### Pasos para correr el proyecto

1. Clona este repositorio en tu máquina local:

   ```bash
   git clone https://github.com/tu_usuario/books-api.git
   cd books-api
