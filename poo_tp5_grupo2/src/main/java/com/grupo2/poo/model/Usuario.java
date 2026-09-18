package com.grupo2.poo.model;

public class Usuario {

    private String id;
    private String nombre;
    private String email;
    private CarritoDeCompras carrito;

    public Usuario(String id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.carrito = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CarritoDeCompras getCarrito() {
        return carrito;
    }

    public void setCarrito(CarritoDeCompras carrito) {
        this.carrito = carrito;
    }

    public void agregarAlCarrito(Producto p, int cantidad) {
        if (carrito != null) {
            carrito.agregar(p, cantidad);
        }
    }

    public void removerDelCarrito(Producto p) {
        if (carrito != null) {
            carrito.remover(p);
        }
    }

    public double verTotalCarrito() {
        if (carrito != null) {
            return carrito.total();
        }

        return 0;
    }

    public void mostrarCarrito() {
        if (carrito != null) {
            System.out.println(carrito);
        } else {
            System.out.println("El usuario no tiene carrito.");
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}