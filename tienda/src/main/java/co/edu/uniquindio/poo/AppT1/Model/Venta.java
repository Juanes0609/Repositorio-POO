package co.edu.uniquindio.poo.AppT1.Model;

import java.util.Date;

public class Venta {
    private Date fecha;
    private int total;
    int cantidadComprada = 0;
    private String identificacionCliente;

    public Venta(Date fecha, int total, String identificacionCliente) {
        this.fecha = fecha;
        this.total = total;
        this.identificacionCliente = identificacionCliente;

    }

    public Date getFecha() {
        return fecha;

    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;

    }

    public int getTotal() {
        return total;

    }

    public void setTota(int total) {
        this.total = total;

    }

    public String getIdentificacionCliente(){
        return identificacionCliente;

    }

    public void setIdentificacionCliente(String identificacionCliente){
        this.identificacionCliente = identificacionCliente;

    }
}
