package Utilidades;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarDatos {

    public static String validarDatos(Scanner sc , String dato, String texto, String formato){
        boolean error = true;
        String respuesta = null;
        do {
            try {
                System.out.print(texto);
                 respuesta = sc.nextLine();

                Matcher m = Pattern.compile(formato).matcher(respuesta);
                if(!m.matches()){
                    throw new Error();
                }
                error = false;
            }
            catch (Error e){
                System.out.println("* " + dato + " no valido *");
            }

        }while(error);
        return respuesta;
    }
}
