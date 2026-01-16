package Modelo;

import java.util.ArrayList;

public class Pelicula {

    private String titulo;
    private String anno;
    private int duracion;
    private String tipo;
    private ArrayList <Estudio> estudios = new ArrayList<>();

    public Pelicula(String titulo, String anno, int duracion, String tipo, ArrayList<Estudio> estudios) {
        this.titulo = titulo;
        this.anno = anno;
        this.duracion = duracion;
        this.tipo = tipo;
        this.estudios =  estudios;
    }

    public Pelicula(String titulo, String anno, int duracion, String tipo) {
        this.titulo = titulo;
        this.anno = anno;
        this.duracion = duracion;
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Estudio> getEstudios() {
        return estudios;
    }

    public void setEstudios(ArrayList<Estudio> estudios) {
        this.estudios = estudios;
    }

    public void setEstudio(Estudio e){
        if(this.estudios == null){
            this.estudios = new ArrayList<>();
        }

        estudios.add(e);
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", anno='" + anno + '\'' +
                ", duracion=" + duracion +
                ", tipo='" + tipo + '\'' +
                ", estudios=" + estudios +
                '}';
    }
}
