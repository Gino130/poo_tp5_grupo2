package com.grupo2.poo.model;

import java.util.ArrayList;
import java.util.List;

public class ManagerProducto {

    private List<Producto> productos;

    public ManagerProducto() {
        productos = new ArrayList<>();

        productos.add(new Producto("P001", "Teclado", 25000, true));
        productos.add(new Producto("P002", "Mouse", 15000, true));
        productos.add(new Producto("P003", "Monitor", 180000, true));
        productos.add(new Producto("P004", "Auriculares", 35000, true));
        productos.add(new Producto("P005", "Webcam", 45000, true));
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public Producto buscarProducto(String codigo) {

        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }

        return null;
    }
}