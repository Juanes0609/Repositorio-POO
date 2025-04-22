package co.edu.uniquindio.poo.AppP1;

import javax.swing.JOptionPane;

import co.edu.uniquindio.poo.Model.Universidad;

public class Main {
    public static void main(String[] args) {

        Universidad universidad = new Universidad("Universidad del Quindío", "Armenia, Quindío");

        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre: ");
        String identificacion = JOptionPane.showInputDialog(null, "Ingrese la identificación: ");
        String mensaje = universidad.registrarEstudiante(nombre, identificacion);

        JOptionPane.showMessageDialog(null, mensaje);

        

    }

}
