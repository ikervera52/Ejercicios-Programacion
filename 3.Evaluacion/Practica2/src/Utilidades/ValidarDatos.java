package Utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarDatos {

    public static String validarString(Scanner sc, String dato, String frase, String formato){
        boolean error = true;
        String respuesta = null;
        do {
            try {
                System.out.println(frase);
                respuesta = sc.nextLine();


                if (!respuesta.matches(formato)) {
                    throw new Error();
                }

                error = false;
            }
            catch (Error e){
                System.out.println( "* "+ dato + " no valido *");
            }

        }while(error);

        return respuesta;
    }

    public static LocalDate validarDate(Scanner sc, String dato, String frase){
        boolean error = true;
        LocalDate fecha = null;
        do {
            try {
                System.out.println(frase);
                String respuesta = sc.nextLine();

                fecha = LocalDate.parse(respuesta, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                error = false;
            }
            catch (DateTimeParseException e){
                System.out.println( "* "+ dato + " no valida *");
            }
        }while (error);

        return fecha;
    }
}
