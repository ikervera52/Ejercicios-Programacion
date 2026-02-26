package Modelo;

import java.util.ArrayList;

public class Pelicula {
    private String titulo;
    private int ano;
    private int duracion;
    private String tipo;
    private ArrayList<Estudio> estudios;

    public Pelicula(String titulo, int ano, int duracion, String tipo, ArrayList<Estudio> estudios) {
        this.titulo = titulo;
        this.ano = ano;
        this.duracion = duracion;
        this.tipo = tipo;
        this.estudios = estudios;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getDuracion() {
        return this.duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Estudio> getEstudios() {
        return this.estudios;
    }

    public void setEstudios(ArrayList<Estudio> estudios) {
        this.estudios = estudios;
    }
}