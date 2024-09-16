package com.operacionesApi.demo.Service;

import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class OperacionesService {

    private List<String> nombres = Arrays.asList("Pepe", "Juan", "Maria");

    public String buscarNombre(String nombre) {
        return nombres.contains(nombre) ? "Encontrado" : "No encontrado";
    }

    public List<String> traerNombres() {
        return nombres;
    }
}
