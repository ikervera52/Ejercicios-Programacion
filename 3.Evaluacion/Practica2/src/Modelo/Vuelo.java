package Modelo;

import java.time.LocalDate;

public class Vuelo {

    private String codVuelo;
    private LocalDate fecha;
    private String destino;
    private String procedencia;

    public Vuelo(String codVuelo, LocalDate fecha, String destino, String procedencia) {
        this.codVuelo = codVuelo;
        this.fecha = fecha;
        this.destino = destino;
        this.procedencia = procedencia;
    }

    public String getCodVuelo() {
        return codVuelo;
    }

    public void setCodVuelo(String codVuelo) {
        this.codVuelo = codVuelo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    @Override
    public String toString() {
        return
                "Código de Vuelo: " + codVuelo +
                " Fecha: " + fecha +
                " Procedencia: " + procedencia +
                " Destino: " + destino + '\n';
    }
}
