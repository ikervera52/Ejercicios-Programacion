import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    final static Scanner sc = new Scanner(System.in);

    public static  HashSet<String> porteros = new HashSet<>();
    public static  HashSet<String> defensas = new HashSet<>();
    public static  HashSet<String> delanteros = new HashSet<>();
    public static  HashSet<String> centrocampistas = new HashSet<>();

    public static void main(String[] args) {

        menu();
        finPrograma();
    }
    public static void menu(){
        boolean error = true;
        do {
            try{
                System.out.print("""
                --- Menú de opciones ---
                a) dar de alta
                b) dar de baja
                c) modificar jugador
                d) salir
                Que quieres hacer:\s""");

                switch (sc.nextLine().toLowerCase()){
                    case "a":
                        darDeAlta();
                        break;
                    case "b":
                        darDeBaja();
                        break;
                    case "c":
                        modificarJugador();
                        break;
                    case "d":
                        error = false;
                        break;
                    default:
                        throw new Error();
                }
            }
            catch (Error ex){
                System.out.println("Error");
            }

        }while(error);
    }

    public static void darDeAlta(){
        boolean salir = true;
        boolean jugadorExiste;
        do {
            try{
                Pattern patron = Pattern.compile("^[A-Z][a-z]+ [A-Z][a-z]+$");
                System.out.print("Nombre y apellido del jugador: ");
                String nombre = sc.nextLine();
                Matcher mat = patron.matcher(nombre);
                if(!mat.matches()){
                    throw new Error();
                }
                System.out.print("Posición del jugador: ");
                switch(sc.nextLine().toLowerCase()){
                    case "portero":
                        jugadorExiste = porteros.add(nombre.toLowerCase());
                        break;
                    case "defensa":
                        jugadorExiste = defensas.add(nombre.toLowerCase());
                        break;
                    case "centrocampista":
                        jugadorExiste = centrocampistas.add(nombre.toLowerCase());
                        break;
                    case "delantero":
                        jugadorExiste = delanteros.add(nombre.toLowerCase());
                        break;
                    default:
                        throw new Error();
                }

                if(!jugadorExiste){
                    System.out.println("El jugador ya existe");
                } else{
                    System.out.println("--> Jugador guardado con éxito");
                    salir = false;
                }
            }
            catch (Error ex) {
                System.out.println("Error");
            }

        }while(salir);
    }

    public static void darDeBaja(){
        boolean error = true;
        boolean jugadorExiste;
        do {
            try {
                System.out.print("Nombre del jugador: ");
                String nombre = sc.nextLine().toLowerCase();

                System.out.print("Posición del jugador: ");
                switch(sc.nextLine().toLowerCase()){
                    case "portero":
                        jugadorExiste = porteros.remove(nombre);
                        break;
                    case  "defensa":
                        jugadorExiste = defensas.remove(nombre);
                        break;
                    case "centrocampista":
                        jugadorExiste = centrocampistas.remove(nombre);
                        break;
                    case "delantero":
                        jugadorExiste = delanteros.remove(nombre);
                        break;
                    default:
                        throw new Error();
                }
                if(!jugadorExiste){
                    System.out.println("** El jugador no existe **");
                }else {
                    System.out.println("--> Jugador eliminado con éxito");
                    error = false;
                }
            }
            catch (Error ex) {
                System.out.println("** Posición no valida, vuelve a intentarlo **");
            }
        } while (error);
    }

    public static void modificarJugador(){
        boolean error = true;
        boolean existe;
        String nombre;
        String posicion;
        do {
            try {
                do {
                    System.out.print("Nombre del jugador: ");
                    nombre = sc.nextLine().toLowerCase();

                    System.out.print("Posición del jugador: ");
                    posicion = sc.nextLine().toLowerCase();
                    switch(posicion){
                        case "portero":
                            existe = porteros.remove(nombre);
                            break;
                        case "defensa":
                            existe = defensas.remove(nombre);
                            break;
                        case "centrocampista":
                            existe = centrocampistas.remove(nombre);
                            break;
                        case "delantero":
                            existe = delanteros.remove(nombre);
                            break;
                        default:
                            throw new Error();
                    }
                    if(!existe) System.out.println("** El jugador no existe, vuelva a intentarlo **");

                }while(!existe);

                opcionesModificarJugador(nombre, posicion);
                error = false;
            }
            catch (Error ex) {
                System.out.println("** La posición indicado no existe **");
            }
        }while(error);
    }
    // Menú de opciones para modificar al Jugador
    public static void opcionesModificarJugador(String nombre, String posicion){
        boolean error = true;
        String nuevoNombre = "";
        do {
            try {
                System.out.print("""
                        --- Opciones de modificación ---
                        a) Modificar nombre
                        b) Modificar posición
                        Que quieres hacer:\s""");
                switch (sc.nextLine().toLowerCase()){
                    case "a":
                        nuevoNombre = modificarNombre(posicion, nombre);
                        break;
                    case "b":
                        posicion = modificarPosicion(nombre, posicion, nuevoNombre);
                        break;
                    default:
                        throw new Error();
                }
                error = masOpciones();
            }
            catch (Error e){
                System.out.println("Error");
            }

        }while(error);
    }
    // Opciones para modificar al Jugador
    public static String modificarNombre(String posicion, String nombre){
        boolean error = true;
        boolean existe;
        String nuevoNombre = "";
        do {
            try {
                Pattern patron = Pattern.compile("^[A-Z][a-z]+ [A-Z][a-z]+$");
                System.out.print("Modificar nombre del jugador " + nombre + ":\n "
                        + "Modificación: ");
                nuevoNombre = sc.nextLine();
                Matcher mat = patron.matcher(nuevoNombre);
                if(!mat.matches()){
                    throw new Error();
                }
                switch(posicion){
                    case "portero":
                        existe = porteros.add(nuevoNombre.toLowerCase());
                        break;
                    case "defensa":
                        existe = defensas.add(nuevoNombre.toLowerCase());
                        break;
                    case "centrocampista":
                        existe = centrocampistas.add(nuevoNombre.toLowerCase());
                        break;
                    case "delantero":
                        existe = delanteros.add(nuevoNombre.toLowerCase());
                        break;
                    default:
                        throw new Error();
                }
                if(!existe){
                    throw new Error();
                }
                error = false;

            }
            catch (Error e){
                System.out.println("** Error, vuelve a intentarlo **");
            }
        }while(error);
        return nuevoNombre.toLowerCase();
    }
    public static String modificarPosicion(String nombre, String posicion, String nuevoNombre){
        boolean error = true;
        String nuevaPosicion = "";
        do {
            try {
                if(nuevoNombre.isEmpty()){
                    nuevoNombre = nombre;
                }

                System.out.print("En que posición vas a asignar a " + nuevoNombre + ": ");
                nuevaPosicion = sc.nextLine().toLowerCase();

                switch(nuevaPosicion){
                    case "portero":
                        porteros.add(nuevoNombre);
                        break;
                    case "defensa":
                        defensas.add(nuevoNombre);
                        break;
                    case "centrocampista":
                        centrocampistas.add(nuevoNombre);
                        break;
                    case "delantero":
                        delanteros.add(nuevoNombre);
                        break;
                    default:
                        throw new Error();
                }
                switch(posicion){
                    case "portero":
                        porteros.remove(nuevoNombre);
                        break;
                    case "defensa":
                        defensas.remove(nuevoNombre);
                        break;
                    case "centrocampista":
                        centrocampistas.remove(nuevoNombre);
                        break;
                    case "delantero":
                        delanteros.remove(nuevoNombre);
                        break;
                    default:
                        throw new Error();

                }
                error = false;

            }catch (Error e){
                System.out.println("Error");
            }
        }while(error);

        return nuevaPosicion;
    }

    public static boolean masOpciones(){
        boolean error = true;
        boolean devolver = true;
        do {
            try {
                System.out.print("Quieres hacer mas modificaciones: ");
                switch(sc.nextLine().toLowerCase()){
                    case"si":
                        break;
                    case "no":
                        devolver = false;
                        break;
                    default:
                        throw new Error();
                }
                error = false;
            }
            catch (Error e){
                System.out.println("Error");
            }
        } while(error);
        return devolver;
    }

    public static void finPrograma(){
        System.out.println("--> Fin del programa");
    }
}