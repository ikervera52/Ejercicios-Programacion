package Modelo;

import java.util.ArrayList;

public class Veterinario extends Persona{

    private String dni;
    private String numSegSocial;
    private ArrayList<Mascota> mascotas;

    public Veterinario() {
    }

    public Veterinario(String nombre, String direccion, String telefono, String dni, String numSegSocial) {
        super(nombre, direccion, telefono);
        this.dni = dni;
        this.numSegSocial = numSegSocial;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNumSegSocial() {
        return numSegSocial;
    }

    public void setNumSegSocial(String numSegSocial) {
        this.numSegSocial = numSegSocial;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public void setMascota(Mascota mascota) {
        if (mascotas == null) {
            mascotas = new ArrayList<>();
        }
        this.mascotas.add(mascota);
    }

    @Override
    public String toString() {
        if (mascotas == null) {
            return null;
        }
        else {
            return
                    super.toString() +
                    mascotas.size() + " mascotas asociadas\n";
        }
    }
}

