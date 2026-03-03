package DAO;

import Modelo.Cuenta;
import Modelo.Titular;
import Utilidades.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CuentaDAO {

    public static void crearCuenta(Cuenta cuenta) throws Exception{
        try{
            Connection con = ConexionBD.getConexion();
            String sql = "INSERT INTO cuentas (iban,saldo) VALUES (?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cuenta.getIban());
            ps.setDouble(2, cuenta.getSaldo());
            int n = ps.executeUpdate();

            if(n == 0){
                throw new Exception();
            }

            ConexionBD.stopConexion(con);

        } catch (SQLException e) {
            System.out.println("Error DAO al insertar el cuenta: " + e.getMessage());
        }
    }

    public static void eliminarCuenta(String iban) throws Exception{
        try{
            Connection con = ConexionBD.getConexion();
            String sql = "DELETE FROM cuentas WHERE iban = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, iban);
            int n = ps.executeUpdate();

            if(n == 0){
                throw new Exception();
            }

            ConexionBD.stopConexion(con);
        }
        catch (SQLException e){
            System.out.println("Error DAO al eliminar el cuenta: " + e.getMessage());
        }
    }

    public static void editarCuenta (String iban, int saldo) throws Exception {
        try{
            Connection con = ConexionBD.getConexion();
            String sql = "UPDATE cuentas SET saldo = ? WHERE iban = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, saldo);
            ps.setString(2, iban);
            int n = ps.executeUpdate();

            if(n == 0){
                throw new Exception();
            }

            ConexionBD.stopConexion(con);

        }
        catch (SQLException e){
            System.out.println("Error DAO al editar el cuenta: " + e.getMessage());
        }
    }

    public static ArrayList<Cuenta> mostrarCuentas(){
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        try{
            Connection con = ConexionBD.getConexion();
            String sql = "SELECT * FROM cuentas";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                cuentas.add(new Cuenta(
                        rs.getInt("id"),
                        rs.getString("iban"),
                        rs.getInt("saldo")
                ));
            }

            ConexionBD.stopConexion(con);

        }
        catch (SQLException e){
            System.out.println("Error DAO mostrar cuentas: " + e.getMessage());
        }

        return cuentas;
    }

    public static ArrayList<Cuenta> verCuentaPorSaldo(int saldo){
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        try{
            Connection con = ConexionBD.getConexion();
            String sql = "SELECT * FROM cuentas WHERE saldo > ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, saldo);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                cuentas.add(new Cuenta (
                        rs.getInt("id"),
                        rs.getString("iban"),
                        rs.getInt("saldo")
                ));
            }

            ConexionBD.stopConexion(con);

        } catch (SQLException e) {
            System.out.println("Error DAO al ver por saldo:" + e.getMessage());
        }

        return cuentas;
    }

    public static Cuenta verCuentaPorIban(String iban){
        Cuenta cuenta = null;
        try{
            Connection con = ConexionBD.getConexion();
            String sql = "SELECT * FROM cuentas WHERE iban = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, iban);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                cuenta = new  Cuenta (
                        rs.getInt("id"),
                        rs.getString("iban"),
                        rs.getInt("saldo")
                        );
            }
        }
        catch (SQLException e){
            System.out.println("Error DAO mostrar cuenta: " + e.getMessage());
        }

        return cuenta;
    }

    public static Cuenta verCuentaPorId(String id) {
        Cuenta cuenta = null;
        try {
            Connection con = ConexionBD.getConexion();
            String sql = "SELECT * FROM cuentas WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cuenta = new Cuenta(
                        rs.getInt("id"),
                        rs.getString("iban"),
                        rs.getInt("saldo"));
            }

        } catch (SQLException e) {
            System.out.println("Error en TitularDAO verTitularPorId: "+e.getMessage());
        }

        return cuenta;
    }
}
