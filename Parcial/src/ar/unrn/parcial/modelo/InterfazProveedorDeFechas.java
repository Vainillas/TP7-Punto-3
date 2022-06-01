package ar.unrn.parcial.modelo;

public interface InterfazProveedorDeFechas {
	public boolean esDomingo();

	public boolean esSabado();

	public boolean esTemprano();

	public String fecha();

}
