/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2025-04
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.Model.Vehiculo;
import co.edu.uniquindio.poo.Model.VehiculoBlindado;

public class VehiculoTest {
    private static final Logger LOG = Logger.getLogger(VehiculoTest.class.getName());

    @Test
    public void registrarPrimeraMisionDeberiaIncrementarNumeroMisionesAUno() {
        LOG.info("Iniciado test registrarPrimeraMisionDeberiaIncrementarNumeroMisionesAUno");
        Vehiculo vehiculo = new VehiculoBlindado("ABC-123", "ModeloX", 2020, 1000.0f, "DISPONIBLE", 0);
        vehiculo.setNumeroMisiones(vehiculo.getNumeroMisiones() + 1);

        assertEquals(1, vehiculo.getNumeroMisiones());

        LOG.info("Finalizando test registrarPrimeraMisionDeberiaIncrementarNumeroMisionesAUno");
    }

    @Test
    void cambiarEstadoOperativoDeberiaActualizarEstado() {
        LOG.info("Iniciando test cambiarEstadoOperativoDeberiaActualizarEstado");

        Vehiculo vehiculo = new VehiculoBlindado("DEF-456", "ModeloY", 2021, 1500.0f, "DISPONIBLE", 0);
        vehiculo.setEstadoOperativo("EN_MANTENIMIENTO");
        assertEquals("EN_MANTENIMIENTO", vehiculo.getEstadoOperativo());

        LOG.info("Finalizando test cambiarEstadoOperativoDeberiaActualizarEstado");
    }

    @Test
    void crearVehiculoDeberiaGuardarDatosCorrectamente() {
        LOG.info("Iniciando test crearVehiculoDeberiaGuardarDatosCorrectamente");

        Vehiculo vehiculo = new VehiculoBlindado("GHI-789", "ModeloZ", 2022, 500.5f, "EN_MISION", 3);
        assertEquals("GHI-789", vehiculo.getId());
        assertEquals("ModeloZ", vehiculo.getModelo());
        assertEquals(2022, vehiculo.getAñoFabricacion());
        assertEquals(500.5f, vehiculo.getKilometraje(), 0.001);
        assertEquals("EN_MISION", vehiculo.getEstadoOperativo());
        assertEquals(3, vehiculo.getNumeroMisiones());

        LOG.info("Finalizando test crearVehiculoDeberiaGuardarDatosCorrectamente");

    }

    @Test
    void aumentarKilometrajeConValorNegativoNoDeberiaModificarKilometraje() {
        LOG.info("Iniciando test aumentarKilometrajeConValorNegativoNoDeberiaModificarKilometraje");

        Vehiculo vehiculo = new VehiculoBlindado("JKL-012", "ModeloW", 2019, 2000.0f, "DISPONIBLE", 0);
        float kilometrajeInicial = vehiculo.getKilometraje();
        vehiculo.setKilometraje(vehiculo.getKilometraje() - 100.0f);
        assertEquals(kilometrajeInicial, vehiculo.getKilometraje());

        LOG.info("Finalizando test aumentarKilometrajeConValorNegativoNoDeberiaModificarKilometraje");
    }

    @Test
    void aumentarKilometrajeConValorPositivoDeberiaActualizarKilometraje() {
        LOG.info("Iniciando test aumentarKilometrajeConValorPositivoDeberiaActualizarKilometraje");

        Vehiculo vehiculo = new VehiculoBlindado("MNO-345", "ModeloU", 2023, 100.0f, "DISPONIBLE", 0);
        float kilometrajeInicial = vehiculo.getKilometraje();
        float incremento = 50.5f;

        vehiculo.setKilometraje(vehiculo.getKilometraje() + incremento);
        assertEquals(kilometrajeInicial + incremento, vehiculo.getKilometraje(), 0.001);

        LOG.info("Iniciando test aumentarKilometrajeConValorPositivoDeberiaActualizarKilometraje");
    }

    @Test
    void multiplesAumentosDeKilometrajeDeberianSumarseCorrectamente() {
        LOG.info("Iniciando test aumentarKilometrajeConValorPositivoDeberiaActualizarKilometraje");

        Vehiculo vehiculo = new VehiculoBlindado("PQR-678", "ModeloV", 2022, 300.0f, "DISPONIBLE", 0);
        float incremento1 = 50.5f;
        float incremento2 = 49.5f;

        vehiculo.setKilometraje(vehiculo.getKilometraje() + incremento1);
        vehiculo.setKilometraje(vehiculo.getKilometraje() + incremento2);

        assertEquals(300.0f + incremento1 + incremento2, vehiculo.getKilometraje(), 0.001);

        LOG.info("Finalizando test aumentarKilometrajeConValorPositivoDeberiaActualizarKilometraje");
    } 
}