package Hotel;

import java.util.Calendar;

public class Estadia {

	Calendar checkIn;
	Calendar checkOut;
	int precio;
	
	//Getters and Setters
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
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	
	//Metodos
	
	public boolean cumpleCheckIn(Calendar checkIn){
		return this.getCheckIn().equals(checkIn);
	}
	
	public boolean cumpleCheckOut(Calendar checkOut){
		return this.getCheckOut().equals(checkOut);
	}
	
	
	//Constructor
	public Estadia(Calendar checkIn, Calendar checkOut, int precio) {
		super();
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.precio = precio;
	}
	
	
}
