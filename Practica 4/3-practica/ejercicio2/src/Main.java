import Modelo.Cliente;
import Modelo.Mascota;
import Modelo.Veterinario;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static Scanner sc;
    private static ArrayList<Mascota> mascotas;
    private static ArrayList<Cliente> clientes;
    private static ArrayList<Veterinario> veterinarios;

    public static void main(String[] args) {

        sc = new Scanner(System.in);

        crearCliente();
        crearVeterinario();
        crearMascotas();

        opciones();

    }

    public static String pedirDato(String nombre, String frase, String patron){
        boolean valido = false;
        String dato = null;
        do {
            try {
                System.out.print(frase);
                dato = sc.nextLine();
                Pattern patron1 = Pattern.compile(patron);
                Matcher m = patron1.matcher(dato);
                if (!m.matches()) {
                    throw new Error();
                }
                valido = true;
            }
            catch (Error e){
                System.out.println(nombre + " no tiene un formato valido");
            }

        }while(!valido);

        return dato;
    }

    //Creación de las instancias
    public static void crearCliente() {

        clientes = new ArrayList<>();

        boolean continuar = true;
        while (continuar) {

            clientes.add(new Cliente(
                    pedirDato("Nombre", "Nombre del cliente: ", "^[a-z]+$"),
                    pedirDato("Dirección", "Dirección del cliente: ", "^[a-z]+$"),
                    pedirDato("Teléfono", "Teléfono del cliente: ", "^[0-9]{9}$")
            ));


            continuar = pedirContinuar("Quieres añadir más clientes: ");
        }
    }
    public static void crearVeterinario() {

        veterinarios = new ArrayList<>();

        boolean continuar = true;
        while (continuar) {

            veterinarios.add(new Veterinario(
                    pedirDato("Nombre", "Nombre del veterinario: ", "^[a-z]+$"),
                    pedirDato("Dirección", "Dirección del veterinario: ", "^[a-z]+$"),
                    pedirDato("Teléfono", "Teléfono del veterinario: ", "^[0-9]{9}$"),
                    pedirDato("DNI", "DNI del veterinario: ", "^[0-9]{8}[A-Z]{1}$"),
                    pedirDato("NSS", "Numero de la seguridad social del veterinario: ", "^[0-9]+$")
            ));

            continuar = pedirContinuar("Quieres añadir más veterinarios: ");

        }
    }
    public static void crearMascotas() {

        mascotas = new ArrayList<>();

        boolean continuar = true;
        while (continuar) {
            try {
                Mascota mascota = new Mascota(
                        pedirDato("Tipo", "Tipo de mascota: ", "^(perro|gato)$"),
                        pedirDato("Dirección", "Raza de la mascota: ", "^[a-z]+$"),
                        pedirDato("Teléfono", "Nombre de la mascota: ", "^[a-z]+$")
                );

                // Verificar si existe cliente y veterinario
                Cliente cliente = asociarCliente();
                Veterinario veterinario = asociarVeterinario();

                mascota.setCliente(cliente);
                mascota.setVeterinario(veterinario);

                mascotas.add(mascota);

                continuar = pedirContinuar("Quires añadir más mascotas: ");
            }
            catch (IllegalArgumentException e) {
                System.out.println("Tipo de mascota no valido");
            }
        }
    }

    public static boolean pedirContinuar(String frase){
        boolean continuar = true;
        boolean error = true;
        while (error) {
            try {
                System.out.print(frase);
                String respuesta = sc.nextLine();
                if (respuesta.equals("no")) {
                    continuar = false;
                    error = false;
                } else if(respuesta.equals("si")) {
                    error = false;
                } else throw new Error();
            }
            catch (Error e) {
                System.out.println("Opción no valida");
            }
        }
        return continuar;
    }

    public static Cliente asociarCliente() {
        boolean error = true;
        int i = 0;
        do {
            try{
                String nombreCliente = pedirDato("Dueño", "Quien es el dueño de la mascota: ", "^[a-z]+$");

                for (i = 0; i < clientes.size() && !clientes.get(i).getNombre().equals(nombreCliente); i++) {}
                if (i == clientes.size()) {
                    throw new Error();
                } else error = false;
            }
            catch (Error e) {
                System.out.println("El cliente no existe");
            }

        }while (error);

        return clientes.get(i);

    }
    public static Veterinario asociarVeterinario() {

        boolean error = true;
        int i = 0;
        do {
            try{
                String veterinario = pedirDato("Veterinario", "Quien es el veterinario de la mascota: ", "^[a-z]+$");



                for (i = 0; i<veterinarios.size() && !veterinarios.get(i).getNombre().equals(veterinario); i++) {}
                if (i == veterinarios.size()) {
                    throw new Error();
                }
                error = false;
            }
            catch (Error e) {
                System.out.println("El veterinario no existe");
            }

        }while (error);

        return veterinarios.get(i);
    }

    public static void opciones(){
        boolean salir = false;
        do {
            try {
                System.out.print("""
                ---------- Menú de opciones -----------
                1. Mostrar el número de clientes que poseen un tipo de animal concreto.
                2. Datos personales del cliente a partir del nombre de mascota.
                3. Datos del veterinario a partir de los datos de una mascota.
                4. Datos de las mascotas de un cliente.
                5. Datos de las mascotas de un veterinario.
                6. Terminar
                Que quieres hacer:\s""");
                int respuesta = sc.nextInt();
                sc.nextLine();
                switch (respuesta){
                    case 1 -> numeroClientesPorTipoAnimal();
                    case 2 -> datosClientePorMascota(pedirDato("Nombre mascota", "Nombre de la mascota: ", "^[a-z]+$"));
                    case 3 -> datosVetPorMascota(pedirDato("Nombre mascota", "Nombre de la mascota: ", "^[a-z]+$"));
                    case 4 -> datosMascPorCliente(pedirDato("Nombre", "Nombre del cliente: ", "^[a-z]+$"));
                    case 5 -> datosMascPorVet(pedirDato("Nombre", "Nombre del veterinario: ", "^[a-z]+$"));
                    case 6 -> salir = true;
                    default -> throw new Error();
                }
            }
            catch (Error e){
                System.out.println("Opción no valida");
            }

        }while(!salir);
    }

    public static void numeroClientesPorTipoAnimal(){
        int perros = 0;
        int gatos = 0;

        for(Mascota mascota: mascotas){
            if (mascota.getTipo().equals("perro")){
                perros++;
            }
            if (mascota.getTipo().equals("gato")){
                gatos++;
            }
        }

        System.out.println("\nPerros: " + perros + " clientes\n" +
                            "Gatos: " + gatos + " clientes\n");
    }

    public static void datosClientePorMascota(String nombreMascota){

        int posicion = 0;

        for(Cliente cliente: clientes){
            for(Mascota mascota: cliente.getMascotas()){
                if (mascota.getNombre().equals(nombreMascota)){
                    posicion = clientes.indexOf(cliente);
                }
            }
        }
        System.out.println(clientes.get(posicion).toString());
    }

    public static void datosVetPorMascota(String nombreMascota){

        int posicion = 0;

        for(Veterinario veterinario: veterinarios){
            for(Mascota mascota: veterinario.getMascotas()){
                if (mascota.getNombre().equals(nombreMascota)){
                    posicion = veterinarios.indexOf(veterinario);
                }
            }
        }
        System.out.println(veterinarios.get(posicion).toString());
    }

    public static void datosMascPorCliente(String nombreCliente){
        int posicion = 0;
        for(Mascota mascota: mascotas){
            if (mascota.getCliente().getNombre().equals(nombreCliente)){
                posicion = mascotas.indexOf(mascota);
            }
        }
        System.out.println(mascotas.get(posicion).toString());
    }

    public static void datosMascPorVet(String nombreVet){
        int posicion = 0;
        for(Mascota mascota: mascotas){
            if (mascota.getVeterinario().getNombre().equals(nombreVet)){
                posicion = mascotas.indexOf(mascota);
            }
        }
        System.out.println(mascotas.get(posicion).toString());
    }
}
