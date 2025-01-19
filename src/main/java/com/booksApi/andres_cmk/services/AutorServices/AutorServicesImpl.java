package com.booksApi.andres_cmk.services.AutorServices;

import com.booksApi.andres_cmk.entities.Autor;
import com.booksApi.andres_cmk.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServicesImpl implements AutorService{

    private final AutorRepository autorRepository;

    public AutorServicesImpl(AutorRepository autorRepository){
        this.autorRepository = autorRepository;
    }

    @Override
    public List<Autor> listar() {
        return autorRepository.findAll();
    }

    @Override
    public List<Autor> listarAutorPorAño(int anio) {
        return autorRepository.findAutoresVivosEnAnio(anio);
    }
}
