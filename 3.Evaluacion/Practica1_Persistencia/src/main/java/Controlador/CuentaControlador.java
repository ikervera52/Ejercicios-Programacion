package Controlador;

import DAO.CuentaDAO;
import DAO.TitularDAO;
import Modelo.Cuenta;

public class CuentaControlador {

    public static String eliminarCuenta(int iban){
            Cuenta cuenta = CuentaDAO.verCuentaPorIban(iban);
            if(cuenta!=null){
                CuentaDAO.eliminarCuenta(cuenta);
                return "--> Cuenta eliminada con éxito";
            } else return "* Esta cuenta no existe *";
    }

    public static void editarIban(int iban, int nuevoIban) throws Exception{
        Cuenta cuenta = CuentaDAO.verCuentaPorIban(iban);
        if(cuenta!=null){
            cuenta.setIban(nuevoIban);
            CuentaDAO.editar(cuenta);
        }
    }

    public static void editarSaldo(int iban, int nuevoSaldo) throws Exception{
        Cuenta cuenta = CuentaDAO.verCuentaPorIban(iban);
        if(cuenta!=null){
            cuenta.setSaldo(nuevoSaldo);
            CuentaDAO.editar(cuenta);
        }
    }
}
