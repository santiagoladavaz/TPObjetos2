package Filtro;


import java.util.Calendar;

import Hotel.Estadia;
import Sistema.Reserva;





public class FiltroResActualesHotel extends Filtro {
	
	//Busca aquellas reservas donde los pasajeros están en el hotel actualmente. 
	public boolean cumpleCondicion(Reserva res) {
		Calendar fechaActual=Calendar.getInstance();
		Calendar inicio=res.getEstadia().getCheckIn();
		Calendar fin=res.getEstadia().getCheckOut();
		return  fechaActual.after(inicio) & fechaActual.before(fin);
	}

	public static void main(String[] args) {
		Calendar inicio= Calendar.getInstance();
		Calendar fin= Calendar.getInstance();
		
		inicio.set(Calendar.DAY_OF_MONTH,20);
		inicio.set(Calendar.MONTH,6);
		inicio.set(Calendar.YEAR,2013);
		
		fin.set(Calendar.DAY_OF_MONTH,27);
		fin.set(Calendar.MONTH,6);
		fin.set(Calendar.YEAR,2013);
		
		Estadia estadia=new Estadia(inicio, fin, 0, null);
		Reserva res=new Reserva(null,null,null, estadia);
		
		FiltroResActualesHotel filtro= new FiltroResActualesHotel();
		System.out.println(filtro.cumpleCondicion(res));
	}
	
}


