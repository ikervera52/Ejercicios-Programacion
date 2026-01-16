package Modelo;

public class Empleado extends Persona {

    private int sueldoBruto;

    public Empleado() {

    }
    public Empleado(int sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    public Empleado(String nombre, int edad, int sueldoBruto) {
        super(nombre, edad);
        this.sueldoBruto = sueldoBruto;
    }

    public int getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(int sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    @Override
    public String mostrar() {
        return super.mostrar() + "\nSueldoBruto: " + this.sueldoBruto;
    }

    public double calcularSalario(){
        return this.sueldoBruto * 0.9;
    }
}
