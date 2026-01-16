import Modelo.Persona;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static Scanner sc;
    public static ArrayList <Persona> personas;
    public static void main(String[] args) {

        sc = new Scanner (System.in);
        personas = new ArrayList<>();

        pedirDatos();
        buscar();
        System.out.println("\n--> Fin del programa");
    }

    public static void pedirDatos(){
        int contador = 1;
        boolean continuar;
        do {
            System.out.println("-- Datos de persona " + contador + " --");
            String nombre = pedirNombre();
            LocalDate nacimiento = pedirFechaNacimiento();
            String direccion = pedirDireccion();
            String codigoPostal = pedirCodPostal();
            String ciudad = pedirCiudad();

            personas.add(new Persona(nombre, nacimiento.getDayOfMonth(), nacimiento.getMonthValue(), nacimiento.getYear() ,direccion, codigoPostal, ciudad));

            contador++;
            continuar = confirmarContinuar();

        } while (continuar);
    }

    public static String pedirNombre(){
        String nombre = null;
        boolean error = true;
        do {
            try {
                Pattern patron = Pattern.compile("^[a-z]+$");
                System.out.print("Nombre: ");
                nombre = sc.nextLine();
                Matcher m = patron.matcher(nombre);
                if (!m.matches()){
                    throw new Error();
                }
                error = false;

            }
            catch (Error e){
                System.out.println("* Nombre no valido*");
            }
        } while (error);
        return nombre;
    }

    public static LocalDate pedirFechaNacimiento(){
        LocalDate nacimiento = null;

        try {
            int dia;
            int mes;
            int ano;
            System.out.print("Dia de nacimiento: ");
            dia = sc.nextInt();

            System.out.print("Mes de nacimiento: ");
            mes = sc.nextInt();

            System.out.print("Año de nacimiento: ");
            ano = sc.nextInt();
            sc.nextLine();

            nacimiento = LocalDate.of (ano, mes, dia);


        }
        catch (DateTimeException e){
            System.out.println("* Fecha no valida *");
        }
        return nacimiento;
    }

    public static String pedirDireccion(){
        String direccion = null;
        try{
            Pattern patron = Pattern.compile("^[A-Za-z ]+");
            System.out.print("Dirección: ");
            direccion = sc.nextLine();
            Matcher m = patron.matcher(direccion);
            if (!m.matches()){
                throw new Error();
            }
        }
        catch (Error e){
            System.out.println("* Dirección no valido*");
        }
        return direccion;
    }

    public static String pedirCodPostal(){
        String codigo = null;
        try{
            Pattern patron = Pattern.compile("^[0-9]{5}");
            System.out.print("Código postal: ");
            codigo = sc.nextLine();
            Matcher m = patron.matcher(codigo);
            if (!m.matches()){
                throw new Error();
            }
        }
        catch (Error e){
            System.out.println("* Código postal no valido*");
        }
        return codigo;
    }

    public static String pedirCiudad(){
        String ciudad = null;
        try{
            Pattern patron = Pattern.compile("^[a-z]+");
            System.out.print("Ciudad: ");
            ciudad = sc.nextLine();
            Matcher m = patron.matcher(ciudad);
            if (!m.matches()){
                throw new Error();
            }
        }
        catch (Error e){
            System.out.println("* Ciudad no valida*");
        }
        return ciudad;
    }

    public static boolean confirmarContinuar(){
        boolean continuar = true;
        boolean error = true;
        do {
            try{
                System.out.print("Quieres añadir más personas (si/no): ");
                String respuesta = sc.nextLine();
                if (respuesta.equals("no")){
                    continuar = false;
                    error = false;
                } else if (respuesta.equals("si")){
                    error = false;
                } else throw new Error();
            }
            catch (Error e){
                System.out.println("* Respuesta no valida *");
            }
        } while (error);

        return continuar;
    }

    public static void buscar(){
        LocalDate nacimientoMayor = LocalDate.now();
        String nombrePersonaMayor = null;

        ArrayList <String> personasDeElche = new ArrayList<>();
        ArrayList <String> mayoresDeEdad = new ArrayList<>();

        for(Persona nombre : personas){

            if (nombre.calcularEdad().isBefore(nacimientoMayor)){
                nacimientoMayor = nombre.calcularEdad();
                nombrePersonaMayor = nombre.getNombre();
            }

            if (nombre.comprobarCiudad()){
                personasDeElche.add(nombre.getNombre());
            }

            if (nombre.calcularMayoriaEdad()){
                mayoresDeEdad.add(nombre.getNombre());
            }

            }

        System.out.println("-- Persona más mayor --\n" + nombrePersonaMayor);

        System.out.println("-- Personas de elche --");
        if (personasDeElche.isEmpty()){
            System.out.println("* No hay ninguna persona de Elche *");
        } else {
            for (String nombre : personasDeElche){
                System.out.println(nombre);
            }
        }

        System.out.println("-- Personas mayores de edad-- ");
        if (mayoresDeEdad.isEmpty()){
            System.out.println("* No hay ninguna persona mayor de edad *");
        } else {
            for (String nombre : mayoresDeEdad){
                System.out.println(nombre);
            }
        }

    }
}