package co.edu.uniquindio.poo.Model;

import java.util.List;

public class Motocicleta extends Vehiculo {
    private int cilindraje;

    public Motocicleta(String placa, String marca, String modelo, int cilindraje) {
        super(placa, marca, modelo);
        this.cilindraje = cilindraje;
    }

    @Override
    public double calcularCostoEnvio(List<Paquete> listaPaquetes, Ruta ruta, ZonaEntrega zonaEntrega) {
        double costoBasePorPaquete;
        if (zonaEntrega == ZonaEntrega.RURAL) {
            costoBasePorPaquete = 15000;
        } else {
            costoBasePorPaquete = 8000;
        }
        int numeroPaquetes = listaPaquetes.size();

        double costoTotal = costoBasePorPaquete * numeroPaquetes;

        return costoTotal;

    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }
}