package DAO;

import Modelo.Pasajero;
import Utilidades.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PasajeroDAO {

    public static void registrarPasajero(Pasajero pasajero){
        try {
            Connection con = ConexionBD.getConexion();
            String sql = "INSERT INTO pasajeros (dni,  nombre, telefono, cod_vuelo) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pasajero.getDni());
            ps.setString(2, pasajero.getNombre());
            ps.setString(3, pasajero.getTelefono());
            ps.setString(4, pasajero.getVuelo());
            int n =  ps.executeUpdate();


            ConexionBD.closeConexion(con);

        }
        catch (SQLException e) {
            System.out.println("Pene");
        }
    }

    public static void eliminarPasajero(String dni) throws Exception{

        try {
            Connection con = ConexionBD.getConexion();
            String sql = "DELETE FROM pasajeros WHERE dni=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            int n =  ps.executeUpdate();

            if (n == 0) {
                throw new Exception();
            }

            ConexionBD.closeConexion(con);
        }
        catch (SQLException e) {
            System.out.println("Error (DAO) al eliminar pasajero " + e.getMessage());
        }
    }

    public static void editarPasajeroString(String dni, String nuevo, String objetivo) throws Exception {
        try {
            Connection conexion = ConexionBD.getConexion();
            String sql = "UPDATE pasajeros SET " + objetivo + " = ? WHERE cod_vuelo = ?";

            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, nuevo);
            ps.setString(2, dni);
            int n =  ps.executeUpdate();

            if (n == 0) {
                throw new Exception();
            }

            ConexionBD.closeConexion(conexion);
        }
        catch (SQLException e) {
            System.out.println("Error (DAO) al editar el pasajero" + e.getMessage());
        }
    }

    public static Pasajero pasajeroPorDni(String dni) {
        Pasajero pasajero = null;
        try {
            Connection conexion = ConexionBD.getConexion();
            String sql = "SELECT * FROM pasajeros WHERE dni=?";

            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pasajero = new Pasajero(
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("cod_vuelo")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error (DAO) pasajeroPorDni" + e.getMessage());
        }

        return pasajero;
    }

    public static ArrayList<Pasajero> pasajerosPorVuelo(String codVuelo) {
        ArrayList<Pasajero> pasajeros = new ArrayList<>();
        try {
            Connection conexion = ConexionBD.getConexion();
            String sql = "SELECT * FROM pasajeros WHERE cod_vuelo=?";

            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, codVuelo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                pasajeros.add(new Pasajero(
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("cod_vuelo")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error (DAO) pasajeros por Vuelo" + e.getMessage());
        }
        return pasajeros;
    }
}
