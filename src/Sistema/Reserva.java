package Sistema;

import java.util.Calendar;

import Hotel.Habitacion;
import Hotel.Hotel;


public class Reserva {
	Hotel hotel;
	Habitacion habitacion;
	Pasajero pasajero;
	Calendar checkIn;
	Calendar checkOut;
	
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
	public Calendar getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(Calendar checkIn) {
		this.checkIn = checkIn;
	}
	public Calendar getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(Calendar checkOut) {
		this.checkOut = checkOut;
	}
	
	
	
	//Constructor
	public Reserva(Hotel hotel, Habitacion habitacion, Pasajero pasajero,
			Calendar checkIn, Calendar checkOut) {
		super();
		this.hotel = hotel;
		this.habitacion = habitacion;
		this.pasajero = pasajero;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	
	
	

}
