package Vista;

import Controlador.CuentaControlador;
import Utilidades.ValidarDatos;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuCuentas {

    private static final Scanner sc = new Scanner(System.in);

    public static void menuOpciones(){

        boolean salir = false;
        do {
            try{
                System.out.print("""
                ==== Menú de Cuentas ====
                a) Crear cuenta
                b) Eliminar cuenta
                c) Editar cuenta
                d) Ver todas las cuentas
                e) Ver cuentas por saldo
                f) Ver cuenta por iban
                g) Salir
                =========================
                Que quieres hacer:\s""");
                String respuesta = sc.nextLine();
                switch (respuesta){
                    case "a" -> crearCuenta();
                    case "b" -> eliminarCuenta();
                    case "c" -> editarCuenta();
                    case "d" -> mostrarCuentas();
                    case "e" -> verCuentaPorSaldo();
                    case "f" -> verCuentaPorIban();
                    case "g" -> salir = true;
                    default -> throw new Error();
                }
            }
            catch (Error e){
                System.out.println("* Opción no valida *");
            }

        }while(!salir);
    }

    private static void crearCuenta(){
        try{
            String iban = ValidarDatos.validarDatos(sc,"IBAN", "IBAN de la cuenta: ", "^[A-Za-z]+$");
            int saldo = Integer.parseInt(ValidarDatos.validarDatos(sc, "Saldo", "Saldo de la cuenta: ", "^[0-9]+$"));
            CuentaControlador.crearCuenta(iban, saldo);
        }
        catch (InputMismatchException e){
            System.out.println("* Saldo no valido *");
        }
        catch (Exception e){
            System.out.println("* Ya existe una persona con ese iban");
        }

    }

    private static void eliminarCuenta(){
        try{
            String iban = ValidarDatos.validarDatos(sc, "IBAN", "IBAN de la cuenta: ", "^[A-Za-z]+$");
            CuentaControlador.eliminarCuenta(iban);
        }
        catch (Exception e){
            System.out.println("* No existe ninguna persona con ese IBAN");
        }
    }

    private static void editarCuenta(){
        try{
            String iban = ValidarDatos.validarDatos(sc, "IBAN", "IBAN de la cuenta a editar el saldo: ", "^[0-9]+$");
            int saldo = Integer.parseInt(ValidarDatos.validarDatos(sc, "Nuevo saldo", "Nuevo saldo de la cuenta: ", "^[0-9]+$"));
            CuentaControlador.editarCuenta(iban,saldo);
        }
        catch (InputMismatchException e){
            System.out.println("* Saldo no valido *");
        }
        catch (Exception e){
            System.out.println("* No existe ninguna persona con ese IBAN");
        }
    }

    private  static void mostrarCuentas(){
        System.out.println(CuentaControlador.mostrarCuentas());
    }

    private static void verCuentaPorSaldo(){
        try {
            int saldo = Integer.parseInt(ValidarDatos.validarDatos(sc, "Saldo", "A partir de que saldo quieres ver las cuentas: ", "^[0-9]+$"));
            System.out.println(CuentaControlador.verCuentaPorSaldo(saldo));
        }
        catch (InputMismatchException e){
            System.out.println("* Saldo no valido *");
        }
    }

    private static void verCuentaPorIban(){
        String iban = ValidarDatos.validarDatos(sc, "IBAN", "IBAN de la cuenta: ", "^[A-Za-z]+$");
        System.out.println(CuentaControlador.verCuentaPorIban(iban));
    }
}
