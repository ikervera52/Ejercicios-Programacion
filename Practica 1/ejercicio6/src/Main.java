import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    final static Scanner sc = new Scanner(System.in);
    final static int[] codigos = {10, 23, 30, 47, 55, 65,135,256, 526, 663};
    static int[] cantidades = new int[codigos.length];
    public static int [] codOrdenados = new int[cantidades.length];
    public static int [] cantidadOrdenados;
    public static void main(String[] args) {

        try {
            String continuar;
            int cantidad;
            do {
                cantidad = pedirCantidad();
                pedirCodigo(cantidad);
                continuar = guardarMas();
            }while (continuar.equals("si"));
            ordenarResultados();
            imprimirResultados();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getClass());
        }

    }

    public static int pedirCantidad() {
        boolean error = true;
        int cantidad = 0;
        do {
            try {
                Pattern patron = Pattern.compile("^[0-9]+$");
                System.out.println("Unidades vendidas: ");
                String cantidadString = sc.nextLine();
                Matcher m = patron.matcher(cantidadString);
                if(!m.matches()){
                    throw new OpcionNoValida();
                }
                cantidad = Integer.parseInt(cantidadString);
                error = false;
            }
            catch (OpcionNoValida e){
                System.out.println("** Error al intentar ingresar los datos **");
            }

        } while (error);
        return cantidad;

    }
    public static void pedirCodigo(int cantidad) {
        boolean error;
        int codigo;
        do {
            try {
                System.out.println("Código de producto: ");
                codigo = sc.nextInt();
                error = comrpobarCodigo(codigo, cantidad);
            }
            catch (InputMismatchException ex){
                System.out.println("** Error al intentar ingresar los datos **");
                sc.nextLine();
                error = true;
            }
        }while(error);
    }

    public static boolean comrpobarCodigo(int codigo, int cantidad) {
        int i;
        boolean error = false;
        for(i = 0; i <= codigos.length-1 && codigos[i] != codigo; i++);

        if(codigos[i] == codigo){
            cantidades[i] += cantidad;
        }else {
            System.out.println("No existe el código de producto");
            error = true;
        }
        return error;
    }

    public static String guardarMas() {
        boolean error = true;
        String respuesta = "";

        do {
            try{
                sc.nextLine();
                System.out.print("Quieres guardar más productos: ");
                respuesta = sc.nextLine().toLowerCase();
                if(!respuesta.equals("no") && !respuesta.equals("si")){
                    throw new Exception();
                }
                error = false;
            }
            catch(Exception e){
                System.out.println("Error");
            }
        } while(error);
        return respuesta;

    }


    public static void ordenarResultados() {
        cantidadOrdenados = Arrays.copyOf(cantidades, cantidades.length);
        Arrays.sort(cantidadOrdenados);
        for(int i = 0; i < cantidadOrdenados.length; i++){

            if(cantidadOrdenados[i] > 0){

                for(int j = 0; j < cantidadOrdenados.length; j++){
                    if (cantidadOrdenados[i] == cantidades[j]) {
                        codOrdenados[i] = codigos[j];
                        j = cantidadOrdenados[i];
                    }
                }
            }
        }
    }

    public static void imprimirResultados() {
        System.out.println("-- Listado de productos --");
        for (int i = 0; i < cantidadOrdenados.length; i++) {
            if (cantidadOrdenados[i] > 0) {
                System.out.print(cantidadOrdenados[i] + " unidades --> Código: " + codOrdenados[i] + "\n");
            }
        }
    }
}