package Vista;

import java.util.Scanner;

public class MenuPrincipal {

    private static final Scanner sc = new Scanner(System.in);

    public void menuGeneral(){
        boolean salir = false;
        do {
            try {
                System.out.print("""
                        ==== Menú Principal ====
                        a) Menú de Cuentas
                        b) Menú de Titulares
                        c) Menú de Cuentas Corrientes
                        d) Salir
                        ========================
                        Que quieres hacer:\s""");
                String respuesta = sc.nextLine();
                switch (respuesta){
                    case "a" -> MenuCuentas.menuOpciones();
                    case "b" -> MenuTitulares.menuOpciones();
                    case "c" -> MenuCuentasCorrientes.menuOpciones();
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
