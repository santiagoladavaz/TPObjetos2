package Sistema;
import java.util.Calendar;

import Hotel.Estadia;
import Hotel.Habitacion;
import Hotel.Hotel;


public class Reserva {
	Hotel hotel;
	Habitacion habitacion;
	Pasajero pasajero;
	Estadia estadia;
	
	//Getters & Setters
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public Habitacion getHabitacion() {
		return habitacion;
	}
	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
	public Pasajero getPasajero() {
		return pasajero;
	}
	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}

	public Estadia getEstadia() {
		return estadia;
	}
	public void setEstadia(Estadia estadia) {
		this.estadia = estadia;
	}
	
	
	//Constructor
	public Reserva(Hotel hotel, Habitacion habitacion, Pasajero pasajero,
			Estadia estadia) {
		super();
		this.hotel = hotel;
		this.habitacion = habitacion;
		this.pasajero = pasajero;
		this.estadia=estadia;
	}
	
	
	public boolean esReservaActual(){
		Calendar fechaActual=Calendar.getInstance();
		Calendar inicio=this.getEstadia().getCheckIn();
		Calendar fin=this.getEstadia().getCheckOut();
		return  fechaActual.after(inicio) & fechaActual.before(fin);
	}
	
	public boolean esReservaFutura(){
		Calendar fechaActual=Calendar.getInstance();
		return this.getEstadia().getCheckIn().after(fechaActual);
	}
	
	
	public boolean esReservaConInicioNDias(int dias){
		Calendar fechaActual=Calendar.getInstance();
		fechaActual.add(Calendar.DATE,dias);
		return this.getEstadia().getCheckIn().equals(fechaActual);	
	}

	public boolean esReservaDeUnaCiudad(String ciudad){
		return this.getHotel().getCiudad().equals(ciudad);
	}
	
}
