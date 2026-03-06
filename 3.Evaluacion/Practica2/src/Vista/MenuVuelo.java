package Vista;

import Controlador.VueloControlador;
import Utilidades.ValidarDatos;

import java.time.LocalDate;
import java.util.Scanner;

public class MenuVuelo {

    private static final Scanner sc = new Scanner(System.in);

    public static void menuVuelos() {
        boolean salir = false;
        do {
            try {
                System.out.println("""
                ===== Menú Principal =====
                a) Registrar un Vuelo
                b) Eliminar un Vuelo
                c) Editar un Vuelo
                d) Salir
                ==========================
                Que quieres hacer:\s""");
                String respuesta = sc.nextLine();
                switch (respuesta) {
                    case "a" -> registarVuelo();
                    case "b" -> eliminarVuelo();
                    case "c" -> editarVuelo();
                    case "d" -> salir = true;
                    default -> throw new Error();
                }
            }
            catch (Error e){
                System.out.println("* Opción no valida *");
            }

        }while (!salir);
    }

    private static void registarVuelo() {
        String codVuelo = ValidarDatos.validarString(sc, "Codigo de Vuelo", "Codigo de Vuelo: ", "^[A-Z]{3}[0-9]-[0-9]{5}$");
        LocalDate fecha = ValidarDatos.validarDate(sc, "Fecha de vuelo", "Fecha del vuelo: ");
        String destino = ValidarDatos.validarString(sc, "Destino", "Destino del vuelo: ", "^[A-Za-z ]+$");
        String procedencia = ValidarDatos.validarString(sc, "Procedencia", "Procedencia: ", "^[A-Za-z ]+$");

        try{
            VueloControlador.registrarVuelo(codVuelo, fecha, destino, procedencia);
        }
        catch (Exception e){
            System.out.println("* No se ha podido registrar el vuelo *");
        }
    }

    private static void eliminarVuelo() {
        try {
            String codVuelo = ValidarDatos.validarString(sc, "Codigo de Vuelo", "Código del Vuelo que se quiere eliminar: ", "^[A-Z]{3}[0-9]-[0-9]{5}$");
            VueloControlador.eliminarVuelo(codVuelo);
        }
        catch (Exception e){
            System.out.println("* No se ha podido eliminar el vuelo *");
        }
    }

    private static void editarVuelo() {
        boolean salir = false;
        String objetivo;
        String formato;
        String dato;
        String frase;
        do {
            try {
                System.out.println("""
                ==== Menú de edición de Vuelos =====
                a) Editar Codigo de Vuelo
                b) Editar Fecha de Vuelo
                c) Editar Destino
                d) Editar Procedencia
                e) Salir
                ====================================
                Que quieres hacer:\s""");
                String respuesta = sc.nextLine();
                switch (respuesta) {
                    case "a":
                        objetivo = "cod_vuelo";
                        formato = "^[A-Z]{3}[0-9]-[0-9]{5}$";
                        dato = "Nuevo Codigo de Vuelo";
                        frase = "Nuevo Codigo de Vuelo: ";
                        editarVueloString(objetivo, formato, dato, frase);
                        break;
                    case "b":
                        editarVueloDate();
                        break;
                    case "c":
                        objetivo = "destino";
                        formato = "^[A-Za-z ]+$";
                        dato = "Nuevo Destino del Vuelo";
                        frase = "Nuevo Destino del Vuelo: ";
                        editarVueloString(objetivo, formato, dato, frase);
                        break;
                    case "d":
                        objetivo = "procedencia";
                        formato = "^[A-Za-z ]+$";
                        dato = "Nueva Procedencia delVuelo";
                        frase = "Nueva Procedencia del Vuelo: ";
                        editarVueloString(objetivo, formato, dato, frase);
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

    private static void editarVueloString(String objetivo, String formato, String dato, String frase) {
        try {
            String codVuelo = ValidarDatos.validarString(sc, "Codigo de Vuelo", "Codigo del Vuelo: ", "^[A-Z]{3}[0-9]-[0-9]{5}$");
            String respuesta = ValidarDatos.validarString(sc, dato, frase, formato);
            VueloControlador.editarVueloString(codVuelo, respuesta, objetivo);
        }
        catch (Exception e){
            System.out.println("* No se ha podido editar el vuelo *");
        }
    }

    private static void editarVueloDate() {
        try{
            String codVuelo = ValidarDatos.validarString(sc, "Codigo de Vuelo", "Codigo del Vuelo: ", "^[A-Z]{3}[0-9]-[0-9]{5}$");
            LocalDate fecha = ValidarDatos.validarDate(sc, "Nueva fecha de Vuelo", "Nueva Fecha del Vuelo: ");
            VueloControlador.editarVueloDate(codVuelo, fecha);
        }
        catch (Exception e){
            System.out.println("* No se ha podido editar la fecha del Vuelo *");
        }

    }
}
