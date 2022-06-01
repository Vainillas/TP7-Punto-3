package ar.unrn.parcial.persistencia;

import java.io.FileWriter;
import java.io.IOException;

import ar.unrn.parcial.modelo.Compra;
import ar.unrn.parcial.modelo.RegistroDeCompras;

public class RegistroCompraConPipe implements RegistroDeCompras {
	private String pathArchivo;

	public RegistroCompraConPipe() {
		this.pathArchivo = "C:\\Users\\maliberti\\Downloads\\RegistroDeCompraDeRemerasConPipe.txt";

	}

	public boolean registrarCompra(Compra compra) throws IOException {
		FileWriter escritorArchivo = new FileWriter(pathArchivo, true);
		escritorArchivo.write(compra.datosFechaCompra() + "|" + compra.cantidadRemerasCompradas() + "|"
				+ compra.obtenerMontoCompra() + "\r\n");
		escritorArchivo.close();
		return true;
	}

}
