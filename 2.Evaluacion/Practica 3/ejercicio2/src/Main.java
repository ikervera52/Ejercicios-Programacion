import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    public static Scanner sc;

    public static LinkedList <String> productos;
    public static LinkedList <LocalDate> fechas;
    public static void main(String[] args) {

        inicializarColas();
        pedirProductos();
        borrarCaducados();

    }
    public static void inicializarColas() {
        sc = new Scanner(System.in);

        productos = new LinkedList<>();
        fechas = new LinkedList<>();
    }

    public static void pedirProductos(){
        System.out.println("-- Guardado de productos --");
        boolean continuar = true;
        do {
            try{
                Pattern patron = Pattern.compile("^[a-z]+$");
                System.out.print("Nombre del producto: ");
                String nombre = sc.nextLine();
                Matcher m = patron.matcher(nombre);
                if(!m.matches()){
                    throw new Error();
                }
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                System.out.print("Fecha de caducidad: ");
                LocalDate fecha = LocalDate.parse(sc.nextLine(), dtf);

                productos.add(nombre);
                fechas.add(fecha);

                continuar = preguntarContinuar();

            }
            catch(Error e){
                System.out.println("** Error en el procedimiento **");
            }
            catch(DateTimeParseException ex){
                System.out.println("** Fecha no valida **");
            }
        }while(continuar);
    }
    public static boolean preguntarContinuar(){
        boolean error = true;
        boolean continuar = true;
        do {
            try{
                System.out.print("Quieres añadir mas productos (si/no): ");
                String respuesta = sc.nextLine();
                if(respuesta.equals("no")){
                    System.out.println("\n-- Productos guardados --");
                    imprimirLista();
                    continuar = false;
                    error = false;
                } else if(respuesta.equals("si")){
                    error = false;
                }
                else throw new Error();
            }
            catch (Error e){
                System.out.println("** Opción no valida **");
            }
        } while(error);
        return continuar;

    }

    public static void borrarCaducados(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.print("\nDesde que fecha quieres descartar productos: ");
        LocalDate fecha = LocalDate.parse(sc.nextLine(), dtf);

        while(!fechas.isEmpty() && fechas.peek().isBefore(fecha) ){

            fechas.remove();
            productos.remove();
        }

        System.out.println("\n-- Productos restantes --");
        imprimirLista();
    }

    public static void imprimirLista(){
        for(int i = 0; i < productos.size(); i++){
            System.out.println("Nombre: " + productos.get(i) + " Fecha: " + fechas.get(i));
        }
    }
}