package ar.unrn.parcial.test;

import ar.unrn.parcial.modelo.EmisorEmail;

public class StubObjectEmail implements EmisorEmail {

	@Override
	public boolean enviarCorreoConfirmacionCompra(String cantidad, String fecha, String monto, String correoDestino) {

		return true;
	}

}
