import Modelo.Estudio;
import Modelo.Pelicula;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Main {

    private static Estudio[] estudios;
    private static ArrayList <Pelicula> listaPeliculas;
    public static void main(String[] args) {

        crearEstudios();
        crearPeliculas();
        buscarPeliculaMasLarga();
        estudioConMasPeliculas();

    }

    public static void crearEstudios(){
        //Creamos los estudios
        Estudio universal = new Estudio("universal", "Madrid", "nolose", "www.a.com",
                "20/10/2004", "USA", "688665656");

        Estudio waltDisney = new Estudio("walt disney", "Madrid", "nolose", "www.b.com",
                "20/10/2003", "Canadá", "688665444");

        Estudio warner = new Estudio("warner", "Madrid", "nolose", "www.a.com",
                "20/10/2004", "España", "688665656");

        estudios = new Estudio[3];
        estudios[0] = universal;
        estudios[1] = waltDisney;
        estudios[2] = warner;
    }

    public static void crearPeliculas(){

        //Creamos las películas

        ArrayList <Estudio> etList = new ArrayList<>();
        etList.add(estudios[1]);
        etList.add(estudios[2]);

        Pelicula et = new Pelicula("et", "2004", 120, "alienigenas", etList);

        System.out.println(estudios[1]);
        ArrayList <Estudio> titanicList = new ArrayList<>();
        etList.add(estudios[0]);

        Pelicula titanic = new Pelicula("titanic", "1985", 200, "historica", titanicList);

        // Añadir estudios según nos apetezca
        Pelicula senorAnillos = new Pelicula("señor de los anillos", "2011", 290,"ficción");

        senorAnillos.setEstudio(estudios[1]);
        senorAnillos.setEstudio(estudios[0]);

        //Añadimos las películas al ArrayList
        listaPeliculas = new ArrayList<>();
        listaPeliculas.add(et);
        listaPeliculas.add(titanic);
        listaPeliculas.add(senorAnillos);
    }

    public static void buscarPeliculaMasLarga(){
        int masLarga = 0;
        ArrayList <String> estudiosMasLarga = new ArrayList<>();

        for (Pelicula pelicula : listaPeliculas){
            if (pelicula.getDuracion() > masLarga){
                masLarga = pelicula.getDuracion();
                estudiosMasLarga.clear();
                for (Estudio estudio :pelicula.getEstudios()){
                    estudiosMasLarga.add(estudio.getNombre());
                }
            }
        }

        System.out.println("Estudios con la película mas larga: ");
        for (String estudio : estudiosMasLarga){
            System.out.println(estudio);
        }
        System.out.println("Con una duracción de " + masLarga + " minutos");
    }

    public static void estudioConMasPeliculas(){

        Map <String, Integer> estudiosCantidad = new HashMap<>();

        for (Pelicula listaPelicula : listaPeliculas) {
            for (int j = 0; j < listaPelicula.getEstudios().size() && listaPelicula.getEstudios().size() == estudios.length; j++) {
                estudiosCantidad.put(listaPelicula.getEstudios().get(j).getNombre(), 0);
            }
        }

        for (Pelicula pelicula: listaPeliculas){
                for (Estudio nombre : pelicula.getEstudios()){
                        if (estudiosCantidad.containsKey(nombre.getNombre())){
                            int sumar = estudiosCantidad.get(nombre.getNombre()) + 1;
                            estudiosCantidad.put(nombre.getNombre(), sumar);
                        }

                }
        }

        System.out.println(estudiosCantidad);

        String estudioMasPelis = null;
        int cantidad = 0;

        for (Estudio estudio : estudios) {
            if (estudiosCantidad.get(estudio.getNombre()) > cantidad) {
                cantidad = estudiosCantidad.get(estudio.getNombre());
                estudioMasPelis = estudio.getNombre();
            }
        }

        System.out.println("El estudio con más peliculas es: " + estudioMasPelis);

    }
}