package Descuento;

import java.util.Calendar;

import Hotel.Estadia;

public  abstract class Descuento {

	private int porcentaje;
	private Calendar fechaLimiteDeReserva;
	
	//Getters & Setters
	public int getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Calendar getFechaLimiteDeReserva() {
		return fechaLimiteDeReserva;
	}

	public void setFechaLimiteDeReserva(Calendar fechaLimiteDeReserva) {
		this.fechaLimiteDeReserva = fechaLimiteDeReserva;
	}

	public Descuento(int porcentaje, Calendar fechaLimiteDeReserva) {
		super();
		this.porcentaje = porcentaje;
		this.fechaLimiteDeReserva = fechaLimiteDeReserva;
	}


	//Metodos
	public float aplicarDescuento(Estadia e) {
		return 0;
	}
}
