package Sistema;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Observable;
import java.util.Set;
import Excepsiones.LaHabitacionYaEstaReservada;
import Excepsiones.NoPuedeCalificar;
import Excepsiones.NoPuedeComentar;
import Excepsiones.NoSeEncuentraEstadia;
import Hotel.Estadia;
import Hotel.Habitacion;
import Hotel.Hotel;
import Hotel.Oferta;

import java.util.Observer;



public class Pasajero implements Observer{

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



public void mandarMail()
{
	System.out.println("Llego una nueva oferta");
}


//Agregado por Diego
@Override
public void update(Observable o, Object arg) {
	
	Oferta oferta = (Oferta)arg;
	
	if(hayEstadiaEntreFechas(oferta, this.getPreferencias().getFechaInicio(), this.getPreferencias().getFechaFin())) {
		try {
			Estadia e = this.dameEstadiaEntreFechas(oferta, this.getPreferencias().getFechaInicio(), this.getPreferencias().getFechaFin());
			// Pregunta si el precio de la estadia es menor o igual al precio que está dispuesto
			// pagar el Pasajero
			if(e.getPrecio() <= this.getPreferencias().getPrecioMenor()) {
				this.mandarMail();
			}
			else {
				// Pregunta si el precio de la estadia es mayor al mínimo que pretende pagar
				if(e.getPrecio() >= this.getPreferencias().getPrecioMayor()) {
					this.mandarMail();
				}
				else {
					if(e.getPrecio()<=this.getPreferencias().getPrecioMaximo() & e.getPrecio()>=this.getPreferencias().getPrecioMinimo()) {
						mandarMail();
					}
				}
			}
		}catch (NoSeEncuentraEstadia e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
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

public void verReservasFuturas(){
	this.getSistema().verReservasFuturas(this.getReservas());
}

public void verTodasLasReservas(){
	this.getReservas();}


public void verReservasDeUnaCiudad(String ciudad){
	this.getSistema().verReservasDeUnaCiudad(this.getReservas(),ciudad);
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
