package com.operacionesApi.demo.Controller;

import com.operacionesApi.demo.Service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculadora")
public class CalculadoraController {
	
    @Autowired
    private CalculadoraService calculadoraService;

    //http://localhost:8080/api/calculadora/suma?a=5&b=10
    @GetMapping("/suma")
    public double sumar(@RequestParam double a, @RequestParam double b) {
        return calculadoraService.sumar(a, b);
    }

    //http://localhost:8080/api/calculadora/resta?a=15&b=5
    @GetMapping("/resta")
    public double restar(@RequestParam double a, @RequestParam double b) {
        return calculadoraService.restar(a, b);
    }

    //http://localhost:8080/api/calculadora/multiplicacion?a=4&b=6
    @GetMapping("/multiplicacion")
    public double multiplicar(@RequestParam double a, @RequestParam double b) {
        return calculadoraService.multiplicar(a, b);
    }

    //http://localhost:8080/api/calculadora/division?a=20&b=4
    @GetMapping("/division")
    public double dividir(@RequestParam double a, @RequestParam double b) {
        return calculadoraService.dividir(a, b);
    }

    //http://localhost:8080/api/calculadora/maximo
    @GetMapping("/maximo")
    public double obtenerMaximo() {
        return calculadoraService.obtenerMaximo();
    }

    //http://localhost:8080/api/calculadora/minimo
    @GetMapping("/minimo")
    public double obtenerMinimo() {
        return calculadoraService.obtenerMinimo();
    }

    //http://localhost:8080/api/calculadora/promedio
    @GetMapping("/promedio")
    public double obtenerPromedio() {
        return calculadoraService.obtenerPromedio();
    }
}
