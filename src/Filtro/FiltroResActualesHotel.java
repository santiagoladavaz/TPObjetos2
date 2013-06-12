package Filtro;


import java.util.Calendar;

import Sistema.Reserva;





public class FiltroResActualesHotel extends Filtro {
	
	//Se fija que la fecha actual este comprendida entre la fecha de entrada y salida del hotel
	public boolean cumpleCondicion(Reserva res) {
		Calendar fechaActual=Calendar.getInstance();
		return  fechaActual.after(res.getCheckIn()) | fechaActual.before(res.getCheckOut());
	}

}
