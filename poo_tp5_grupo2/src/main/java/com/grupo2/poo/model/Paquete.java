package com.grupo2.poo.model;

public class Paquete {

    private String codigo;
    private String descripcion;
    private double peso;
    private double volumen;

    public Paquete(String codigo, String descripcion, double peso, double volumen) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.peso = peso;
        this.volumen = volumen;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    @Override
    public String toString() {
        return "Paquete{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", peso=" + peso +
                ", volumen=" + volumen +
                '}';
    }
}