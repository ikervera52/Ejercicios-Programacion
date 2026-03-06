package Vista;

import Controlador.PasajeroControlador;
import Controlador.VueloControlador;
import Utilidades.ValidarDatos;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuPasajero {

    private static final Scanner sc = new Scanner(System.in);

    public static void menuPasajeros(){
        boolean salir = false;
        do {
            try {
                System.out.println("""
                ==== Menú de Pasajeros ====
                a) Registrar Pasajero
                b) Eliminar Pasajero
                c) Editar Pasajero
                d) Salir
                ===========================
                Que quieres hacer:\s""");
                String respuesta = sc.nextLine();
                switch (respuesta) {
                    case "a" -> registrarPasajero();
                    case "b" -> eliminarPasajero();
                    case "c" -> editarPasajero();
                    case "d" -> salir = true;
                    default -> throw new Error();
                }
            }
            catch (Error e){
                System.out.println("* Opción no valida *");
            }

        }while(!salir);
    }

    private static void registrarPasajero(){
        String dni = ValidarDatos.validarString(sc, "DNI", "DNI: ", "^[0-9]{8}[A-Z]$");
        String nombre = ValidarDatos.validarString(sc, "Nombre", "Nombre: ", "^[A-Za-z]+$");
        String telefono = ValidarDatos.validarString(sc, "Teléfono", "Teléfono: ", "^[0-9]{9}$");
        String codVuelo = ValidarDatos.validarString(sc, "Código de Vuelo", "Código de Vuelo", "^[A-Z]{3}[0-9]-[0-9]{5}");
        PasajeroControlador.registrarPasajero(dni, nombre, telefono, codVuelo);
        System.out.println("Pasajero registrado exitosamente");
    }

    private static void eliminarPasajero(){
        try{
            String dni = ValidarDatos.validarString(sc, "DNI", "DNI: ", "^[0-9]{8}[A-Z]$");
            PasajeroControlador.eliminarPasajero(dni);
        }
        catch (Exception e){
            System.out.println("* No se ha podido eliminar el pasajero *");
        }
    }

    private static void editarPasajero() {
        boolean salir = false;
        String objetivo;
        String formato;
        String dato;
        String frase;
        do {
            try {
                System.out.println("""
                ==== Menú de edición de Vuelos =====
                a) Editar DNI de Pasajero
                b) Editar Nombre de Pasajero
                c) Editar Telefono de Pasajero
                d) Editar Vuelo de Pasajero
                e) Salir
                ====================================
                Que quieres hacer:\s""");
                String respuesta = sc.nextLine();
                switch (respuesta) {
                    case "a":
                        objetivo = "dni";
                        formato = "^[0-9]{8}[A-Z]$";
                        dato = "Nuevo DNI";
                        frase = "Nuevo DNI: ";
                        editarPasajeroString(objetivo, formato, dato, frase);
                        break;
                    case "b":
                        objetivo = "nombre";
                        formato = "^[A-Za-z ]+$";
                        dato = "Nuevo Nombre";
                        frase = "Nuevo Nombre: ";
                        editarPasajeroString(objetivo, formato, dato, frase);
                        break;
                    case "c":
                        objetivo = "telefono";
                        formato = "^[0-9]{9}$";
                        dato = "Nuevo Telefono";
                        frase = "Nuevo Telefono: ";
                        editarPasajeroString(objetivo, formato, dato, frase);
                        break;
                    case "d":
                        objetivo = "cod_vuelo";
                        formato = "^[A-Z]{3}[0-9]-[0-9]{5}$";
                        dato = "Nuevo Codigo de Vuelo";
                        frase = "Nueva Codigo de Vuelo: ";
                        editarPasajeroString(objetivo, formato, dato, frase);
                        break;
                    case "e":
                        salir = true;
                        break;
                    default: throw new Error();
                }
            }
            catch (Error e){
                System.out.println("* Opción no valida *");
            }

        }while (!salir);
    }

    private static void editarPasajeroString(String objetivo, String formato, String dato, String frase) {
        try {
            String dni = ValidarDatos.validarString(sc, "DNI", "DNI del Pasajero: ", "^[0-9]{8}[A-Z]$");
            String respuesta = ValidarDatos.validarString(sc, dato, frase, formato);
            PasajeroControlador.editarPasajeroString(dni, respuesta, objetivo);
        }
        catch (Exception e){
            System.out.println("* No se ha podido editar el vuelo *");
        }
    }
}
