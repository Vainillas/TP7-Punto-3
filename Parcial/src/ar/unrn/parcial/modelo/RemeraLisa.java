package ar.unrn.parcial.modelo;

public class RemeraLisa implements Remera {
	private final String tipo = "Lisa";
	private final double precio = 2000;
	private final double PORCENTAJE_DESCUENTO_MAÑANA = 0.05;
	private InterfazProveedorDeFechas proveedorFechaCompra;

	public RemeraLisa(InterfazProveedorDeFechas proveedorFechaCompra) {
		this.proveedorFechaCompra = proveedorFechaCompra;
	}

	public double calcularCostoUnitario(int cantidad) {
		return precio - precio * obtenerDescuento(cantidad);
	}

	private double obtenerDescuento(int cantidad) {
		if (proveedorFechaCompra.esTemprano())
			return PORCENTAJE_DESCUENTO_MAÑANA;
		return 0;
	}

	public double calcularCosto(int cantidad) {
		return calcularCostoUnitario(cantidad) * cantidad;
	}

	public String tipoRemera() {
		return tipo;
	}
}
