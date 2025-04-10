package co.edu.uniquindio.poo.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Batallon {
    private String nombreBatallon;
    private List<Vehiculo> listaVehiculos;
    private List<Mision> listaMisiones;

    public Batallon(String nombreBatallon) {
        this.nombreBatallon = nombreBatallon;
        this.listaVehiculos = new ArrayList<>();
        this.listaMisiones = new ArrayList<>();

    }

    public String getIdBatallon() {
        return nombreBatallon;
    }

    public void setIdBatallon(String idBatallon) {
        this.nombreBatallon = idBatallon;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public List<Mision> getListaMisiones() {
        return listaMisiones;
    }

    public void setListaMisiones(List<Mision> listaMisiones) {
        this.listaMisiones = listaMisiones;
    }

    public String registrarVehiculo(Vehiculo newVehiculo) {
        String mensaje = "";
        Optional<Vehiculo> optionalVehiculo = buscarVehiculo(newVehiculo.getId());
        if (optionalVehiculo.isPresent()) {
            mensaje = "El vehiculo ya existe";
        } else {
            listaVehiculos.add(newVehiculo);
            mensaje = "Vehículo registrado correctamente";

        }
        return mensaje;
    }

    public Optional<Vehiculo> buscarVehiculo(String id) {
        return listaVehiculos.stream().filter(vehiculo -> vehiculo.getId().equals(id)).findFirst();
    }

    public String editarVehiculo(String id, Vehiculo vehiculo) {
        String mensaje = "";
        Optional<Vehiculo> optionalVehiculo = buscarVehiculo(id);
        if (optionalVehiculo.isPresent()) {
            Vehiculo editVehiculo = optionalVehiculo.get();
            editVehiculo.setModelo(vehiculo.getModelo());
            editVehiculo.setAñoFabricacion(vehiculo.getAñoFabricacion());
            editVehiculo.setKilometraje(vehiculo.getKilometraje());
            editVehiculo.setListaMisiones(vehiculo.getListaVehiculos());
            editVehiculo.setEstadoOperativo(vehiculo.getEstadoOperativo());
            editVehiculo.setNumeroMisiones(vehiculo.getNumeroMisiones());
            return mensaje = "Vehiculo editado correctamente";
        } else {
            mensaje = "El vehiculo no existe";
        }
        return mensaje;
    }

    public Vehiculo vehiculoMasMisiones() {
        Vehiculo vehiculoMayorMisiones = null;
        int maxMisiones = -1;
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getNumeroMisiones() > maxMisiones) {
                maxMisiones = vehiculo.getNumeroMisiones();
                vehiculoMayorMisiones = vehiculo;
            }
        }
        return vehiculoMayorMisiones;
    }
}
