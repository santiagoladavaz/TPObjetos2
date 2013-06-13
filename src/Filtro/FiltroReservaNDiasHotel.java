package Filtro;


import java.util.Calendar;

import Sistema.Reserva;





public class FiltroReservaNDiasHotel extends Filtro{

	int nDias;

	public int getnDias() {
		return nDias;
	}

	public void setnDias(int nDias) {
		this.nDias = nDias;
	}

	@Override
	public boolean cumpleCondicion(Reserva res) {
	 Calendar fechaActual=Calendar.getInstance();
	 fechaActual.add(Calendar.DATE,this.getnDias());
	 return res.getEstadia().getCheckIn().equals(fechaActual);	
		
	}
	
	
	
	
}
