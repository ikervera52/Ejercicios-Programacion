package Modulo;

public class Alumno {

    private String codigo;
    private String nombre;
    private String telefono;


    public Alumno() {
    }

    public Alumno(String codigo, String nombre, String telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return
                "Código de alumno: " + codigo +"\n" +
                "Nombre: " + nombre + '\n' +
                "Teléfono: " + telefono + '\n';
    }
}
