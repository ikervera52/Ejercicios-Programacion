import Modelo.Circunferencia;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {


        System.out.print("Cual es el radio de la circunferencia: ");
        double radio = sc.nextDouble();
        sc.nextLine();

        Circunferencia circulo1 = new Circunferencia(radio);

        opciones(circulo1);
    }

    public static void opciones(Circunferencia circulo1){
        boolean continuar = true;
        do {
            try{
                System.out.print("""
                a) Calcular longitud de la circunferencia
                b) Calcular su area
                c) Calcular volumen de la esfera
                d) Salir
                Que quieres hacer:\s""");
                switch (sc.nextLine()){
                    case "a" -> System.out.println("\nLa longitud es: " + circulo1.calcularLongitud() + "\n");
                    case "b" -> System.out.println("\nEl area es: " + circulo1.calcularArea() + "\n");
                    case "c" -> System.out.println("\nEl volumen es: " + circulo1.calcularVolumen() + "\n");
                    case "d" -> continuar = false;
                    default -> throw new Error();
                }
            }
            catch (Error e){
                System.out.println("* Opción o valida *");
            }

        } while (continuar);
        System.out.println("\nFin del programa");
    }
}