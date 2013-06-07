import java.util.ArrayList;
import java.util.Calendar;


public class Habitacion {
	
	int numero;
	int capacidad;
	ArrayList<Servicio>servicios=new ArrayList<Servicio>();
	EstadoHabitacion estado;
	Calendar checkIn;
	Calendar checkOut;
	
	
	
	//Constructor
	public Habitacion(int numero, int capacidad, ArrayList<Servicio> servicios,
			EstadoHabitacion estado, Calendar checkIn, Calendar checkOut) {
		super();
		this.numero = numero;
		this.capacidad = capacidad;
		this.servicios = servicios;
		this.estado = estado;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	//Getters & Setters
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public ArrayList<Servicio> getServicios() {
		return servicios;
	}
	public void setServicios(ArrayList<Servicio> servicios) {
		this.servicios = servicios;
	}
	public EstadoHabitacion getEstado() {
		return estado;
	}
	public void setEstado(EstadoHabitacion estado) {
		this.estado = estado;
	}
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
	
	///////////
	
	//Metodos
	public boolean cumpleCapacidad(int capacidad){
		return this.getCapacidad()==capacidad;
	}
	
	public boolean cumpleCheckIn(Calendar checkIn){
		return this.getCheckIn().equals(checkIn);
	}
	
	public boolean cumpleCheckOut(Calendar checkOut){
		return this.getCheckOut().equals(checkOut);
	}

	public boolean cumpleCondiciones(int capacidad,Calendar checkIn,Calendar checkOut){
		return this.cumpleCapacidad(capacidad) & this.cumpleCheckIn(checkIn) & this.cumpleCheckOut(checkOut);
	}
	
}
