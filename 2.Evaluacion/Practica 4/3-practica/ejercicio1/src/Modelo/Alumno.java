package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Alumno extends Persona {

    private String dni;
    private ArrayList<Libro> libros;

    public Alumno(String dni) {
        this.dni = dni;
    }

    public Alumno(String nombre, LocalDate fechaNac, String paisNac, String dni) {
        super(nombre, fechaNac, paisNac);
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public boolean setLibro(Libro libro){

        if(this.libros == null){
            this.libros = new ArrayList<>();
        }
        if(this.libros.size() < 2){
            this.libros.add(libro);
            return false;
        }
        else return true;



    }

    public void devolverLibro(Libro libro){
        this.libros.remove(libro);
    }
}
