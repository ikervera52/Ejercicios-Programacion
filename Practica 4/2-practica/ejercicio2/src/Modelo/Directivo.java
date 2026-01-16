package Modelo;

import java.util.ArrayList;

public class Directivo extends Empleado{

    private String categoria;
    private ArrayList<Empleado> subordinados;

    public Directivo() {
    }

    public Directivo(String nombre, int edad, int sueldoBruto, String categoria) {
        super(nombre, edad, sueldoBruto);
        this.categoria = categoria;
    }

    public String mostrar(){
        return super.mostrar() + "\nCategoria: " + categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public ArrayList<Empleado> getSubordinados() {
        return subordinados;
    }

    public void setSubordinados(ArrayList<Empleado> subordinados) {
        this.subordinados = subordinados;
    }

    public void setSubordinado(Empleado subordinado) {
        if (this.subordinados == null) {
            this.subordinados = new ArrayList<>();
        }
        this.subordinados.add(subordinado);
    }
}
