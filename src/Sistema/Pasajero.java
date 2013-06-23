package Sistema;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import Excepsiones.LaHabitacionYaEstaReservada;
import Hotel.Habitacion;
import Hotel.Hotel;



public class Pasajero {

//Var. De Instancia	
private String nombre;
private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
private Sistema sistema;
private String mail;

//Getteres Y Setters
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public ArrayList<Reserva> getReservas() {
	return reservas;
}
public void setReservas(ArrayList<Reserva> reservas) {
	this.reservas = reservas;
}
public Sistema getSistema() {
	return sistema;
}
public void setSistema(Sistema sistema) {
	this.sistema = sistema;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}


//Metodos



//Método creado por Diego << Verifica después si hace lo que tendría que hacer
public boolean puedeCalificarYComentarAHotel(Hotel unHotel) {
	
	boolean res = false;
	
	for(Reserva r:this.getReservas())
	{
		// Esto supuestamente se fija si la fecha del check-out es anterior a la del check-out
		if(r.getHotel().equals(unHotel) & r.getEstadia().getCheckOut().before(Calendar.getInstance()) )
		{
			res = true;
			break;
		}
		// Te parece tirar una excepción aca que diga que no puede calificar un hotel en el cual no haya estado
		// o que la fecha del check-out sea posterior a la fecha actual
	
	}
	return res;
}







//Agrega una reserva a su lista de reservas
public void agregarReserva(Reserva res){
	this.getReservas().add(res);
}


//Aca porque no me entra en el template de Filtro
public Set<String> verCiudadesConReservas()
{
	Set<String> ciudades = new HashSet<String>();
	
	for(Reserva r: this.getReservas())
	{
		ciudades.add(r.getHotel().getCiudad());
	}
	
	return ciudades;
}


//Le dice al sistema que busque Hoteles segun Busqueda
public void buscarHotelesPor(Busqueda busqueda){
	this.getSistema().buscarHotelesPor(busqueda);
}


//Oferta en el remate
public void ofertar(Pasajero unPasajero,int unPrecio) throws Exception{
	this.getSistema().ofertar(this,unPrecio);
}

//Reserva una habitacion,antes debe buscarlas
public void reservarHabitacion(Hotel hotel, Habitacion habitacion,Pasajero pas,Calendar in,Calendar out) throws LaHabitacionYaEstaReservada{
	this.getSistema().reservarHabitacion(hotel,habitacion,this,in,out);
}


//Constructor
public Pasajero(String nombre, ArrayList<Reserva> reservas, Sistema sistema,
		String mail) {
	super();
	this.nombre = nombre;
	this.reservas = reservas;
	this.sistema = sistema;
	this.mail = mail;
}




}
