package Modelo;

public class Cuenta {

    private String iban;
    private int saldo;
    private int id;


    public Cuenta(int id){
        this.id=id;
    }

    public Cuenta(String iban, int saldo) {
        this.iban = iban;
        this.saldo = saldo;
    }

    public Cuenta( int id, String iban, int saldo) {
        this.id = id;
        this.iban = iban;
        this.saldo = saldo;
    }

    public String getIban() {
        return iban;
    }
    public void setIban(String iban) {
        this.iban = iban;
    }
    public int getSaldo() {
        return saldo;
    }
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "IBAN: " + iban + "\n" +
                "Saldo: " + saldo + "\n";
    }
}
