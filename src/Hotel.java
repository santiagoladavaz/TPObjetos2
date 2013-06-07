import java.util.ArrayList;


public class Hotel {
	ArrayList<Habitacion>habitaciones=new ArrayList<Habitacion>();
	ArrayList<Reserva>reservas=new ArrayList<Reserva>();
	Servicio servicios;
	String nombre;
	String pais;
	String ciudad;
	String direccion;
	int telefono;
	String email;
	
	
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
	
	
	public boolean igualDestino(String unDestino){
		return this.getCiudad().equals(unDestino);
	}
	
	
	
	public ArrayList<Habitacion>cumpleTodasCondiciones(Busqueda busqueda){
		ArrayList<Habitacion>res =new ArrayList<Habitacion>();
		if(this.igualDestino(busqueda.getUnDestino())){
			for(Habitacion h:this.getHabitaciones()){
				if(h.cumpleCondiciones(busqueda.getCantHuespedes(),busqueda.getFechaIngreso(),busqueda.getFechaSalida())){
					res.add(h);
				  }
	          }
	      }
		return res;
	}
		
	public boolean cumpleCondicionHotel(Busqueda busqueda){
		return this.cumpleTodasCondiciones(busqueda).size()>0;
		}
	
}

	
	


