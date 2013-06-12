package Filtro;


import java.util.ArrayList;

import Sistema.Reserva;



public abstract class Filtro {

	
	
	//Filtra la lista de reservas segun las condiciones que se impongan
	public ArrayList<Reserva> aplicar(ArrayList<Reserva> reservas) {
		ArrayList<Reserva> listaRet = new ArrayList<Reserva>();
		
		for(Reserva res : reservas) {
			if(!this.cumpleCondicion(res)) {
				listaRet.add(res);
			}
		}
		return listaRet;
	}
	
	
	//Metodo hook utilizado en el template para evaluar si se cumplen las condicioness
	public abstract boolean cumpleCondicion(Reserva res);
	
	
	
	
	
}
