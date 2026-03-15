package Utilidades;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConexionBD {

    private static EntityManagerFactory emf;
    public static EntityManagerFactory getEMF() {
        return emf;
    }

    public static void crearEMF() {
        emf = Persistence.createEntityManagerFactory("AppTitulares");
    }
}
