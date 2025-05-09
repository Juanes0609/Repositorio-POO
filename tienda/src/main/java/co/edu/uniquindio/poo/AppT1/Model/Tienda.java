package co.edu.uniquindio.poo.AppT1.Model;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private String nombre;
    private int nit;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Venta> listaVentas;
    private ArrayList<Producto> listaProductos;

    public Tienda(String nombre, int nit, ArrayList<Cliente> listaClientes, ArrayList<Producto> listaProductos,
            ArrayList<Venta> listaVentas) {
        this.nombre = nombre;
        this.nit = nit;
        this.listaClientes = listaClientes;
        this.listaProductos = listaProductos;
        this.listaVentas = listaVentas;
    }

    public String getNombre() {
        return nombre;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;

    }

    public int getNit() {
        return nit;

    }

    public void setNit(int nit) {
        this.nit = nit;

    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;

    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;

    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public ArrayList<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(ArrayList<Venta> listaVentas) {
        this.listaVentas = listaVentas;

    }

    public String agregarCliente(String nombre, String identificacion, String direccion, String telefono,
            String email) {
        String mensaje = "";
        Cliente cliente = null;
        cliente = buscarClientePorId(identificacion);

        if (cliente != null) { // ya existe en el sistema
            mensaje = "El cliente" + cliente.getNombre() + "ya está registrado/a";
            return mensaje;

        }

        Cliente nuevoCliente = new Cliente(nombre, identificacion, direccion, telefono, email);
        listaClientes.add(nuevoCliente);
        mensaje = "El cliente fue registrado exitosamente";
        return mensaje;

    }

    private Cliente buscarClientePorId(String identificacion) {
        Cliente clienteEncontrado = null;
        for (Cliente cliente : listaClientes) {
            if (cliente.getIdentificacion().equals(identificacion)) {
                return cliente;
            }
        }
        return clienteEncontrado;
    }

    public String actualizarCliente(String newNombre, String newIdentificacion, String newDireccion, String newTelefono,
            String newEmail, String identificacion) {
        String mensaje = "";
        Cliente clienteEncontrado = buscarClientePorId(identificacion);
        if (clienteEncontrado != null) {
            clienteEncontrado.setNombre(newNombre);
            clienteEncontrado.setIdentificacion(newIdentificacion);
            clienteEncontrado.setDireccion(newDireccion);
            clienteEncontrado.setTelefono(newTelefono);
            clienteEncontrado.setEmail(newEmail);

            mensaje = "cliente actualizado correctamente";

        }
        return mensaje;
    }

    public String eliminarCliente(String identificacion) {
        String mensaje = "";

        Cliente clienteEncontrado = buscarClientePorId(identificacion);
        if (clienteEncontrado != null) {
            if (listaClientes.remove(clienteEncontrado)) {
                mensaje = "Cliente eliminado correctamente";

            } else {
                mensaje = "Error al eliminar el cliente";
            }
        }
        return mensaje;
    }

    public String agregarProducto(String nombre, String codigo, double precio, String categoria,
            int stock) {
        String mensaje = "";
        Producto producto = null;
        producto = buscarProducto(codigo);

        if (producto != null) { // ya existe el producto
            mensaje = "El producto" + producto.getNombre() + "ya existe";
            return mensaje;

        }
        Producto nuevoProducto = new Producto(nombre, codigo, precio, categoria, stock);
        listaProductos.add(nuevoProducto);
        mensaje = "El producto fue actualizado correctamente";

        return mensaje;
    }

    private Producto buscarProducto(String codigo) {
        Producto productoEncontrado = null;

        for (Producto producto : listaProductos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }

        }
        return productoEncontrado;
    }

    public String actualizarProducto(String codigo, String newNombre, String newCodigo, String newPrecio,
            String newCategoria, int newStock) {
        String mensaje = "";

        Producto productoEncontrado = buscarProducto(codigo);

        if (productoEncontrado != null) {
            mensaje = productoEncontrado.actualizarProducto(newNombre, newCodigo, newPrecio, newCategoria, newStock);
        } else {
            mensaje = "El producto no está en Stock.";
        }
        return mensaje;
    }

    public ArrayList<Producto> obtenerProductosStockMenorA(int stockLimite) {
        ArrayList<Producto> productosStockBajo = new ArrayList<>();

        for (Producto producto : listaProductos) {
            if (producto.getStock() < stockLimite) {
                productosStockBajo.add(producto);
            }
        }

        return productosStockBajo;

    }

    public ArrayList<Cliente> ClientesConMayoresCompras() {
        ArrayList<Cliente> clientesMultiplesVentas = new ArrayList<>();

        for (Cliente cliente : listaClientes) {
            int conteoVentas = 0;
            for (Venta ventas : listaVentas) {
                if (ventas.getIdentificacionCliente().equals(cliente.getIdentificacion()))
                conteoVentas++;
            }
            if (conteoVentas > 1) {
                clientesMultiplesVentas.add(cliente);
            }
        }
        return clientesMultiplesVentas;

    }

    public List<Venta> ventasEntreDosFechas(Date fechaInicio, Date fechaFinal) {
        List<Venta> ventasEnRango = new ArrayList<>();
        for (Venta venta : listaVentas) {
            Date fechaVenta = venta.getFecha();
            if (fechaVenta.after(fechaInicio) || fechaVenta.equals(fechaInicio )&& fechaVenta.before(fechaFinal) || fechaVenta.equals(fechaFinal)) {
                ventasEnRango.add(venta);
            }
        }
        return ventasEnRango;
    }

    public String nombreMasLargo(){
        if (listaClientes.isEmpty()){
            return null;
        }
        String nombreMasLargo = "";
        for (Cliente cliente : listaClientes) {
            if(cliente.getNombre().length() > nombreMasLargo.length()){
                nombreMasLargo = cliente.getNombre();
            }
        }

        return nombreMasLargo;
    }

    public ArrayList <String> obtenerClientesNombresPalindromos(){
        ArrayList <String> nombresPalindromos = new ArrayList<>();

        for (Cliente cliente : listaClientes) {
           String nombre = cliente.getNombre();
           if (esPalindromo(nombre)){
            nombresPalindromos.add(nombre);

           }    
        }
        return nombresPalindromos;
    }

    private boolean esPalindromo(String palabra){
        palabra = palabra.toLowerCase();
        int longitud = palabra.length();
        for (int i = 0; i < longitud / 2; i++){
            if(palabra.charAt(i) != palabra.charAt(longitud - 1 - i)){
                return false;
            }
        }
    return true;
}
}

