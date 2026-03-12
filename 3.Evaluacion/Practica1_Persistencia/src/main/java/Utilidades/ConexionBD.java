package Utilidades;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static EntityManagerFactory emf;

    public static EntityManagerFactory getEMF() {
        return emf;
    }

    public static void crearEMF() {
        emf = Persistence.createEntityManagerFactory("AppTitulares");
    }
}
