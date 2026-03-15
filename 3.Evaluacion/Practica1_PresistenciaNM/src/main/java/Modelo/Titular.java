package Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "titulares")
public class Titular {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 15)
    private String nombre;

    @Column(name = "dni", nullable = false, length = 9)
    private String dni;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Titular(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public Titular() {
    }

    @Override
    public String toString() {
        return "ID: " + id + " Nombre= " + nombre + " DNI= " + dni + '\n';
    }
}