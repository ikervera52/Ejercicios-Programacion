package Modelo;

import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private String email;
    private ArrayList<Pedido> pedidos = new ArrayList<>();


    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.pedidos = new ArrayList<>();
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

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void setPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }
}
