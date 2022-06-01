package ar.unrn.parcial.main;

import java.util.List;

import ar.unrn.parcial.gui.GUICompraRemeras;
import ar.unrn.parcial.modelo.Compras;
import ar.unrn.parcial.modelo.InterfazCompras;
import ar.unrn.parcial.modelo.RegistroDeCompras;
import ar.unrn.parcial.persistencia.RegistroCompraConPipe;
import ar.unrn.parcial.servicios.EmailManager;
import ar.unrn.parcial.servicios.ProveedorFecha;

public class Main {

	public static void main(String[] args) {
		EmailManager emailSender = new EmailManager();
		RegistroDeCompras rcc = new RegistroCompraConPipe();
		ProveedorFecha proveedor = new ProveedorFecha();
		InterfazCompras compras = new Compras(List.of(emailSender));
		GUICompraRemeras gui = new GUICompraRemeras(rcc, proveedor, compras);

	}

}
