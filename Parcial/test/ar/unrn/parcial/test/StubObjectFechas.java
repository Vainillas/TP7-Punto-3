package ar.unrn.parcial.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import ar.unrn.parcial.modelo.InterfazProveedorDeFechas;

public class StubObjectFechas implements InterfazProveedorDeFechas {
	private LocalDateTime fecha;
	private LocalDateTime horarioInicioMa�ana;
	private LocalDateTime horarioFinMa�ana;
	private DateTimeFormatter formato;

	public StubObjectFechas(int a�o, int mes, int dia, int hora, int minuto) {
		formato = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm");
		fecha = obtenerFecha(a�o, mes, dia, hora, minuto);
		horarioInicioMa�ana = obtenerFecha(a�o, mes, dia, 8, 0);
		horarioFinMa�ana = obtenerFecha(a�o, mes, dia, 10, 0);

	}

	private StubObjectFechas(LocalDateTime fecha) {
		this(fecha.getYear(), fecha.getMonth().getValue(), fecha.getDayOfMonth(), fecha.getHour(), fecha.getMinute());
	}

	public StubObjectFechas() {
		this(LocalDateTime.now());
	}

	private LocalDateTime obtenerFecha(int a�o, int mes, int dia, int hora, int minuto) {
		return LocalDateTime.of(a�o, mes, dia, hora, minuto);
	}

	private LocalDateTime obtenerFecha() {
		return fecha;
	}

	public boolean esDomingo() {// codigo duplicado
		boolean esDomingo = false;
		if (fecha.getDayOfWeek().getValue() == 7)
			esDomingo = true;
		return esDomingo;
	}

	public boolean esSabado() { // codigo duplicado
		boolean esSabado = false;
		if (fecha.getDayOfWeek().getValue() == 6)
			esSabado = true;
		return esSabado;
	}

	public boolean esTemprano() { // codigo duplicado
		boolean esTemprano = false;
		if ((fecha.isAfter(horarioInicioMa�ana) || fecha.isEqual(horarioInicioMa�ana))
				&& (fecha.isBefore(horarioFinMa�ana) || fecha.isEqual(horarioFinMa�ana)))
			esTemprano = true;
		return esTemprano;
	}

	public String fecha() {
		return fecha.format(formato);
	}
}
