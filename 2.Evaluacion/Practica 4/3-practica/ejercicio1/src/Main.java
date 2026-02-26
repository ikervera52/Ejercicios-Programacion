import Modelo.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner sc;

    private static ArrayList<Alumno> alumnos;

    private static ArrayList<Libro> libros;

    public static void main(String[] args) {

        sc = new Scanner(System.in);
        alumnos = new ArrayList<>();
        libros = new ArrayList<>();

        ArrayList<Autor> autores = crearAutores();
        crearLibros(autores);
        crearAlumnos();


        opcionesPrincipales();

    }

    public static ArrayList<Autor> crearAutores() {

        ArrayList<Autor> autores = new ArrayList<>();

        Autor autor1 = new Autor("autor1", LocalDate.of(1999, 10, 20), "España");
        Autor autor2 = new Autor("autor2", LocalDate.of(2000,12,12), "USA");
        Autor autor3 = new Autor("autor3", LocalDate.of(2000,12,12), "USA");

        autores.add(autor1);
        autores.add(autor2);
        autores.add(autor3);

        return  autores;
    }

    public static void crearLibros(ArrayList<Autor> autores) {

        Libro libro1 = new Libro("libro1", "ABC", 200, autores.getFirst());
        Libro libro2 = new Libro("libro2", "DEF", 300, autores.get(1));
        Libro libro3 = new Libro("libro3", "GHI", 400, autores.getLast());
        Libro libro4 = new Libro("libro4", "JKL", 500, autores.get(2));
        Libro libro5 = new Libro("libro5", "KLM", 600, autores.get(0));
        Libro libro6 = new Libro("libro6", "LUX", 700, autores.get(2));

        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);
        libros.add(libro4);
        libros.add(libro5);
        libros.add(libro6);
    }

    public static void crearAlumnos(){

        Alumno alumno1 = new Alumno("alumno1", LocalDate.of(2004, 9, 7), "España", "58012197X");
        Alumno alumno2 = new Alumno("alumno2", LocalDate.of(2004, 9, 7), "España", "58012197X");
        Alumno alumno3 = new Alumno("alumno3", LocalDate.of(2004, 9, 7), "España", "58012197X");

        alumnos.add(alumno1);
        alumnos.add(alumno2);
        alumnos.add(alumno3);
    }

    public static void opcionesPrincipales(){
        boolean salir = false;
        do {
            try {
                System.out.print("""
                --- Menú de opciones Principales ---
                1. Identificarse
                2. Salir
                Que quieres hacer:\s""");
                int opcion = sc.nextInt();
                sc.nextLine();
                switch(opcion){
                    case 1:
                        int posicionAlumno = identificacion();
                        menuOpciones(posicionAlumno);
                        break;
                    case 2:
                        salir = true;
                        break;
                    default:
                        throw new Error();
                }
            }
            catch(Error e){
                System.out.println("* Opción no valida *");
            }
            catch (InputMismatchException e){
                sc.nextLine();
                System.out.println("* Caracteres no permitidos *");
            }

        }while(!salir);
        System.out.println("--> Fin del programa");

    }

    public static int identificacion(){
       boolean valido = false;
       int posicion = -1;
        while(!valido){
            try{
                System.out.print("Identificate con tu nombre: ");
                String nombre = sc.nextLine();
                for(int i = 0; i < alumnos.size(); i++){
                    if(nombre.equals(alumnos.get(i).getNombre())){
                        System.out.println("--> Identificación exitosa");
                        valido = true;
                        posicion = alumnos.indexOf(alumnos.get(i));
                    }
                }
                if (posicion == -1){
                    throw new Error();
                }
            }
            catch(Error e){
                System.out.println("* Identificación no valida *");
            }
        }

        return posicion;
    }

    public static void menuOpciones(int posicionAlumno) {
        boolean salir = false;
        do {
            try {
                System.out.print("""
                        --- Menú de opciones ---
                        1. Alquilar libro
                        2. Devolver libro
                        3. Ver datos disponibles
                        4. Volver al menú principal
                        Que quieres hacer:\s""");
                int opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1 -> alquilarLibro(posicionAlumno);
                    case 2 -> devolverLibro(posicionAlumno);
                    case 3 -> verDatos();
                    case 4 -> salir = true;
                    default -> throw new Error();
                }
            } catch (Error e){
                System.out.println("* Opción no valida *");
            }
            catch (InputMismatchException e){
                sc.nextLine();
                System.out.println("* Caracteres no permitidos *");
            }

        }while (!salir);
    }

    public static void alquilarLibro(int posicionAlumno) {

        int accion = 1;
        int posicionLibro = -1;
        boolean librosAlquilados;

        try {
            System.out.print("Que libro quieres alquilar: ");
            String nombreLibro = sc.nextLine();

            //Comprobar que existe el libro
            for (int i = 0; i < libros.size(); i++) {
                if (nombreLibro.equals(libros.get(i).getTitulo())) {
                    posicionLibro = libros.indexOf(libros.get(i));
                }
            }
            if (posicionAlumno == -1) {
                throw new Error();
            }

            if(libros.get(posicionLibro).getNumEjemplares() <= 0){
                throw new NoLibrosDisponibles();
            } else {
                libros.get(posicionLibro).modificar(accion);
                librosAlquilados = alumnos.get(posicionAlumno).setLibro(libros.get(posicionLibro));
                System.out.println("--> Libro alquilado con éxito");
            }

            if(librosAlquilados){
                throw new CantidadMaximaDeLibros();
            }
        }
        catch(Error e){
            System.out.println("* Libro no encontrado *");
        }
        catch(NoLibrosDisponibles e){
            System.out.println("* Libro no disponible para alquilar *");
        }
        catch(CantidadMaximaDeLibros e){
            System.out.println("* Cantidad de libros sobrepasada - No puedes alquilar más libros*");
        }

    }

    public static void devolverLibro(int posicionAlumno) {

        int accion = 2;
        int posicionLibro = 0;

        try {
            System.out.print("Que libro quieres devolver: ");
            String nombreLibro = sc.nextLine();

            // Comprobar si el alumno tiene ese libro alquilado
            for(int i = 0; i < alumnos.get(posicionAlumno).getLibros().size() && !alumnos.get(posicionAlumno).getLibros().get(i).getTitulo().equals(nombreLibro); i++){
                if (!nombreLibro.equals(alumnos.get(posicionAlumno).getLibros().get(i).getTitulo())){
                    // Si no lo tiene
                    throw new Error();
                }
            }
            // Coger la posición de ese libro
            for(Libro libro : libros){
                if (libro.getTitulo().equals(nombreLibro)){
                    posicionLibro = libros.indexOf(libro);
                }
            }

            // Devolver el libro y borrarlo del alumno
            libros.get(posicionLibro).modificar(accion);
            alumnos.get(posicionAlumno).devolverLibro(libros.get(posicionLibro));
            System.out.println("--> Libro devuelto con éxito");
        }
        catch(Error e){
            System.out.println("* No tienes este libro alquilado");
        }
    }

    public static void verDatos() {
        System.out.println("\n-- Libros disponibles ---");
        for(Libro libro : libros){
            System.out.println(" - " +libro.getTitulo() + ": "  + libro.getNumEjemplares() + " disponibles");
        }


        System.out.println("\n-- Libros alquilados ---");
        int contador = 0;
        for(Alumno alumno : alumnos){
            if(!(alumno.getLibros() == null) && !alumno.getLibros().isEmpty()){
                contador++;
                for(Libro libro : alumno.getLibros()){
                    System.out.println("'" +  libro.getTitulo() +"' esta alquilado por " + alumno.getNombre());
                }
            }

        }
        if(contador == 0){
            System.out.println(" - No hay libros alquilados en este momento\n");
        }
    }

}