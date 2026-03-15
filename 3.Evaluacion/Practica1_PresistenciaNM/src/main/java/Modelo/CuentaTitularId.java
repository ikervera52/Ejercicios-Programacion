package Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CuentaTitularId implements Serializable {
    private static final long serialVersionUID = 8207714154749485350L;
    @Column(name = "idTitular", nullable = false)
    private Integer idTitular;

    @Column(name = "idCuenta", nullable = false)
    private Integer idCuenta;

    public Integer getIdTitular() {
        return idTitular;
    }

    public void setIdTitular(Integer idTitular) {
        this.idTitular = idTitular;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CuentaTitularId entity = (CuentaTitularId) o;
        return Objects.equals(this.idTitular, entity.idTitular) &&
                Objects.equals(this.idCuenta, entity.idCuenta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTitular, idCuenta);
    }
}