package co.edu.uniquindio.poo.Model;

import java.util.List;

public class Furgoneta extends Vehiculo {
    private Transmision transmision;

    public Furgoneta(String placa, String marca, String modelo, Transmision transmision){
        super(placa, marca, modelo);
        this.transmision = transmision;

    }
    @Override
    public double calcularCostoEnvio(List<Paquete> listaPaquetes, Ruta ruta, ZonaEntrega zonaEntrega){
        return (ruta.getDistancia()* 3000 ) + 10000;

    }

    public Transmision getTransmision() {
        return transmision;
    }

    public void setTransmision(Transmision transmision) {
        this.transmision = transmision;
    }

    
    
}
