package ar.unrn.parcial.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import ar.unrn.parcial.modelo.Compra;
import ar.unrn.parcial.modelo.Compras;
import ar.unrn.parcial.modelo.InterfazCompras;
import ar.unrn.parcial.modelo.InterfazProveedorDeFechas;
import ar.unrn.parcial.modelo.Remera;
import ar.unrn.parcial.modelo.RemeraEstampada;
import ar.unrn.parcial.modelo.RemeraLisa;

public class TestCompraDeRemeras {
	private InterfazCompras administradorCompras = new Compras();

	@Test
	public void CompraDeRemerasLisaTest() throws IOException {
		// Inicialización
		InterfazProveedorDeFechas proveedor = new StubObjectFechas(2022, 5, 7, 10, 30);
		Remera rl = new RemeraLisa(proveedor);
		Compra compra = administradorCompras.crearCompra(4, proveedor, rl, "stubobject@gmail.com");

		// Ejercitación
		String info = compra.obtenerDatosCompra();
		double montoCompra = administradorCompras.calcularMontoCompra(4, proveedor, rl);
		// Verificación
		assertEquals("Fecha de Compra: " + "07/05/2022-10:30" + " Cantidad de remeras compradas: " + 4
				+ " Monto total: " + 8000.0, info);
		assertEquals(8000.0, montoCompra);

	}

	@Test
	public void CompraDeRemerasLisaConDescuentoTest() throws IOException {
		// Inicialización
		InterfazProveedorDeFechas proveedor = new StubObjectFechas(2022, 5, 7, 9, 30);
		Remera rl = new RemeraLisa(proveedor);
		Compra compra = administradorCompras.crearCompra(4, proveedor, rl, "stubobject@gmail.com");
		// Ejercitación
		String info = compra.obtenerDatosCompra();
		double montoCompra = administradorCompras.calcularMontoCompra(4, proveedor, rl);
		// Verificación
		assertEquals("Fecha de Compra: " + "07/05/2022-09:30" + " Cantidad de remeras compradas: " + 4
				+ " Monto total: " + 7600.0, info);
		assertEquals(7600.0, montoCompra);
	}

	@Test
	public void CompraDeRemerasEstampadasTest() throws IOException {
		// Inicialización
		InterfazProveedorDeFechas proveedor = new StubObjectFechas(2022, 5, 5, 9, 30);
		Remera rl = new RemeraEstampada(proveedor);
		Compra compra = administradorCompras.crearCompra(4, proveedor, rl, "stubobject@gmail.com");
		// Ejercitación
		String info = compra.obtenerDatosCompra();
		double montoCompra = administradorCompras.calcularMontoCompra(4, proveedor, rl);
		// Verificación
		assertEquals("Fecha de Compra: " + "05/05/2022-09:30" + " Cantidad de remeras compradas: " + 4
				+ " Monto total: " + 10000.0, info);
		assertEquals(10000.0, montoCompra);

	}

	@Test
	public void CompraDeRemerasEstampadasEnCantidadConDescuentoTest() throws IOException {
		// Inicialización
		InterfazProveedorDeFechas proveedor = new StubObjectFechas(2022, 5, 7, 9, 30);
		Remera rl = new RemeraEstampada(proveedor);
		Compra compra = administradorCompras.crearCompra(4, proveedor, rl, "stubobject@gmail.com");
		// Ejercitación
		String info = compra.obtenerDatosCompra();
		double montoCompra = administradorCompras.calcularMontoCompra(4, proveedor, rl);
		// Verificación
		assertEquals("Fecha de Compra: " + "07/05/2022-09:30" + " Cantidad de remeras compradas: " + 4
				+ " Monto total: " + 8800.0, info);
		assertEquals(8800.0, montoCompra);
	}

	@Test
	public void CompraDeRemerasConEmailInvalidoTest() throws IOException {
		// Inicialización
		InterfazProveedorDeFechas proveedor = new StubObjectFechas(2022, 5, 7, 9, 30);
		Remera rl = new RemeraEstampada(proveedor);
		// Ejercitación

		try {
			Compra compra = administradorCompras.crearCompra(4, proveedor, rl, "formatoDeEmailIncorrecto!");
			String info = compra.obtenerDatosCompra();
			assertEquals("Fecha de Compra: " + "07/05/2022-09:30" + " Cantidad de remeras compradas: " + 4
					+ " Monto total: " + 8800.0, info);
			Assert.fail();
		} catch (Exception e) {
			String mensajeError = "El email debe ser válido";
			assertEquals(mensajeError, e.getMessage());
		}

	}

}
