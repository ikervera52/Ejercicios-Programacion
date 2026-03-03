package DAO;

import Modelo.Cuenta;
import Modelo.Titular;
import Utilidades.ConexionBD;
import jdk.jfr.TransitionFrom;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class CuentaCorrienteDAO {

    public static void crearCuentaCorriente(Titular titular, Cuenta cuenta) throws Exception {
        try{
            Connection con = ConexionBD.getConexion();
            String sql = "INSERT INTO cuentaTitular (idTitular, idCuenta) VALUES (?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,titular.getId());
            ps.setInt(2,cuenta.getId());
            int e = ps.executeUpdate();

            if(e == 0){
                throw new Exception();
            }
            ConexionBD.stopConexion(con);

        } catch (SQLException e) {
            System.out.println("Error (DAO) al crear la cuenta corriente");
        }
    }

    public static void eliminarCuentaCorriente(Titular titular, Cuenta cuenta) throws Exception {
        try{
            Connection con = ConexionBD.getConexion();
            String sql = "DELETE FROM cuentaTitular WHERE idTitular = ? AND idCuenta = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,titular.getId());
            ps.setInt(2,cuenta.getId());
            int e = ps.executeUpdate();

            if(e == 0){
                throw new Exception();
            }

            ConexionBD.stopConexion(con);

        } catch (SQLException e) {
            System.out.println("Error (DAO) al eliminar la cuenta corriente");
        }
    }

    public static Map<Titular, Cuenta> mostrarCuentasCorrientes(){
        Map<Titular, Cuenta> cuentasCorrientes = new HashMap<>();
        try{
            Connection con = ConexionBD.getConexion();
            String sql = "SELECT idTitular, idCuenta FROM cuentaTitular";

            Statement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                cuentasCorrientes.put(
                        new Titular (rs.getInt("idTitular")),
                        new Cuenta (rs.getInt("idCuenta")));
            }

        } catch (SQLException e) {
            System.out.println("Error (DAO) mostrar cuentas corrientes");
        }

        return cuentasCorrientes;
    }

    public static void editarCuentaCorrienteTitular(Cuenta cuenta, Titular nuevoTitular, Titular titularActual) throws Exception {
        try{
            Connection con = ConexionBD.getConexion();
            String sql = "UPDATE cuentaTitular SET idTitular = ? WHERE idTitular = ? AND idCuenta = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,nuevoTitular.getId());
            ps.setInt(2,titularActual.getId());
            ps.setInt(3,cuenta.getId());
            int e = ps.executeUpdate();

            if(e == 0){
                throw new Exception();
            }

            ConexionBD.stopConexion(con);
        }
        catch (SQLException e) {
            System.out.println("Error (DAO) al editar la cuenta corriente" + e.getMessage());
        }
    }

    public static void editarCuentaCorrienteCuenta(Cuenta cuentaActual, Cuenta cuentaNueva, Titular titular) throws Exception {
        try{
            Connection con = ConexionBD.getConexion();
            String sql = "UPDATE cuentaTitular SET idCuenta = ? WHERE idTitular = ? AND idCuenta = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,cuentaNueva.getId());
            ps.setInt(2,titular.getId());
            ps.setInt(3,cuentaActual.getId());
            int e = ps.executeUpdate();

            if(e == 0){
                throw new Exception();
            }

            ConexionBD.stopConexion(con);

        } catch (SQLException e) {
            System.out.println("Error (DAO) al editar la cuenta corriente" + e.getMessage());
        }
    }

    public static void asociarTitularACuenta(Titular titular,Cuenta cuenta) throws Exception {
        try{
            Connection con = ConexionBD.getConexion();
            String sql = "INSERT INTO cuentaTitular (idTitular,idCuenta) VALUES (?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,titular.getId());
            ps.setInt(2,cuenta.getId());
            int e = ps.executeUpdate();

            if(e == 0){
                throw new Exception();
            }

            ConexionBD.stopConexion(con);
        }
        catch (SQLException e) {
            System.out.println("Error (DAO) al asociar titular" + e.getMessage());
        }
    }

}
