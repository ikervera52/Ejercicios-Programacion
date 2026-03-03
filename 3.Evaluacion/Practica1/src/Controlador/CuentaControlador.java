package Controlador;

import DAO.CuentaDAO;
import Modelo.Cuenta;

import java.util.ArrayList;

public class CuentaControlador {

    public static void crearCuenta(String iban, int saldo) throws Exception {
        Cuenta cuenta = new Cuenta(iban,saldo);
        CuentaDAO.crearCuenta(cuenta);
    }

    public static void eliminarCuenta(String iban) throws Exception {
        CuentaDAO.eliminarCuenta(iban);
    }

    public static void editarCuenta(String iban, int saldo) throws Exception {
        CuentaDAO.editarCuenta(iban,saldo);
    }

    public static String mostrarCuentas(){
        ArrayList<Cuenta> cuentas = CuentaDAO.mostrarCuentas();
        if(cuentas.isEmpty()){
            return "* No hay ninguna cuenta *";
        } else {
            StringBuilder builder = new StringBuilder();
            for(Cuenta cuenta : cuentas){
                builder.append(cuenta.toString());
            }
            return builder.toString();
        }
    }

    public static String verCuentaPorSaldo(int saldo){
        ArrayList<Cuenta> cuentas = CuentaDAO.verCuentaPorSaldo(saldo);
        if(cuentas.isEmpty()){
            return "* No hay ninguna cuenta con saldo superior a " + saldo + " *";
        } else  {
            StringBuilder builder = new StringBuilder();
            for(Cuenta cuenta : cuentas){
                builder.append(cuenta.toString());
            }
            return builder.toString();
        }
    }

    public static String verCuentaPorIban(String iban){
        Cuenta cuenta = CuentaDAO.verCuentaPorIban(iban);
        if(cuenta == null){
            return "* No existe ninguna cuenta con ese IBAN *";
        } else{
            return cuenta.toString();
        }
    }
}
