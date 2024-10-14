package com.practicaBasica.demo.model;

import java.util.ArrayList;

public class Alumno extends Persona {
	
	private Integer legajo;
	ArrayList<Integer> notas = new ArrayList<Integer>();
	
	public Integer getLegajo() {
		return legajo;
	}
	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}
	public ArrayList<Integer> getNotas() {
		return notas;
	}
	public void setNotas(ArrayList<Integer> notas) {
		this.notas = notas;
	}
	
	public double getPromedio() {
	      if (notas.isEmpty()) return 0;
	      int suma = 0;
	      for(int nota : notas) {
	    	  suma += nota;
	      }
	      return suma / (double) notas.size();
	}
}
