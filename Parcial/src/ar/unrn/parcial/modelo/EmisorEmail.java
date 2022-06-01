package ar.unrn.parcial.modelo;

public interface EmisorEmail {
	public boolean enviarCorreoConfirmacionCompra(String cantidad, String fecha, String monto, String correoDestino);
}
