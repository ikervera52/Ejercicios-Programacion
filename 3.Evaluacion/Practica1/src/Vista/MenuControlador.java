package Vista;

import Controlador.TitularControlador;
import Modelo.Titular;
import Utilidades.ValidarDatos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuControlador {

    private Scanner sc;

    public void menuOpciones(){
        sc = new Scanner(System.in);
        boolean salir = false;
        do {
            try{
                System.out.print("""
                --- Menú de opciones ---
                a) Crear titular
                b) Borrar titular
                c) Editar titular
                d) Ver todos los titulares
                e) Ver titular por id
                f) Ver titular por nombre
                g) Ver titular por DNI
                h) Salir
                Que quieres hacer:\s""");
                String respuesta = sc.nextLine();
                switch (respuesta){
                    case "a" -> crearTitular();
                    case "b" -> borrarTitular();
                    case "c" -> editarTitular();
                    case "d" -> verTodosTitulares();
                    case "e" -> verTitularPorId();
                    case "f" -> verTitularPorNombre();
                    case "g" -> verTitularPorDni();
                    case "h" -> salir = true;
                    default -> throw new Exception();
                }
            }
            catch(Exception e){
                System.out.println("* Opcion no valida *");
            }

        }while(!salir);
    }

    public void verTodosTitulares(){
        ArrayList<Titular> titulares = TitularControlador.obtenerTodosTitular();

        for(Titular t: titulares){
            System.out.println(t);
        }
    }

    public void crearTitular(){
        try {
            String nombre = ValidarDatos.validarDatos(sc, "Nombre", "Nombre del titular: ", "^[A-Za-z]+$");
            String dni = ValidarDatos.validarDatos(sc, "DNI", "DNI del titular: ", "^[0-9]{8}[A-Z]$");
            TitularControlador.crearTitular(nombre,dni);
        }catch (Exception e){
            System.out.println("* Ya existe un titular con ese DNI *");
        }
    }

    public void borrarTitular(){
        String dni = ValidarDatos.validarDatos(sc, "DNI", "DNI del titular: ", "^[0-9]{8}[A-Z]$");
        try {
            TitularControlador.borrarTitular(dni);
            System.out.println("--> Titular eliminado con éxito");
        } catch (Exception e){
            System.out.println("No existe el titular con ese DNI");
        }
    }

    public void editarTitular(){
        String dniTitular = ValidarDatos.validarDatos(sc, "DNI", "DNI del titular que quieres editar: ", "^[0-9]{8}[A-Z]$");

        boolean salir = false;
        do {
            try{
                System.out.print("""
                --- Menú de edición ---
                a) Editar nombre
                b) Editar dni
                Que quieres hacer:\s""");
                String respuesta = sc.nextLine();
                switch (respuesta){
                    case "a":
                        editarNombre(dniTitular);
                        salir = true;
                        break;
                    case "b":
                        editarDni(dniTitular);
                        salir = true;
                        break;
                    default:
                        throw new Exception();
                }
            }
            catch(Exception e){
                System.out.println("* Opción no valida *");
            }

        }while(!salir);
    }

    public void editarNombre(String dniTitular){
        try {
            String nuevoNombre = ValidarDatos.validarDatos(sc, "Nuevo nombre", "Nuevo nombre del titular: ", "^[A-Za-z]+$");
            TitularControlador.editarNombre(nuevoNombre, dniTitular);
            System.out.println("--> Nombre editado con éxito");
        }
        catch(Exception e){
            System.out.println("No existe la persona con ese DNI");
        }
    }

    public void editarDni(String dniAntiguo){
        try{
            String dniNuevo = ValidarDatos.validarDatos(sc, "Nuevo DNI", "Nuevo DNI del titular: ", "^[0-9]{8}[A-Z]$");
            TitularControlador.editarDni(dniAntiguo, dniNuevo);
            System.out.println("--> DNI editado con éxito");
        }
        catch(Exception e){
            System.out.println("No existe la persona con ese DNI");
        }
    }

    public void verTitularPorId(){
            String id = ValidarDatos.validarDatos(sc, "ID", "ID del titular: ", "^[0-9]+$");
            System.out.println(TitularControlador.verTitularPorId(id));
    }

    public void verTitularPorNombre(){
            String nombre = ValidarDatos.validarDatos(sc, "Nombre", "Nombre del titular: ", "^[A-Za-z ]+$");
            ArrayList<Titular> titulares = TitularControlador.verTitularPorNombre(nombre);
            if(titulares.isEmpty()){
                System.out.println("* No existe ningún titular con ese nombre *");
            } else{
                for(Titular t: titulares){
                    System.out.println(t);
                }
            }
    }

    public void verTitularPorDni(){
        String dni = ValidarDatos.validarDatos(sc, "DNI", "DNI del titular: ", "^[0-9]{8}[A-Z]$");
        Titular titular = TitularControlador.verTitularPorDni(dni);

        if(titular == null){
            System.out.println("* No existe ningún titular con ese DNI *");
        } else System.out.println(titular);
    }
}
