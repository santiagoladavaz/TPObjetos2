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
		System.out.println(this.getCheckIn().equals(checkIn));
		return this.getCheckIn().equals(checkIn);
	}
	
	public boolean cumpleCheckOut(Calendar checkOut){
		return this.getCheckOut().equals(checkOut);
	}
	
	
	public static void main(String[] args) {
		Estadia estadia=new Estadia();
		Calendar in= Calendar.getInstance();
		Calendar out= Calendar.getInstance();
		in.set(Calendar.DAY_OF_MONTH,29);
		in.set(Calendar.MONTH,5);
		in.set(Calendar.YEAR,2013);
		out.set(Calendar.DAY_OF_MONTH,2);
		out.set(Calendar.MONTH,6);
		out.set(Calendar.YEAR,2013);
		estadia.setCheckIn(in);
		estadia.setCheckOut(out);
		estadia.cumpleCheckIn(in);
	}
	
	
}
