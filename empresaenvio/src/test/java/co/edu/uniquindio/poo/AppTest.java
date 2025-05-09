/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2023-08
 *
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.Model.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    /**
     * Rigorous Test :-)
     */
    @Test
    public void testCalcularEnvioCostoCamion() {
        LOG.info("Iniciado test calcular envio costo camion");

        Cliente cliente = new Cliente("Juan Perez", "12345", "juan@example.com", "Calle 123");
        Vehiculo camion = new Camion("ABC-123", "Mazda", "WW", 6000);
        Ruta ruta = new Ruta(3, 42);
        Envio envio = new Envio("123456", ZonaEntrega.URBANA, LocalDate.of(2023, 11, 20), cliente, camion, ruta);

        envio.agregarPaquete("12345", 16);
        envio.agregarPaquete("54368", 40);

        double costoPeajes = ruta.getNumeroPeajes() * 12000;
        double costoPeso = (16 + 40) * 7000;
        double costoEsperado = costoPeajes + costoPeso;

        double costoMetodo = envio.calcularCostoEnvio();

        assertEquals(costoEsperado, costoMetodo, 0.001);
        LOG.info("Finalizando test calcular envio costo camion");
    }

    @Test
    public void calcularEnvioCostoMoto() {
        LOG.info("Iniciando Test moto calcular envio");

        Cliente cliente = new Cliente("Maria Gomez", "67890", "maria@example.com", "Avenida 456");
        Vehiculo moto = new Motocicleta("RRR-222", "Susuki", "Ninja", 600);
        Ruta ruta = new Ruta(2, 100);
        Envio envio = new Envio("120394", ZonaEntrega.URBANA, LocalDate.of(2025, 6, 22), cliente, moto, ruta);

        envio.agregarPaquete("9393993", 2);
        envio.agregarPaquete("239499", 5);
        envio.agregarPaquete("029349", 1);

        double costoEsperado = 8000 * 3;

        double costoMetodo = envio.calcularCostoEnvio();

        assertEquals(costoEsperado, costoMetodo, 0.001);
        LOG.info("Finalizando test calcular envio costo moto");
    }

    @Test
    public void calcularEnvioCostoFurgoneta() {
        LOG.info("Iniciando de test furgoneta");

        Cliente cliente = new Cliente("Carlos Rodriguez", "13579", "carlos@example.com", "Carrera 789");
        Vehiculo furgoneta = new Furgoneta("ADF-366", "Volkswagen", "AE", Transmision.AUTOMATICA);
        Ruta ruta = new Ruta(5, 80);
        Envio envio = new Envio("30948143", ZonaEntrega.RURAL, LocalDate.of(2025, 7, 22), cliente, furgoneta, ruta);

        envio.agregarPaquete("20943204", 20);
        envio.agregarPaquete("2984934", 5);
        envio.agregarPaquete("9494949", 8);
        envio.agregarPaquete("1029324", 11);

        double costoEsperado = 10000;

        double costoMetodo = envio.calcularCostoEnvio();

        assertEquals(costoEsperado, costoMetodo, 0.001);
        LOG.info("Finalizando test furgoneta");
    }

    @Test
    public void obtenerEnviosPesoMayor50() {
        LOG.info("Iniciando test obtener envios peso mayor 50");

        EmpresaEnvio empresaEnvio = new EmpresaEnvio("Envio Rapido", "123456789", "Cra 14#10N-63");

        Cliente cliente1 = new Cliente("Ana Martinez", "24680", "ana@example.com", "Transversal 12");
        Cliente cliente2 = new Cliente("Pedro Lopez", "98765", "pedro@example.com", "Diagonal 34");
        Vehiculo camion1 = new Camion("DEF-456", "Ford", "XYZ", 8000);
        Vehiculo moto1 = new Motocicleta("GHI-789", "Yamaha", "ABC", 200);
        Ruta ruta1 = new Ruta(1, 35);
        Ruta ruta2 = new Ruta(0, 10);

        Envio envio1 = new Envio("ENV-001", ZonaEntrega.RURAL, LocalDate.of(2025, 5, 12), cliente1, camion1, ruta1);
        envio1.agregarPaquete("PAQ-001", 32);
        envio1.agregarPaquete("PAQ-002", 28);

        Envio envio2 = new Envio("ENV-002", ZonaEntrega.URBANA, LocalDate.of(2026, 7, 11), cliente2, moto1, ruta2);
        envio2.agregarPaquete("PAQ-003", 2);
        envio2.agregarPaquete("PAQ-004", 28);

        Envio envio3 = new Envio("ENV-003", ZonaEntrega.RURAL, LocalDate.of(2025, 6, 4), cliente1, camion1, ruta1);
        envio3.agregarPaquete("PAQ-005", 32);
        envio3.agregarPaquete("PAQ-006", 18);

        empresaEnvio.agregarEnvio(envio1.getCodigoEnvio(), cliente1, camion1, ruta1, envio1.getZonaEntrega(),
                envio1.getFechaEnvio());
        empresaEnvio.agregarEnvio(envio2.getCodigoEnvio(), cliente2, moto1, ruta2, envio2.getZonaEntrega(),
                envio2.getFechaEnvio());
        empresaEnvio.agregarEnvio(envio3.getCodigoEnvio(), cliente1, camion1, ruta1, envio3.getZonaEntrega(),
                envio3.getFechaEnvio());

        List<Envio> listaTestResul = new ArrayList<>();
        listaTestResul.add(envio1);
        listaTestResul.add(envio3);

        List<Envio> listaEnvioss = new ArrayList<>();
        for (Envio envio : empresaEnvio.getEnvios()) {
            double pesoTotal = 0;
            for (Paquete paquete : envio.getPaquetes()) {
                pesoTotal += paquete.getPeso();
            }
            if (pesoTotal > 50) {
                listaEnvioss.add(envio);
            }
        }

        assertEquals(listaTestResul, listaEnvioss);
        LOG.info("Finalizando test obtener envios peso mayor 50");
    }
}