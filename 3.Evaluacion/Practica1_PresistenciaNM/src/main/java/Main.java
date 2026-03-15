import Utilidades.ConexionBD;
import Vista.MenuGeneral;

public class Main {

    public static void main(String[] args) {

        ConexionBD.crearEMF();

        MenuGeneral.menuGeneral();

    }
}
