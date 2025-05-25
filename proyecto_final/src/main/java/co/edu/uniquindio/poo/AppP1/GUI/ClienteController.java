package co.edu.uniquindio.poo.AppP1.GUI;

import co.edu.uniquindio.poo.Model.Cliente;
import co.edu.uniquindio.poo.Model.CuentaBancaria;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;

public class ClienteController {

    @FXML private Label nombreClienteLabel;
    @FXML private Label saldoActualLabel;

    private Cliente clienteAutenticado;
    private CuentaBancaria cuentaPrincipal; // Suponiendo que el cliente tiene una cuenta principal asociada a su login

    // Este método es llamado por FXMLLoader después de que los elementos FXML han sido procesados.
    // Necesitamos un método para pasar el cliente autenticado desde LoginController.
    public void setClienteAutenticado(Cliente cliente) {
        this.clienteAutenticado = cliente;
        if (cliente != null) {
            nombreClienteLabel.setText(cliente.getNombre());
            // Asumiendo que el cliente tiene una cuenta principal, o que podemos buscarla.
            // Por simplicidad, tomamos la primera cuenta si existe.
            if (!cliente.getListaCuentas().isEmpty()) {
                this.cuentaPrincipal = cliente.getListaCuentas().get(0); // Tomamos la primera cuenta
                actualizarSaldo();
            } else {
                saldoActualLabel.setText("$ 0.00 (Sin cuenta)");
            }
        }
    }

    public void actualizarSaldo() {
        if (cuentaPrincipal != null) {
            DecimalFormat df = new DecimalFormat("#,##0.00");
            saldoActualLabel.setText("$ " + df.format(cuentaPrincipal.getSaldoCuenta()));
        }
    }

    @FXML
    public void consultarSaldo(ActionEvent event) {
        if (cuentaPrincipal == null) {
            new Alert(Alert.AlertType.WARNING, "No hay una cuenta asociada para consultar el saldo.").showAndWait();
            return;
        }
        // El saldo ya se actualiza en el label, solo mostramos una alerta para confirmar
        new Alert(Alert.AlertType.INFORMATION, "Su saldo actual es: $" + new DecimalFormat("#,##0.00").format(cuentaPrincipal.getSaldoCuenta())).showAndWait();
    }

    @FXML
    public void mostrarVentanaDepositar(ActionEvent event) {
        if (cuentaPrincipal == null) {
            new Alert(Alert.AlertType.WARNING, "No hay una cuenta asociada para realizar depósitos.").showAndWait();
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/AppP1/GUI/deposito.fxml"));
            Parent root = loader.load();

            DepositarController controller = loader.getController();
            controller.setCuentaCliente(cuentaPrincipal); // Pasamos la cuenta para que el controlador la use
            controller.setClienteController(this); // Para poder llamar a actualizarSaldo() desde DepositarController

            Stage stage = new Stage();
            stage.setTitle("Depositar Dinero");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL); // Bloquea la ventana principal hasta que se cierre
            stage.initStyle(StageStyle.UTILITY); // Estilo de ventana de utilidad
            stage.showAndWait(); // Espera a que la ventana se cierre

            actualizarSaldo(); // Actualiza el saldo en la ventana principal del cliente después de cerrar la de depósito
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error al abrir la ventana de depósito: " + e.getMessage()).showAndWait();
        }
    }

    @FXML
    public void mostrarVentanaRetirar(ActionEvent event) {
        if (cuentaPrincipal == null) {
            new Alert(Alert.AlertType.WARNING, "No hay una cuenta asociada para realizar retiros.").showAndWait();
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/AppP1/GUI/retiro.fxml"));
            Parent root = loader.load();

            RetirarController controller = loader.getController();
            controller.setCuentaCliente(cuentaPrincipal); // Pasamos la cuenta
            controller.setClienteController(this); // Para actualizar el saldo

            Stage stage = new Stage();
            stage.setTitle("Retirar Dinero");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UTILITY);
            stage.showAndWait();

            actualizarSaldo(); // Actualiza el saldo
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error al abrir la ventana de retiro: " + e.getMessage()).showAndWait();
        }
    }

    @FXML
    public void mostrarVentanaTransferir(ActionEvent event) {
        if (cuentaPrincipal == null) {
            new Alert(Alert.AlertType.WARNING, "No hay una cuenta asociada para realizar transferencias.").showAndWait();
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/AppP1/GUI/transferencia.fxml"));
            Parent root = loader.load();

            TransferirController controller = loader.getController();
            controller.setCuentaOrigen(cuentaPrincipal); // Pasamos la cuenta de origen
            controller.setClienteController(this); // Para actualizar el saldo

            Stage stage = new Stage();
            stage.setTitle("Transferir Dinero");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UTILITY);
            stage.showAndWait();

            actualizarSaldo(); // Actualiza el saldo
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error al abrir la ventana de transferencia: " + e.getMessage()).showAndWait();
        }
    }

    @FXML
    public void mostrarReportes(ActionEvent event) {
        try {
            // Cargar el FXML de reportes
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/AppP1/GUI/reportes.fxml"));
            Parent root = loader.load();

            // Puedes obtener el controlador si necesitas pasarle datos, aunque en este caso
            // ReportesController ya carga los datos directamente del Banco.getInstance()
            // ReportesController controller = loader.getController();
            // Si tuvieras datos específicos que pasar, lo harías aquí:
            // controller.setDatos(miListaDeDatos);

            Stage stage = new Stage();
            stage.setTitle("Reportes de Transacciones");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL); // Opcional: modal para bloquear la ventana principal
            stage.initStyle(StageStyle.UTILITY); // Estilo de ventana de utilidad
            stage.showAndWait(); // Muestra la ventana y espera a que se cierre

        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error al abrir la ventana de reportes: " + e.getMessage()).showAndWait();
        }
    }

    @FXML
    public void cambiarPIN(ActionEvent event) {
        if (clienteAutenticado == null) {
            new Alert(Alert.AlertType.WARNING, "No hay un cliente autenticado para cambiar el PIN.").showAndWait();
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/AppP1/GUI/cambiar_pin.fxml"));
            Parent root = loader.load();

            CambiarPINController controller = loader.getController();
            controller.setClienteAutenticado(clienteAutenticado); // Pasamos el cliente actual

            Stage stage = new Stage();
            stage.setTitle("Cambiar PIN");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UTILITY);
            stage.showAndWait();

            // No necesitas actualizar saldo aquí, pero si el PIN fuera visible en la pantalla principal
            // y se actualizara, lo harías. En este caso, solo se actualiza en el objeto Cliente.

        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error al abrir la ventana de cambio de PIN: " + e.getMessage()).showAndWait();
        }
    }

    @FXML
    public void cerrarSesion(ActionEvent event) {
        try {
            // Cargar la vista de login
            URL fxmlUrl = getClass().getResource("/co/edu/uniquindio/poo/AppP1/GUI/login.fxml");
            if (fxmlUrl == null) {
                throw new RuntimeException("No se encontró login.fxml en recursos");
            }
            Parent root = FXMLLoader.load(fxmlUrl);
            Scene scene = new Scene(root);

            // Obtener el Stage actual y cambiar la escena
            Stage stage = (Stage) nombreClienteLabel.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Banco UQ - Login");
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error al cerrar sesión: " + e.getMessage()).showAndWait();
        }
    }
}