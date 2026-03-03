package Vista;

import Controlador.ControladorGeneral;
import Utilidades.ValidarDatos;

import java.util.Scanner;

public class MenuCuentasCorrientes {

    private static final Scanner sc = new Scanner(System.in);

    public static void menuOpciones() {
        boolean salir = false;
        do {
            try{
                System.out.print("""
                    ==== Menú de Cuentas Corrientes ====
                    a) Crear una Cuenta Corriente
                    b) Eliminar una Cuenta Corriente
                    c) Editar una Cuenta Corriente
                    d) Ver todas las cuentas Corrientes
                    g) Salir
                    ====================================
                    Que quieres hacer:\s""");
                String respuesta = sc.nextLine();
                switch (respuesta) {
                    case "a" -> crearCuentaCorriente();
                    case "b" -> eliminarCuentaCorriente();
                    case "c" -> editarCuentaCorriente();
                    case "d" -> mostrarCuentasCorrientes();
                    case "g" -> salir = true;
                        default -> throw new Error();
                }
            }
            catch (Error e){
                System.out.println("* Opción no valida *");
            }

        }while (!salir);
    }

    public static void crearCuentaCorriente() {
        try {
            String iban = ValidarDatos.validarDatos(sc, "IBAN", "IBAN de la cuenta: ", "^[A-Za-z ]+$");
            String dni = ValidarDatos.validarDatos(sc, "DNI", "DNI del titular: ", "^[0-9]{8}[A-Z]$");
            System.out.println(ControladorGeneral.crearCuentaCorriente(dni, iban));
        }
        catch (Exception e) {
            System.out.println("* No se ha podido crear la Cuenta Corriente *");
        }
    }

    public static void eliminarCuentaCorriente() {
        try{
            String dni = ValidarDatos.validarDatos(sc, "DNI", "DNI del titular: ", "^[0-9]{8}[A-Z]$");
            String iban = ValidarDatos.validarDatos(sc, "IBAN", "IBAN de la cuenta: ", "^[A-Za-z ]+$");
            System.out.println(ControladorGeneral.eliminarCuentaCorriente(dni, iban));
        }
        catch (Exception e) {
            System.out.println("* No se ha eliminado la Cuenta Corriente *");
        }
    }

    // Menú de edición
    public static void editarCuentaCorriente() {
        boolean error = true;
        do {
            try {
                System.out.println("""
                    ==== Editar Cuenta Corriente ====
                    a) Editar Titular
                    b) Editar Cuenta
                    c) Asociar Titular a una Cuenta
                    =================================
                    Que quieres hacer:\s""");
                String respuesta = sc.nextLine();
                switch (respuesta) {
                    case "a" -> editarCuentaCorrienteTitular();
                    case "b" -> editarCuentaCorrienteCuenta();
                    case "c" -> asociarTitularACuenta();
                    default -> throw new Error();
                }
            }
            catch (Error e){
                System.out.println("* Opción no valida *");
                error = false;
            }

        }while(!error);
    }

    public static void editarCuentaCorrienteTitular() {
        try {
            String dni = ValidarDatos.validarDatos(sc, "DNI", "DNI del titular actual: ", "^[0-9]{8}[A-Z]$");
            String iban = ValidarDatos.validarDatos(sc, "IBAN", "IBAN del titular: ", "^[A-Za-z ]+$");

            String nuevoDni = ValidarDatos.validarDatos(sc,"DNI", "DNI del nuevo titular: ", "^[0-9]{8}[A-Z]$");
            System.out.println(ControladorGeneral.editarCuentaCorrienteTitular(dni, iban, nuevoDni));
        }
        catch (Exception e) {
            System.out.println("* No se ha podido editar la Cuenta Corriente *");
        }
    }

    public static void editarCuentaCorrienteCuenta() {
        try {
            String dni = ValidarDatos.validarDatos(sc, "DNI", "DNI del titular: ", "^[0-9]{8}[A-Z]$");
            String ibanActual = ValidarDatos.validarDatos(sc, "IBAN", "IBAN del la cuenta actual: ", "^[A-Za-z ]+$");

            String ibanNuevo = ValidarDatos.validarDatos(sc, "IBAN", "IBAN del la nueva cuenta: ", "^[A-Za-z ]+$");
            System.out.println(ControladorGeneral.editarCuentaCorrienteCuenta(dni, ibanActual, ibanNuevo));
        }
        catch (Exception e) {
            System.out.println("* No se ha podido editar la Cuenta Corriente *");
        }
    }

    public static void asociarTitularACuenta() {
        try{
            String dni = ValidarDatos.validarDatos(sc, "DNI", "DNI del titular: ", "^[0-9]{8}[A-Z]$");
            String iban = ValidarDatos.validarDatos(sc, "IBAN", "IBAN de la cuenta: ", "^[A-Za-z ]+$");
            System.out.println(ControladorGeneral.asociarTitularACuenta(dni, iban));
        }
        catch (Exception e) {
            System.out.println("* No se ha podido asociar el Titular *");
        }
    }

    public static void mostrarCuentasCorrientes() {
        System.out.println(ControladorGeneral.mostrarCuentasCorrientes());
    }
}
