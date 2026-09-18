package com.grupo2.poo.model;

import java.util.ArrayList;
import java.util.List;

public class CarritoDeCompras {

    private int id;
    private List<ItemCarrito> items;

    public CarritoDeCompras(int id) {
        this.id = id;
        this.items = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ItemCarrito> getItems() {
        return items;
    }

    public void setItems(List<ItemCarrito> items) {
        this.items = items;
    }

    public void agregar(Producto p, int cantidad) {
        ItemCarrito item = new ItemCarrito(items.size() + 1, p, cantidad);
        items.add(item);
    }

    public void remover(Producto p) {

        ItemCarrito itemEliminar = null;

        for (ItemCarrito item : items) {
            if (item.getProducto().getCodigo().equals(p.getCodigo())) {
                itemEliminar = item;
                break;
            }
        }

        if (itemEliminar != null) {
            items.remove(itemEliminar);
        }
    }

    public double total() {

        double total = 0;

        for (ItemCarrito item : items) {
            total = total + item.subTotal();
        }

        return total;
    }

    public void vaciar() {
        items.clear();
    }

    @Override
    public String toString() {
        return "CarritoDeCompras{" +
                "id=" + id +
                ", items=" + items +
                '}';
    }
}