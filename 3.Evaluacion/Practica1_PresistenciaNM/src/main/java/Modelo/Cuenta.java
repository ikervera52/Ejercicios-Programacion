package Modelo;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cuentas")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "iban", nullable = false, length = 24)
    private String iban;

    @Column(name = "saldo", nullable = false)
    private Integer saldo;

    @ManyToMany (cascade = { CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable (name = "cuentaTitular",
            joinColumns = @JoinColumn (name = "idCuenta"),
            inverseJoinColumns = @JoinColumn (name = "idTitular"))
    private Set<Titular> titulares = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public Set<Titular> getTitulares() {
        return titulares;
    }

    public void setTitulares(Set<Titular> titulares) {
        this.titulares = titulares;
    }

    public Cuenta() {

    }

    public Cuenta(String iban, Integer saldo) {
        this.iban = iban;
        this.saldo = saldo;
        this.titulares = new LinkedHashSet<>(titulares);
    }

    public void setTitular(Titular titular){
        this.titulares.add(titular);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Titular titular : titulares) {
            sb.append(titular.toString());
        }

        if (titulares.isEmpty()) {
            sb.append("No hay titulares asociados");
        }
        return "ID: " + id + "\n" +
                "IBAN: " + iban + '\n' +
                "Saldo: " + saldo + "\n" +
                "Titulares:\n "  + sb.toString() + "\n";
    }
}