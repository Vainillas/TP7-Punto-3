package ar.unrn.parcial.test;

import java.io.IOException;
import java.util.List;

import ar.unrn.parcial.modelo.Compra;
import ar.unrn.parcial.modelo.EmisorEmail;
import ar.unrn.parcial.modelo.InterfazCompras;
import ar.unrn.parcial.modelo.InterfazProveedorDeFechas;
import ar.unrn.parcial.modelo.RegistroDeCompras;
import ar.unrn.parcial.modelo.Remera;

public class StubObjectCompras implements InterfazCompras {

	@Override
	public double calcularMontoCompra(int cantidadCompra, InterfazProveedorDeFechas proveedorFechaCompra,
			Remera remeraComprada) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Compra crearCompra(int cantidadCompra, InterfazProveedorDeFechas proveedorFechaCompra, Remera remeraComprada,
			String emailComprador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Remera> obtenerRemeras(InterfazProveedorDeFechas proveedorFechaCompra) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean registrarCompra(int cantidadCompra, InterfazProveedorDeFechas proveedorFechaCompra,
			Remera remeraComprada, String emailComprador, RegistroDeCompras registro, EmisorEmail emailSender)
			throws IOException {
		// TODO Auto-generated method stub
		return false;
	}

}
