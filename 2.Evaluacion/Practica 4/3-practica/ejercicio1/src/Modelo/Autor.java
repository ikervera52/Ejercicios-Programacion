package Modelo;

import java.time.LocalDate;

public class Autor extends Persona {

    public Autor() {
    }

    public Autor(String nombre, LocalDate fechaNac, String paisNac) {
        super(nombre, fechaNac, paisNac);
    }
}
