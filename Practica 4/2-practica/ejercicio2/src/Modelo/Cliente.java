package Modelo;

public class Cliente extends Persona{

    private String telefono;

    public Cliente() {
    }

    public Cliente(String telefono) {
        this.telefono = telefono;
    }

    public Cliente(String nombre, int edad, String telefono) {
        super(nombre, edad);
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String mostrar(){
        return super.mostrar() + "\nTeléfono: " + telefono;
    }
}
