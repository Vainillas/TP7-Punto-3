package ar.unrn.parcial.modelo;

public interface Remera {
	public double calcularCostoUnitario(int cantidad);

	public double calcularCosto(int cantidad);

	public String tipoRemera();
}
