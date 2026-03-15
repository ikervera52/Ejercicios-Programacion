package Controlador;

import DAO.TitularDAO;

public class TitularControlador {


    public static void eliminarTitular(String dni) throws Exception{
        TitularDAO.eliminarTitular(dni);
    }
}
