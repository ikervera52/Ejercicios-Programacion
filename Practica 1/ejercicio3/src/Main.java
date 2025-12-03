import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    final static Scanner sc = new Scanner(System.in);
    public static char[] abcdario = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    public static StringBuilder letras = new StringBuilder();


    public static void main(String[] args) {

        posicion();
        imprimir();


    }
    public static void posicion (){
       boolean error = true;
        do{
            try{
                int posicion;
                do {
                    System.out.println("Que posición quieres guardar: ");
                    posicion = sc.nextInt();
                    if(posicion != -1){
                        anadirLetra(posicion);
                    }

                } while (posicion != -1);
                error = false;
            }
            catch (InputMismatchException | ArrayIndexOutOfBoundsException ex){
                System.out.println("error");
            }
            catch(Exception e){
                System.out.println(e.getClass());
                sc.nextLine();
            }


        } while (error);
    }
    public static void anadirLetra(int posicion){

        letras.append(abcdario[posicion]);
    }

    public static void imprimir(){
        System.out.print(letras);
    }
}