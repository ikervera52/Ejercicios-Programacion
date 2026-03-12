package DAO;

import Modelo.Titular;
import Utilidades.ConexionBD;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;

public class TitularDAO {

    public static void crearTitular(Titular titular) throws Exception {
        EntityManager em = ConexionBD.getEMF().createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(titular);
            em.getTransaction().commit();
            em.close();
        }
        catch (Exception ex) {
            System.out.println("Error (DAO) al crear titular: " + ex.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new Exception();
        }
    }

    public static void borrarTitular(String dni) throws Exception{
        EntityManager em = ConexionBD.getEMF().createEntityManager();

        try {

            em.getTransaction().begin();
            TypedQuery<Titular> query = em.createQuery("SELECT t FROM Titular t WHERE t.dni=:dni", Titular.class);
            query.setParameter("dni", dni);
            Titular titular = query.getSingleResult();

            em.remove(titular);
            em.getTransaction().commit();
            em.close();
        }
        catch (Exception ex) {
            System.out.println("Error (DAO) al borrar titular: " + ex.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new Exception();
        }
    }

    public static ArrayList<Titular> mostrarTodosLosTitulares(){
        EntityManager em = ConexionBD.getEMF().createEntityManager();
        ArrayList<Titular> titulares = new ArrayList<>();
        try {
            em.getTransaction().begin();
            TypedQuery<Titular> query =
                    em.createQuery("SELECT t FROM Titular t", Titular.class);
            titulares = new ArrayList<>(query.getResultList());


        }catch (Exception ex){
            System.out.println("Error (DAO) mostrarTodosLosTitulares: " + ex.getMessage());
        }
        return titulares;

    }

    public static void editarNombre(Titular titular) throws Exception{
        EntityManager em = ConexionBD.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(titular);
            em.getTransaction().commit();
            em.close();
        }
        catch (Exception ex) {
            System.out.println("Error (DAO) editarNombre: " + ex.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new Exception();
        }

    }

    public static void editarDni(Titular titular) throws Exception{
        EntityManager em = ConexionBD.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(titular);
            em.getTransaction().commit();
            em.close();
        }catch (Exception ex) {
            System.out.println("Error (DAO) editarDni: " + ex.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new Exception();
        }
    }

    public static Titular verTitularPorId(String id) {
        EntityManager em = ConexionBD.getEMF().createEntityManager();
        Titular titular = null;
        try {
            titular = em.find(Titular.class, id);

        }catch (Exception ex){
            System.out.println("Error (DAO) verTitularPorId: " + ex.getMessage());
        }
        return titular;


    }

    public static ArrayList<Titular> verTitularPorNombre(String nombre) {
        EntityManager em = ConexionBD.getEMF().createEntityManager();
        ArrayList<Titular> titulares = null;

        try {
            em.getTransaction().begin();
            TypedQuery<Titular> query = em.createQuery(
                    "SELECT t FROM Titular t WHERE t.nombre = :nombre", Titular.class);
            query.setParameter("nombre", nombre);
            titulares = new ArrayList<>(query.getResultList());
        }
        catch (Exception ex){
            System.out.println("Error (DAO) verTitularPorNombre: " + ex.getMessage());
        }
        return titulares;
    }

    public static Titular verTitularPorDni(String dni){
        EntityManager em = ConexionBD.getEMF().createEntityManager();
        Titular titular = null;
        try {
            em.getTransaction().begin();
            TypedQuery<Titular> query = em.createQuery(
                    "SELECT t FROM Titular t WHERE t.dni = :dni", Titular.class);
            query.setParameter("dni", dni);
            titular = query.getSingleResult();
            em.close();

        } catch (Exception ex) {
            System.out.println("Error (DAO) al ver titular por DNI: " + ex.getMessage());
        }
        return titular;
    }
}
