package co.edu.uniquindio.poo.AppP1.GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class AdminController {

    @FXML public void registrarEmpleado() {
        mostrarMensaje("Empleado registrado.");
    }

    @FXML public void eliminarEmpleado() {
        mostrarMensaje("Empleado eliminado.");
    }

    @FXML public void verTransacciones() {
        mostrarMensaje("Transacciones mostradas.");
    }

    @FXML public void generarReportes() {
        mostrarMensaje("Reportes generados.");
    }

    private void mostrarMensaje(String mensaje) {
        new Alert(Alert.AlertType.INFORMATION, mensaje).showAndWait();
    }
}