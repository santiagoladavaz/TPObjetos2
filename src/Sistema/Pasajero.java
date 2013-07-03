package Sistema;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import Excepsiones.LaHabitacionYaEstaReservada;
import Excepsiones.NoPuedeCalificar;
import Excepsiones.NoPuedeComentar;
import Excepsiones.NoSeEncuentraEstadia;
import Hotel.Estadia;
import Hotel.Habitacion;
import Hotel.Hotel;
import Hotel.Oferta;





public class Pasajero{

//Var. De Instancia	
private String nombre;
private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
private Sistema sistema;
private String mail;
private PreferenciasPasajero preferencias;


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
public PreferenciasPasajero getPreferencias() {
	return preferencias;
}
public void setPreferencias(PreferenciasPasajero preferencias) {
	this.preferencias = preferencias;
}

//Metodos



//Método creado por Diego//Testeado
public void calificarHotel(Hotel h, int calificacion) throws NoPuedeCalificar{
	this.getSistema().calificarHotel(h,calificacion, this);
}

//Método creado por Diego//Testeado
public void comentarHotel(Hotel h, String comentario) throws NoPuedeComentar{
	this.getSistema().comentarHotel(h,comentario, this);
}


//Método creado por Diego//Testeado
public void agregarComentario(Hotel h, String comentario){

		h.getComentarios().add(comentario);
}


//Agregado por Diego//Testeado
public boolean igualPaisYCiudad(Oferta o) {
	return o.getCiudad() == this.getPreferencias().getCiudad() & o.getPais() == this.getPreferencias().getPais();
}



//Agregado por Diego//Testeado - no corre
public boolean hayEstadiaEntreFechas(Oferta o, Calendar fechaInicial, Calendar fechaFinal) {

	boolean res = false;
	
	for(Estadia e: o.getHabitacion().getEstadias()){
		if(e.getCheckIn().after(fechaInicial) & e.getCheckOut().before(fechaFinal))
		      {res = true;
		       break;}
	   }
return res;
}


//Agregado por Diego	//Testeado - no corre
public Estadia dameEstadiaEntreFechas(Oferta o, Calendar fechaInicial, Calendar fechaFinal) throws NoSeEncuentraEstadia {
	Estadia res = null;
	for(Estadia e: o.getHabitacion().getEstadias()){
		if(this.hayEstadiaEntreFechas(o, fechaInicial, fechaFinal)) {
			res = e;
		}
		else {
			throw new NoSeEncuentraEstadia();}
	         }
	return res;
}




//Agrega una reserva a su lista de reservas -Testeado
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


//Le dice al sistema que busque Hoteles segun Busqueda - Testeado
public void buscarHotelesPor(Busqueda busqueda){
	this.getSistema().buscarHotelesPor(busqueda);
}


//Oferta en el remate - Testeado
public void ofertar(Pasajero unPasajero,int unPrecio) throws Exception{
	this.getSistema().ofertar(this,unPrecio);
}

//Reserva una habitacion,antes debe buscarlas - Testeado
public void reservarHabitacion(Hotel hotel, Habitacion habitacion,Pasajero pas,Calendar in,Calendar out) throws LaHabitacionYaEstaReservada{
	this.getSistema().reservarHabitacion(hotel,habitacion,this,in,out);
}

//Ver las reservas futuras
public ArrayList<Reserva>reservasFuturas(){
	ArrayList<Reserva>res=new ArrayList<Reserva>();
	
	for(Reserva r:this.getReservas()){
		if(r.esReservaFutura())
			res.add(r);
	}
return res;
}


//ver reservas actuales
public ArrayList<Reserva>reservasActuales(){
	ArrayList<Reserva>res=new ArrayList<Reserva>();
	
	for(Reserva r:this.getReservas()){
		if(r.esReservaActual())
			res.add(r);
	}
return res;
}


//ver reseravas con NDias
public ArrayList<Reserva>reservasConNDias(int dias){
	ArrayList<Reserva>res=new ArrayList<Reserva>();
	
	for(Reserva r:this.getReservas()){
		if(r.esReservaConInicioNDias(dias))
			res.add(r);
	}
return res;
}


//Ver las reservas de una ciudad
public ArrayList<Reserva> reservasDeUnaCiudad(String ciudad){
	ArrayList<Reserva>res=new ArrayList<Reserva>();

	for(Reserva r:this.getReservas()){
		if(r.esReservaDeUnaCiudad(ciudad))
			res.add(r);}

	return res;
}



//Devuelve una lista de hoteles filtrados por ciudad
public ArrayList<Hotel> buscarHotelPorCiudad(String ciudad) {
	
	ArrayList<Hotel> res = new ArrayList<Hotel>();
	
	for(Hotel h:this.getSistema().getDescuentos()) {
		if(h.getCiudad().equals(ciudad)) {
			res.add(h.filtrarHabitaciones(h));
		}
	}
	
	return res;
}


// Busca e imprime en pantalla las habitaciones con los precios (con y sin descuento) que estan vigentes y 
// estan entre las fechas pasadas por parámetro
public void buscarHabitacionEntreFechas(Calendar f1, Calendar f2) {
	
	for(Hotel h:getSistema().getDescuentos())
	{
		h.hotelConEstadiasEntre(f1, f2);
	
	}
}

// Busca e imprime en pantalla las habitaciones con los precios (con y sin descuento) que estan vigentes y 
// son anteriores a la fecha pasada por parámetro
public void buscarHabitacionAnterioresA(Calendar f1) {
	
	for(Hotel h:getSistema().getDescuentos())
	{
		h.hotelConEstadiasAnteriorA(f1);
	
	}
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
