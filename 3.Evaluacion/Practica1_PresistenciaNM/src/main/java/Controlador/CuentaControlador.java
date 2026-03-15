package Controlador;

import DAO.CuentaDAO;
import Modelo.Cuenta;

import java.util.List;

public class CuentaControlador {

    public static void eliminarCuenta(String iban) throws Exception {
        CuentaDAO.eliminarCuenta(iban);
    }

    public static String verCuentas(){
        List<Cuenta> cuentas = CuentaDAO.verCuentas();
        if(!cuentas.isEmpty()){
            StringBuilder sb = new StringBuilder();
            sb.append("==== Cuentas Corrientes ====").append("\n");
            for(Cuenta cuenta : cuentas){
                sb.append(cuenta.toString());
            }
            return sb.toString();
        } else return "* No hay ninguna cuenta en este momento *";
    }

    public static String verTitularesPorCuenta(String iban){
        Cuenta cuenta = CuentaDAO.verTitularesPorCuenta(iban);
        if(cuenta!=null){
            return cuenta.toString();
        } else return "* No existe ninguna cuenta con ese IBAN *";
    }
}
