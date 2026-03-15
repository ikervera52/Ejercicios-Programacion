package Controlador;
import DAO.CuentaDAO;
import DAO.GeneralDAO;
import Modelo.Cuenta;
import Modelo.Titular;

public class GeneralControlador {

    public static void crearCuenta(String nombre, String dni, String iban, int saldo) throws Exception {

            Titular titular = new Titular(nombre, dni);

            Cuenta cuenta = new Cuenta(iban, saldo);
            cuenta.setTitular(titular);

            CuentaDAO.crearCuenta(cuenta);

    }

    public static void anadirTitularExistente(String iban, String dni) throws Exception {

        GeneralDAO.anadirTitularExistente(dni, iban);
    }

    public static void eliminarTitularCuenta(String iban, String dni) throws Exception {
        GeneralDAO.eliminarTitularCuenta(iban, dni);
    }
}
