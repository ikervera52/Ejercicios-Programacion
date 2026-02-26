package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Pedido {

    private LocalDate fecha;
    private Usuario usuario;
    private Map<Producto, Integer> productos;

    public Pedido() {
    }

    public Pedido(LocalDate fecha, Usuario usuario) {
        this.fecha = fecha;
        this.usuario = usuario;
        this.productos = new HashMap<>();
    }

    public LocalDate getFehca() {
        return fecha;
    }

    public void setFehca(LocalDate fehca) {
        this.fecha = fehca;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Map<Producto, Integer> getProductos() {
        return productos;
    }

    public void setProductos(Map<Producto, Integer> productos) {
        this.productos = productos;
    }

    public void setProducto(Producto producto, int cantidad) {
        if(productos.containsKey(producto)){
            int cant = productos.get(producto);
            cant = cant + cantidad;
            productos.put(producto, cant);
        } else this.productos.put(producto, cantidad);
    }
}
