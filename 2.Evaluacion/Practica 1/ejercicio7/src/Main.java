import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    final static Scanner sc  = new Scanner(System.in);
    static int [][] matriz = new int [4][4];

    public static void main(String[] args) {

        opciones();

    }
    public static void opciones (){
        boolean continuar = true;
        boolean matrizMetida = false;
        do {
            System.out.print("""
                -- Menú de opciones --
                a) Rellenar matriz
                b) Ver matriz guardada
                c) Sumar una fila
                d) Sumar una columna
                e) Sumar diagonal principal
                f) Sumar diagonal inversa
                g) Ver media de la matriz
                h) Salir
                Que quieres hacer:\s""");
            switch (sc.nextLine()){
                case "a":
                    pedirMatriz();
                    matrizMetida = true;
                    break;
                case "b":
                    if(matrizMetida){
                        verMatriz();
                    }else {
                        matrizNoMetida();
                    }
                    break;
                case "c":
                    if(matrizMetida){
                        sumarFila();
                    }else {
                        matrizNoMetida();
                    }
                    break;
                case "d":
                    if(matrizMetida){
                        sumaColumna();
                    }else {
                        matrizNoMetida();
                    }
                    break;
                case "e":
                    if(matrizMetida){
                        sumarDiagonalPrincipal();
                    }else {
                        matrizNoMetida();
                    }
                    break;
                case "f":
                    if(matrizMetida){
                        sumarDiagonalInversa();
                    }else {
                        matrizNoMetida();
                    }
                    break;
                case "g":
                    if(matrizMetida){
                        mediaMatriz();
                    }else {
                        matrizNoMetida();
                    }
                    break;
                case "h":
                    if(matrizMetida){
                        salirPrograma();
                        continuar = false;
                    } else {
                        matrizNoMetida();
                    }
                    break;
                default:
                    throw new Error();
            }
        } while (continuar);
    }

    public static void matrizNoMetida(){
        System.out.println("Tienes q introducir la matriz primero");
    }

    public static void pedirMatriz (){
        for(int x = 1; x < 5; x++){
            for(int y = 1; y < 5; y++){
                System.out.print("Posición X = " + x + " Posición Y = " + y + ": ");
                matriz[x-1][y-1] = sc.nextInt();
            }
            sc.nextLine();
        }
    }
    public static void verMatriz (){
        System.out.println("-- Matriz guardada --");
        for(int x = 0; x < 4; x++){
            System.out.print(matriz[0][x] + "   " + matriz[1][x] + "   "  + matriz[2][x] + "   "  + matriz[3][x] + "\n");
        }
    }
    public static void sumarFila(){
        boolean error = true;
        do {
            try {
                Pattern patron = Pattern.compile("^[0-9]$");
                System.out.print("Que columna quieres sumar: ");
                String filaString = sc.nextLine();
                sc.nextLine();
                Matcher mat = patron.matcher(filaString);
                if(!mat.matches()){
                    throw new Error();
                }
                int fila = Integer.parseInt(filaString) - 1;
                int suma = 0;
                for(int x = 0; x < 4; x++){
                    suma += matriz[x][fila];
                }
                System.out.println("Suma de la columna Nº" + fila + " --> " + suma);
                error = false;
            }
            catch (Error e){
                System.out.println(e.getMessage());
            }

        }while(error);
    }
    public static void sumaColumna(){
        boolean error = true;
        do {
            try {
                Pattern patron = Pattern.compile("^[0-9]$");
                System.out.print("Que columna quieres sumar: ");
                String columnaString = sc.nextLine();
                sc.nextLine();
                Matcher mat = patron.matcher(columnaString);
                if(!mat.matches()){
                    throw new Error();
                }
                int columna = Integer.parseInt(columnaString) - 1;
                int suma = 0;
                for(int y = 0; y < 4; y++){
                    suma += matriz[columna][y];
                }
                System.out.println("Suma de la columna Nº" + columna + " --> " + suma);
                error = false;
            }
            catch (Error e){
                System.out.println(e.getMessage());
            }

        }while(error);
    }
    public static void sumarDiagonalPrincipal(){
        int suma = 0;
        for(int x = 0; x < 4; x++){
            for(int y = 0; y < 4; y++){
                if(x == y){
                    suma += matriz[x][y];
                }
            }
        }
        System.out.println("Suma de la Diagonal Principal --> " + suma);
    }
    public static void sumarDiagonalInversa(){
        int suma = 0;
        int fila = 3;
        for(int x = 0; x < 4; x++){
                    suma += matriz[x][fila];
                    fila--;
        }
        System.out.println("Suma de la Diagonal Inversa --> " + suma);
    }
    public static void mediaMatriz(){
        int suma = 0;
        int cantidadNumeros = 0;
        for(int x = 1; x < 4; x++){
            for(int y = 1; y < 4; y++){
                suma += matriz[x][y];
                cantidadNumeros++;
            }
        }
        int media = suma / cantidadNumeros;
        System.out.println("Media de la matriz --> " + media);
    }

    public static void salirPrograma(){
        System.out.println("-- Fin del programa --");
    }
}