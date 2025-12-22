import java.util.*;

public class Main {

    public static Scanner sc;
    // especies
    public static String [] especies;
    //Animales rescatados
    public static ArrayList<String> animalesRescatados;
    // Animales con cuidadores
    public static HashMap<String, String> cuidadores;

    //Lista de adopciones
    public static Queue <String> colaAdopciones;

    public static void main(String[] args) {

        sc = new Scanner(System.in);
        especies = new String[] {"perro", "gato", "conejo", "loro", "tortuga"};
        animalesRescatados = new ArrayList<>();
        cuidadores = new HashMap<>();
        colaAdopciones = new ArrayDeque<>();
        opciones();


    }

    public static void opciones(){
        boolean salir = false;
        do {
            System.out.print("""
                --- Menú de opciones ---
                a) Ver especies aceptadas
                b) Agregar un nuevo animal al listado de rescatados
                c) Asignar un cuidador a un animal
                d) Pasar un animal a la cola de espera de adopción
                e) Adoptar un animal
                f ) Lista todos los animales y sus cuidadores actuales
                g) Salir
                Que quieres hacer:\s""");
            switch (sc.nextLine().toLowerCase()){
                case "a" -> verEspecies();
                case "b" -> agregarRescatado();
                case "c" -> asignarCuidador();
                case "d" -> pasarAnimalColaEspera();
                case "e" -> adoptar();
                case "f" -> listarAnimalesCuidadores();
                case "g" -> salir = true;
                default -> throw new Error();
            }

        }while (!salir);
        System.out.println("--> Fin del programa");
    }

    public static void verEspecies(){
        System.out.println("--- Especies aceptadas ---");
        for (String especie : especies){
            System.out.println(especie);
        }
    }

    public static void agregarRescatado(){
        boolean error = true;
        do {
            try {
                System.out.print("Especie del animal: ");
                String especie = sc.nextLine().toLowerCase();
                List <String> especiesLista = Arrays.asList(especies);
                if (!especiesLista.contains(especie)){
                    throw new Error();
                }

                System.out.print("Nombre del animal: ");
                String nombre = sc.nextLine();

                StringBuilder nombreEspecie = new StringBuilder();

                animalesRescatados.add(nombreEspecie.append(nombre).append(" - ").append(especie).toString());
                System.out.println("--> Animal agregado con éxito");
                error = false;
            }
            catch (Error e){
                System.out.println("** Esta especie no se acepta **");
            }

        }while (error);
    }

    public static void asignarCuidador(){
        try{
            System.out.print("Nombre del animal: ");
            String nombre = sc.nextLine();

            System.out.print("Especie del animal: ");
            String especie = sc.nextLine();
            if (!animalesRescatados.contains(nombre + " - " + especie)){
                throw new Error();
            }

            System.out.print("Nombre del cuidador: ");
            String cuidador = sc.nextLine();
            cuidadores.put(nombre, cuidador);
        }
        catch (Error e){
            System.out.println("** Datos no validos **");
        }
    }

    public static void pasarAnimalColaEspera(){
        System.out.print("Nombre del animal: ");
        String nombre = sc.nextLine().toLowerCase();
        if (!cuidadores.containsKey(nombre)){
            throw new Error();
        }
        colaAdopciones.add(nombre);
        animalesRescatados.remove(nombre);
        System.out.println("--> " + nombre + " a sido agregado a la cola de espera");
    }

    public static void adoptar(){
        boolean error = true;
        do {
            try {
                System.out.print("Nombre del animal: ");
                String nombre = sc.nextLine();
                if (!colaAdopciones.contains(nombre)){
                    throw new Error();
                }

                System.out.println("--> " + colaAdopciones.poll() + " a sido adoptado");
                cuidadores.remove(nombre);
                error = false;
            }
            catch (Error e){
                System.out.println("** No existe este animal **");
            }
        }while (error);
    }

    public static void listarAnimalesCuidadores(){
        System.out.println(cuidadores);
    }
}