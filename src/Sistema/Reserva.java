package Sistema;
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
	
	
	
	

}
