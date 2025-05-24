package co.edu.uniquindio.poo.Model;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nombre;
    private String direccion;
    private String nit;
    private List<CuentaBancaria> cuentasBancarias;
    private List<Empleado> empleados;
    private List<Cliente> clientes;

    public Banco(String nombre, String direccion, String nit, List<CuentaBancaria> cuentasBancarias,
            List<Persona> empleados, List<Persona> clientes) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.nit = nit;
        this.cuentasBancarias = cuentasBancarias;
        this.empleados = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public Banco() {
        this.nombre = "Banco UQ";
        this.direccion = "Carrera 15 # 12-34";
        this.nit = "800.123.456-7";
        this.cuentasBancarias = new ArrayList<>();
        this.empleados = new ArrayList<>(); 
        this.clientes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public List<CuentaBancaria> getCuentasBancarias() {
        return cuentasBancarias;
    }

    public void setCuentasBancarias(List<CuentaBancaria> cuentasBancarias) {
        this.cuentasBancarias = cuentasBancarias;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void depositarDinero(String numeroCuentaDestino, String numeroCuentaOrigen, double monto) {
        for (CuentaBancaria cuentaOrigen : cuentasBancarias) {
            if (cuentaOrigen.getNumeroCuenta().equals(numeroCuentaOrigen)) {

                if (cuentaOrigen.getSaldoCuenta() >= monto) {

                    for (CuentaBancaria cuenta : cuentasBancarias) {

                        if (cuenta.getNumeroCuenta().equals(numeroCuentaDestino)) {

                            cuenta.setSaldoCuenta(cuenta.getSaldoCuenta() + monto);

                        }
                    }
                    cuentaOrigen.setSaldoCuenta(cuentaOrigen.getSaldoCuenta() - monto);
                    System.out.println("Se ha depositado " + monto + " a la cuenta " + numeroCuentaDestino);
                } else {
                    System.out.println("No hay suficiente saldo en la cuenta de origen");
                }
                break;
            }
        }
    }

    public void registrarCliente(String nombre, String identificacion, String direccion, String telefono, String numeroCuenta,
            String pin) {
        Cliente nuevoCliente = new Cliente(nombre, identificacion, telefono, direccion, numeroCuenta, pin);
        this.clientes.add(nuevoCliente);
        System.out.println("Cliente " + nombre + " registrado.");
    }

    public void registrarCajero(String nombre, String identificacion, String direccion, String telefono, String numeroCuenta,
            String codigoEmpleado, double salario, String pin) {
        Cajero nuevoCajero = new Cajero(nombre, identificacion, direccion, telefono, numeroCuenta, codigoEmpleado, salario,
                pin);
        this.empleados.add(nuevoCajero);
        System.out.println("Cajero " + nombre + " registrado.");
    }

    public void registrarAdministrador(String nombre, String identificacion, String direccion, String telefono,
            String email, String codigoEmpleado, double salario, String pin) {
        Administrador nuevoAdministrador = new Administrador(nombre, identificacion, direccion, telefono, email,
                codigoEmpleado, salario, pin);
        this.empleados.add(nuevoAdministrador);
        System.out.println("Administrador " + nombre + " registrado.");
    }

    public Cliente autenticarCliente(String identificacion, String pin) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdentificacion().equals(identificacion) && cliente.getPin().equals(pin)) {
                return cliente;
            }
        }
        return null;
    }

    public Empleado autenticarEmpleado(String identificacion, String pin) {
        for (Empleado empleado : empleados) {
            if (empleado.getIdentificacion().equals(identificacion)) {
                return empleado;
            }
        }
        return null;
    }

    public Cliente buscarCliente(String identificacion) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdentificacion().equals(identificacion)) {
                return cliente;
            }
        }
        return null;
    }

    public Empleado buscarEmpleado(String identificacion) {
        for (Empleado empleado : empleados) {
            if (empleado.getIdentificacion().equals(identificacion)) {
                return empleado;
            }
        }
        return null;
    }

    public void registrarCuenta(CuentaBancaria cuenta) {
        this.cuentasBancarias.add(cuenta);
        System.out.println("Cuenta bancaria " + cuenta.getNumeroCuenta() + " registrada.");
    }

    public CuentaBancaria buscarCuentaPorNumero(String numeroCuenta) {
        for (CuentaBancaria cuenta : cuentasBancarias) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }

    public String generarNumeroCuentaUnico() {
        return "ACC" + String.format("%08d", cuentasBancarias.size() + 1);
    }

}