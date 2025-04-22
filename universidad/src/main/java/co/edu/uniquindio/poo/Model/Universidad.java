package co.edu.uniquindio.poo.Model;

import java.util.ArrayList;
import java.util.List;

public class Universidad {
    private String nombre;
    private String ubicacion;
    private List<Estudiante> listaEstudiantes = new ArrayList<>();

    public Universidad(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;

    }

    public String getNombre() {
        return nombre;
    }

    public List<Estudiante> getEstudiantes() {
        return listaEstudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.listaEstudiantes = estudiantes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String registrarEstudiante(String nombre, String identificacion) {
        String mensaje = "";
        Estudiante encontrado = null;
        Estudiante nuevoEstudiante = null;

        encontrado = buscarEstudiantePorIdentificacion(identificacion);
        if (encontrado != null) {
            mensaje = "El estudiante" + encontrado.getNombre() + "ya existe en el sistema.";
            return mensaje;
        }
        nuevoEstudiante = new Estudiante();
        listaEstudiantes.add(nuevoEstudiante);
        return mensaje;
    }

    public String registrarNota(String identificacion, String nombreNota, double valor) {
        String mensaje = "";
        Estudiante estudiante = buscarEstudiantePorIdentificacion(identificacion);
        if (estudiante != null) {
            estudiante.registrarNota(nombreNota, valor);
            mensaje = "La nota ha sido registrada.";

        } else {
            mensaje = "El estudiante no se encuentra registrado en la Universidad.";
        }
        return mensaje;
    }

    public Estudiante buscarEstudiantePorIdentificacion(String identificacion) {
        Estudiante encontrado = null;
        for (Estudiante estudiante : listaEstudiantes) {
            if (estudiante.getIdentificacion().equals(identificacion)) {
                return estudiante;
            }
        }
        return encontrado;
    }

    public String actualizarNota(String identificacion, String nombreNota, double nuevoValor) {
        String mensaje = "";
        Estudiante estudianteEncontrado = buscarEstudiantePorIdentificacion(identificacion);
        if (estudianteEncontrado != null) {
            mensaje = estudianteEncontrado.actualizarNota(nombreNota, nuevoValor);
        } else {
            mensaje = "El estudiante no está registrado en la universidad.";
        }
        return mensaje;
    }

    public String eliminarNota(String identificacion, String nombreNota){
        String mensaje = "";
        Estudiante estudianteEncontrado = buscarEstudiantePorIdentificacion(identificacion);
        if (estudianteEncontrado != null) {
            mensaje = estudianteEncontrado.eliminarNota(nombreNota);
        } else {
            mensaje = "El estudiante no está registrado en la Universidad";
        }
        return mensaje;
    }


    public float calcularPromedioGeneral() {
        float sumatoria = 0;

        for (Estudiante estudiante : listaEstudiantes) {
            sumatoria += estudiante.calcularPromedio();

        }
        return sumatoria / listaEstudiantes.size();
    }
}
