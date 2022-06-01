package ar.unrn.parcial.modelo;

import java.io.IOException;
import java.util.List;

public class Compras extends Observable implements InterfazCompras {

	public Compras(List<Observer> observadores) {
		super(observadores);
	}

	public double calcularMontoCompra(int cantidadCompra, InterfazProveedorDeFechas proveedorFechaCompra,
			Remera remeraComprada) throws IOException {
		Compra compra = new Compra(cantidadCompra, proveedorFechaCompra, remeraComprada,
				new Email("email@stubobject.com"));
		return compra.obtenerMontoCompra();
	}

	public Compra crearCompra(int cantidadCompra, InterfazProveedorDeFechas proveedorFechaCompra, Remera remeraComprada,
			String emailComprador) throws IOException {
		return new Compra(cantidadCompra, proveedorFechaCompra, remeraComprada, new Email(emailComprador));
	}

	public List<Remera> obtenerRemeras(InterfazProveedorDeFechas proveedorFechaCompra) {
		RemeraLisa rl = new RemeraLisa(proveedorFechaCompra);
		RemeraEstampada re = new RemeraEstampada(proveedorFechaCompra);
		return List.of(rl, re);
	}

	public boolean registrarCompra(int cantidadCompra, InterfazProveedorDeFechas proveedorFechaCompra,
			Remera remeraComprada, String emailComprador, RegistroDeCompras registro)
			throws IOException {
		// El mail se manda desde este m�todo o desde el registro.registrarCompra?
		Compra compra = crearCompra(cantidadCompra, proveedorFechaCompra, remeraComprada, emailComprador);
		registro.registrarCompra(compra);
		super.notificar(String.valueOf(compra.cantidadRemerasCompradas()),
		compra.datosFechaCompra(), String.valueOf(compra.obtenerMontoCompra()), compra.emailComprador());
		return true;
	}

}
