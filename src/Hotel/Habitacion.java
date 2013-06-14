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
	
	
	
	
	
	//Constructor
	public Habitacion(int numero, int capacidad, ArrayList<Servicio> servicios,
			ArrayList<Estadia>estadias) {
		super();
		this.numero = numero;
		this.capacidad = capacidad;
		this.servicios = servicios;
		this.estadias=estadias;
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
	
	//Dada una capacidad me dice si cumple con la de la Habitacion
	public boolean cumpleCapacidad(int capacidad){
		return this.getCapacidad()==capacidad;
	}
	
	//Se fija si la habitacion cumple con los params. de Busqueda
	public boolean cumpleCondiciones(Busqueda busqueda){
		boolean res=false;
		for(Estadia estadia:this.getEstadias()){
			if(estadia.cumpleCondiciones(busqueda,this))
				res=true;
		}
	 return res;
	
	}

	
	
	
	//Dada una habitacion me dice es la misma a esta
	public boolean mismaHabitacion(Habitacion habitacion){
		return habitacion.equals(this);
	}
	
	//Le dice a su Estado que se reserve
	public void reservate(Estadia est) throws LaHabitacionYaEstaReservada {
			est.reservar();
	}

	
	

	public static void main(String[] args) {
		Libre libre=new Libre();
		//Fecha in = 29/5/2013
		Calendar in= Calendar.getInstance();
		in.set(Calendar.DAY_OF_MONTH,29);
		in.set(Calendar.MONTH,5);
		in.set(Calendar.YEAR,2013);

		//Fecha out = 2/6/2013
		Calendar out= Calendar.getInstance();
		out.set(Calendar.DAY_OF_MONTH,2);
		out.set(Calendar.MONTH,6);
		out.set(Calendar.YEAR,2013);
		
		//Fecha out1 = 2/6/2013
		Calendar out1= Calendar.getInstance();
		out1.set(Calendar.DAY_OF_MONTH,2);
		out1.set(Calendar.MONTH,6);
		out1.set(Calendar.YEAR,2013);
		
		Estadia estadia=new Estadia(in,out,0,libre);
		
		ArrayList<Estadia>estadias= new ArrayList<Estadia>();
		estadias.add(estadia);
		
		Busqueda busqueda= new Busqueda("Bernal",in,out,4);
		
		Habitacion h1=new Habitacion(1,4,null,estadias);
		
		System.out.println(h1.getEstadias().size());
		System.out.println(h1.cumpleCondiciones(busqueda));
		
		
	}
	
}
