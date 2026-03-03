package Modelo;

public class Titular {

    private String nombre;
    private String dni;
    private int id;

    public Titular(int id){
        this.id=id;
    }
    public Titular(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }
    public Titular(int id, String nombre, String dni) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ID: " + id + '\n' +
                "Nombre: " + nombre + '\n' +
                "DNI: " + dni + "\n";
    }
}
