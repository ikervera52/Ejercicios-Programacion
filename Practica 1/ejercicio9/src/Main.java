import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    final static Scanner sc = new Scanner(System.in);

    public static int[][][] temperaturas;
    public static String[] ciudades;
    public static void main(String[] args) {

    pedirDatos();
    temperaturaMediaCiudades();
    temperaturaMediaPorDia();

    }

    public static void pedirDatos(){
        System.out.print("Cuantas ciudades quieres guardar: ");
        int ciudad = sc.nextInt();
        sc.nextLine();

        ciudades = new String[ciudad];

        for(int i = 0; i < ciudad; i++){
            System.out.print("Nombre de la ciudad: ");
            ciudades[i] = sc.nextLine();
        }

        System.out.print("Numero de dias q quieres guardar: ");
        int dias = sc.nextInt();

        temperaturas = new int[ciudad][dias][3];
        pedirTemperaturas(ciudad, dias);
    }

    public static void pedirTemperaturas(int ciudad, int dias){
        for(int i = 0; i < ciudad; i++){
            for(int j = 0; j < dias; j++){
                for(int k = 0; k < temperaturas[i][j].length; k++){
                    System.out.print("Temperatura en " + ciudades[i] + " el dia " +  (j+1) + " a hora " + k + ": " );
                    temperaturas[i][j][k] = sc.nextInt();
                }
            }
        }
    }

    public static void temperaturaMediaCiudades(){
        int suma = 0;
        int contador = 0;
        for(int i = 0; i < temperaturas.length; i++){
            for (int j = 0; j < temperaturas[i].length; j++){
                for (int k = 0; k < temperaturas[i][j].length; k++){
                    suma += temperaturas[i][j][k];
                    contador++;
                }
            }
            System.out.println("La media en " + ciudades[i] + " es: " + suma/contador);
            suma = 0;
            contador = 0;
        }
    }

    public static void temperaturaMediaPorDia(){
        int suma = 0;
        int contador = 0;
        for(int i = 0; i < temperaturas[0].length; i++){
            for(int j = 0; j < temperaturas.length; j++){
                for (int k = 0; k < temperaturas[j][i].length; k++){
                    suma += temperaturas[j][i][k];
                    contador++;
                }
            }
            System.out.println("La media del dia " + (i + 1) + " es: " + suma/contador);
            suma = 0;
            contador = 0;
        }
    }


}