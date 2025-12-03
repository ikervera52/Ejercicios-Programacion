import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    final static Scanner sc = new Scanner(System.in);

    public static int[][] clases;
    public static void main(String[] args) {

        int alumnos = pedirCantidadAlumnos();
        int notas = pedirAsignaturas();
        clases = new int[alumnos][notas];
        pedirNotas();
        calcularMediaAlumno();
        calcularMediaAsignatura(alumnos, notas);
        notasAltaBaja();
    }

    public static int pedirCantidadAlumnos(){
        boolean error = true;
        int cantidad = 0;
        do {
            try {
                Pattern patron = Pattern.compile("^[0-9]+$");
                System.out.println("Cuantos alumnos hay:");
                String cantidadString = sc.nextLine();
                Matcher m = patron.matcher(cantidadString);
                if (!m.matches()) {
                    throw new Error();
                }
                cantidad = Integer.parseInt(cantidadString);
                error = false;
            }
            catch (Error e) {
                System.out.println("Dato de cantidad de alumnos incorrecto");
            }

        } while (error);
        return cantidad;
    }
    public static int pedirAsignaturas(){
        boolean error = true;
        int cantidad = 0;
        do {
            try {
                Pattern patron = Pattern.compile("^[0-9]+$");
                System.out.println("Cuantos asignaturas hay:");
                String cantidadString = sc.nextLine();
                Matcher m = patron.matcher(cantidadString);
                if (!m.matches()) {
                    throw new Error();
                }
                cantidad = Integer.parseInt(cantidadString) + 1;
                error = false;
            }
            catch (Error e) {
                System.out.println("Dato de asignaturas incorrecto");
            }

        } while (error);
        return cantidad;
    }

    public static void pedirNotas(){
        boolean error = true;
        do {
            try {
                Pattern patron = Pattern.compile("^(1|2|3|4|5|6|7|8|9|10)$");
                for ( int x = 0; x < clases.length; x++ ) {
                    for (int y = 0; y < clases[x].length - 1; y++ ) {
                        System.out.print("Nota del alumno Nº" + (x+1) + " en la asignatura " + (y + 1) + ": ");
                        String posicionString = sc.nextLine();
                        Matcher m = patron.matcher(posicionString);
                        if (!m.matches()) {
                            throw new Error();
                        }
                        int posicion = Integer.parseInt(posicionString);
                        clases[x][y] = posicion;
                    }
                }
                error = false;
            }
            catch (Error e){
                System.out.println("Nota no valida, introdúcelas desde el principio");
            }

        } while (error);
    }

    public static void calcularMediaAlumno(){

        System.out.println("----------------------------------");

        for (int x = 0; x < clases.length; x++ ) {
            int suma = 0;
            int cantidad = 0;
            for (int y = 0; y < clases.length; y++) {
                suma += clases[x][y];
                cantidad++;
            }
            System.out.println("La media es del alumno Nº" + (x + 1) + " es " + suma/cantidad);
        }
    }
    public static void calcularMediaAsignatura(int alumnos, int notas){

        System.out.println("----------------------------------");
        for (int x = 0; x < notas - 1; x++ ) {
            int suma = 0;
            int cantidad = 0;
            for (int y = 0; y < alumnos; y++) {
                suma += clases[y][x];
                cantidad++;
            }
            System.out.println("La media la asignatura Nº" + (x + 1) + " es " + suma/cantidad);
        }
    }

    public static void notasAltaBaja(){
        System.out.println("----------------------------------");
        int notaMasAlta = 0;
        int notaMasBaja = 10;
        for (int[] clase : clases) {
            for (int y = 0; y < clases.length; y++) {
                if (clase[y] > notaMasAlta) {
                    notaMasAlta = clase[y];
                }
                if (clase[y] < notaMasBaja) {
                    notaMasBaja = clase[y];
                }
            }
        }
        System.out.println("La nota mas alta es: " + notaMasAlta);
        System.out.println("La nota mas baja es: " + notaMasBaja);
    }
}