package Controlador;

import DAO.TitularDAO;
import Modelo.Titular;

import java.util.ArrayList;

public class TitularControlador {

    public static void  crearTitular(String nombre, String dni) throws Exception{
        Titular titular = new Titular(nombre, dni);
        TitularDAO.crearTitular(titular);
    }

    public static void borrarTitular(String dni) throws Exception{
        TitularDAO.borrarTitular(dni);
    }

    public static ArrayList<Titular> obtenerTodosTitular(){
        return TitularDAO.mostrarTodosLosTitulares();
    }

    public static void editarNombre(String nombre, String dni) throws Exception{
        TitularDAO.editarNombre(nombre, dni);
    }

    public static void editarDni(String dniAntiguo, String dniNuevo) throws Exception{
        TitularDAO.editarDni(dniAntiguo, dniNuevo);
    }

    public static String verTitularPorId(String id){
        Titular titular = TitularDAO.verTitularPorId(id);
        if(titular != null){
            return titular.toString();
        } else return  "* No existe ningún titular con ese ID *";
    }

    public static ArrayList<Titular> verTitularPorNombre(String nombre){
        return TitularDAO.verTitularPorNombre(nombre);
    }

    public static Titular verTitularPorDni(String dni){
        return TitularDAO.verTitularPorDni(dni);
    }
}

