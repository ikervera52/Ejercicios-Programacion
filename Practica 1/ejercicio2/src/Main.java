import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    final static Scanner sc  = new Scanner(System.in);
    public static void main(String[] args) {

        int numeros = cantidadNumeros();
        int[] numerosGuardar = generarNumeros(numeros);
        sumaTotal(numerosGuardar);

    }
    public static int cantidadNumeros (){
        System.out.println("Cuantos numeros quieres generar: ");
        return sc.nextInt();
    }
    public static int[] generarNumeros(int numeros){
        int[] random = new int[numeros];

        for (int i = 0; i < random.length; i++) {
            random[i] = (int) (Math.random() * 100);
            System.out.println(random[i]);
        }
        return random;
    }
    public static void sumaTotal(int[] numerosGuardar){
        int suma = 0;
        for (int sumas : numerosGuardar){
            suma += sumas;
        }
        System.out.println(Arrays.stream(numerosGuardar).sum());
        System.out.println("Suma total: " + suma);
    }
}