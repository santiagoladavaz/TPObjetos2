package Remate;

import Excepsiones.ElRemateNoSeInicio;
import Sistema.Pasajero;

public class SinIniciar extends Estado {

	@Override
	public void ofertar(Pasajero unPasajero, int unPrecio, Remate rem)
			throws Exception {
		throw new ElRemateNoSeInicio();
	}

	@Override
	public Pasajero anunciarGanador(Remate rem) throws Exception {
		throw new ElRemateNoSeInicio();
	}

}
