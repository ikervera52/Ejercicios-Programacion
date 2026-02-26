import java.util.Arrays;
import java.util.Scanner;

public class Main {
    final static Scanner sc  = new Scanner(System.in);
    public static String[] meses = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
    public static void main(String[] args) {

    try {
        String mes = pedirMes();
        comprobarMes(mes);
    }
    catch (Exception e) {
        System.out.println(e.getClass());
    }

    }
    public static String pedirMes(){
        System.out.print("Escribe un mes en letras: ");
        return sc.nextLine().toLowerCase();
    }
    public static void comprobarMes(String mes) {

        if (Arrays.asList(meses).contains(mes)) {
            System.out.println("Mes correctamente introducido");
        } else{
            System.out.println("Mes introducido incorrectamente");
        }
    }
}