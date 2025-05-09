package co.edu.uniquindio.poo.AppT1.Model;

public class Producto {
    private String nombre;
    private String codigo;
    private double precio;
    private String categoria;
    private int stock;

    public Producto(String nombre, String codigo, double precio, String categoria, int stock) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String actualizarProducto(String newNombre, String newCodigo, String newPrecio, String newCategoria,
            int newStock) {
        String mensaje = "";

        Producto producto = buscarProducto();
        
        return mensaje;
}

}
