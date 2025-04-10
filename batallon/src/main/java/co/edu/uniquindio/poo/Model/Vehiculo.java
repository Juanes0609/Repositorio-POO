package co.edu.uniquindio.poo.Model;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehiculo {
    private String id;
    private String modelo;
    private int añoFabricacion;
    private float kilometraje;
    private ArrayList<Vehiculo> listaVehiculos;
    private ArrayList<Vehiculo> listaMisiones;
    private String estadoOperativo;
    private int numeroMisiones;

    public Vehiculo(String id, String modelo, int añoFabricacion, float kilometraje, String estadoOperativo, int numeroMisiones) {
        this.id = id;
        this.modelo = modelo;
        this.añoFabricacion = añoFabricacion;
        this.kilometraje = kilometraje;
        this.estadoOperativo = estadoOperativo;
        this.numeroMisiones = numeroMisiones;
        this.listaVehiculos = new ArrayList<>();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAñoFabricacion() {
        return añoFabricacion;
    }

    public void setAñoFabricacion(int añoFabricacion) {
        this.añoFabricacion = añoFabricacion;
    }

    public float getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(float kilometraje) {
        this.kilometraje = kilometraje;
    }

    public List<Vehiculo> getListaMisiones() {
        return listaMisiones;
    }

    public void setListaMisiones(ArrayList<Vehiculo> listaMisiones) {
        this.listaMisiones = listaMisiones;
    }

    public String getEstadoOperativo() {
        return estadoOperativo;
    }

    public void setEstadoOperativo(String estadoOperativo) {
        this.estadoOperativo = estadoOperativo;
    }

    public ArrayList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public int getNumeroMisiones() {
        return numeroMisiones;
    }

    public void setNumeroMisiones(int numeroMisiones) {
        this.numeroMisiones = numeroMisiones;
    }

    
    
}
