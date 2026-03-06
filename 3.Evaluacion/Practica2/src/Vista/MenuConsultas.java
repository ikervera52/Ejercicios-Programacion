package Vista;

import Controlador.GeneralControlador;
import Controlador.PasajeroControlador;
import Controlador.VueloControlador;
import Utilidades.ValidarDatos;

import java.time.LocalDate;
import java.util.Scanner;

public class MenuConsultas {

    private static final Scanner sc = new Scanner(System.in);

    public static void menuConsultas(){
        boolean salir = false;
        do {
            try {
                System.out.println("""
                ==== Menú de Consultas ====
                a) Datos de un Vuelo por Codigo
                b) Datos de un Pasajero por DNI
                c) Vuelos a un Destino
                d) Vuelos por Origen
                e) Vuelo de un Pasajero
                f) Lista de Pasajeros por Vuelo
                g) Lista de Vuelos para una Fecha
                h) Salir
                ===========================
                Que quieres hacer:\s""");
                String respuesta = sc.nextLine();
                switch (respuesta){
                    case "a" -> vueloPorCodigo();
                    case "b" -> pasajeroPorDni();
                    case "c" -> vueloPorDestino();
                    case "d" -> vueloPorOrigen();
                    case "e" -> vuelosDePasajero();
                    case "f" -> pasajerosPorVuelo();
                    case "g" -> vuelosPorFecha();
                    case "h" -> salir = true;
                    default -> throw new Error();
                }
            }
            catch (Error e){
                System.out.println("* Opción no valida *");
            }

        }while (!salir);
    }

    public static void vueloPorCodigo(){
        String codVuelo = ValidarDatos.validarString(sc, "Codigo de Vuelo", "Codigo de Vuelo: ", "^[A-Z]{3}[0-9]-[0-9]{5}$");
        System.out.println(VueloControlador.vueloPorCodigo(codVuelo));
    }

    public static void pasajeroPorDni(){
        String dni = ValidarDatos.validarString(sc, "DNI", "DNI del Pasajero: ", "^[0-9]{8}[A-Z]$");
        System.out.println(PasajeroControlador.pasajeroPorDni(dni));
    }

    public static void vueloPorDestino(){
        String destino = ValidarDatos.validarString(sc, "Destino", "Destino: ", "^[A-Za-z ]+$");
        System.out.println(VueloControlador.vueloPorDestino(destino));
    }

    public static void vueloPorOrigen(){
        String origen = ValidarDatos.validarString(sc, "Origen", "Origen: ", "^[A-Za-z ]+$");
        System.out.println(VueloControlador.vueloPorOrigen(origen));
    }

    public static void vuelosDePasajero(){
        String dni = ValidarDatos.validarString(sc, "DNI", "DNI: ", "^[0-9]{8}[A-Z]$");
        System.out.println(GeneralControlador.vueloPorPasajero(dni));
    }

    public static void pasajerosPorVuelo(){
        String codVuelo = ValidarDatos.validarString(sc, "Código de Vuelo", "Código de Vuelo: ", "^[A-Z]{3}[0-9]-[0-9]{5}$");
        System.out.println(PasajeroControlador.pasajerosPorVuelo(codVuelo));
    }

    public static void vuelosPorFecha(){
        LocalDate fecha = ValidarDatos.validarDate(sc, "Fecha de Salida", "Fecha de Salida: ");
        System.out.println(VueloControlador.vuelosPorFecha(fecha));
    }
}
