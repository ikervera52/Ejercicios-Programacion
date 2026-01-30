import Modelo.Coche;
import Modelo.Propietario;

import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static ArrayList<Coche> coches;
    public static ArrayList<Propietario> propietarios;
    public static void main(String[] args) {

        crearObjetos();

        //EJERCICIOS
        ejercicioUno();
        ejercicioDos();
        ejercicioTres();
        ejercicioCuatro();
        ejercicioCinco();
        ejercicioSeis();
        ejercicioSiete();
        ejercicioOcho();
        ejercicioNueve();
        ejercicioDiez();
        ejercicioOnce();
        ejercicioDoce();
        ejercicioTrece();
        ejercicioCatorce();
        ejercicioQuince();
        ejercicioDiecises();
        ejercicioDiecisiete();
        ejercicioDieciocho();
        ejercicioDieciNueve();
        ejercicioVente();
        ejercicioVeintiuno();


    }

    public static void crearObjetos(){
        // COCHES
        Coche c1 = new Coche("1234 ABC", "Toyota", 2018, 18000);
        Coche c2 = new Coche("5678 DEF", "BMW", 2015, 25000);
        Coche c3 = new Coche("9012 GHI", "Seat", 2012, 12000);

        Coche c4 = new Coche("3456 JKL", "Toyota", 2020, 22000);
        Coche c5 = new Coche("7890 MNO", "Audi", 2017, 30000);
        Coche c6 = new Coche("1122 PQR", "BMW", 2010, 15000);

        Coche c7 = new Coche("3344 STU", "Seat", 2019, 16000);
        Coche c8 = new Coche("5566 VWX", "Audi", 2014, 20000);
        Coche c9 = new Coche("7788 YZA", "Toyota", 2021, 24000);

        coches = new ArrayList<>();
        coches.add(c1);
        coches.add(c2);
        coches.add(c3);
        coches.add(c4);
        coches.add(c5);
        coches.add(c6);
        coches.add(c7);
        coches.add(c8);
        coches.add(c9);

        Propietario p1 = new Propietario ("Carlos", List.of(c1 , c2 , c3));
        Propietario p2 = new Propietario ("Ana", List.of(c4 , c5 , c6));
        Propietario p3 = new Propietario ("Luis", List.of(c7 , c8 , c9));

        propietarios = new ArrayList<>();
        propietarios.add(p1);
        propietarios.add(p2);
        propietarios.add(p3);

    }

    public static void ejercicioUno(){
        List <String> matriculasCoches = coches.stream()
                .map(Coche::getMatricula)
                .toList();

        System.out.println("Matriculas: " + matriculasCoches);

        ArrayList <String> matriculasCochesV2 = new ArrayList<>();

        for (Coche coche : coches){
            matriculasCochesV2.add(coche.getMatricula());
        }

        System.out.println("Matriculas: " + matriculasCochesV2);
    }

    public static void ejercicioDos(){
        List<String> cochesPorPropietario = propietarios.stream()
                .map(propietario -> propietario.getNombre() + " - " + propietario.getCoches().size())
                .toList();

        System.out.println("Coches: " + cochesPorPropietario);

        ArrayList <String> cochesPorPropietarioV2 = new ArrayList<>();

        for (Propietario propietario : propietarios){
            cochesPorPropietarioV2.add(propietario.getNombre() + " - " + propietario.getCoches().size());
        }

        System.out.println("Coches: " + cochesPorPropietarioV2);
    }

    public static void ejercicioTres(){

        List <Coche> cochesPosteriores2015 = coches.stream()
                .filter(coche -> coche.getAno() > 2015)
                .toList();
        System.out.println("Coches: " + cochesPosteriores2015);

        ArrayList <Coche> cochesPosteriores2015V2 = new ArrayList<>();
        for (Coche coche : cochesPosteriores2015){
            if(coche.getAno() > 2015){
                cochesPosteriores2015V2.add(coche);
            }
        }
        System.out.println("Coches: " + cochesPosteriores2015V2);
    }

    public static void ejercicioCuatro(){
        //V1
        double precioMedioCoches = coches.stream()
                .mapToDouble(Coche::getPrecio)
                .average()
                .orElse(0);

        System.out.println("Precio medio: " + precioMedioCoches);

        //V2
        double suma = 0;
        int contador = 0;

        for (Coche coche : coches){
            suma = suma + coche.getPrecio();
            contador++;
        }

        double precioMedioCochesV2 = suma / contador;
        System.out.println("Precio medio: " + precioMedioCochesV2);
    }

    public static void ejercicioCinco() {

        //V1
        String cocheMasCaro = coches.stream()
                .max(Comparator.comparing(Coche::getPrecio))
                .map(Coche::getMatricula)
                .orElse(" ");

        System.out.println("Precio mas caro: " + cocheMasCaro);


        //V2
        String cocheMasCaroV2 = null;
        int precioMasCaro = 0;

        for (Coche coche : coches){
            if (coche.getPrecio() > precioMasCaro){
                cocheMasCaroV2 = coche.getMatricula();
            }
        }

        System.out.println(cocheMasCaroV2);
    }

    public static void ejercicioSeis(){
        //V1

        boolean marcaBmw = coches.stream()
                .anyMatch(coche -> coche.getMarca().equals("BMW"));
        System.out.println("Coches marca BMW: " + marcaBmw);

        //V2
        boolean marcaBmwV2 = false;
        for(Coche coche : coches){
            if (coche.getMarca().equals("BMW")) {
                marcaBmwV2 = true;
                break;
            }
        }
        System.out.println("Coches marca BMWV2: " + marcaBmwV2);
    }

    public static void ejercicioSiete(){
        coches.stream()
                .sorted(Comparator.comparing(Coche::getPrecio))
                .map(Coche -> Coche.getMatricula() + " -" + Coche.getPrecio())
                .forEach(System.out::println);

        ArrayList<Coche> mayorAMenor = new ArrayList<>(coches);


        for (int x = 0; x < mayorAMenor.size(); x++){
            for (int j = x + 1; j < mayorAMenor.size(); j++){
                if (mayorAMenor.get(x).getPrecio() > mayorAMenor.get(j).getPrecio()){
                    Coche coche = mayorAMenor.get(x);
                    mayorAMenor.set(x, mayorAMenor.get(j));
                    mayorAMenor.set(j, coche);
                }
            }
        }
        for (Coche coche : mayorAMenor){
            System.out.println(coche.getMatricula() + " - " + coche.getPrecio());
        }
    }

    public static void ejercicioOcho(){

        String cocheMasAntiguo = coches.stream()
                .min(Comparator.comparing(Coche::getAno))
                .map(Coche -> Coche.getMatricula() + " - " + Coche.getAno())
                .orElse(" ");

        System.out.println("Coches: " + cocheMasAntiguo);

        int ano = coches.getFirst().getAno();

        for (Coche coche : coches){
            if (coche.getAno() < ano){
                ano = coche.getAno();
            }
        }
        System.out.println("Ano: " + ano);
    }

    public static void ejercicioNueve(){
        //V1

        System.out.println("Coches con valor mayor de 20000€: " + coches.stream()
                .filter(coche -> coche.getPrecio() > 20000)
                .count());

        int contador = 0;
        for (Coche coche : coches){
            if (coche.getPrecio() > 20000){
                contador++;
            }
        }
        System.out.println("Coches con valor mayor a 20000€: " + contador);
    }

    public static void ejercicioDiez(){

        coches.stream()
                .map(Coche :: getMarca)
                .distinct()
                .forEach(System.out::println);

        ArrayList<String> marcas = new ArrayList<>();

        for (Coche coche : coches){
            if (!marcas.contains(coche.getMarca())){
                marcas.add(coche.getMarca());
            }
        }

        System.out.println("Marcas: \n" + marcas);
    }

    public static void ejercicioOnce(){

        Map<String, Double> cochesOnce = coches.stream()
                .collect(Collectors.toMap(Coche::getMatricula, Coche::getPrecio));

        System.out.println("Coches: " + cochesOnce);

        Map <String, Double> cochesOnceV2 = new HashMap<>(cochesOnce);

        for (Coche coche : coches){
            cochesOnceV2.put(coche.getMatricula(), coche.getPrecio());
        }
        System.out.println("Coches: " + cochesOnceV2);
    }

    public static void ejercicioDoce(){

        Map <String, List<Coche>> cochesDoce = coches.stream()
                .collect(Collectors.groupingBy(Coche :: getMarca));

        cochesDoce.forEach((marca, matricula) -> {
            System.out.println( "Marca: " + marca);
            matricula.forEach(c -> System.out.println(c.getMatricula()));
        });

        Map <String, List<Coche>>  cochesDoceV2 = new HashMap<>(cochesDoce);

        for (Coche coche : coches){
            if(!cochesDoceV2.containsKey(coche.getMarca())){
                cochesDoceV2.put(coche.getMarca(), new ArrayList<>());
                cochesDoceV2.get(coche.getMarca()).add(coche);
            } else{
                cochesDoceV2.get(coche.getMarca()).add(coche);
            }
        }

        System.out.println("Coches: " + cochesDoceV2);
    }

    public static void ejercicioTrece(){

        Map <String, List<Coche>> cochesTrece = coches.stream()
                .collect(Collectors.groupingBy(coche -> coche.getAno() > 2015 ? "Antiguos" : "Modernos"));

        System.out.println("Coches: " + cochesTrece);
    }

    public static void ejercicioCatorce(){

        Map <String, Double> cochesCatorce = coches.stream()
                .collect(Collectors.groupingBy(Coche :: getMarca,
                        Collectors.averagingDouble(Coche :: getPrecio)));

        System.out.println("Coches: " + cochesCatorce);
    }

    public static void ejercicioQuince(){
        System.out.println("Quince");
        String cochesQuince = coches.stream()
                .map(Coche :: getMatricula)
                    .reduce("" , (a,b) -> a + " " + b);

        System.out.println("Coches: " + cochesQuince);
    }

    public static void ejercicioDiecises(){
        long contador = coches.stream()
                .filter(Coche -> Coche.getMarca().equalsIgnoreCase("Toyota"))
                .count();
        System.out.println("Coches de la marca Toyota: " + contador);
    }

    public static void ejercicioDiecisiete(){
        coches.stream()
                .map(Coche :: getMarca)
                .sorted()
                .distinct()
                .forEach(System.out::println);
    }

    public static void ejercicioDieciocho(){
        Coche cocheMasBaratoModerno = coches.stream()
                .filter(coche -> coche.getAno() > 2015)
                .min(Comparator.comparing(Coche :: getPrecio))
                .orElse(null);

        if (cocheMasBaratoModerno != null){
            System.out.println(cocheMasBaratoModerno.toString());
        }
    }

    public static void ejercicioDieciNueve(){
        boolean matriculaRep = coches.stream()
                .map(Coche :: getMatricula)
                .distinct()
                . count() != coches.size();

        System.out.println("Matriculas repetidas: " + matriculaRep);
    }

    public static void ejercicioVente(){
        List <String> cochesMasCarosTop3 = coches.stream()
                .sorted(Comparator.comparing(Coche :: getPrecio).reversed())
                .limit(3)
                .map(coche -> coche.getMatricula() + " - " + coche.getPrecio())
                .toList();

        System.out.println("TOP 3:");
        for (String coche : cochesMasCarosTop3) {
            System.out.println(coche);
        }
    }

    public static void ejercicioVeintiuno(){
        System.out.println("a)");

        List <String> cochesDePropietarios = propietarios.stream()
                .flatMap(propietario -> propietario.getCoches().stream())
                .map(Coche :: getMatricula)
                .toList();

        for (String coche : cochesDePropietarios) {
            System.out.println(coche);
        }

        System.out.println("b)");

        long numTotalCoches = propietarios.stream()
                .flatMap(propietario -> propietario.getCoches().stream())
                .count();

        System.out.println("Total coches: " + numTotalCoches);

        System.out.println("c)");

        List <String> matriculas = propietarios.stream()
                .flatMap(propietario -> propietario.getCoches().stream())
                .map(Coche :: getMatricula)
                .toList();

        for (String matricula : matriculas) {
            System.out.println(matricula);
        }

        System.out.println("d)");

        boolean BMW = propietarios.stream()
                .flatMap(propietario -> propietario.getCoches().stream())
                .anyMatch(coche -> coche.getMarca().equalsIgnoreCase("BMW"));

        System.out.println("BMW: " + BMW);

        System.out.println("e)");

        List <Coche> coches2018 = propietarios.stream()
                .flatMap(propietario -> propietario.getCoches().stream())
                .filter(coche -> coche.getAno() > 2018)
                .toList();

        for (Coche coche : coches2018) {
            System.out.println(coche.getMatricula() + " - " + coche.getAno());
        }

        System.out.println("f)");

        double precioMedio = propietarios.stream()
                .flatMap(propietario -> propietario.getCoches().stream())
                .mapToDouble(Coche :: getPrecio)
                .average()
                .orElse(0);

        System.out.println("Precio medio: " + precioMedio);

        System.out.println("g)");

        Coche cocheMasCaro = propietarios.stream()
                .flatMap(propietario -> propietario.getCoches().stream())
                .max(Comparator.comparing(Coche :: getPrecio))
                .orElse(null);

        if (cocheMasCaro != null){
            System.out.println(cocheMasCaro.getMatricula() + " - " + cocheMasCaro.getPrecio());
        }

        System.out.println("h)");

        boolean matriculaRepetida = propietarios.stream()
                .flatMap(propietario -> propietario.getCoches().stream())
                .distinct()
                .count() != propietarios.size();

        System.out.println("Se repiten matriculas: " +  matriculaRepetida);

    }

}