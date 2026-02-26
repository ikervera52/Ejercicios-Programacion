import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    // Patron para el número de teléfono
    public static Pattern patron = Pattern.compile("^[0-9]{9}$");

    public static Scanner sc;

    public static HashMap <Integer, String> alumnos;
    public static void main(String[] args) {

        try {
            inicializarFunciones();

            pedirDatos();
            opciones();
        }
        catch (Exception e){
            System.out.println("Error: " + e.getClass());
        }

    }

    public static void inicializarFunciones(){
        sc = new Scanner(System.in);
        alumnos = new HashMap<>();
    }

    public static void pedirDatos(){
        System.out.print("Numero de teléfono: ");
        String numeroString = sc.nextLine();
        Matcher m = patron.matcher(numeroString);
        if(!m.matches()){
            throw new Error();
        }
        int numero = Integer.parseInt(numeroString);
        System.out.print("Nombre del alumno: ");
        String nombre = sc.nextLine();
        if(nombre.isEmpty()){
            throw new Error();
        }

        alumnos.put(numero, nombre);
    }

    public static void opciones() {
        boolean salir = false;
        do {
            try {
                System.out.print("""
                    -- Menú de opciones --
                    a) Añadir un nuevo numero
                    b) Borrar un numero
                    c) Buscar un numero
                    d) Borrar por nombre
                    e) Buscar por nombre
                    f) Salir
                    Elige una opción:\s""");
                if (alumnos.isEmpty()){
                    throw new FuncionVacia();
                }
                switch (sc.nextLine().toLowerCase()) {
                    case "a":
                        pedirDatos();
                        break;
                    case "b":
                        borrarNumero();
                        break;
                    case "c":
                        buscarNumero();
                        break;
                    case "d":
                        borrarNombre();
                        break;
                    case "e":
                        buscarNombre();
                        break;
                    case "f":
                        salir = true;
                        break;
                    default:
                        throw new Error();
                }
            }
            catch (FuncionVacia e){
                System.out.println("** No hay ningún dato guardado **");
            }
        } while (!salir);
    }

        public static void borrarNumero() {

            try{
                System.out.print("Que numero quieres borrar: ");
                String numeroString = sc.nextLine();
                Matcher m = patron.matcher(numeroString);

                if (!m.matches()){
                    throw new Error();
                }

                int numero = Integer.parseInt(numeroString);

                if (alumnos.containsKey(numero)){
                    alumnos.remove(numero);
                }

                else{
                    System.out.println("--> El numero no existe");
                }
            }
            catch (Error e){
                System.out.println("** Numero no valido **");
            }

        }

        public static void buscarNumero() {
            try {
                System.out.print("Que numero quieres buscar: ");
                String numeroString = sc.nextLine();
                Matcher m = patron.matcher(numeroString);

                if (!m.matches()){
                    throw new Error();
                }

                int numero = Integer.parseInt(numeroString);

                if (alumnos.containsKey(numero)){
                    System.out.println("Buscado: " + numero + ", " + alumnos.get(numero));
                }

                else{
                    System.out.println("** El numero no existe **");
                }
            }
            catch (Error e){
                System.out.println("** Numero no valido **");
            }
        }

        public static void borrarNombre() {
            System.out.print("Que nombre quieres borrar: ");
            String nombre = sc.nextLine();
            HashMap <Integer, String> recorrer = new HashMap<>(alumnos);

            if (recorrer.containsValue(nombre)){
                for(Integer alumno : recorrer.keySet()){
                    if (alumnos.get(alumno).contains(nombre)){
                        alumnos.remove(alumno);
                        System.out.println("--> El alumno se ha eliminado correctamente");

                    }
                }
            }
            else{
                System.out.println("** El nombre no existe **");
            }
        }

    public static void buscarNombre() {
        System.out.print("Que nombre quieres buscar: ");
        String nombre = sc.nextLine();

        if (alumnos.containsValue(nombre)){
            for(Integer alumno : alumnos.keySet()){
                if (alumnos.get(alumno).contains(nombre)){
                    System.out.println("Buscado: " + alumnos.get(alumno) + ", " + alumno);
                }
            }
        }
        else{
            System.out.println("** El nombre no existe **");
        }
    }

}