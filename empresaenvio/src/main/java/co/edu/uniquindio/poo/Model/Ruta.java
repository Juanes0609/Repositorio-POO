package co.edu.uniquindio.poo.Model;

public class Ruta {
    private int numeroPeajes;
    private double distancia;

    public Ruta(int numeroPeajes, double distancia) {
        this.numeroPeajes = numeroPeajes;
        this.distancia = distancia;

    }

    public int getNumeroPeajes() {
        return numeroPeajes;
    }

    public void setNumeroPeajes(int numeroPeajes) {
        this.numeroPeajes = numeroPeajes;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

}
