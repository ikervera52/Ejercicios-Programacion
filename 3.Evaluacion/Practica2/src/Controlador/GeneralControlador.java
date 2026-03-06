package Controlador;

import DAO.PasajeroDAO;
import DAO.VueloDAO;
import Modelo.Pasajero;
import Modelo.Vuelo;

public class GeneralControlador {

    public static String vueloPorPasajero(String dni) {
        Pasajero pasajero = PasajeroDAO.pasajeroPorDni(dni);
        if (pasajero != null) {
            Vuelo vuelo = VueloDAO.vueloPorCodigo(pasajero.getVuelo());
            if (vuelo != null) {
                return "==== Vuelo del pasajero " + pasajero.getDni() + "====\n" + vuelo.toString();

            } else return  "* Este pasajero no tiene ningún vuelo asignado *";

        } else  return "* No existe ningún pasajero con este DNI *";

    }
}
