package ar.unrn.parcial.test;

import java.io.IOException;

import ar.unrn.parcial.modelo.Compra;
import ar.unrn.parcial.modelo.RegistroDeCompras;

public class StubObjectRegistro implements RegistroDeCompras {

	public boolean registrarCompra(Compra compra) throws IOException {
		return true;
	}

	public boolean informarCompra(Compra compra) {
		return true;
	}

}
