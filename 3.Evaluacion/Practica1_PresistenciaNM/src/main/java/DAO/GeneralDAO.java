package DAO;

import Modelo.Cuenta;
import Modelo.Titular;
import Utilidades.ConexionBD;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class GeneralDAO {

    public static void anadirTitularExistente(String dni, String iban) throws Exception {
        EntityManager em = ConexionBD.getEMF().createEntityManager();

        try {
            em.getTransaction().begin();
            TypedQuery<Titular> query = em.createQuery("SELECT t FROM Titular t WHERE t.dni = :dni", Titular.class);
            query.setParameter("dni", dni);
            Titular titular = query.getSingleResult();

            if(titular != null){
                TypedQuery<Cuenta> query1 = em.createQuery("SELECT c FROM Cuenta c WHERE c.iban = :iban", Cuenta.class);
                query1.setParameter("iban", iban);

                Cuenta cuenta = query1.getSingleResult();
                cuenta.setTitular(titular);

                em.merge(cuenta);
                em.getTransaction().commit();

            } else throw new Exception("* No existe el titular *");

            } catch (Exception e) {
            System.out.println("Error (DAO) al anadirTitularExistente: " + e.getMessage());
            em.getTransaction().rollback();
            throw new Exception();
        }
    }

    public static void eliminarTitularCuenta(String iban, String dni) throws Exception {
        EntityManager em = ConexionBD.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery<Cuenta> query = em.createQuery("SELECT t FROM Cuenta t WHERE t.iban = :iban", Cuenta.class);
            query.setParameter("iban", iban);
            Cuenta cuenta = query.getSingleResult();
            if(cuenta != null){

                for (Titular titular : cuenta.getTitulares()) {
                    TypedQuery <Cuenta> query2 = em.createQuery(
                            "SELECT c FROM Cuenta c JOIN c.titulares t2 WHERE t2.dni = :dni", Cuenta.class);
                    query2.setParameter("dni", titular.getDni());
                    List<Cuenta> cuentas = query2.getResultList();
                    if (cuentas.size() == 1) {
                        em.remove(titular);
                    }
                }

                if (!cuenta.getTitulares().removeIf(titular -> titular.getDni().equals(dni))) {
                    throw new Exception("* Titular no encontrado *");
                } else {

                    em.merge(cuenta);
                    em.getTransaction().commit();
                }

            } else throw new Exception("* No existe la Cuenta son ese IBAN *");
        } catch (Exception e) {
            System.out.println("Error (DAO) al eliminarTitularCuenta: " + e.getMessage());
            em.getTransaction().rollback();
            throw new Exception("* Error al eliminar el Titular de la Cuenta");
        }
        finally {
            em.close();
        }
    }
}
