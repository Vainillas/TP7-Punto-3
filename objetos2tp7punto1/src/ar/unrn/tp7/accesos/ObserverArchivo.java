package ar.unrn.tp7.accesos;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import ar.unrn.tp7.modelo.Observer;

public class ObserverArchivo implements Observer {

	private String pathArchivo;

	@Override
	public void actualizar(String temperatura) {

		try {
			FileWriter escritorArchivo = new FileWriter("C:\\Users\\maliberti\\Downloads\\Temperaturas.txt",
					true);
			escritorArchivo.write(temperatura + "�, Fecha de Realizacion: " + LocalDate.now() + "\r\n");
			escritorArchivo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
