package co.edu.uniquindio.poo.Model;

import java.util.List;

public class Camion extends Vehiculo {
    private int capacidadCarga;

    public Camion(String placa, String marca, String modelo, int capacidadCarga) {
        super(placa, marca, modelo);
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public double calcularCostoEnvio(List<Paquete> listaPaquetes, Ruta ruta, ZonaEntrega zonaEntrega) {
        double costoPeajes = ruta.getNumeroPeajes() * 12000;
        double costoPeso = 0;
        for (Paquete paquete : listaPaquetes) {
            costoPeso += paquete.getPeso() * 7000;

        }
        return costoPeso + costoPeajes;
    }

    public int getCapacidadCarga(){
        return capacidadCarga;
    }

    public void setCapacidadCarga(int capacidadCarga){
        this.capacidadCarga = capacidadCarga;
    }
}
