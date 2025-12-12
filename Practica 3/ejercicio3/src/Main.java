import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static Scanner sc;

    public static Stack <String> nombresLibros;
    public static void main(String[] args) {

        try {
            inicializarFunciones();
            opciones();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getClass());
        }

    }
    public static void inicializarFunciones() {
        sc = new Scanner(System.in);
        nombresLibros = new Stack<>();
    }

    public static void opciones() {
        boolean continuar = true;
        do {
            try {
                System.out.print("""
                \n--- Menú de opciones ---
                a) Añadir un libro
                b) Consultar libro de la parte superior
                c) Retirar libro de la parte superior
                d) Mostrar todos los libros en la pila
                e) Verificar si la pila esta vacía
                f) Salir
                Que quieres hacer:\s""");
                switch (sc.nextLine().toLowerCase()) {
                    case "a":
                        anadirLibro();
                        break;
                    case "b":
                        consultarLibro();
                        break;
                    case "c":
                        retirarLibro();
                        break;
                    case "d":
                        mostrarLibros();
                        break;
                    case "e":
                        verificarPilaVacia();
                        break;
                    case "f":
                        System.out.println("\n--> Fin del programa");
                        continuar = false;
                        break;
                    default:
                        throw new Error();

                }
            }
            catch (Error e){
                System.out.println("\n** Opción no valida **\n");
            }
        }while (continuar);
    }

    public static void anadirLibro() {
        boolean error = true;
        do {
            try {
                Pattern patron = Pattern.compile("^[a-z ]+$");
                System.out.print("Nombre del libro: ");
                String nombre = sc.nextLine();
                Matcher mat = patron.matcher(nombre);
                if (!mat.matches()){
                    throw new Error();
                }
                nombresLibros.push(nombre);
                error = false;
            }
            catch (Error e){
                System.out.println("\n** Nombre del libro no valido **\n");
            }
        }while (error);
    }
    public static void consultarLibro() {
        try {
            System.out.println("\nEl libro de arriba en la pila es: " +  nombresLibros.peek() + "\n");
        }
        catch (EmptyStackException e){
            System.out.println("\n** No hay ningún elemento en la pila **\n");
        }
    }
    public static void retirarLibro() {
        try {
            System.out.println("\nEl libro " + nombresLibros.pop() + " se ha eliminado de la pila\n");

        }
        catch (EmptyStackException e){
            System.out.println("\n** No hay ningún elemento en la pila **\n");
        }
    }
    public static void mostrarLibros() {
        try {
            Stack <String> librosOrdenados = new Stack<>();
            int contador = nombresLibros.size();
            for (int i = 0; i < contador ; i++) {
                String libroOrdenado = nombresLibros.pop();
                librosOrdenados.push(libroOrdenado);
            }

            System.out.println("Los libros de la pila son: ");
            for (String libro : librosOrdenados) {
                System.out.println(libro);
            }

            for (int i = 0; i < contador; i++) {
                String libroVuelta = librosOrdenados.pop();
                nombresLibros.push(libroVuelta);

            }
        }
        catch (EmptyStackException e){
            System.out.println("\n** No hay ningún elemento en la pila **\n");
        }
    }
    public static void verificarPilaVacia() {
        if (nombresLibros.isEmpty()){
            System.out.println("\nLa pila esta vacía\n");
        }else System.out.println("\nLa pila NO esta vacía\n");
    }


}