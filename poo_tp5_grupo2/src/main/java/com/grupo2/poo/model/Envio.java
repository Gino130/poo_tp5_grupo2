package com.grupo2.poo.model;

import java.util.ArrayList;
import java.util.List;

public class Envio {
	private int id;
	private String remitente;
	private String destinatario;
	private String estado;
	private String direccion;
	private List<Paquete> paquetes;
	private Ruta ruta;

	public Envio(int id, String remitente, String destinatario, String direccion) {
		this.id = id;
		this.remitente = remitente;
		this.destinatario = destinatario;
		this.direccion = direccion;
		this.estado = "GENERADO";
		this.paquetes = new ArrayList<>();
		this.ruta = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRemitente() {
		return remitente;
	}

	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Paquete> getPaquetes() {
		return paquetes;
	}

	public void setPaquetes(List<Paquete> paquetes) {
		this.paquetes = paquetes;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	public void agregarPaquete(Paquete paquete) {
		paquetes.add(paquete);
	}

	public void asignarRuta(Ruta ruta) {
		if (paquetes.isEmpty()) {
			System.out.println("No se puede asignar un envío sin paquetes");
			return;
		}
		if (!ruta.puedeAgregar(this)) {
			System.out.println("El envío supera la capacidad disponible de la ruta.");
			return;
		}
		this.ruta = ruta;
		ruta.agregarEnvioInterno(this);
		this.estado = "EN_ALMACEN";
	}

	public void despachar() {
		if (ruta == null) {
			System.out.println("No se puede despachar un envío sin ruta");
			return;
		}
		if (estado != "EN_ALMACEN") {
			System.out.println("El envío debe estar en estado EN_ALMACEN.");
			return;
		}

		setEstado("EN RUTA");
	}

	public double calcularPesoTotal() {
		double total = 0;
		for (Paquete paquete : paquetes) {
			total += paquete.getPeso();
		}
		return total;
	}

	public double calcularVolumenTotal() {
		double total = 0;
		for (Paquete paquete : paquetes) {
			total += paquete.getVolumen();
		}
		return total;
	}

	public void devolver() {
		if (estado == "ENTREGADO") {
			System.out.println("No se puede devolver un envío ya entregado.");
			return;
		}
		if (estado == "CANCELADO") {
			System.out.println("No se puede devolver un envío cancelado.");
			return;
		}
		setEstado("DEVUELTO");
	}

	public void entregar() {
		if (estado == "EN_RUTA") {
			System.out.println("No se puede entregar un envío ya entregado.");
			return;
		}

		estado = "ENTREGADO";
	}

	public String mostrarInfo() {
		StringBuilder informacion = new StringBuilder();
		informacion.append("\n===== INFORMACIÓN DEL ENVÍO =====\n");
		informacion.append("ID: ").append(id).append("\n");
		informacion.append("Remitente: ").append(remitente).append("\n");
		informacion.append("Destinatario: ").append(destinatario).append("\n");
		informacion.append("Dirección: ").append(direccion).append("\n");
		informacion.append("Estado: ").append(estado).append("\n");
		informacion.append("Cantidad de paquetes: ").append(paquetes.size()).append("\n");
		informacion.append("Peso total: ").append(calcularPesoTotal()).append(" kg\n");
		informacion.append("Volumen total: ").append(calcularVolumenTotal()).append(" dm3\n");
		if (ruta != null) {
			informacion.append("Ruta: ").append(ruta.getFecha()).append("\n");
			informacion.append("Vehículo: ").append(ruta.getVehiculo().getPatente()).append("\n");
		} else {
			informacion.append("Ruta: Sin asignar\n");
		}
		informacion.append("Paquetes:\n");
		for (Paquete paquete : paquetes) {
			informacion.append("  - ").append(paquete).append("\n");
		}
		informacion.append("=================================\n");
		return informacion.toString();
	}

	@Override
	public String toString() {
		return "Envio{" + "id='" + id + '\'' + ", destinatario='" + destinatario + '\'' + ", estado=" + estado
				+ ", pesoTotal=" + calcularPesoTotal() + '}';
	}
}
