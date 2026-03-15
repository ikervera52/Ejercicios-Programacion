package Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "cuentaTitular")
public class CuentaTitular {
    @EmbeddedId
    private CuentaTitularId id;

    @MapsId("idTitular")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idTitular", nullable = false)
    private Titular idTitular;

    @MapsId("idCuenta")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idCuenta", nullable = false)
    private Cuenta idCuenta;

    public CuentaTitularId getId() {
        return id;
    }

    public void setId(CuentaTitularId id) {
        this.id = id;
    }

    public Titular getIdTitular() {
        return idTitular;
    }

    public void setIdTitular(Titular idTitular) {
        this.idTitular = idTitular;
    }

    public Cuenta getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Cuenta idCuenta) {
        this.idCuenta = idCuenta;
    }

}