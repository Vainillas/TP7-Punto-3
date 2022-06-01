package ar.unrn.parcial.modelo;

public class RemeraEstampada implements Remera {
	private final String tipo = "Estampada";
	private final double precio = 2500;
	private final double PORCENTAJE_DESCUENTO_DOMINGO = 0.10;
	private final double PORCENTAJE_DESCUENTO_SABADO = 0.12;

	private InterfazProveedorDeFechas proveedorFechaCompra;

	public RemeraEstampada(InterfazProveedorDeFechas proveedorFechaCompra) {
		this.proveedorFechaCompra = proveedorFechaCompra;
	}

	public double calcularCostoUnitario(int cantidad) {
		return precio - precio * obtenerDescuento(cantidad);
	}

	private double obtenerDescuento(int cantidad) {
		if (proveedorFechaCompra.esDomingo())
			return PORCENTAJE_DESCUENTO_DOMINGO;
		if (proveedorFechaCompra.esSabado() && cantidad > 3)
			return PORCENTAJE_DESCUENTO_SABADO;
		return 0;
	}

	public double calcularCosto(int cantidad) {
		return calcularCostoUnitario(cantidad) * cantidad;
	}

	public String tipoRemera() {
		return tipo;
	}
}
