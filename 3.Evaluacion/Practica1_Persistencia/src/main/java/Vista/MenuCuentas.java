package Vista;

import Controlador.CuentaControlador;
import Controlador.GeneralControlador;
import Controlador.TitularControlador;
import Utilidades.ValidarDatos;

import java.util.Scanner;

public class MenuCuentas {

    private static final Scanner sc = new Scanner(System.in);


    public static void menuCuentas(){
        boolean salir = false;
        do {
            try {
                System.out.print("""
                ===== Menú de Cuentas =====
                a) Crear cuenta
                b) Eliminar cuenta
                c) Editar cuenta
                d) Salir
                ==========================
                Que quieres hacer:\s""");
                String respuesta = sc.nextLine();
                switch (respuesta){
                    case "a" -> crearCuenta();
                    case "b" -> eliminarCuenta();
                    case "c" -> editarCuenta();
                    case "d" -> salir = true;
                    default -> throw new Error();
                }
            }
            catch (Error e){
                System.out.println("* Opción no valida *");
            }

        }while (!salir);
    }

    private static void crearCuenta(){
        int iban = ValidarDatos.validarInt(sc, "IBAN", "IBAN: ", "^[0-9]+$");
        int saldo = ValidarDatos.validarInt(sc, "Saldo", "Saldo: ", "^[0-9]+$");
        String dni = ValidarDatos.validarDatos(sc, "DNI", "DNI del titular de la cuenta: ", "^[0-9]{8}[A-Z]$");
        System.out.println(GeneralControlador.crearCuenta(iban, saldo, dni));
    }

    private static void eliminarCuenta(){
        int iban = ValidarDatos.validarInt(sc, "IBAN", "IBAN: ", "^[0-9]+$");
        System.out.println(CuentaControlador.eliminarCuenta(iban));
    }

    private static void editarCuenta(){
        int iban = ValidarDatos.validarInt(sc, "IBAN", "IBAN: ", "^[0-9]+$");
        boolean salir = false;

        do {
            try {
                System.out.print("""
                ===== Menú de Edición =====
                a) Editar IBAN
                b) Editar saldo
                c) Editar titular
                ===========================
                Que quieres hacer:\s""");
                String respuesta = sc.nextLine();
                switch (respuesta){
                    case "a" : editarIban(iban);
                    salir = true;
                    break;
                    case "b": editarSaldo(iban);
                    salir = true;
                    break;
                    case "c": editarTitularCuenta(iban);
                    salir = true;
                    break;
                    default: throw new Error();
                }
            }catch (Error e){
                System.out.println("* Opción no valida *");
            }
        } while (!salir);

    }

    private static void editarIban(int iban){
        try {
            int nuevoIban = ValidarDatos.validarInt(sc, "Nuevo IBAN", "Nuevo IBAN: ", "^[0-9]+$");
            CuentaControlador.editarIban(iban, nuevoIban);
        }catch (Exception e){
            System.out.println("* No existe ninguna cuenta con ese IBAN *");
        }
    }

    public static void editarSaldo(int iban){
        try {
            int nuevoSaldo = ValidarDatos.validarInt(sc, "Nuevo saldo", "Nuevo saldo: ", "^[0-9]+$");
            CuentaControlador.editarSaldo(iban,nuevoSaldo);
        }catch (Exception e){
            System.out.println("* No existe ninguna cuenta con ese IBAN *");
        }
    }

    public static void editarTitularCuenta(int iban){
        try {
            String nuevoDni = ValidarDatos.validarDatos(sc, "DNI del nuevo titular", "DNI del nuevo titular: ", "^[0-9]{8}[A-Z]$");
            GeneralControlador.editarTitularCuenta(iban, nuevoDni);
        }catch (Exception e){
            System.out.println("* No existe ninguna cuenta con ese IBAN *");
        }
    }

}
