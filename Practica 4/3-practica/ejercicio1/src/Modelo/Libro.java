package Modelo;

public class Libro {

    private String titulo;
    private String editorial;
    private int numPaginas;
    private int numEjemplares;
    private Autor autor;

    public Libro() {
    }

    public Libro(String titulo, String editorial, int numPaginas, Autor autor) {
        this.titulo = titulo;
        this.editorial = editorial;
        this.numPaginas = numPaginas;
        this.numEjemplares = 3;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public int getNumEjemplares() {
        return numEjemplares;
    }

    public void setNumEjemplares(int numEjemplares) {
        this.numEjemplares = numEjemplares;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void modificar(int opcion){
        if(opcion == 1){
            this.numEjemplares--;
        } else if(opcion == 2){
            this.numEjemplares++;
        }
    }
}
