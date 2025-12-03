import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        double[] numeros = guardarDatos();
        numeroMayorBien(numeros);
        numeroMenorBien(numeros);
    }
    public static double[] guardarDatos(){
        double [] numeros = new double [10];

        for(int i = 0; i < numeros.length; i++){
            System.out.print("Introduce un numero: ");
            numeros[i] = sc.nextDouble();
        }

        return numeros;
    }

    public static void numeroMayorBien(double[] numeros){
        double numeroMayor= numeros[0];
        for (double numero : numeros) {
            if (numero > numeroMayor) {
                numeroMayor = numero;
            }
        }
        System.out.println("El numero mayor es: "+numeroMayor);
    }
    public static void numeroMenorBien(double[] numeros){
        double numeroMenor= numeros[0];
        for (double numero : numeros) {
            if (numero < numeroMenor) {
                numeroMenor = numero;
            }
        }
        System.out.println("El numero mayor es: "+numeroMenor);
    }
}