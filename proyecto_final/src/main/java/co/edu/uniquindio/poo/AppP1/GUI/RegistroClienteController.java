package co.edu.uniquindio.poo.AppP1.GUI;

import co.edu.uniquindio.poo.Model.Banco;
import co.edu.uniquindio.poo.Model.CuentaBancaria; // Para crear la cuenta del nuevo cliente
import co.edu.uniquindio.poo.Model.Cliente; // Importa tu clase Cliente
import co.edu.uniquindio.poo.Model.CuentaAhorros;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;

public class RegistroClienteController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtIdentificacion;
    @FXML private TextField txtDireccion;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtEmail;
    @FXML private PasswordField txtPin;
    @FXML private PasswordField txtConfirmarPin;
    @FXML private Label lblMensajeRegistro;

    private Banco banco;

    // Constructor
    public RegistroClienteController() {
        // Es importante que el controlador de registro tenga acceso a la misma instancia de Banco
        // que está usando tu App principal o tu LoginController.
        // Para simplificar, aquí podemos instanciarlo nuevamente si Banco gestiona los datos de forma estática
        // o si es un Singleton. Si no, necesitarás pasar la instancia de Banco.
        this.banco = Banco.getInstancia(); // Asumiendo que tienes un Singleton para Banco
                                           // Si no es Singleton, necesitarás un método setBanco(Banco b)
                                           // y llamarlo desde App o LoginController al cargar este FXML.
    }

    // Si Banco NO es un Singleton, necesitarías este método:
    // public void setBanco(Banco banco) {
    //     this.banco = banco;
    // }

    @FXML
    private void handleRegistrarCliente() {
        String nombre = txtNombre.getText();
        String identificacion = txtIdentificacion.getText();
        String direccion = txtDireccion.getText();
        String telefono = txtTelefono.getText();
        String email = txtEmail.getText();
        String pin = txtPin.getText();
        String confirmarPin = txtConfirmarPin.getText();

        // Validaciones básicas
        if (nombre.isEmpty() || identificacion.isEmpty() || direccion.isEmpty() ||
            telefono.isEmpty() || email.isEmpty() || pin.isEmpty() || confirmarPin.isEmpty()) {
            lblMensajeRegistro.setText("Todos los campos son obligatorios.");
            lblMensajeRegistro.setStyle("-fx-text-fill: red;");
            return;
        }

        if (!pin.equals(confirmarPin)) {
            lblMensajeRegistro.setText("El PIN y la confirmación no coinciden.");
            lblMensajeRegistro.setStyle("-fx-text-fill: red;");
            return;
        }

        if (pin.length() != 4 || !pin.matches("\\d+")) {
            lblMensajeRegistro.setText("El PIN debe ser numérico y de 4 dígitos.");
            lblMensajeRegistro.setStyle("-fx-text-fill: red;");
            return;
        }

        // Verificar si la identificación ya existe
        if (banco.buscarCliente(identificacion) != null || banco.buscarEmpleado(identificacion) != null) {
            lblMensajeRegistro.setText("La identificación ya está registrada.");
            lblMensajeRegistro.setStyle("-fx-text-fill: red;");
            return;
        }

        // Intentar registrar el cliente en el banco
        // Asumo que tu método registrarCliente en Banco devuelve true si el registro fue exitoso
        String registrado = banco.registrarCliente(nombre, identificacion, direccion, telefono, email, pin);

        if (registrado) {
            // Si el cliente se registró, automáticamente le creamos una cuenta bancaria inicial
            // Puedes generar un número de cuenta único aquí o tener una lógica en Banco
            String numeroCuenta = "ACC-" + (banco.getCuentasBancarias().size() + 1001); // Generación simple
            CuentaBancaria nuevaCuenta = new CuentaAhorros(numeroCuenta, 0.0, , banco.buscarCliente(identificacion), 0); // Saldo inicial 0
            banco.registrarCuenta(nuevaCuenta); // Asumiendo que tienes este método en Banco

            lblMensajeRegistro.setText("¡Registro exitoso! Ya puedes iniciar sesión.");
            lblMensajeRegistro.setStyle("-fx-text-fill: green;");

            // Opcional: Limpiar campos después de un registro exitoso
            txtNombre.clear();
            txtIdentificacion.clear();
            txtDireccion.clear();
            txtTelefono.clear();
            txtEmail.clear();
            txtPin.clear();
            txtConfirmarPin.clear();

            // Redirigir de vuelta a la pantalla de login después de un pequeño retraso
            // para que el usuario vea el mensaje de éxito.
            Platform.runLater(() -> {
                try {
                    // Espera un momento antes de redirigir (opcional)
                    Thread.sleep(1500); // 1.5 segundos
                    App.setRoot("login");
                    App.getStage().setTitle("Banco UQ - Login");
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            });

        } else {
            lblMensajeRegistro.setText("Error al registrar cliente. Inténtalo de nuevo.");
            lblMensajeRegistro.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    private void handleVolverLogin() throws IOException {
        App.setRoot("login");
        App.getStage().setTitle("Banco UQ - Login");
    }

    @FXML
    private void handleExitButton() {
        Platform.exit();
        System.exit(0);
    }
}
