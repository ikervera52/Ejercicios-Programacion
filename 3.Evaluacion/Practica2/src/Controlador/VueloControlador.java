package Controlador;

import DAO.VueloDAO;
import Modelo.Vuelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class VueloControlador {

    public static void registrarVuelo(String codVuelo, LocalDate fecha, String destino, String procedencia) throws Exception {
        Vuelo vuelo = new Vuelo(codVuelo, fecha, destino, procedencia);
        VueloDAO.registrarVuelo(vuelo);
    }

    public static void eliminarVuelo(String codVuelo) throws Exception {
        VueloDAO.eliminarVuelo(codVuelo);
    }

    public static void editarVueloString(String codVuelo, String respuesta, String objetivo) throws Exception {
        VueloDAO.editarVueloString(codVuelo, respuesta, objetivo);
    }

    public static void editarVueloDate(String codVuelo, LocalDate fecha) throws Exception {
        VueloDAO.editarVueloDate(codVuelo,fecha);
    }

    public static String vueloPorCodigo(String codVuelo) {
        Vuelo vuelo = VueloDAO.vueloPorCodigo(codVuelo);
        if (vuelo != null) {
            return vuelo.toString();
        } else return "* No existe el vuelo con ese código *";
    }

    public static String vueloPorDestino(String destino) {
        ArrayList<Vuelo> vuelos = VueloDAO.vueloPorDestino(destino);
        if (!vuelos.isEmpty()){
            StringBuilder sb = new StringBuilder();
            sb.append("==== Vuelos con Destino: ").append(destino).append(" ====").append("\n");
            for (Vuelo vuelo : vuelos) {
                sb.append(vuelo.toString());
            }


            return sb.toString();

        } else  return "* No hay ningún Vuelo con ese Destino *";
    }

    public static String vueloPorOrigen(String origen) {
        ArrayList<Vuelo> vuelos = VueloDAO.vueloPorOrigen(origen);
        if (!vuelos.isEmpty()){
            StringBuilder sb = new StringBuilder();
            sb.append("==== Vuelos con origen: ").append(origen).append(" ====").append("\n");
            for (Vuelo vuelo : vuelos) {
                sb.append(vuelo.toString());
            }
            return sb.toString();
        } else return "* No hay ningún Vuelo con ese Origen *";
    }

    public static String vuelosPorFecha(LocalDate fecha) {
        ArrayList<Vuelo> vuelos = VueloDAO.vuelosPorFecha(fecha);
        if (!vuelos.isEmpty()){
            StringBuilder sb = new StringBuilder();
            sb.append("==== Vuelos con Fecha: ").append(fecha).append(" ====").append("\n");
            for (Vuelo vuelo : vuelos) {
                sb.append(vuelo.toString());
            }
            return sb.toString();
        } return "* No hay ningún Vuelo en esa Fecha *";
    }
}
