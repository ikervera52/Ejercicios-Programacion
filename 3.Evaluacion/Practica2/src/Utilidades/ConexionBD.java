package Utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    public static Connection getConexion() {
        Connection conexion = null;
        try {
            String url = "jdbc:mysql://localhost:3306/practica1";
            String user = "root";
            String password = "";
            conexion = DriverManager.getConnection(url, user, password);
        }
        catch (Exception e) {
            System.out.println("Error al conectar con la base de datos");
        }
        return conexion;
    }

    public static void closeConexion(Connection conexion) {
        try {
            if (conexion != null) {

                conexion.close();
            }
        }
        catch (SQLException e) {
            System.out.println("Error al cerrar la base de datos");
        }
    }
}
