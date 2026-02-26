package DAO;

import Modelo.Titular;
import Utilidades.ConexionBD;

import java.sql.*;
import java.util.ArrayList;

public class TitularDAO {

    public static void crearTitular(Titular titular) throws Exception {

        Connection con = ConexionBD.getConexion();

        String sql = "INSERT INTO titulares (nombre, dni) VALUES (?,?)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, titular.getNombre());
        ps.setString(2, titular.getDni());
        ps.executeUpdate();


    }

    public static void borrarTitular(String dni) throws Exception{
        try {
            Connection con = ConexionBD.getConexion();
            String sql = "DELETE FROM titulares WHERE dni=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            int exito = ps.executeUpdate();

            ConexionBD.stopConexion(con);

            if (exito == 0){
                throw new Exception();
            }

        } catch (SQLException e) {
            System.out.println("Error en TitularDAO borrarTitular: "+e.getMessage());
        }
    }

    public static ArrayList<Titular> mostrarTodosLosTitulares(){
        ArrayList<Titular> titulares = new ArrayList<>();

        try {
            Connection con = ConexionBD.getConexion();
            String sql = "SELECT * FROM titulares";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                titulares.add(new Titular (rs.getInt("id"),
                                            rs.getString("nombre"),
                                            rs.getString("dni")));
            }

        } catch (SQLException e) {
            System.out.println("Error en TitularDAO mostrarTodosLosTitulares: "+e.getMessage());
        }

        return  titulares;
    }

    public static void editarNombre(String nombre, String dni) throws Exception{
        try {
            Connection con = ConexionBD.getConexion();
            String sql = "UPDATE titulares SET nombre=? WHERE dni=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, dni);
            int exito = ps.executeUpdate();

            System.out.println("Titular Actualizado Correctamente");
            ConexionBD.stopConexion(con);

            if (exito == 0){
                throw new Exception();
            }

        } catch (SQLException e) {
            System.out.println("Error en TitularDAO editarTitular: "+e.getMessage());
        }
    }

    public static void editarDni(String dniAntiguo, String dniNuevo) throws Exception{
        try {
            Connection con = ConexionBD.getConexion();
            String sql = "UPDATE titulares SET dni=? WHERE dni=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dniNuevo);
            ps.setString(2, dniAntiguo);
            int exito = ps.executeUpdate();

            if (exito == 0){
                throw new Exception();
            }
            ConexionBD.stopConexion(con);



        } catch (SQLException e) {
            System.out.println("Error en TitularDAO editarDni: "+e.getMessage());
        }
    }

    public static Titular verTitularPorId(String id) {
        Titular titular = null;
        try {
            Connection con = ConexionBD.getConexion();
            String sql = "SELECT * FROM titulares WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                titular = new Titular(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("dni"));
            }

        } catch (SQLException e) {
            System.out.println("Error en TitularDAO verTitularPorId: "+e.getMessage());
        }

        return titular;
    }

    public static ArrayList<Titular> verTitularPorNombre(String nombre) {
        ArrayList<Titular> titulares = new ArrayList<>();
        try {
            Connection con = ConexionBD.getConexion();
            String sql = "SELECT * FROM titulares WHERE nombre=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                titulares.add(
                        new Titular(
                                rs.getInt("id"),
                                rs.getString("nombre"),
                                rs.getString("dni")));
            }

        } catch (SQLException e) {
            System.out.println("Error en TitularDAO verTitularesPorNombre: "+e.getMessage());
        }

        return  titulares;
    }

    public static Titular verTitularPorDni(String dni){
        Titular titular = null;
        try {
            Connection con = ConexionBD.getConexion();
            String sql = "SELECT * FROM titulares WHERE dni=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();


            if (rs.next()) {
                titular = new Titular(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("dni"));
            }

        } catch (SQLException e) {
            System.out.println("Error en TitularDAO verTitularPorDni: "+e.getMessage());
        }

        return titular;
    }
}
