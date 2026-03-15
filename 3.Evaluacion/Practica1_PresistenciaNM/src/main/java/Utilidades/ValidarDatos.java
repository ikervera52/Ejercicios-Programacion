package Utilidades;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarDatos {

    public static String validarString (Scanner sc, String dato, String frase, String formato){
        boolean error = true;
        String respuesta = null;
        do {
            try {
                System.out.println(frase);
                respuesta = sc.nextLine();

                Matcher m = Pattern.compile(formato).matcher(respuesta);
                if (!m.matches()) {
                    throw new Error();
                }

                error = false;

            }catch (Error e){
                System.out.println("* " + dato + " no valido *");
            }

        }while (error);
        return respuesta;
    }

    public static int validarInt (Scanner sc, String dato, String frase, String formato){
        boolean error = true;
        int respuesta = 0;
        do {
            try {
                System.out.println(frase);
                String respuestaString = sc.nextLine();

                Matcher m = Pattern.compile(formato).matcher(respuestaString);
                if (!m.matches()) {
                    throw new Error();
                }
                
                respuesta = Integer.parseInt(respuestaString);

                error = false;

            }catch (Error e){
                System.out.println("* " + dato + " no valido *");
            }

        }while (error);
        return respuesta;
    }
    
}
