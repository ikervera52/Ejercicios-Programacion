package Controlador;

import DAO.PasajeroDAO;
import Modelo.Pasajero;

import java.sql.SQLException;
import java.util.ArrayList;

public class PasajeroControlador {

    public static void registrarPasajero(String dni, String nombre, String telefono, String codigoVuelo){
        Pasajero pasajero =  new Pasajero(dni, nombre, telefono, codigoVuelo);
        PasajeroDAO.registrarPasajero(pasajero);
    }

    public static void eliminarPasajero(String dni) throws Exception{
        PasajeroDAO.eliminarPasajero(dni);
    }

    public static void editarPasajeroString(String dni, String respuesta, String objetivo) throws Exception {
        PasajeroDAO.editarPasajeroString(dni, respuesta, objetivo);
    }

    public static String pasajeroPorDni(String dni) {
        Pasajero pasajero = PasajeroDAO.pasajeroPorDni(dni);
        if(pasajero != null){
            return pasajero.toString();
        } else return "* No existe ningún Pasajero con ese DNI *";

    }

    public static String pasajerosPorVuelo(String codVuelo) {
        ArrayList<Pasajero> pasajeros = PasajeroDAO.pasajerosPorVuelo(codVuelo);
        if(!pasajeros.isEmpty()){
            StringBuilder sb = new StringBuilder();
            sb.append("==== Pasajeros de Vuelo: ").append(codVuelo).append(" ====\n");
            for (Pasajero pasajero : pasajeros) {
                sb.append(pasajero.toString());
            }
            return sb.toString();
        } else return "* El Vuelo seleccionada esta vacío *";
    }
}
