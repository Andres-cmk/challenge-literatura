package com.booksApi.andres_cmk.services.servicesAPI;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json,Class<T> clase);
}
