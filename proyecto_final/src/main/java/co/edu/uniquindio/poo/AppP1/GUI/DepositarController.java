package co.edu.uniquindio.poo.AppP1.GUI;

import co.edu.uniquindio.poo.Model.Banco;
import co.edu.uniquindio.poo.Model.CuentaBancaria;
import co.edu.uniquindio.poo.Model.EstadoTransaccion; // Importar EstadoTransaccion
import co.edu.uniquindio.poo.Model.Transaccion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDateTime;

public class DepositarController {

    @FXML
    private Label numeroCuentaLabel;
    @FXML
    private TextField montoField;

    private CuentaBancaria cuentaCliente;
    private ClienteController clienteController;

    public void setCuentaCliente(CuentaBancaria cuenta) {
        this.cuentaCliente = cuenta;
        if (cuenta != null) {
            numeroCuentaLabel.setText(cuenta.getNumeroCuenta());
        }
    }

    public void setClienteController(ClienteController controller) {
        this.clienteController = controller;
    }

    @FXML
    public void confirmarDeposito(ActionEvent event) {
        try {
            double monto = Double.parseDouble(montoField.getText());

            if (monto <= 0) {
                new Alert(Alert.AlertType.ERROR, "El monto a depositar debe ser positivo.").showAndWait();
                return;
            }

            if (cuentaCliente == null) {
                new Alert(Alert.AlertType.ERROR, "No se ha especificado la cuenta para el depósito.").showAndWait();
                return;
            }

            cuentaCliente.depositarDinero(monto); // Llama al método de depósito de la cuenta

            // Crear y registrar la transacción con TU CONSTRUCTOR
            Banco.getInstance().registrarTransaccion(
                    new Transaccion(
                            LocalDateTime.now(), // fechaHora
                            "Deposito", // tipoTransaccion
                            monto, // monto
                            null, // codigoTransaccion (se genera internamente en tu Transaccion)
                            EstadoTransaccion.COMPLETADA, // estado (suponemos exitoso)
                            null, // cuentaOrigen (null para depósito)
                            cuentaCliente.getNumeroCuenta() // cuentaDestino
                    ));

            new Alert(Alert.AlertType.INFORMATION, "Depósito de $" + monto + " realizado con éxito.").showAndWait();
            cerrarVentana();
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Monto inválido. Ingrese solo números.").showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error al procesar el depósito: " + e.getMessage()).showAndWait();
        }
    }

    @FXML
    public void cancelar(ActionEvent event) {
        cerrarVentana();
    }

    private void cerrarVentana() {
        Stage stage = (Stage) montoField.getScene().getWindow();
        stage.close();
    }
}