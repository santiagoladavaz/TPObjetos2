package Remate;

import java.util.Calendar;

import Hotel.Habitacion;
import Sistema.Pasajero;

public class Remate {
	Habitacion h;
	int precio;
	Calendar fechaInicio;
	Calendar fechaFin;
	Estado estado;
	Pasajero posibleGanador;
	
	
	//Constructor
	public Remate(Habitacion h, int precio, Calendar fechaInicio,
			Calendar fechaFin, Estado estado, Pasajero posibleGanador) {
		this.h = h;
		this.precio = precio;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
		this.posibleGanador = posibleGanador;
	}


	//Getters y Setters
	
	public Habitacion getH() {
		return h;
	}


	public void setH(Habitacion h) {
		this.h = h;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public Calendar getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(Calendar fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public Calendar getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(Calendar fechaFin) {
		this.fechaFin = fechaFin;
	}


	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	public Pasajero getPosibleGanador() {
		return posibleGanador;
	}


	public void setPosibleGanador(Pasajero posibleGanador) {
		this.posibleGanador = posibleGanador;
	}

/////////////////////////////////////////////////
	
	
	//Le dice a su estado que oferte
	public void ofertar(Pasajero unPasajero,int unPrecio,Remate rem) throws Exception{
		this.getEstado().ofertar(unPasajero,unPrecio,this);
	}


	
	
	//Si la fecha es de hoy es igual a la fecha de cierre del remate,este se finaliza
	public void finalizarRemate(){
		Calendar fechaActual = Calendar.getInstance();
		if(fechaActual.equals(this.getFechaFin())){
			this.setEstado(new Finalizada());
		}
	}	
	
	


	//Si la fecha es de hoy es igual a la fecha de incio del remate,este se inicia
	public void IniciarRemate(){
	  Calendar fechaActual = Calendar.getInstance();
		if(fechaActual.equals(this.getFechaInicio())){
			this.setEstado(new EnCurso());
		}
	}
	
	
	//Toma si estado y le pregunta por el ganador,solo lo dara si el Remate finalizo
	public Pasajero anunciarGanador(Remate rem) throws Exception{
		return this.getEstado().anunciarGanador(this);
	}
	
	
	
}
