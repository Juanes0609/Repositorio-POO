package co.edu.uniquindio.poo.AppP1.GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class CajeroController {

    @FXML public void registrarCliente() {
        mostrarMensaje("Cliente registrado exitosamente.");
    }

    @FXML public void realizarDeposito() {
        mostrarMensaje("Depósito realizado.");
    }

    @FXML public void realizarRetiro() {
        mostrarMensaje("Retiro realizado.");
    }

    @FXML public void realizarTransferencia() {
        mostrarMensaje("Transferencia exitosa.");
    }

    @FXML public void generarReporte() {
        mostrarMensaje("Reporte generado.");
    }

    private void mostrarMensaje(String mensaje) {
        new Alert(Alert.AlertType.INFORMATION, mensaje).showAndWait();
    }
}