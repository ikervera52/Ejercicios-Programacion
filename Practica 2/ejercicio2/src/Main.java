import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    final static Scanner sc = new Scanner(System.in);
    public static ArrayList<ArrayList<Double>> notasAlumnos = new ArrayList<>();
    public static String[] asignaturas = {"Base de Datos", "Programación", "Entornos de Desarrollo", "Ingles"};
    public static ArrayList<String> nombreAlumnos = new ArrayList<>();
    public static void main(String[] args) {

        guardarDatosAlumnos();
        mediaPorAlumno();

    }
    public static void guardarDatosAlumnos(){
        boolean continuar = true;
        int numeroAlumno = 0;
        double notaProg = 0;
        int contadorNombreAlumno = 0;
        do {
            try{
                System.out.println("-- Guardando notas del alumno " + (numeroAlumno + 1) + " -- ");
                pedirNombreAlumno();
                for (int i = 0; i < asignaturas.length; i++) {
                    try{
                        System.out.print(nombreAlumnos.get(contadorNombreAlumno) + " esta matriculado en " + asignaturas[i] + " (si/no)? ");
                        String respuesta = sc.nextLine().toLowerCase();
                        if (respuesta.equals("si")) {

                            double nota = pedirNota(numeroAlumno, i);

                            if(i == 1){
                                notaProg += nota;
                            }
                        }else if (!respuesta.equals("no")) {
                            throw new Error();
                        }
                    }
                    catch (Error e){
                        System.out.println("** Opción no valida **");
                        i -= 1;
                    }

                }
                contadorNombreAlumno++;
                numeroAlumno++;
                continuar = anadirMasAlumnos();
            }
            catch (Error e){
                System.out.println("** Nombre de alumno no valido **");
                notasAlumnos.remove(numeroAlumno);
            }
        }while(continuar);

        System.out.println("\nLa nota media en Programación es: " + notaProg/numeroAlumno);
    }

    public static void pedirNombreAlumno() throws Error{
        notasAlumnos.add(new ArrayList<>());
        Pattern patron = Pattern.compile("^[A-Za-z]+$");
        System.out.print("Nombre del alumno: ");
        String nombreAlumno = sc.nextLine();
         Matcher mat = patron.matcher(nombreAlumno);
        if (!mat.matches()) {
            throw new Error();
        } else{
            nombreAlumnos.add(nombreAlumno);
        }
    }

    public static double pedirNota(int numeroAlumno, int i){
        boolean error = true;
        double nota = 0;
        do {
            try {
                System.out.print("Que nota tiene en " + asignaturas[i] + ": ");
                 nota = sc.nextInt();
                sc.nextLine();
                if (nota > 10 || nota < 0) {
                    throw new Error();
                }
                notasAlumnos.get(numeroAlumno).add(nota);
                error = false;
            }
            catch (Error e){
                System.out.println("** Nota no valida **");
            }

        } while (error);
        return nota;
    }

    public static boolean anadirMasAlumnos(){
        boolean error = true;
        boolean continuar = false;
        do {
            try {
                System.out.print("Quieres añadir mas alumnos (si/no): ");
                String respuesta = sc.nextLine().toLowerCase();
                if (respuesta.equals("si")) {
                    error = false;
                    continuar = true;
                }
                else if (respuesta.equals("no")) {
                    error = false;
                }
                else{
                    throw new Error();
                }
            }catch (Error e){
                System.out.println("Error");
            }

        }while(error);
        return continuar;
    }

    public static void mediaPorAlumno(){
        double sumaNotas = 0;
        for(int i = 0; i < notasAlumnos.size(); i++){
            for(int j = 0; j < notasAlumnos.get(i).size(); j++){
                sumaNotas += notasAlumnos.get(i).get(j);
            }
            System.out.println("La media de " + nombreAlumnos.get(i) + " es: " + sumaNotas/notasAlumnos.get(i).size());
            sumaNotas = 0;
        }
    }
}