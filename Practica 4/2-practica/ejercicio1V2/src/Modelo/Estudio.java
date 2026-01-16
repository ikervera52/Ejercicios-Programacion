package Modelo;
import java.time.LocalDate;
import java.util.ArrayList;

public class Estudio {
    private String nombre;
    private String ciudad;
    private String direccion;
    private String direccionWeb;
    private LocalDate fechaFundacion;
    private String pais;
    private int telefono;
    private ArrayList<Pelicula> peliculas = new ArrayList();

    public Estudio(String nombre, String ciudad, String direccion, String direccionWeb, LocalDate fechaFundacion, String pais, int telefono) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.direccionWeb = direccionWeb;
        this.fechaFundacion = fechaFundacion;
        this.pais = pais;
        this.telefono = telefono;
    }

    public Estudio(String nombre, String ciudad, String direccion, String direccionWeb, LocalDate fechaFundacion, String pais, int telefono, ArrayList<Pelicula> peliculas) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.direccionWeb = direccionWeb;
        this.fechaFundacion = fechaFundacion;
        this.pais = pais;
        this.telefono = telefono;
        this.peliculas = peliculas;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccionWeb() {
        return this.direccionWeb;
    }

    public void setDireccionWeb(String direccionWeb) {
        this.direccionWeb = direccionWeb;
    }

    public LocalDate getFechaFundacion() {
        return this.fechaFundacion;
    }

    public void setFechaFundacion(LocalDate fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Pelicula> getPeliculas() {
        return this.peliculas;
    }

    public void setPeliculas(ArrayList<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public void setPelicula(Pelicula pelicula) {
        if (this.peliculas.isEmpty()) {
            this.peliculas = new ArrayList();
        }

        this.peliculas.add(pelicula);
    }