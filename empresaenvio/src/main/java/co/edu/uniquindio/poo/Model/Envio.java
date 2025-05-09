package co.edu.uniquindio.poo.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Envio {
    private String codigoEnvio; // Cambié 'codigo' a 'codigoEnvio' para consistencia
    private ZonaEntrega zonaEntrega;
    private LocalDate fechaEnvio; // Cambié 'fecha' a 'fechaEnvio' para consistencia
    private Cliente cliente;
    private Vehiculo vehiculo;
    private Ruta ruta;
    private List<Paquete> paquetes = new ArrayList<>();

    public Envio(String codigoEnvio, ZonaEntrega zonaEntrega, LocalDate fechaEnvio, Cliente cliente, Vehiculo vehiculo,
            Ruta ruta) {
        this.codigoEnvio = codigoEnvio;
        this.zonaEntrega = zonaEntrega;
        this.fechaEnvio = fechaEnvio;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.ruta = ruta;
        this.paquetes = new ArrayList<>();
    }

    public String getCodigoEnvio() {
        return codigoEnvio;
    }

    public void setCodigoEnvio(String codigoEnvio) {
        this.codigoEnvio = codigoEnvio;
    }

    public ZonaEntrega getZonaEntrega() {
        return zonaEntrega;
    }

    public void setZonaEntrega(ZonaEntrega zonaEntrega) {
        this.zonaEntrega = zonaEntrega;
    }

    public LocalDate getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDate fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(List<Paquete> paquetes) {
        this.paquetes = paquetes;
    }

    public void agregarPaquete(String codigo, double peso) {
        Paquete paquete = new Paquete(codigo, peso);
        this.paquetes.add(paquete);
    }

    public double calcularCostoEnvio() {
        double costoTotal = 0;

        if (vehiculo instanceof Camion) {
            costoTotal = calcularCostoCamion();
        } else if (vehiculo instanceof Furgoneta) {
            costoTotal = calcularCostoFurgoneta();
        } else if (vehiculo instanceof Motocicleta) {
            costoTotal = calcularCostoMotocicleta();
        }

        return costoTotal;
    }

    private double calcularCostoCamion() {
        double costoPeajes = ruta.getNumeroPeajes() * 12000;
        double costoPeso = paquetes.stream().mapToDouble(Paquete::getPeso).sum() * 7000;
        return costoPeajes + costoPeso;
    }

    private double calcularCostoFurgoneta() {
        double distancia = ruta.getDistancia(); 
        double costoCombustible = distancia * 3000;
        return costoCombustible + 10000;
    }

    private double calcularCostoMotocicleta() {
        int factorZona = (zonaEntrega == ZonaEntrega.RURAL) ? 15000 : 8000;
        return factorZona * paquetes.size();
    }
}
