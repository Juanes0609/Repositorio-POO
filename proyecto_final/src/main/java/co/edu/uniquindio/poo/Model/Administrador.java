package co.edu.uniquindio.poo.Model;

public class Administrador extends Empleado {
    public Administrador(String nombre, String identificacion, String direccion, String telefono, String email,
            String idEmpleado, double salario, String pin) {
        super(nombre, identificacion, direccion, telefono, email, salario, pin);
    }

    @Override
    public String obtenerDetalles() {
        return "Administrador: " + getNombre() + ", ID Empleado: " + getIdEmpleado() + ", Identificación: "
                + getIdentificacion();
    }
}
