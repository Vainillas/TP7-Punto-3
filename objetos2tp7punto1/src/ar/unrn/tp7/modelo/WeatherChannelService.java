package ar.unrn.tp7.modelo;

import java.util.Random;

public class WeatherChannelService implements ClimaOnline {
	@Override
	public String temperatura() {
		int temp = new Random().nextInt(32);
		return temp + " c";
	}
}
