package Modelo;

public class Circunferencia {

    private double radio;
    final private double PI = Math.PI;

    public Circunferencia(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double calcularLongitud(){
        return 2 * PI * getRadio();
    }

    public double calcularArea(){
        return PI * getRadio() * getRadio();
    }

    public double calcularVolumen(){
        return 4 * PI * getRadio() * getRadio() * getRadio() / 3;
    }
}
