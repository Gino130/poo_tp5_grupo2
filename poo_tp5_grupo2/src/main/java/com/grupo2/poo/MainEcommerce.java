package com.grupo2.poo;

import com.grupo2.poo.model.CarritoDeCompras;
import com.grupo2.poo.model.Producto;
import com.grupo2.poo.model.Usuario;

public class MainEcommerce {

    public static void main(String[] args) {

        Producto producto1 = new Producto("P01", "Mouse", 15000, true);
        Producto producto2 = new Producto("P02", "Teclado", 25000, true);
        Producto producto3 = new Producto("P03", "Monitor", 180000, true);
        Producto producto4 = new Producto("P04", "Auriculares", 30000, true);
        Producto producto5 = new Producto("P05", "Webcam", 45000, true);

        Usuario usuario = new Usuario("1", "Gustavo", "gustavo@gmail.com");

        CarritoDeCompras carrito = new CarritoDeCompras(1);

        usuario.setCarrito(carrito);

        usuario.agregarAlCarrito(producto1, 2);
        usuario.agregarAlCarrito(producto2, 1);
        usuario.agregarAlCarrito(producto4, 1);

        System.out.println("=== CARRITO DE COMPRAS ===");
        usuario.mostrarCarrito();

        System.out.println("Total: $" + usuario.verTotalCarrito());

        System.out.println("\n=== REMOVER PRODUCTO ===");

        usuario.removerDelCarrito(producto2);

        usuario.mostrarCarrito();

        System.out.println("Nuevo total: $" + usuario.verTotalCarrito());

        System.out.println("\n=== VACIAR CARRITO ===");

        carrito.vaciar();

        usuario.mostrarCarrito();

        System.out.println("Total final: $" + usuario.verTotalCarrito());
    }
}