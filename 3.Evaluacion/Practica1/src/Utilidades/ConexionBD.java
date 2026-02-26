package Utilidades;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    public static Connection getConexion(){
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bdejemplo";
            String user = "root";
            String password = "";
            conexion = DriverManager.getConnection(url, user, password);

        }catch (ClassNotFoundException e){
            System.out.println("No se a encontrado el driver");
        }catch (SQLException e){
            System.out.println("No se pudo establecer la conexión");
        }

        return conexion;
    }

    public static void stopConexion(Connection conexion){
        try {
            conexion.close();
        }catch (SQLException e){
            System.out.println("Error al cerrar la conexión");
        }
    }
}
