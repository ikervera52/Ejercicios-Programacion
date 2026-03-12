package Controlador;

import DAO.CuentaDAO;
import DAO.TitularDAO;
import Modelo.Cuenta;
import Modelo.Titular;

public class GeneralControlador {

    public static String crearCuenta(int iban, int saldo, String dni) {
        Titular titular = TitularDAO.verTitularPorDni(dni);
        if (titular != null){
            Cuenta cuenta = new Cuenta(iban, saldo);
            cuenta.setIdTitular(titular);
            CuentaDAO.crearCuenta(cuenta);
            return "--> Cuenta creada con éxito";

        } else return "* No existe el titular con ese DNI *";
    }

    public static void editarTitularCuenta(int iban, String nuevoDni)  throws Exception {
        Titular titular =  TitularDAO.verTitularPorDni(nuevoDni);
        if (titular != null){

            Cuenta cuenta = CuentaDAO.verCuentaPorIban(iban);
            cuenta.setIdTitular(titular);

            CuentaDAO.editar(cuenta);
        }
    }
}
