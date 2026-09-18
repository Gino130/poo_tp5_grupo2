package com.grupo2.poo.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.grupo2.poo.model.Envio;
import com.grupo2.poo.model.Ruta;
import com.grupo2.poo.model.Vehiculo;

public class ManagerEnvio {
	private List<Envio> envios= new ArrayList<>() ;
	private List<Vehiculo> vehiculos= new ArrayList<>() ;
	private List<Ruta> rutas= new ArrayList<>();
	
	public void registrarEnvio(Envio envio) {
		this.envios.add(envio);
	}

	public void registrarVehiculo(Vehiculo vehiculo) {
		this.vehiculos.add(vehiculo);
	}

	public Envio buscarEnvioPorId(int id) {
		for (Envio e : envios) {
			if (e.getId() == id) {
				return e;
			}
		}
		return null;
	}

	public Vehiculo buscarVehiculoPorPatente(String patente) {
		for (Vehiculo v : vehiculos) {
			if (v.getPatente().equalsIgnoreCase(patente)) {
				return v;
			}
		}
		return null;
	}
	
	public Ruta crearRuta(Date fecha,Vehiculo vehiculo) {
		Ruta ruta =new Ruta(fecha,vehiculo);
		rutas.add(ruta);
		
		return ruta;
	}
	
	public void asignarEnvioARuta(int idEnvio, Ruta ruta) {
		Envio envio = buscarEnvioPorId(idEnvio);
		
		if (envio == null) {           
			System.out.println("No se encontró el envío con ID " + idEnvio);
			return;
       }
		 envio.asignarRuta(ruta);
		
	}
}
