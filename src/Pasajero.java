import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

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
public ArrayList<Reserva> reservasFuturas(){
	ArrayList<Reserva>res=new ArrayList<Reserva>();
    
	Calendar fechaActual=Calendar.getInstance();
	
	for(Reserva r:this.getReservas()){
		if(r.getFechaReserva().after(fechaActual)){
			res.add(r);
		}
	}
	return res;
}


public ArrayList<Reserva> reservasDe(String unaCiudad)
{
	ArrayList<Reserva> res = new ArrayList<Reserva>();
	
	for(Reserva r:this.getReservas())
	{
		if(r.getHotel().getCiudad().equals(unaCiudad))
		{
			res.add(r);
		}
	}
	return res;
}


public Set<String> verCiudadesConReservas()
{
	Set<String> ciudades = new HashSet<String>();
	
	for(Reserva r: this.getReservas())
	{
		ciudades.add(r.getHotel().getCiudad());
	}
	
	return ciudades;
}



public void buscarHotelesPor(Busqueda busqueda){
	this.getSistema().buscarHotelesPor(busqueda);
}

public void ofertar(Pasajero unPasajero,int unPrecio) throws Exception{
	this.getSistema().ofertar(this,unPrecio);
}


public void reservarHabitacion(Hotel hotel, int nroHabitacion){
	this.getSistema().reservarHabitacion(hotel,nroHabitacion);
}


}
