package DAO;

import Modelo.Cuenta;
import Modelo.Titular;
import Utilidades.ConexionBD;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Set;

public class CuentaDAO {

    public static void crearCuenta(Cuenta cuenta) throws Exception {
        EntityManager em = ConexionBD.getEMF().createEntityManager();
        try {

            em.getTransaction().begin();
            em.persist(cuenta);
            em.getTransaction().commit();

        }
        catch (Exception ex) {
            System.out.println("Error (DAO) al crear Cuenta " + ex.getMessage());
            em.getTransaction().rollback();
            throw new Exception();

        }
        finally {
            em.close();
        }
    }

    public static List<Cuenta> verCuentas(){
        EntityManager em = ConexionBD.getEMF().createEntityManager();
        List<Cuenta> cuentas = null;

        try {
            em.getTransaction().begin();

            TypedQuery<Cuenta> query = em.createQuery("SELECT c FROM Cuenta c", Cuenta.class);
            cuentas = query.getResultList();

        }catch (Exception ex){
            System.out.println("Error (DAO) al verCuentas " + ex.getMessage());
        }finally {
            em.close();
        }
        return  cuentas;
    }

    public static Cuenta verTitularesPorCuenta(String iban){
        EntityManager em = ConexionBD.getEMF().createEntityManager();
        Cuenta cuenta = null;
        try {
            em.getTransaction().begin();
            TypedQuery<Cuenta> query = em.createQuery("SELECT c FROM Cuenta c WHERE c.iban = :iban", Cuenta.class);
            cuenta = query.setParameter("iban", iban).getSingleResult();

        }catch (Exception ex){
            System.out.println("Error (DAO) al verTitularesPorCuenta " + ex.getMessage());
        }
        finally{
            em.close();
        }
        return cuenta;
    }

    public static void eliminarCuenta(String iban) throws Exception {
        EntityManager em = ConexionBD.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();

            TypedQuery<Cuenta> query = em.createQuery(
                    "SELECT c FROM Cuenta c WHERE c.iban = :iban", Cuenta.class);
            query.setParameter("iban", iban);

            Cuenta cuenta = query.getSingleResult();


            if (cuenta != null) {
                em.remove(cuenta);

                for (Titular titular : cuenta.getTitulares()) {
                    TypedQuery <Cuenta> query2 = em.createQuery(
                            "SELECT c FROM Cuenta c JOIN c.titulares t2 WHERE t2.dni = :dni", Cuenta.class);
                    query2.setParameter("dni", titular.getDni());
                    List<Cuenta> cuentas = query2.getResultList();
                    if (cuentas.isEmpty()) {
                        em.remove(titular);
                    }
                }

                em.getTransaction().commit();

            } else throw new Exception();

        }
        catch (Exception ex) {
            System.out.println("Error (DAO) al eliminar Cuenta " + ex.getMessage());
            em.getTransaction().rollback();
            throw new Exception();
        }
        finally {
            em.close();
        }
    }


}
