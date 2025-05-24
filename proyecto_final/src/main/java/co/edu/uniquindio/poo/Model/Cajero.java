package co.edu.uniquindio.poo.Model;

public class Cajero extends Empleado {
    public Cajero(String nombre, String identificacion, String direccion, String telefono, String email, String idEmpleado, double salario, String pin) {
        super(nombre, identificacion, direccion, telefono, email, salario, pin);
    }

    @Override
    public String obtenerDetalles() {
        return "Cajero: " + getNombre() + ", ID Empleado: " + getIdEmpleado() + ", Identificación: " + getIdentificacion();
    }
}