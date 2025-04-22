package co.edu.uniquindio.poo.Model;

public class Nota {
    private String nombreNota;
    private double valor;

    public Nota(String nombreNota, double valor){
        this.nombreNota = nombreNota;
        this.valor = valor;
        
    }

    public String getNombreNota() {
        return nombreNota;
    }

    public void setNombreNota(String nombre) {
        this.nombreNota = nombre;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String actualizarNota (double nuevoValor){
        setValor(nuevoValor);
        return "Nota actualizada";
        
    }

}
