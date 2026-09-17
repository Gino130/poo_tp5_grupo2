package com.grupo2.poo.model;

// import java.util.ArrayList;
// import java.util.List;

public class Ruta {

    private String fecha;
    private Vehiculo vehiculo;

    // habilitar cuando tenga la clase envios
    // private List<Envio> envios;

    public Ruta(String fecha, Vehiculo vehiculo) {
        this.fecha = fecha;
        this.vehiculo = vehiculo;

        // this.envios = new ArrayList<>();
    }

    public String getFecha() {
        return fecha;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    // habilita cuando se integre la clase Envio
    // public List<Envio> getEnvios() {
    //     return envios;
    // }
}