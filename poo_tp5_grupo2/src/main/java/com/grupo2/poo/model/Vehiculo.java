package com.grupo2.poo.model;

public class Vehiculo {

	private String patente;
	private double capacidadPeso;
	private double capacidadVolumen;

	public Vehiculo(String patente, double capacidadPeso, double capacidadVolumen) {
		this.patente = patente;
		this.capacidadPeso = capacidadPeso;
		this.capacidadVolumen = capacidadVolumen;
	}

	public String getPatente() {
		return patente;
	}

	public double getCapacidadPeso() {
		return capacidadPeso;
	}

	public double getCapacidadVolumen() {
		return capacidadVolumen;
	}

	@Override
	public String toString() {
		return "Vehiculo{" + "patente='" + patente + '\'' + ", capacidadPesoKg=" + capacidadPeso
				+ ", capacidadVolumenDm3=" + capacidadVolumen + '}';
	}
}