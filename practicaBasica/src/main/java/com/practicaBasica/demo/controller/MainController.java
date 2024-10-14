package com.practicaBasica.demo.controller;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.practicaBasica.demo.model.Alumno;

@Controller
public class MainController {

	
	@GetMapping("/usuarios")
	public String index() {
	    return "index"; 
	}
	
    @GetMapping("/")
    @ResponseBody
    public String holaMundo() {
        return "Hola Mundo";
    }
    
    @GetMapping("multiplos7")
    @ResponseBody
    public String imprimirTablaDel7() {
        StringBuilder sb = new StringBuilder("Tabla del 7:<br>");
        for (int i = 1; i < 10; i++) {
            sb.append("7 x ").append(i).append(" = ").append(7 * i).append("<br>");
        }
        return sb.toString();
    }
    
    @GetMapping("ListadeNumerosAleatorios")
    @ResponseBody
    public String Generador(@RequestParam(required = false) Integer num) {
    	
    	Random rand = new Random();
    	ArrayList<Integer> numerosAleatorios = new ArrayList<>();
		for (int i = 1; i <= 99; i++) {
		    numerosAleatorios.add(rand.nextInt(99)+1);
        }
    	
    	StringBuilder sb = new StringBuilder();
    	
    	 if (num != null) {
    	        if (numerosAleatorios.contains(num)) {
    	            sb.append("<strong>Numero ").append(num).append(" encontrado.</strong><br>");
    	        } else {
    	            sb.append("<strong>Numero ").append(num).append(" no encontrado.</strong><br>");
    	        }
    	    }else {
    	    	sb.append("<strong>No se ingreso ningun numero como parametro de busqueda.</strong><br>");
    	    }
    	
    	 for(Integer numero : numerosAleatorios) {
    		 sb.append(numero).append("<br>");
    	 }
    
    	return sb.toString();
    }
    
    @GetMapping("VerificarEdad")
    @ResponseBody
    public String Verificacion(@RequestParam Integer edad) {
    	return (edad > 18)?"ES MAYOR DE EDAD":"ES MENOR DE EDAD";
    }
    
    @GetMapping("calcularPromedio")
    @ResponseBody
    public String calcularPromedio(@RequestParam String nombre, @RequestParam int legajo) {
        Alumno alumno = new Alumno();
        alumno.setNombre(nombre);
        alumno.setLegajo(legajo);
        alumno.getNotas().add(8);
        alumno.getNotas().add(9);
        alumno.getNotas().add(10);
        
        return "El promedio de " + alumno.getNombre() + " es: " + alumno.getPromedio();
    }

}
