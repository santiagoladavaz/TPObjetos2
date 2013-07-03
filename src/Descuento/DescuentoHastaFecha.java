package Descuento;


import java.util.Calendar;

import Hotel.Estadia;

public class DescuentoHastaFecha extends Descuento {

	
	 private Calendar fechaTope;
	
	public Calendar getFechaTope() {
		return fechaTope;
	}

	public void setFechaTope(Calendar fechaTope) {
		this.fechaTope = fechaTope;
	}

	


	public DescuentoHastaFecha(int porcentaje, Calendar fechaLimiteDeReserva,Calendar fechaTope) {
		super(porcentaje, fechaLimiteDeReserva);
		this.fechaTope = fechaTope;
	}
	
	// Aplica el descuento verificando que la estadia sea antes de la fecha del checkIn del hotel
	@Override
	public float aplicarDescuento(Estadia e) {
		
		float res =0;
		
		if(getFechaTope().after(e.getCheckIn())) {
			
			res = e.getPrecio()-e.getPrecio()*this.getPorcentaje() /100;
		}
		
		else {
			res=e.getPrecio();
		}
		
		return res;
	}
	
}
