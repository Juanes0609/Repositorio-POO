package co.edu.uniquindio.poo.Model;

public abstract class Empleado extends Persona {
    private String idEmpleado;
    private double salario;
    private String contraseña;

    public Empleado(String nombre, String identificacion, String direccion, String telefono, String idEmpleado,
            double salario, String contrasena) {
        super(nombre, identificacion, direccion, telefono);
        this.idEmpleado = idEmpleado;
        this.salario = salario;
        this.contraseña = contraseña;

    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getContrasena() {
        return contraseña;
    }

    public void setContrasena(String contrasena) {
        this.contraseña = contrasena;
    }

    public String obtenerDetalles() {
        return "Empleado: " + getNombre() + ", ID: " + getIdEmpleado() + ", Identificación: " + getIdentificacion();
    }
}
