package Modelo;

public class Pasajero {

    private String dni;
    private String nombre;
    private String telefono;
    private String vuelo;

    public Pasajero(String dni, String nombre, String telefono, String vuelo) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.vuelo = vuelo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getVuelo() {
        return vuelo;
    }

    public void setVuelo(String vuelo) {
        this.vuelo = vuelo;
    }

    @Override
    public String toString() {
        return
                "DNI: " + dni +
                " Nombre: " + nombre +
                " Teléfono: " + telefono +
                " Código de Vuelo: " + vuelo + '\n' ;
    }
}
