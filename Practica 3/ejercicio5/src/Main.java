import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static Scanner sc;
    public static double[] gastadoPorMes;
    public static void main(String[] args) {

        try{
            inicializarFunciones();
            guardarGasto();
            String [] mesesOrdenados = ordenarGastos();
            imprimirDatos(mesesOrdenados);
        }
        catch (Exception e){
            System.out.println("Error: " + e.getClass());
        }
    }
    public static void inicializarFunciones(){
        sc = new Scanner(System.in);
        gastadoPorMes = new double[12];
    }
    public static void guardarGasto() {
        boolean continuar = true;
        System.out.println("-- Guardar gasto --");
        do {
            try {
                Pattern patron = Pattern.compile("^([0-9]|[0-2][0-9]|3[0-1])");
                System.out.print("Dia del gasto: ");
                Matcher m = patron.matcher(sc.nextLine());
                if (!m.matches()){
                    throw new Error();
                }

                System.out.print("Mes del gasto: ");
                Meses mes = Meses.valueOf(sc.nextLine().toUpperCase());

                System.out.print("Cuanto has gastado: ");
                double gasto = sc.nextDouble();
                sc.nextLine();
                if (gasto < 0){
                    throw new Error();
                }

                switch (mes){
                    case ENERO -> gastadoPorMes [0] += gasto;
                    case FEBRERO -> gastadoPorMes [1] += gasto;
                    case MARZO -> gastadoPorMes [2] += gasto;
                    case ABRIL -> gastadoPorMes [3] += gasto;
                    case MAYO -> gastadoPorMes [4] += gasto;
                    case JUNIO -> gastadoPorMes [5] += gasto;
                    case JULIO -> gastadoPorMes [6] += gasto;
                    case AGOSTO -> gastadoPorMes [7] += gasto;
                    case SEPTIEMBRE -> gastadoPorMes [8] += gasto;
                    case OCTUBRE -> gastadoPorMes [9] += gasto;
                    case NOVIEMBRE -> gastadoPorMes [10] += gasto;
                    case DICIEMBRE -> gastadoPorMes [11] += gasto;
                }
                continuar = preguntarMas();
            }
            catch (Error e){
                System.out.println("** Error **");
            }
            catch (IllegalArgumentException e){
                System.out.println("** Mes no valido **");
            }
        }while (continuar);
    }
    public static boolean preguntarMas(){
        boolean continuar = false;
        boolean error = true;
        do {
            try {
                System.out.print("Quieres añadir mas pagos (si/no): ");
                String respuesta = sc.nextLine();
                if (respuesta.equals("no")){
                    error = false;
                } else if (respuesta.equals("si")){
                    continuar = true;
                    error = false;
                } else throw new Error();
            }
            catch (Error e){
                System.out.println("** Opción no valida **");
            }
        } while (error);
        return continuar;


    }
    public static String[] ordenarGastos(){
        String [] meses = new String[]{"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre",
                            "octubre", "noviembre", "diciembre"};

        for (int i = 0; i < gastadoPorMes.length; i++){
            for (int j = 0; j < gastadoPorMes.length; j++){

                if (gastadoPorMes[i] < gastadoPorMes[j]){

                    double gastoMenor = gastadoPorMes[i];
                    gastadoPorMes[i] = gastadoPorMes[j];
                    gastadoPorMes[j] = gastoMenor;

                    String mesMenor = meses [i];
                    meses[i] = meses [j];
                    meses [j] = mesMenor;
                }
            }
        }

        return meses;
    }
    public static void imprimirDatos(String[] mesesOrdenados){
        System.out.println("\n");
        for (int x = 0; x < gastadoPorMes.length; x++){
            if (gastadoPorMes[x] != 0){
                System.out.println(mesesOrdenados[x] + ": " + gastadoPorMes[x] + "€");
            }
        }
    }
}