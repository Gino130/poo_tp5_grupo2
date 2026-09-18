package com.grupo2.poo;

import java.util.Date;

import com.grupo2.poo.manager.ManagerEnvio;
import com.grupo2.poo.model.Envio;
import com.grupo2.poo.model.Paquete;
import com.grupo2.poo.model.Ruta;
import com.grupo2.poo.model.Vehiculo;

public class MainEnvio {

	public static void main(String[] args) {

		ManagerEnvio manager = new ManagerEnvio();

		//  Registrar vehículos

		Vehiculo camion = new Vehiculo("AA123BB", 1000, 5000);
		Vehiculo camionSecundario = new Vehiculo("AC456CD", 500, 2500);

		manager.registrarVehiculo(camion);
		manager.registrarVehiculo(camionSecundario);

		//  Registrar paquetes

		Paquete paquete1 = new Paquete("P001", "Notebook", 3.5, 20);

		Paquete paquete2 = new Paquete("P002", "Monitor", 6.0, 40);

		Paquete paquete3 = new Paquete("P003", "Teclado y mouse", 2.0, 15);

		Paquete paquete4 = new Paquete("P004", "Impresora", 8.0, 50);

		//  Registrar envíos

		Envio envio1 = new Envio(001, "Empresa Tecnológica S.A.", "Juan Pérez", "Av. Belgrano 123, San Pedro");

		Envio envio2 = new Envio(002, "Empresa Tecnológica S.A.", "María González", "Calle Mitre 456, San Pedro");

		Envio envio3 = new Envio(003, "Distribuidora Norte", "Carlos López", "Ruta Nacional 34 km 10");

		manager.registrarEnvio(envio1);
		manager.registrarEnvio(envio2);
		manager.registrarEnvio(envio3);

		//  Agregar paquetes

		envio1.agregarPaquete(paquete1);
		envio1.agregarPaquete(paquete2);
		envio2.agregarPaquete(paquete3);
		envio3.agregarPaquete(paquete4);

		//  Crear una ruta diaria

		Ruta ruta = manager.crearRuta(new Date(), camion);
		ruta.toString();

		//  Asignar envíos a la ruta

		manager.asignarEnvioARuta(001, ruta);
		manager.asignarEnvioARuta(002, ruta);

		System.out.println(ruta);

		//  Mostrar información

		System.out.println(envio1.mostrarInfo());
		System.out.println(envio2.mostrarInfo());
		
		 //  Despachar los envíos  
		
        envio1.despachar();        
        envio2.despachar();
        System.out.println("\nEstados luego del despacho:");        
        System.out.println(envio1.getId() + ": " + envio1.getEstado());        
        System.out.println(envio2.getId() + ": " + envio2.getEstado());
        
        // Entregar el primer envío 
        
        envio1.entregar();
        System.out.println("\nEstado del envío E001 luego de entregar:");        
        System.out.println(envio1.getEstado());
        
        //  Devolver el segundo envío 
        
        envio2.devolver();
        System.out.println("\nEstado del envío E002 luego de devolver:");        
        System.out.println(envio2.getEstado());
        
        // Mostrar información final 
        
        System.out.println(envio1.mostrarInfo());       
        System.out.println(envio2.mostrarInfo());

	}
	
	

}
