package ar.unrn.parcial.modelo;

import java.io.IOException;

public class Email {
	private String correoElectronico;

	public Email(String correoElectronico) throws IOException {
		validarConstructor(correoElectronico);
		this.correoElectronico = correoElectronico;
	}

	private boolean validarConstructor(String email) throws IOException {
		if (!validarCorreo(email))
			throw new IOException("El email debe ser válido");
		return true;
	}

	private boolean validarCorreo(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}

	public String correo() {
		return correoElectronico;
	}

}
