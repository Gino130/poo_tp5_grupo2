package com.grupo2.poo.model;

import java.util.Date;

import java.util.ArrayList;
import java.util.List;

public class Ruta {

	private Date fecha;
	private Vehiculo vehiculo;
	private List<Envio> envios;

	public Ruta(Date fecha, Vehiculo vehiculo) {
		this.fecha = fecha;
		this.vehiculo = vehiculo;

		this.envios = new ArrayList<>();
	}

	public Date getFecha() {
		return fecha;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public List<Envio> getEnvios() {
		return envios;
	}

	public boolean puedeAgregar(Envio envio) {
		double pesoAcumulado = getPesoTotal() + envio.calcularPesoTotal();
		double volumenAcumulado = getVolumenTotal() + envio.calcularVolumenTotal();
		return pesoAcumulado <= vehiculo.getCapacidadPeso() && volumenAcumulado <= vehiculo.getCapacidadVolumen();
	}

	public double getPesoTotal() {
		double total = 0;
		for (Envio envio : envios) {
			total += envio.calcularPesoTotal();
		}
		return total;
	}

	public double getVolumenTotal() {
		double total = 0;
		for (Envio envio : envios) {
			total += envio.calcularVolumenTotal();
		}
		return total;
	}

	void agregarEnvioInterno(Envio envio) {
		if (!envios.contains(envio)) {
			envios.add(envio);
		}
	}

	@Override
	public String toString() {
		return "Ruta{" + "fecha=" + fecha + ", vehiculo=" + vehiculo.getPatente() + ", cantidadEnvios=" + envios.size()
				+ ", pesoTotal=" + getPesoTotal() + ", volumenTotal=" + getVolumenTotal() + '}';
	}
}