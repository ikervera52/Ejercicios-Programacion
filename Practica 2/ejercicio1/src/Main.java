import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    final static Scanner sc = new Scanner(System.in);
    public static ArrayList<Double> numeros = new ArrayList<>();
    public static void main(String[] args) {

        try {
            rellenarArrayList();
            opciones();
        }
        catch (Exception e) {
            System.out.println(e.getClass());
        }

    }

    public static void rellenarArrayList() {
        System.out.println("-- Añadir números en el ArrayList --");
        boolean continuar = true;
        do {
            try{
                System.out.print("Guardar numero: ");
                numeros.add(sc.nextDouble());
                sc.nextLine();
                continuar = masNumeros();
            }
            catch(Exception e){
                System.out.println("Error al intentar guardar los datos");
                sc.nextLine();
            }

        }while(continuar);
    }
    public static boolean masNumeros() {
        boolean error = true;
        boolean continuar = true;
        do {
            try{
                System.out.print("Quieres añadir más números (si/no): ");
                String respuesta = sc.nextLine().toLowerCase();
                if(respuesta.equals("si")){
                    error = false;
                }
                else if(respuesta.equals("no")){
                    error = false;
                    continuar = false;
                } else {
                    throw new OpcionNoValida();
                }
            }
            catch(OpcionNoValida e){
                System.out.println("** Opción no valida **");
            }
        }while(error);
        return continuar;

    }
    public static void opciones() {
        boolean error = true;
        do {
            try {
                System.out.println("""
                -- Menú de opciones --
                a)Visualizar el valor máximo y el mínimo.
                b) Solicitar un número y buscarlo. Muestra un mensaje indicando
                  si lo has encontrado o no.
                c) Solicitar un número, buscarlo y borrarlo. Sino se encuentra
                   muestra un mensaje de error.
                d) Convertir el arrayList en un array.
                e) Si no esta vacío, mostrar el número de elementos que contiene.
                f) Insertar un nuevo elemento por el final.
                g) Insertar un nuevo elemento en la posición que te indique el
                  usuario.
                h) Borrar un elemento de una posición concreta.
                i) Calcular la suma y la media aritmética de los valores contenidos.
                j) Finalizar
                Que quieres hacer:\s""");
                switch (sc.nextLine()){
                    case "a":
                        visualizarMaximoMinimo();
                        break;
                    case "b":
                        encontrarNumero();
                        break;
                    case "c":
                        borrarNumero();
                        break;
                    case "d":
                        convertirEnArray();
                        break;
                    case "e":
                        verCantidadContenido();
                        break;
                    case "f":
                        insertarPorElFinal();
                        break;
                    case "g":
                        insertarEnPosicionIndicada();
                        break;
                    case "h":
                        borrarDePosicionConcreta();
                        break;
                    case "i":
                        calcularSumaMedia();
                        break;
                    case "j":
                        error = false;
                        finPrograma();
                        break;
                    default:
                        throw new Error();
                }
            }
            catch (Error e){
                System.out.println("** Opción no valida **");
            }

        }while(error);
    }

    public static void visualizarMaximoMinimo(){
        double maximo = numeros.getFirst();
        double minimo = numeros.getFirst();

        for (Double numero : numeros) {
            if (numero > maximo) {
                maximo = numero;
            }
            if (numero < minimo) {
                minimo = numero;
            }
        }
        System.out.println("\nMaximo: " + maximo);
        System.out.println("Mínimo: " + minimo + "\n");
    }

    public static void encontrarNumero(){
        System.out.print("Que numero quieres encontrar: ");
        double numero = sc.nextDouble();
        sc.nextLine();
        if (numeros.contains(numero)){
            System.out.println("\nSi que existe este numero\n");
        }
        else{
            System.out.println("\nNo existe el numero\n");
        }
    }

    public static void borrarNumero(){
        System.out.print("Que numero quieres borrar: ");
        double numero = sc.nextDouble();
        sc.nextLine();
        if (numeros.contains(numero)){
            numeros.remove(numero);
            System.out.println("\nSe ha borrado el numero\n");
        }
        else{
            System.out.println("\nNo existe el numeron\n");
        }
    }

    public static void convertirEnArray(){
        System.out.println("\n");
        Object[] numerosArray = numeros.toArray();
        System.out.println("Se ha convertido en array (Contenido): ");
        for (Object numero : numerosArray) {
            System.out.print(numero + " ");
        }
        System.out.println("\n");
    }

    public static void verCantidadContenido(){
        System.out.println("\n");
        System.out.println("La cantidad de datos dentro del ArrayList es : " + numeros.size());
        System.out.println("\n");
    }

    public static void insertarPorElFinal(){
        System.out.print("Que numero quieres el insertar: ");
        double numero = sc.nextDouble();
        sc.nextLine();
        numeros.add(numeros.size(), numero);
        System.out.println("\nEl numero al final del ArrayList es: " + numeros.getLast() + "\n");
    }

    public static void insertarEnPosicionIndicada(){
        System.out.print("Que numero quieres el insertar: ");
        double numero = sc.nextDouble();
        System.out.print("En que posición lo quieres insertar:");
        int posicion = sc.nextInt();
        sc.nextLine();
        numeros.add(posicion, numero);
        System.out.println("\nEl numero en la posición " + posicion + " es: " + numeros.get(posicion) + "\n");
    }

    public static void borrarDePosicionConcreta(){
        System.out.print("En que posición esta lo que quieres borrar:");
        int posicion = sc.nextInt();
        sc.nextLine();
        System.out.println("\nEn la posición " + posicion + " había: " + numeros.get(posicion));
        numeros.remove(posicion);
        System.out.println("En la posición " + posicion + " hay: " + numeros.get(posicion) + "\n");
    }

    public static void calcularSumaMedia(){
        int suma = 0;
        for (Double numero : numeros) {
            suma += numero;
        }
        System.out.println("-- Numeros del ArrayList --");
        for (Double numero : numeros) {
            System.out.println(numero + " ");
        }
        System.out.println("\nLa suma es: " + suma);
        System.out.println("La media es: " + suma / numeros.size() + "\n" );
    }

    public static void finPrograma(){
        System.out.println("--> Programa finalizado");
    }
}
