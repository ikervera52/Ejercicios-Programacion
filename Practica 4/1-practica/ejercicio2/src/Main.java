import Modulo.Alumno;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static Scanner sc;
    private static ArrayList<Alumno> agenda;

    public static void main(String[] args) {

        try {
            sc = new Scanner (System.in);
            agenda = new ArrayList<>();

            opciones();
        }
        catch (Exception e){
            System.out.println("Error" + e.getClass());
        }

    }

    public static void opciones(){
        boolean salir = false;
        do {
            try {
                System.out.print("""
                -- Menú de opciones --
                a) Guardar datos de alumno
                b) Ver datos de alumno
                c) Salir
                Que quieres hacer:\s""");
                switch (sc.nextLine().toLowerCase()){
                    case "a" -> guardarDatos();
                    case "b" -> verDatos();
                    case "c" -> salir = true;
                    default -> throw new Error();
                }
            }
            catch (Error e){
                System.out.println("\n* Opción no valida *\n");
            }

        }while (!salir);
        System.out.println("--> Fin del programa");
    }

    public static void guardarDatos(){

        boolean error = true;
        do {
            try {
                Pattern patronCodigo = Pattern.compile("^[0-9]{3}$");
                System.out.print("\nCódigo de alumno: ");
                String codigo = sc.nextLine();
                Matcher mCodigo = patronCodigo.matcher(codigo);
                if (!mCodigo.matches()) throw new Error();

                Pattern patronNombre = Pattern.compile("^[A-Za-z]+$");
                System.out.print("Nombre del alumno: ");
                String nombre = sc.nextLine();
                Matcher mNombre = patronNombre.matcher(nombre);
                if (!mNombre.matches()) throw new Error();

                Pattern patronTelefono = Pattern.compile("^[0-9]{9}$");
                System.out.print("teléfono del alumno: ");
                String telefono = sc.nextLine();
                Matcher mTel = patronTelefono.matcher(telefono);
                if (!mTel.matches()) throw new Error();


                agenda.add( new Alumno(codigo, nombre, telefono));

                System.out.println("\n--> Alumno guardado correctamente\n");
                error = false;
            }
            catch (Error e){
                System.out.println("\n * Campo mal introducido, vuelve a intentarlo *\n");
            }

        }while (error);
    }

    public static void verDatos(){
        try{
            boolean noExiste = true;
            System.out.print("\nCódigo del estudiante: ");
            String codigo = sc.nextLine();
            for (Alumno alumno : agenda){
                if (alumno.getCodigo().equals(codigo)){
                    System.out.println("\n" + alumno + "\n");
                    noExiste = false;
                }
            }
            if (noExiste) throw new Error();
        }
        catch (Error e){
            System.out.println("\n* No existe ningún estudiante con ese código *\n");
        }
    }
}