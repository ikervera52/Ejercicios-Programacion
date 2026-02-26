package Modelo;

import java.util.ArrayList;

public class Empresa {

    private String nombre;
    private ArrayList<Cliente> clientes;
    private ArrayList<Empleado> empleados;

    public Empresa(String nombre){
    }
    public Empresa(String nombre, ArrayList<Cliente> clientes, ArrayList<Empleado> empleados) {
        this.nombre = nombre;
        this.clientes = clientes;
        this.empleados = empleados;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void setCliente(Cliente cliente) {
        if(this.clientes == null){
            this.clientes = new ArrayList<>();
        }
        this.clientes.add(cliente);
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void setEmpleado(Empleado empleado) {
        if(this.clientes == null){
            this.empleados = new ArrayList<>();
        }
        this.empleados.add(empleado);
    }
}
