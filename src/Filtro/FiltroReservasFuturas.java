package Filtro;


import java.util.Calendar;

import Sistema.Reserva;





public class FiltroReservasFuturas extends Filtro{

	@Override
	//Se fija que la fecha de checkIn sea posterior a la actual
	public boolean cumpleCondicion(Reserva res) {
		Calendar fechaActual=Calendar.getInstance();
		return res.getCheckIn().after(fechaActual);
	}
	
	
}
