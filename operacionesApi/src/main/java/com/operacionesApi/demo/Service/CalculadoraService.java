package com.operacionesApi.demo.Service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CalculadoraService {

    private List<Double> numeros = Arrays.asList(2.0, 3.0, 5.0, 6.0, 10.0, 19.0, 50.0, 3131.0, 13.0, 2.0);

    public double sumar(double a, double b) {
        return a + b;
    }

    public double restar(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }

    public double dividir(double a, double b) {
        if (b == 0) throw new ArithmeticException("No se puede dividir por cero.");
        return a / b;
    }

    public double obtenerMaximo() {
        return numeros.stream().max(Double::compare).orElseThrow(() -> new IllegalArgumentException("Lista vacía"));
    }

    public double obtenerMinimo() {
        return numeros.stream().min(Double::compare).orElseThrow(() -> new IllegalArgumentException("Lista vacía"));
    }

    public double obtenerPromedio() {
        return numeros.stream().mapToDouble(Double::doubleValue).average().orElseThrow(() -> new IllegalArgumentException("Lista vacía"));
    }
}

