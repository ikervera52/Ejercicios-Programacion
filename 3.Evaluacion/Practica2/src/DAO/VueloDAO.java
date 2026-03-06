package DAO;

import Modelo.Vuelo;
import Utilidades.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class VueloDAO {

    public static void registrarVuelo (Vuelo vuelo) throws Exception {
        try {
            Connection conexion = ConexionBD.getConexion();
            String sql = "INSERT INTO vuelos (cod_vuelo, fecha_salida, destino, procedencia) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, vuelo.getCodVuelo());
            ps.setDate(2, java.sql.Date.valueOf(vuelo.getFecha()));
            ps.setString(3, vuelo.getDestino());
            ps.setString(4, vuelo.getProcedencia());
            int n =  ps.executeUpdate();

            if (n == 0) {
                throw new Exception();
            }

            ConexionBD.closeConexion(conexion);

        } catch (SQLException e) {
            System.out.println("Error (DAO) al insertar el vuelo" + e.getMessage());
        }
    }

    public static void eliminarVuelo (String codVuelo) throws Exception {
        try {
            Connection conexion = ConexionBD.getConexion();
            String sql = "DELETE FROM vuelos WHERE cod_vuelo = ?";

            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, codVuelo);
            int n =  ps.executeUpdate();

            if (n == 0) {
                throw new Exception();
            }

            ConexionBD.closeConexion(conexion);

        } catch (SQLException e) {
            System.out.println("Error (DAO) al eliminar el vuelo" + e.getMessage());
        }
    }

    public static void editarVueloString(String codVuelo, String nuevo, String objetivo) throws Exception {
        try {
            Connection conexion = ConexionBD.getConexion();
            String sql = "UPDATE vuelos SET " + objetivo + " = ? WHERE cod_vuelo = ?";

            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, nuevo);
            ps.setString(2, codVuelo);
            int n =  ps.executeUpdate();

            if (n == 0) {
                throw new Exception();
            }

            ConexionBD.closeConexion(conexion);
        }
        catch (SQLException e) {
            System.out.println("Error (DAO) al editar el vuelo" + e.getMessage());
        }
    }

    public static void editarVueloDate(String codVuelo, LocalDate fecha) throws Exception {
        try {
            Connection conexion = ConexionBD.getConexion();
            String sql  = "UPDATE vuelos SET fecha_salida =? WHERE cod_vuelo = ?";

            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setDate(1, java.sql.Date.valueOf(fecha));
            ps.setString(2, codVuelo);
            int n =  ps.executeUpdate();

            if (n == 0) {
                throw new Exception();
            }

            ConexionBD.closeConexion(conexion);
        }
        catch (SQLException e) {
            System.out.println("Error (DAO) al editar el vuelo" + e.getMessage());
        }
    }

    public static Vuelo vueloPorCodigo(String codVuelo) {
        Vuelo vuelo = null;
        try {
            Connection conexion = ConexionBD.getConexion();
            String sql = "SELECT * FROM vuelos WHERE cod_vuelo = ?";

            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, codVuelo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                vuelo = new Vuelo(
                        rs.getString("cod_vuelo"),
                        rs.getDate("fecha_salida").toLocalDate(),
                        rs.getString("destino"),
                        rs.getString("procedencia")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error (DAO) al consultar el codigo de vuelo" + e.getMessage());
        }

        return vuelo;
    }

    public static ArrayList<Vuelo> vueloPorDestino(String destino) {
        ArrayList<Vuelo> vuelos = new ArrayList<>();
        try {
            Connection conexion = ConexionBD.getConexion();
            String sql = "SELECT * FROM vuelos WHERE destino = ?";

            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, destino);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                vuelos.add(new Vuelo(
                        rs.getString("cod_vuelo"),
                        rs.getDate("fecha_salida").toLocalDate(),
                        rs.getString("destino"),
                        rs.getString("procedencia")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error (DAO) al consultar el destino" + e.getMessage());
        }
        return vuelos;
    }

    public static ArrayList<Vuelo> vueloPorOrigen(String origen) {
        ArrayList<Vuelo> vuelos = new ArrayList<>();
        try {
            Connection conexion = ConexionBD.getConexion();
            String sql = "SELECT * FROM vuelos WHERE procedencia = ?";

            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, origen);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                vuelos.add(new Vuelo(
                        rs.getString("cod_vuelo"),
                        rs.getDate("fecha_salida").toLocalDate(),
                        rs.getString("destino"),
                        rs.getString("procedencia")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error (DAO) al consultar el origen" + e.getMessage());
        }
        return vuelos;
    }

    public static ArrayList<Vuelo> vuelosPorFecha(LocalDate fecha) {
        ArrayList<Vuelo> vuelos = new ArrayList<>();
        try {
            Connection conexion = ConexionBD.getConexion();
            String sql = "SELECT * FROM vuelos WHERE fecha_salida = ?";

            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setDate(1, java.sql.Date.valueOf(fecha));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                vuelos.add(new Vuelo(
                        rs.getString("cod_vuelo"),
                        rs.getDate("fecha_salida").toLocalDate(),
                        rs.getString("destino"),
                        rs.getString("procedencia")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error (DAO) al consultar por fecha" + e.getMessage());
        }
        return vuelos;
    }


}
