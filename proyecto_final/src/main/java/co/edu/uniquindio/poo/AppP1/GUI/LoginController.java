package co.edu.uniquindio.poo.AppP1.GUI;
import co.edu.uniquindio.poo.Model.Banco;
import co.edu.uniquindio.poo.Model.Cliente;
import co.edu.uniquindio.poo.Model.Empleado;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML private TextField txtIdentificacion;
    @FXML private PasswordField txtPin;
    @FXML private Label lblMensaje;

    private Banco banco; // Instancia de tu clase Banco para manejar la lógica de negocio

    /**
     * Constructor del controlador.
     * Aquí inicializas el modelo de negocio (tu clase Banco) y puedes agregar datos de prueba.
     */
    public LoginController() {
        this.banco = new Banco();
        // --- DATOS DE PRUEBA ---
        // (¡Puedes eliminar o comentar estas líneas después de probar la autenticación!)
        banco.registrarCliente("Juan Perez", "1001", "Carrera 9", "3001234567", "00001", "1234");
        banco.registrarCajero("Maria Gomez", "2001", "3007654321", "Calle 5", "maria@mail.com", "EMP001", 1500000, "5678");
        banco.registrarAdministrador("Admin General", "3001", "3219876543", "Avenida Principal", "admin@mail.com", "ADM001", 3000000, "admin");
        // -----------------------
    }

    /**
     * Método que se ejecuta cuando el botón "Iniciar Sesión" es presionado.
     * La anotación @FXML lo vincula al onAction="#handleLoginButton" en login.fxml
     * @param event El evento de acción (clic del botón).
     */
    @FXML
    private void handleLoginButton(ActionEvent event) {
        String identificacion = txtIdentificacion.getText(); // Obtiene el texto del campo de identificación
        String pin = txtPin.getText(); // Obtiene el texto del campo del PIN

        // Intenta autenticar como Cliente
        Cliente cliente = banco.autenticarCliente(identificacion, pin);
        if (cliente != null) {
            lblMensaje.setText("¡Bienvenido, Cliente " + cliente.getNombre() + "!");
            lblMensaje.setStyle("-fx-text-fill: green;"); // Mensaje de éxito en verde
            System.out.println("Login exitoso como Cliente: " + cliente.getNombre());
            // TODO: Aquí deberías redirigir a la siguiente vista (por ejemplo, la pantalla principal del cliente)
            return; // Sale del método si la autenticación fue exitosa
        }

        // Si no es Cliente, intenta autenticar como Empleado (Cajero o Administrador)
        Empleado empleado = banco.autenticarEmpleado(identificacion, pin); // Asumo que tienes un método así en Banco
        if (empleado != null) {
            lblMensaje.setText("¡Bienvenido, Empleado " + empleado.getNombre() + "!");
            lblMensaje.setStyle("-fx-text-fill: green;"); // Mensaje de éxito en verde
            System.out.println("Login exitoso como Empleado: " + empleado.getNombre());
            // TODO: Aquí deberías redirigir a la siguiente vista (por ejemplo, la pantalla principal del empleado/administrador)
            return; // Sale del método
        }

        // Si ninguna autenticación fue exitosa
        lblMensaje.setText("Identificación o PIN incorrectos.");
        lblMensaje.setStyle("-fx-text-fill: red;"); // Mensaje de error en rojo
    }

    /**
     * Método que se ejecuta cuando el botón "Salir" es presionado.
     * La anotación @FXML lo vincula al onAction="#handleExitButton" en login.fxml
     * @param event El evento de acción (clic del botón).
     */
    @FXML
    private void handleExitButton(ActionEvent event) {
        Platform.exit(); // Cierra la aplicación JavaFX
        System.exit(0); // Termina el proceso Java completamente
    }
}

