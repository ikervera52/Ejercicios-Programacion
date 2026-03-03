package Controlador;

import DAO.CuentaCorrienteDAO;
import DAO.CuentaDAO;
import DAO.TitularDAO;
import Modelo.Cuenta;
import Modelo.Titular;

import java.util.ArrayList;
import java.util.Map;

public class ControladorGeneral {

    public static String crearCuentaCorriente(String dni, String iban)throws Exception{
        Titular titular = TitularDAO.verTitularPorDni(dni);
        if(titular != null){
            Cuenta cuenta = CuentaDAO.verCuentaPorIban(iban);

            if(cuenta != null){
                CuentaCorrienteDAO.crearCuentaCorriente(titular, cuenta);
                return "Cuenta Corriente creada  correctamente";

            } else return "* No existe ninguna cuenta con ese IBAN *";

        }else  return "* No existe ningún Titular con ese DNI *";

    }

    public static String eliminarCuentaCorriente (String dni, String iban) throws Exception{
        Titular titular = TitularDAO.verTitularPorDni(dni);
        if(titular != null){
            Cuenta cuenta = CuentaDAO.verCuentaPorIban(iban);

            if(cuenta != null){
                CuentaCorrienteDAO.eliminarCuentaCorriente(titular, cuenta);
                return "Cuenta Corriente eliminada  correctamente";

            } else return "* No existe ninguna cuenta con ese IBAN *";

        }else  return "* No existe ningún Titular con ese DNI *";

    }

    public static String mostrarCuentasCorrientes(){
        Map<Titular, Cuenta> cuentasCorrientes = CuentaCorrienteDAO.mostrarCuentasCorrientes();

        if(!cuentasCorrientes.isEmpty()){

            for (Map.Entry<Titular, Cuenta> entry : cuentasCorrientes.entrySet()) {
                Titular titular = TitularDAO.verTitularPorId(String.valueOf(entry.getKey().getId()));
                entry.getKey().setDni(titular.getDni());
                entry.getKey().setNombre(titular.getNombre());

                Cuenta cuenta = CuentaDAO.verCuentaPorId(String.valueOf(entry.getValue().getId()));
                entry.getValue().setIban(cuenta.getIban());
                entry.getValue().setSaldo(cuenta.getSaldo());
            }

            StringBuilder lista = new StringBuilder();

            for (Map.Entry<Titular, Cuenta> entry : cuentasCorrientes.entrySet()) {
                lista.append("Cuenta Corriente:\n").append("Titular: ").append(entry.getKey().getNombre()).append(" DNI: ").append(entry.getKey().getDni())
                .append("\n").append("IBAN: ").append(entry.getValue().getIban()).append(" Saldo: ")
                .append(entry.getValue().getSaldo()).append('\n');
            }

            return lista.toString();

        } else return "* No existe ninguna Cuenta Corriente en este momento *";
    }

    public static String editarCuentaCorrienteTitular(String dni, String iban, String nuevoDni)  throws Exception{
        Titular nuevoTitular = TitularDAO.verTitularPorDni(nuevoDni);
        if(nuevoTitular != null){
            Titular titularActual = TitularDAO.verTitularPorDni(dni);
            Cuenta cuenta = CuentaDAO.verCuentaPorIban(iban);

            CuentaCorrienteDAO.editarCuentaCorrienteTitular(cuenta, nuevoTitular, titularActual);
            return "Cuenta Corriente editada correctamente";
        } else return "* No existe ningún titular con ese DNI *";
    }

    public static String editarCuentaCorrienteCuenta(String dni, String ibanActual, String ibanNuevo)  throws Exception{
        Cuenta nuevaCuenta = CuentaDAO.verCuentaPorIban(ibanNuevo);
        if(nuevaCuenta != null){
            Titular titularActual = TitularDAO.verTitularPorDni(dni);
            Cuenta cuentaActual = CuentaDAO.verCuentaPorIban(ibanActual);

            CuentaCorrienteDAO.editarCuentaCorrienteCuenta(cuentaActual, nuevaCuenta, titularActual);
            return "Cuenta Corriente editada correctamente";
        } else return "* No existe ninguna cuenta con el nuevo IBAN *";
    }

    public static String asociarTitularACuenta(String dni, String iban) throws Exception{
        Titular titular = TitularDAO.verTitularPorDni(dni);
        if(titular != null){
            Cuenta cuenta = CuentaDAO.verCuentaPorIban(iban);
            if(cuenta != null){

                CuentaCorrienteDAO.asociarTitularACuenta(titular, cuenta);
                return "Titular asociado a Cuenta correctamente";

            } else return "* No existe ninguna cuenta con ese IBAN *";
        } else return "* No existe nigun titular con ese DNI *";
    }
}
