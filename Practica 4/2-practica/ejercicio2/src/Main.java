import Modelo.Directivo;
import Modelo.Empleado;

import java.util.ArrayList;


public class Main {

    public static ArrayList<Directivo> directivos;
    public static void main(String[] args) {

        ArrayList<Empleado> empleados = crearEmpleados();
        crearDirectivos(empleados);
        mayorNumeroSubordinados();

    }

    public static ArrayList<Empleado> crearEmpleados(){
        ArrayList<Empleado> empleados = new ArrayList<>();
        Empleado empleado1 = new Empleado("Iker", 20, 20000);
        Empleado empleado2 = new Empleado("Jose", 13, 10000);
        Empleado empleado3 = new Empleado("Juan", 60, 60000);
        Empleado empleado4 = new Empleado("Miguel", 49, 25000);

        empleados.add(empleado1);
        empleados.add(empleado2);
        empleados.add(empleado3);
        empleados.add(empleado4);

        return empleados;

    }
    public static void crearDirectivos(ArrayList<Empleado> empleados){
        directivos = new ArrayList<>();
        Directivo directivo1 = new Directivo("Poza", 56, 34500, "Ciencia");
        Directivo directivo2 = new Directivo("Manuel", 40, 389000, "Comida");
        Directivo directivo3 = new Directivo("Julen", 30, 38400, "Informatica");

        directivos.add(directivo1);
        directivos.add(directivo2);
        directivos.add(directivo3);

        // Declarar subordinados de cada directivo
        // Directivo 1
        directivo1.setSubordinado(empleados.getFirst());
        directivo1.setSubordinado(empleados.get(1));
        directivo1.setSubordinado(empleados.get(2));

        //Directivo 2
        directivo2.setSubordinado(empleados.get(2));
        directivo2.setSubordinado(empleados.get(3));

        //Directivo 3
        directivo3.setSubordinado(empleados.get(0));
    }

    public static void mayorNumeroSubordinados(){
        int maximo = 0;
        String nombre = null;
        for(Directivo directivo: directivos){
            if (directivo.getSubordinados().size() >= maximo){
                maximo = directivo.getSubordinados().size();
                nombre = directivo.getNombre();
            }
        }

        System.out.println("\nEl directivo con mayor numero de subordinados es " + nombre +
                " y tiene " + maximo + " subordinados");
    }
}