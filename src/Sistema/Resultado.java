package Sistema;

import java.util.ArrayList;

import Hotel.Habitacion;
import Hotel.Hotel;

public class Resultado {
	Hotel hotel;
	ArrayList<Habitacion>habitaciones=new ArrayList<Habitacion>();
	
	//Getters & Setters
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}
	public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}
	
	
	//Constructor
	public Resultado(Hotel hotel, ArrayList<Habitacion> habitaciones) {
		super();
		this.hotel = hotel;
		this.habitaciones = habitaciones;
	}
	

	
	
	
	
}
