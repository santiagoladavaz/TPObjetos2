package Hotel;

import java.util.ArrayList;

import Sistema.Busqueda;
import Sistema.Reserva;

	

public class Hotel {

	public ArrayList<Habitacion>habitaciones=new ArrayList<Habitacion>();
	ArrayList<Reserva>reservas=new ArrayList<Reserva>();
	ArrayList<Servicio> servicios =new ArrayList<Servicio> (); // Modificado por Diego
	String nombre;
	String pais;
	public String ciudad;
	int categoria; // Agregado por Diego
	String direccion;
	int telefono;
	String email;
	ArrayList<String> comentarios = new ArrayList<String>(); // Agregado por Diego
	ArrayList<Integer> calificaciones = new ArrayList<Integer>(); // Agregado por Diego
	
	//Constructor
	public Hotel(ArrayList<Habitacion> habitaciones,
			ArrayList<Reserva> reservas, ArrayList<Servicio> servicios,
			String nombre, String pais, String ciudad, int categoria,
			String direccion, int telefono, String email,
			ArrayList<String> comentarios, ArrayList<Integer> calificaciones) {
		super();
		this.habitaciones = habitaciones;
		this.reservas = reservas;
		this.servicios = servicios;
		this.nombre = nombre;
		this.pais = pais;
		this.ciudad = ciudad;
		this.categoria = categoria;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.comentarios = comentarios;
		this.calificaciones = calificaciones;
	}
	
	
	//Getters & Setters
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
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
	public ArrayList<Servicio> getServicios() {
		return servicios;
	}
	public void setServicios(ArrayList<Servicio> servicios) {
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
	public ArrayList<String> getComentarios() {
		return comentarios;
	}
	public void setComentarios(ArrayList<String> comentarios) {
		this.comentarios = comentarios;
	}
	public ArrayList<Integer> getCalificaciones() {
		return calificaciones;
	}
	public void setCalificaciones(ArrayList<Integer> calificaciones) {
		this.calificaciones = calificaciones;
	}
	
	//////////
	//Mensajes
	/////////
	
	// Agregado por Diego
	public float puntajePromedio() {
		float res = 0;
		for(int x:this.getCalificaciones()){
			res = res + x;
		}
		return res/this.getCalificaciones().size();
	}
	
	
	// Agregado por Diego
	public void agregarServicioAHotel(Hotel h, ServicioHotel sh)
	{
		ServiciosHotel svs = new ServiciosHotel();
		for(ServicioHotel s:svs.getServiciosH()){
			if(sh.equals(s)){
				this.getServicios().add(sh);
			}
		   }
		}
	
	public void agregarCalificacion(int cal){
		cal=(Integer)cal;
		this.getCalificaciones().add(cal);
	}
	
	
	public void agregarComentario(String comentario){
		this.getComentarios().add(comentario);
	}
	
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

}
	
	


	
	


