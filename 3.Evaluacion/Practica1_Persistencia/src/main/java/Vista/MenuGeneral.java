package Vista;

import java.util.Scanner;

public class MenuGeneral {

    private static final Scanner sc = new Scanner(System.in);

    public static void menuGeneral(){
        boolean salir = false;
        do {
            try {
                System.out.print("""
                ==== Menú General ====
                a) Menú de Cuentas
                b) Menú de Titulares
                c) Menú de Acciones
                d) Salir
                ======================
                Que quieres hacer:\s""");
                String respuesta = sc.nextLine();
                switch (respuesta){
                    case "a" -> MenuCuentas.menuCuentas();
                    case "b" -> MenuTitulares.menuOpciones();
                    //case "c" -> MenuAcciones.menuAcciones();
                    case "d" -> salir = true;
                    default -> throw new Error();
                }
            }
            catch (Error e){
                System.out.println("* Opción no valida *");
            }

        }while(!salir);

    }
}
