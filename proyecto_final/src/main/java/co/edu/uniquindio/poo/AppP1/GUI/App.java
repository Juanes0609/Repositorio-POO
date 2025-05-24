package co.edu.uniquindio.poo.AppP1.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene scene; 
    
    @Override
    public void start(Stage stage) throws IOException {
    
        scene = new Scene(loadFXML("login"), 400, 300); 
        stage.setScene(scene);
        stage.setTitle("Banco UQ - Login"); 
        stage.show();
    }

    static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static void main(String[] args) {
        launch();
    }
}
