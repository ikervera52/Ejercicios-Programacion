import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    final static Scanner sc  = new Scanner(System.in);
    public static void main(String[] args) {

        texto();

    }
    public static void texto(){
        System.out.println("Escribe un texto: ");
        String texto = sc.nextLine().toLowerCase().replace(" ", "");
        comprobarTexto(texto);
    }
    public static void comprobarTexto(String texto){
        StringBuilder comprobar = new StringBuilder(texto);
        char[] letras = new char[27];
        int[] cuantasVeces = new int[27];
        int contador = comprobar.length();
        ArrayList<Integer> borrarCaracteres = new ArrayList<>();

        for(int i = 0; i < contador; i++){

            char letra = comprobar.charAt(0);
            letras[i] = letra;

                for(int j = 0; j < comprobar.length(); j++){

                    if(letra == comprobar.charAt(j)){
                    cuantasVeces[i]++;
                    borrarCaracteres.add(j);
                    }
                }

            borrarCaracteres.sort(Collections.reverseOrder());
            for(int caracter : borrarCaracteres){
                comprobar.deleteCharAt(caracter);
            }
            borrarCaracteres.clear();

            if (comprobar.isEmpty()){
                    i = contador;
                }
        }

        for(int i = 0; i < letras.length; i++){
            if(cuantasVeces[i] > 0){
                System.out.print(letras[i] +" -> " + cuantasVeces[i] + "\n");
            }
        }
    }
}