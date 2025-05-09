package co.edu.uniquindio.poo.Model;

public class Cliente {
    private String cedulaCliente;
    private String nombre;
    private String correo;
    private String direccion;

    public Cliente(String cedulaCliente, String nombre, String correo, String direccion) {
        this.cedulaCliente = cedulaCliente;
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;

    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
