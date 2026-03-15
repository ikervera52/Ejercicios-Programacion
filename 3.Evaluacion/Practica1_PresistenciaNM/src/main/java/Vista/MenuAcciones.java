package Vista;

import Controlador.CuentaControlador;
import Controlador.GeneralControlador;
import Controlador.TitularControlador;
import Utilidades.ValidarDatos;

import java.util.Scanner;

public class MenuAcciones {

    private static final Scanner sc = new Scanner(System.in);

    public static void menuCrear(){
        boolean salir = false;
        do {
            try {
                System.out.println("""
                        ===== Menú de Gestión =====
                        a) Crear Cuenta
                        b) Eliminar Cuenta
                        d) Añadir Titular a Cuenta
                        e) Eliminar Titular de Cuenta
                        f) Salir
                        ===========================
                        Que quieres hacer:\s""");
                String respuesta =  sc.nextLine();
                switch (respuesta){
                    case "a" -> crearCuenta();
                    case "b" -> eliminarCuenta();
                    case "c" -> eliminarTitular();
                    case "d" -> anadirTitular();
                    case "e" -> eliminarTitularCuenta();
                    case "f" -> salir = true;
                    default -> throw new Error();
                }
            }
            catch (Error e){
                System.out.println("* Opción no valida *");
            }
        }while (!salir);
    }

    public static void menuVer(){
        boolean salir = false;
        do {
            try {
                System.out.println("""
                        ===== Menú de Visualización =====
                        a) Ver todas las cuentas y sus titulares
                        b) Ver titulares de una cuenta
                        c) Salir
                        =================================
                        Que quieres hacer:\s""");
                String respuesta =  sc.nextLine();
                switch (respuesta){
                    case "a" -> verCuentas();
                    case "b" -> verTitularesPorCuenta();
                    case "c" -> salir = true;
                }
            }catch (Error e){
                System.out.println("* Opción no valida *");
            }
        } while (!salir);
    }

    private static void verCuentas(){
        System.out.println(CuentaControlador.verCuentas());
    }

    private static void verTitularesPorCuenta(){
        String iban = ValidarDatos.validarString(sc, "IBAN", "IBAN de la Cuenta: ", "^[A-Z0-9]+$");
        System.out.println(CuentaControlador.verTitularesPorCuenta(iban));
    }

    private static void crearCuenta(){
        try {
            // Datos el titular de la cuenta
            System.out.println("==== Datos del nuevo Titular ====");
            String nombre = ValidarDatos.validarString(sc, "Nombre", "Nombre: ", "^[A-Za-z ]+$");
            String dni = ValidarDatos.validarString(sc, "DNI", "DNI: ", "^[0-9]{8}[A-Z]$");

            // Datos la cuenta
            System.out.println("==== Datos de la nueva Cuenta ====");
            String iban = ValidarDatos.validarString(sc, "IBAN", "IBAN: ", "^[0-9A-Z]+$");
            int saldo = ValidarDatos.validarInt(sc, "Saldo", "Saldo: ", "^[0-9]+$");
            GeneralControlador.crearCuenta(nombre, dni, iban, saldo);
        }
        catch (Exception e){
            System.out.println("* No se ha podido crear la Cuenta * ");
        }
    }

    private static void eliminarTitular(){
        try {
            String dni = ValidarDatos.validarString(sc, "DNI", "DNI: ", "^[0-9]{8}[A-Z]$");
            TitularControlador.eliminarTitular(dni);
        }
        catch (Exception e){
            System.out.println("* No existe ningún titular con ese DNI *");
        }
    }

    private static void eliminarCuenta(){
        try {
            String iban = ValidarDatos.validarString(sc, "IBAN", "IBAN: ", "^[0-9A-Z]+$");
            CuentaControlador.eliminarCuenta(iban);

        }
        catch (Exception e){
            System.out.println("* No existe ninguna cuenta con ese IBAN *");
        }
    }

    private static void anadirTitular(){

        String iban = ValidarDatos.validarString(sc, "IBAN", "IBAN de la Cuenta: ", "^[0-9A-Z]+$");
        System.out.println("""
                ==== Menú de añadir Titular ====
                a) Añadir Titular ya Existente
                b) Añadir Nuevo Titular
                ================================
                Que quieres hacer:\s""");
        String respuesta =  sc.nextLine();
        switch (respuesta){
            case "a" -> anadirTitularExistente(iban);
            //case "b" -> anadirTitularNuevo(iban);
        }
    }

    private static void anadirTitularExistente(String iban){
        try {
            String dni = ValidarDatos.validarString(sc, "DNI", "DNI del Titular: ", "^[0-9]{8}[A-Z]$");
            GeneralControlador.anadirTitularExistente(iban, dni);
            System.out.println("--> Titular añadido con éxito a cuenta con IBAN: " + iban);
        }
        catch (Exception _){

        }
    }

    private static void eliminarTitularCuenta(){
        try {
            String iban = ValidarDatos.validarString(sc, "IBAN", "IBAN: ", "^[0-9A-Z]+$");
            String dni = ValidarDatos.validarString(sc, "DNI", "DNI del Titular: ", "^[0-9]{8}[A-Z]$");
            GeneralControlador.eliminarTitularCuenta(iban, dni);
        }catch (Exception e){
            System.out.println("* No se ha podido eliminar el Titular de la Cuenta * ");
        }
    }
}
