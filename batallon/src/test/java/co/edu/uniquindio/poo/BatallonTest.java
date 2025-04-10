/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2025-04
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.Model.Batallon;
import co.edu.uniquindio.poo.Model.Vehiculo;
import co.edu.uniquindio.poo.Model.VehiculoBlindado;

public class BatallonTest {
    private static final Logger LOG = Logger.getLogger(VehiculoTest.class.getName());

    @Test
    void registrarVehiculoDuplicadoDeberiaRetornarMensajeDeError() {
        LOG.info("Iniciado test registrarVehiculoDuplicadoDeberiaRetornarMensajeDeError");
        Batallon batallon = new Batallon("Batallon Central");
        Vehiculo vehiculo1 = new VehiculoBlindado("ABC-123", "ModeloX", 2020, 1000.0f, "DISPONIBLE", 0);
        batallon.registrarVehiculo(vehiculo1);

        Vehiculo vehiculo2 = new VehiculoBlindado("ABC-123", "ModeloX", 2020, 1000.0f, "DISPONIBLE", 0);
        String mensaje = batallon.registrarVehiculo(vehiculo2);
        assertEquals("El vehiculo ya existe", mensaje);
        assertEquals(1, batallon.getListaVehiculos().size());

        LOG.info("Finalizando test registrarVehiculoDuplicadoDeberiaRetornarMensajeDeError");
    }

    @Test
    void registrarVehiculoNuevoRetornaMensajeDeExito() {
        LOG.info("Iniciado test registrarVehiculoNuevoRetornaMensajeDeExito");

        Batallon batallon = new Batallon("Batallón Central");
        Vehiculo newVehiculo = new VehiculoBlindado("DFG-456", "ModeloZ", 2021, 500.0f, "DISPONIBLE", 0);

        String mensaje = batallon.registrarVehiculo(newVehiculo);
        assertEquals("Vehículo registrado correctamente", mensaje);
        assertEquals(1, batallon.getListaVehiculos().size());
        assertTrue(batallon.getListaVehiculos().contains(newVehiculo));

        LOG.info("Finalizando test registrarVehiculoNuevoRetornaMensajeDeExito");
    }

    @Test
    void buscarVehiculoExistenteDeberiaRetornarElVehiculo() {
        LOG.info("Iniciado test buscarVehiculoExistenteDeberiaRetornarElVehiculo");

        Batallon batallon = new Batallon("Batallon Central");
        Vehiculo vehiculo = new VehiculoBlindado("GHI-789", "ModeloW", 2019, 2000.0f, "DISPONIBLE", 0);
        batallon.registrarVehiculo(vehiculo);

        Optional<Vehiculo> vehiculoEncontrado = batallon.buscarVehiculo("GHI-789");
        assertTrue(vehiculoEncontrado.isPresent());
        assertEquals(vehiculo, vehiculoEncontrado.get());

        LOG.info("Finalizando test buscarVehiculoExistenteDeberiaRetornarElVehiculo");
    }

    @Test
    void buscarVehiculoNoExistenteDeberiaRetornarOptionalVacio() {
        LOG.info("Iniciando test buscarVehiculoNoExistenteDeberiaRetornarOptionalVacio");

        Batallon batallon = new Batallon("Batallón Central");
        Optional<Vehiculo> vehiculoEncontrado = batallon.buscarVehiculo("JKL-012");
        assertFalse(vehiculoEncontrado.isPresent());

        LOG.info("Finalizando test buscarVehiculoNoExistenteDeberiaRetornarOptionalVacio");
    }

    @Test
    void editarVehiculoExistenteDeberiaActualizarLosDatos() {
        LOG.info("Iniciando test editarVehiculoExistenteDeberiaActualizarLosDatos");

        Batallon batallon = new Batallon("Batallón Central");
        Vehiculo vehiculoOriginal = new VehiculoBlindado("MNO-345", "ModeloU", 2023, 100.0f, "DISPONIBLE", 0);
        batallon.registrarVehiculo(vehiculoOriginal);

        Vehiculo vehiculoEditado = new VehiculoBlindado("MNO-345", "NuevoModelo", 2024, 200.0f, "EN MISION", 1);

        String mensaje = batallon.editarVehiculo("MNO-345", vehiculoEditado);
        assertEquals("Vehiculo editado correctamente", mensaje);

        Optional<Vehiculo> vehiculoEncontrado = batallon.buscarVehiculo("MNO-345");
        assertTrue(vehiculoEncontrado.isPresent());
        assertEquals("NuevoModelo", vehiculoEncontrado.get().getModelo());
        assertEquals(2024, vehiculoEncontrado.get().getAñoFabricacion());
        assertEquals(200.0f, vehiculoEncontrado.get().getKilometraje(), 0.001);
        assertEquals("EN MISION", vehiculoEncontrado.get().getEstadoOperativo());
        assertEquals(1, vehiculoEncontrado.get().getNumeroMisiones());

        LOG.info("Finalizando test editarVehiculoExistenteDeberiaActualizarLosDatos");
    }

    @Test
    void editarVehiculoNoExistenteDeberiaRetornarMensajeDeError() {
        LOG.info("Iniciando test editarVehiculoNoExistenteDeberiaRetornarMensajeDeError");

        Batallon batallon = new Batallon("Batallón Central");
        Vehiculo vehiculoNoExistente = new VehiculoBlindado("PQR-678", "ModeloV", 2025, 800.0f, "DISPONIBLE", 0);

        String mensaje = batallon.editarVehiculo("PQR-687", vehiculoNoExistente);

        assertEquals("El vehiculo no existe", mensaje);

        LOG.info("Finalizando test editarVehiculoNoExistenteDeberiaRetornarMensajeDeError");

    }

    @Test
    void obtenerVehiculoMasMisionesDeberiaRetornarElVehiculoConMasMisiones() {
        LOG.info("Iniciando test obtenerVehiculoMasMisionesDeberiaRetornarElVehiculoConMasMisiones");

        Batallon batallon = new Batallon("Batallón Central");
        batallon.registrarVehiculo(new VehiculoBlindado("STU-901", "ModeloA", 2020, 1000.0f, "DISPONIBLE", 2));
        batallon.registrarVehiculo(new VehiculoBlindado("VWX-234", "ModeloB", 2021, 1500.0f, "EN_MISION", 5));
        batallon.registrarVehiculo(new VehiculoBlindado("YZA-567", "ModeloC", 2022, 500.0f, "DISPONIBLE", 1));

        Vehiculo vehiculoMasMisiones = batallon.vehiculoMasMisiones();

        assertNotNull(vehiculoMasMisiones);
        assertEquals("VWX-234", vehiculoMasMisiones.getId());

        LOG.info("Finalizando test obtenerVehiculoMasMisionesDeberiaRetornarElVehiculoConMasMisiones");
    }

    @Test
    void obtenerVehiculoMasMisionesDeberiaRetornarNullSiNoHayVehiculos() { 
        LOG.info("Iniciando test obtenerVehiculoMasMisionesDeberiaRetornarNullSiNoHayVehiculos");
        Batallon batallon = new Batallon("Batallon Central");
        Vehiculo vehiculoMasMisiones = batallon.vehiculoMasMisiones();

        assertNull(vehiculoMasMisiones);
        LOG.info("Finalizando test obtenerVehiculoMasMisionesDeberiaRetornarNullSiNoHayVehiculos");
    }
 }