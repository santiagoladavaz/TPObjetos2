package Hotel;

import java.util.ArrayList;
import java.util.Calendar;

import Excepsiones.LaHabitacionYaEstaReservada;
import Sistema.Busqueda;


public class Habitacion {
	
	int numero;
	int capacidad;
	ArrayList<Servicio>servicios=new ArrayList<Servicio>();
	ArrayList<Estadia>estadias=new ArrayList<Estadia>();
	EstadoHabitacion estado;
	
	
	
	
	//Constructor
	public Habitacion(int numero, int capacidad, ArrayList<Servicio> servicios,
			EstadoHabitacion estado,ArrayList<Estadia>estadias) {
		super();
		this.numero = numero;
		this.capacidad = capacidad;
		this.servicios = servicios;
		this.estado = estado;
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
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public ArrayList<Estadia> getEstadias() {
		return estadias;
	}
	
	public void setEstadias(ArrayList<Estadia> estadias) {
		this.estadias = estadias;
	}
	
	///////////
	//Metodos
	
	public boolean cumpleCapacidad(int capacidad){
		return this.getCapacidad()==capacidad;
	}
	
	public boolean cumpleCheckIn(Calendar checkIn){
		boolean res=true;
		for(Estadia est:this.getEstadias()){
			if(est.cumpleCheckIn(checkIn))
				res=true;
			}
		System.out.println(res);
		return res;
	
	}
	
	
	public boolean cumpleCheckOut(Calendar checkOut){
		boolean res=true;
		for(Estadia est:this.getEstadias()){
			if(est.cumpleCheckOut(checkOut))
				res=true;
			}
		System.out.println(res);
	 return res;	
	}


	
	
	public boolean cumpleCondiciones(Busqueda busqueda){
		return this.getEstado().cumpleCondiciones(busqueda,this);
	}

	//Dada una habitacion me dice es la misma a esta
	public boolean mismaHabitacion(Habitacion habitacion){
		return habitacion.equals(this);
	}
	
	//Le dice a su Estado que se reserve
	public void reservate() throws LaHabitacionYaEstaReservada {
		this.getEstado().reservar(this);		
	}

	
	public static void main(String[] args) {
		Estadia estadia=new Estadia();
		Calendar in= Calendar.getInstance();
		Calendar out= Calendar.getInstance();
		Libre libre=new Libre();
		in.set(Calendar.DAY_OF_MONTH,29);
		in.set(Calendar.MONTH,5);
		in.set(Calendar.YEAR,2013);
		out.set(Calendar.DAY_OF_MONTH,2);
		out.set(Calendar.MONTH,6);
		out.set(Calendar.YEAR,2013);
		estadia.setCheckIn(in);
		estadia.setCheckOut(out);
		ArrayList<Estadia>estadias= new ArrayList<Estadia>();
		estadias.add(estadia);
		Habitacion hab=new Habitacion(1,4,null,libre,estadias);
		hab.cumpleCheckIn(in);
		hab.cumpleCheckOut(out);
		
	}
	
}