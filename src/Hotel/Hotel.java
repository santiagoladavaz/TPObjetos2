package Hotel;

import java.util.ArrayList;

import Sistema.Busqueda;
import Sistema.Reserva;



public class Hotel {
	public ArrayList<Habitacion>habitaciones=new ArrayList<Habitacion>();
	ArrayList<Reserva>reservas=new ArrayList<Reserva>();
	Servicio servicios;
	String nombre;
	String pais;
	public String ciudad;
	String direccion;
	int telefono;
	String email;
	
	//Getters & Setters
	public ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}
	public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}
	public ArrayList<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
	}
	public Servicio getServicios() {
		return servicios;
	}
	public void setServicios(Servicio servicios) {
		this.servicios = servicios;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	//////////
	//Mensajes
	/////////
	
	//Dado un destino me dice si es igual al del Hotel
	public boolean igualDestino(String unDestino){
		return this.getCiudad().equals(unDestino);
	}
	
	//Metodo principal que busca habitaciones que coincidan con la busqueda
	public ArrayList<Habitacion>cumpleTodasCondiciones(Busqueda busqueda){
		ArrayList<Habitacion>res =new ArrayList<Habitacion>();
		if(this.igualDestino(busqueda.getUnDestino())){
			for(Habitacion hab:this.getHabitaciones()){
				if(hab.cumpleCondiciones(busqueda)){
					res.add(hab);
				  }
	          }
	      }
		return res;
	}
		
	
	//Metodo que sirve para saber si en el hotel hay alguna habitacion que cumpla con la busqueda
	public boolean cumpleCondicionHotel(Busqueda busqueda){
		return this.cumpleTodasCondiciones(busqueda).size()>0;
		}
	
	//Dado uno Hotel me dice es el mismo
	public boolean mismoHotel(Hotel hotel){
		return hotel.equals(this);
	}
	
	
	//Dada una Habitacion me dice si es "mia"
	public boolean mismaHabitacion(Habitacion h){
		boolean res=false;
	for(Habitacion hab:this.getHabitaciones())
		if(hab.equals(h))
			res=true;
	return res;
  }
	
	//Agrega una Reserva a su Lista de Reservas
	public void agregarReserva(Reserva res){
		this.getReservas().add(res);
	}
}

	
	


