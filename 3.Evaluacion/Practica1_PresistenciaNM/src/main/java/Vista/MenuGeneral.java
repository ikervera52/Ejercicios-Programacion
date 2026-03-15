package Vista;

import java.util.Scanner;

public class MenuGeneral {

    private static final Scanner sc = new Scanner(System.in);

    public static void  menuGeneral(){
        boolean salir = false;
        do {
            try {
                System.out.println("""
                        ===== Menú General =====
                        a) Menú de Gestión de Cuentas
                        b) Menú de visualización de Cuentas
                        c) Salir
                        ========================
                        Que quieres hacer:\s""");
                String respuesta =  sc.nextLine();
                switch (respuesta){
                    case "a" -> MenuAcciones.menuCrear();
                    case "b" -> MenuAcciones.menuVer();
                    case "c" -> salir = true;
                    default -> throw new Error();
                }

            }
            catch (Error e){
                System.out.println("* Opción no valida *");
            }

        }while(!salir);
    }
}
