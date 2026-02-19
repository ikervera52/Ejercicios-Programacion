import Excepciones.CantidadNoValida;
import Modelo.Pedido;
import Modelo.Producto;
import Modelo.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static Scanner sc;

    // Tablas
    public static ArrayList <Usuario> usuarios;
    public static ArrayList <Producto> productos;

    public static void main(String[] args) {

        sc = new Scanner(System.in);
        usuarios = new ArrayList<>();
        productos = new ArrayList<>();

        crearProductos();

        opciones();

    }

    public static void crearProductos() {

        Producto producto1 = new Producto("platano", 1F, 9);
        Producto producto2 = new Producto("manzana", 3F, 12);
        Producto producto3 = new Producto("melon", 2F, 8);
        Producto producto4 = new Producto("pizza", 2F, 8);

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
    }

    public static void opciones(){
        boolean salir = false;
        do {
            try {
                System.out.print("""
                -- Menú de opciones --
                a) Gestionar usuarios
                b) Hacer pedidos
                c) Salir
                Que quieres hacer:\s""");
                String respuesta =  sc.nextLine();
                switch (respuesta){
                    case "a" -> gestionUsuario();
                    case "b" -> hacerPedido();
                    case "c" -> salir = true;
                    default -> throw new Error();
                }
            }
            catch (Error e){
                System.out.println("Opción no valida");
            }

        }while(!salir);
    }

    public static void gestionUsuario(){
        boolean salir = false;
        do {
            try {
                System.out.println("""
                -- Menú de usuarios --
                a) Dar de alta un usuario
                b) Editar usuario
                c) Dar de baja un usuario
                d) Salir
                Que quieres hacer:""");
                String respuesta =  sc.nextLine();
                switch (respuesta){
                    case "a" -> altaUsuario();
                    //case "b" -> editarUsuario();
                    //case "c" -> bajaUsuario();
                    case "d" -> salir = true;
                    default -> throw new Error();
                }
            }
            catch (Error e){
                System.out.println("Opción no valida");
            }
        }while(!salir);
    }

    public static void altaUsuario(){
        try {
            // Pedir los datos para el alta
            String nombre = validarDatos("Nombre", "Nombre del usuario: ", "^[A-Za-z]+$");
            String email = validarDatos("Email", "Email del usuario: ", "^[A-Za-z0-9]+@[A-Za-z0-9]+.(com|org|eus)$");

            // Comprobar que no exista este usuario
            for (Usuario usuario : usuarios) {
                if (usuario.getNombre().equals(nombre)) {
                    throw new Error(); // Si existe no se añade a la lista
                }
            }

            // Añadir el usuario a la lista
            Usuario usuario = new Usuario(nombre, email);
            usuarios.add(usuario);
        }
        catch (Error e){
            System.out.println("Ya existe un usuario con ese nombre");
        }
    }

    public static String validarDatos(String dato, String frase, String formato){

        boolean error = true;
        String respuesta = "";
        do {
            try {
                System.out.println(frase);
                respuesta = sc.nextLine();

                Matcher m = Pattern.compile(formato).matcher(respuesta);
                if(!m.matches()){
                    throw new Error();
                }

                error = false;

            }
            catch (Error e){
                System.out.println(dato + " no valido");
            }

        }while(error);

        return respuesta;
    }

    public static void hacerPedido(){
        try{
            System.out.println("Que usuario va a hacer el pedido: ");
            String nombreUsuario = sc.nextLine();

            // Comprobar que exista este usuario
            Usuario usuario = usuarios.stream()
                    .filter(u -> u.getNombre().equals(nombreUsuario))
                    .findFirst().orElse(null);

            if(usuario == null){
                throw new Error();
            }

            pedirProductos(usuario);
        }
        catch (Error e){
            System.out.println("Ese usuario no existe");
        }
    }

    public static void pedirProductos(Usuario usuario){
        boolean salir = false;
        Pedido pedido = new Pedido(LocalDate.now(), usuario);

        do {
            try {
                System.out.println("\n-- Productos disponibles --");
                for(Producto producto : productos){
                    if (producto.getStock() > 0){
                        System.out.println(producto.getNombre() + " --> " + producto.getStock() + " unidades");
                    }
                }

                System.out.println("\nQue producto quieres añadir al carrito: ");
                String producto = sc.nextLine();
                Producto p = productos.stream().filter(u -> u.getNombre().equals(producto)).findFirst().orElse(null);

                if(p == null){
                    throw new Error();
                }

                String cantidadString = validarDatos("Cantidad", "Cuantos quieres: ", "^[0-9]+$");
                int cantidad = Integer.parseInt(cantidadString);

                if (cantidad < 0){
                    throw new CantidadNoValida();
                }

                if(cantidad > p.getStock()){
                    throw new Exception();
                }

                pedido.setProducto(p, cantidad);

                int stock = p.getStock() - cantidad;
                p.setStock(stock);

                System.out.println("--> "+ cantidad + " " + p.getNombre() + " añadidos al pedido");

                salir = salirDePedido();
            }
            catch (Error e){
                System.out.println("No existe ese producto");
            }
            catch (CantidadNoValida e){
                System.out.println("La cantidad no puede ser menor a cero");
            }
            catch (Exception e){
                System.out.println("No hay suficiente stock");
            }

        }while (!salir);

        usuario.setPedido(pedido);
        System.out.println("--> Pedido realizado con éxito");
    }

    public static boolean salirDePedido(){
        boolean error = true;
        boolean salir = true;
        do {
            try {
                System.out.println("Quieres añadir más productos: ");
                String respuesta = sc.nextLine();
                if(respuesta.equals("si")){
                    salir = false;
                    error = false;
                } else if (respuesta.equals("no")){
                    error = false;
                } else throw new Error();
            }
            catch (Error e){
                System.out.println("Opción no valida");
            }

        }while (error);

        return salir;
    }
}