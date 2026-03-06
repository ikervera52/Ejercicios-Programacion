package Vista;

import java.util.Scanner;

public class MenuPrincipal {

    private static final Scanner sc = new Scanner(System.in);

    public static void menuPrincipal() {
        boolean salir = false;
        do {
            try {
                System.out.println("""
                ===== Menú Principal =====
                a) Menú de Vuelos
                b) Menú de Pasajeros
                c) Menú de Operaciones
                d) Salir
                ==========================
                Que quieres hacer:\s""");
                String respuesta = sc.nextLine();
                switch (respuesta) {
                    case "a" -> MenuVuelo.menuVuelos();
                    case "b" -> MenuPasajero.menuPasajeros();
                    case "c" -> MenuConsultas.menuConsultas();
                    case "d" -> salir = true;
                    default -> throw new Error();
                }
            }
            catch (Error e){
                System.out.println("* Opción no valida *");
            }

        }while (!salir);
    }
}
