package co.edu.uniquindio.poo.Model;

public class Estudiante {
    private String nombre;
    private String identificacion;
    private Nota[] listaNotas = new Nota[5];

    public Nota[] getListaNotas() {
        return listaNotas;
    }

    public void setListaNotas(Nota[] listaNotas) {
        this.listaNotas = listaNotas;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String registrarNota(String nombreNota, double valor) {
        int posDisponible = -1;
        posDisponible = buscarPos();
        if (posDisponible == -1) {
            return "No hay espacio para más notas";
        } else {
            Nota nota = new Nota(nombreNota, valor);
            listaNotas[posDisponible] = nota;
            return "La nota fue registrada";

        }
    }

    private int buscarPos() {
        for (int i = 0; i < listaNotas.length; i++) {
            if (listaNotas[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public double calcularPromedio() {
        if (listaNotas.length == 0) {
            return 0.0;
        }
        double suma = 0;
        for (Nota nota : listaNotas) {
            suma += nota.getValor();
        }
        return suma / listaNotas.length;
    }

    public String actualizarNota(String nombreNota, double nuevoValor) {
        String mensaje = "";

        Nota notaEncontrada = buscarNota(nombreNota);
        if (notaEncontrada != null) {
            mensaje = notaEncontrada.actualizarNota(nuevoValor);
        } else {
            mensaje = "La nota está registrada";
        }
        return mensaje;
    }

    private Nota buscarNota(String nombreNota) {
        Nota notaEncontrada = null;

        for (Nota nota : listaNotas) {
            if (nota != null && nota.getNombreNota().equals(nombreNota)) {
                notaEncontrada = nota;
                break;
            }
        }
        return notaEncontrada;
    }

    @Override
    public String toString() {
        String mensaje = "Estudiante: " + nombre + "(" + identificacion + ")\n";
        mensaje += "Notas:\n";
        for (int i = 0; i < listaNotas.length; i++) {
            mensaje += "- " + listaNotas[i].getNombreNota() + ":" + listaNotas[i].getValor() + "\n";
        }
        mensaje += "Promedio: " + calcularPromedio();
        return mensaje;
    }

    public String eliminarNota(String nombreNota) {
        String mensaje = "";
        Nota notaEncontrada = buscarNota(nombreNota);

        if (notaEncontrada != null) {
            for (int i = 0; i < listaNotas.length; i++) {
                if (listaNotas[i] != null && listaNotas[i].equals(notaEncontrada))
                    ;
                listaNotas[i] = null;
                mensaje = "Nota eliminada";

            }
        }

        return mensaje;
    }

}
