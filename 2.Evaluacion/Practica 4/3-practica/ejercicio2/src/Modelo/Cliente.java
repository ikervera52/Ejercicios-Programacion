package Modelo;

import java.util.ArrayList;

public class Cliente extends Persona{

    private ArrayList<Mascota> mascotas;

    public Cliente(String nombre, String direccion, String telefono) {
        super(nombre, direccion, telefono);
    }

    public Cliente(){}

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public void setMascota(Mascota mascota) {
        if(mascotas == null){
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
            return  super.toString() +
            mascotas.size() + " mascotas a su cargo\n";
        }
    }
}
