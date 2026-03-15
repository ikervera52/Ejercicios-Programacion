package DAO;

import Modelo.Titular;
import Utilidades.ConexionBD;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class TitularDAO {

    public static void eliminarTitular(String dni) throws Exception{
        EntityManager em = ConexionBD.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery<Titular> query = em.createQuery(
                    "SELECT t FROM Titular t WHERE t.dni = :dni", Titular.class);
            query.setParameter("dni", dni);
            Titular titular = query.getSingleResult();

            if(titular != null){
                em.remove(titular);
                em.getTransaction().commit();
            } else throw new Exception();

        }catch (Exception ex){
            em.getTransaction().rollback();
            throw new Exception();
        }
        finally {
            em.close();
        }
    }
}
