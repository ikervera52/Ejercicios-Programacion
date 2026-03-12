package DAO;

import Modelo.Cuenta;
import Utilidades.ConexionBD;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class CuentaDAO {

    public static void crearCuenta(Cuenta cuenta){
        EntityManager em = ConexionBD.getEMF().createEntityManager();

        try {

            em.getTransaction().begin();
            em.persist(cuenta);
            em.getTransaction().commit();
            em.close();

        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Error (DAO) al crear Cuenta" + ex.getMessage());
        }
    }

    public static Cuenta verCuentaPorIban(int iban){
        EntityManager em = ConexionBD.getEMF().createEntityManager();
        Cuenta cuenta = null;
        try {
            em.getTransaction().begin();
            TypedQuery<Cuenta> query = em.createQuery("SELECT c FROM Cuenta c WHERE c.iban = :iban", Cuenta.class);
            query.setParameter("iban", iban);
            cuenta = query.getSingleResult();
            em.close();
        }
        catch (Exception nre){
            System.out.println("Error (DAO) al ver por Iban Cuenta" + nre.getMessage());
        }
        return cuenta;
    }

    public static void eliminarCuenta(Cuenta cuenta){
        EntityManager em = ConexionBD.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(cuenta);
            em.getTransaction().commit();
            em.close();

        }catch (Exception nre){
            System.out.println("Error (DAO) al eliminar Cuenta" + nre.getMessage());
        }
    }

    public static void editar(Cuenta cuenta) throws Exception{
        EntityManager em = ConexionBD.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(cuenta);
            em.getTransaction().commit();
            em.close();
        }
        catch (Exception nre){
            System.out.println("Error (DAO) al editar Cuenta" + nre.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new Exception();
        }
    }
}
