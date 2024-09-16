package com.operacionesApi.demo.Controller;

import com.operacionesApi.demo.Service.OperacionesService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OperacionesController {

    @Autowired
    private OperacionesService operacionesService;

    @GetMapping("")
    public String home() {
        return "So queres buscar un nombre busca usando /buscar/{nombre}";
    }
    
    @GetMapping("/buscar/{nombre}")
    public String buscarNombre(@PathVariable String nombre) {
        return operacionesService.buscarNombre(nombre);
    }
    
    @GetMapping("/nombres")
    public List<String> obtenerNombres() {
        return operacionesService.traerNombres();
    }
}