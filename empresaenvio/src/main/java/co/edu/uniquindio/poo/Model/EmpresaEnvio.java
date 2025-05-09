package co.edu.uniquindio.poo.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmpresaEnvio {
    private String nombre;
    private String nit;
    private String direccion;
    private List<Envio> envios;
    private List<Cliente> clientes;
    private List<Vehiculo> vehiculos;

    public EmpresaEnvio(String nombre, String nit, String direccion) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.envios = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.vehiculos = new ArrayList<>();

    }

    public List<Envio> getEnvios() {
        return envios;
    }

    public void setEnvios(List<Envio> envios) {
        this.envios = envios;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

     public Optional<Envio> buscarEnvio(String codigo) {
        return envios.stream()
                .filter(envio -> envio.getCodigoEnvio().equals(codigo))
                .findFirst();
    }

    public boolean existeEnvio(String codigo) {
        return buscarEnvio(codigo).isPresent();
    }

    public Envio agregarEnvio(String codigo, Cliente cliente, Vehiculo vehiculo, Ruta ruta, ZonaEntrega zonaEntrega, LocalDate fechaEnvio) {
        if (existeEnvio(codigo)) {
            System.out.println("Error: Ya existe un envío con el código " + codigo);
            return null; // O lanzar una excepción
        }

        Envio nuevoEnvio = new Envio(codigo, zonaEntrega, fechaEnvio, cliente, vehiculo, ruta);
        envios.add(nuevoEnvio);
        return nuevoEnvio;
    }

    public void agregarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }
}

