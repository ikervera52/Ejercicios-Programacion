

import Modelo.Estudio;
import Modelo.Pelicula;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    private static Estudio[] estudios;
    private static ArrayList<Pelicula> peliculas;

    public static void main(String[] args) {
        crearEstudios();
        crearPeliculas();
        relacionarEstudiosConPeliculas();
        resultados();
        estudioMasPeliculas();
    }

    public static void crearEstudios() {
        Estudio universal = new Estudio("Universal", "Albacete", "Calle Castilla", "universal.com", LocalDate.of(1985, 5, 3), "España", 687348384);
        Estudio century = new Estudio("Century", "Granada", "Calle Dos", "century.com", LocalDate.of(1993, 9, 10), "España", 694839273);
        Estudio warner = new Estudio("Warner", "Paris", "Calle Paris", "warmer.com", LocalDate.of(1975, 8, 12), "Francia", 857392043);
        estudios = new Estudio[3];
        estudios[0] = universal;
        estudios[1] = century;
        estudios[2] = warner;
    }

    public static void crearPeliculas() {
        ArrayList<Estudio> estudiosEt = new ArrayList<>();
        estudiosEt.add(estudios[0]);
        estudiosEt.add(estudios[1]);
        Pelicula et = new Pelicula("ET", 2002, 90, "Comedia", estudiosEt);
        ArrayList<Estudio> estudiosTitanic = new ArrayList<>();
        estudiosTitanic.add(estudios[1]);
        estudiosTitanic.add(estudios[2]);
        Pelicula titanic = new Pelicula("Titanic", 1998, 180, "Romance", estudiosTitanic);
        ArrayList<Estudio> estudiosElReyLeon = new ArrayList<>();
        estudiosElReyLeon.add(estudios[2]);
        estudiosElReyLeon.add(estudios[1]);
        Pelicula elReyLeon = new Pelicula("El Rey Leon", 2005, 97, "Comedia", estudiosElReyLeon);
        peliculas = new ArrayList<>();
        peliculas.add(titanic);
        peliculas.add(elReyLeon);
        peliculas.add(et);
    }

    public static void relacionarEstudiosConPeliculas() {
        estudios[0].setPelicula(peliculas.get(0));
        estudios[0].setPelicula(peliculas.get(2));
        estudios[1].setPelicula(peliculas.get(0));
        estudios[1].setPelicula(peliculas.get(1));
        estudios[2].setPelicula(peliculas.get(0));
    }

    public static void resultados() {
        int mayorDuracion = 0;
        int posicionMayorDuracion = 0;

        for(int i = 0; i < peliculas.size(); ++i) {
            if (peliculas.get(i).getDuracion() > mayorDuracion) {
                mayorDuracion = peliculas.get(i).getDuracion();
                posicionMayorDuracion = i;
            }
        }

        StringBuilder estudiosDePelicula = new StringBuilder();

        for(int i = 0; i < peliculas.get(posicionMayorDuracion).getEstudios().size(); ++i) {
            estudiosDePelicula.append(" ").append(peliculas.get(posicionMayorDuracion).getEstudios().get(i).getNombre());
        }

        PrintStream var10000 = System.out;
        String var10001 = peliculas.get(posicionMayorDuracion).getTitulo();
        var10000.println("\nLa pelicula con mayor duracion es " + var10001 + " y es de" + estudiosDePelicula + "\n");
    }

    public static void estudioMasPeliculas() {
        String nombreEstudio = null;
        int contadorPeliculas = 0;
        ArrayList<String> nombresPeliculas = new ArrayList<>();

        for(Estudio estudio : estudios) {
            if (estudio.getPeliculas().size() >= contadorPeliculas) {
                nombreEstudio = estudio.getNombre();
                contadorPeliculas = estudio.getPeliculas().size();
                nombresPeliculas.clear();

                for(Pelicula pelicula : estudio.getPeliculas()) {
                    nombresPeliculas.add(pelicula.getTitulo());
                }
            }
        }

        System.out.println("El estudio con más peliculas es " + nombreEstudio + " habiendo producido " + contadorPeliculas + " peliculas.\nLas peliculas son: ");

        for(String pelicula : nombresPeliculas) {
            System.out.println(pelicula);
        }

    }
}