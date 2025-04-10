package co.edu.uniquindio.poo.Model;

import java.time.LocalDate;
import java.util.List;

public class Mision {
    private LocalDate fecha;
    private String ubicacion;
    private List<String> listaPersonalAsignado;
    private List<String> listaVehiculosUtilizados;

    public Mision(LocalDate fecha, String ubicacion, List<String> listaPersonalAsignado,
            List<String> listaVehiculosUtilizados) {

        this.listaPersonalAsignado = listaPersonalAsignado;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.listaVehiculosUtilizados = listaVehiculosUtilizados;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<String> getListaPersonalAsignado() {
        return listaPersonalAsignado;
    }

    public void setListaPersonalAsignado(List<String> listaPersonalAsignado) {
        this.listaPersonalAsignado = listaPersonalAsignado;
    }

    public List<String> getListaVehiculosUtilizados() {
        return listaVehiculosUtilizados;
    }

    public void setListaVehiculosUtilizados(List<String> listaVehiculosUtilizados) {
        this.listaVehiculosUtilizados = listaVehiculosUtilizados;
    }

}
