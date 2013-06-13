package Sistema;
import Hotel.Estadia;
import Hotel.EstadoHabitacion;
import Hotel.Habitacion;
import Hotel.Hotel;
import Hotel.Libre;
import Hotel.Reservada;

import java.util.ArrayList;
import java.util.Calendar;
import Excepsiones.LaHabitacionYaEstaReservada;


public class MainBusqueda {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws LaHabitacionYaEstaReservada {
		
	
	//Habitacion 
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
	Habitacion h1=new Habitacion(1,4,null,libre,estadias);

	
	//Habitacion 2
	EstadoHabitacion reservada=new Reservada();
	Habitacion h2=new Habitacion(2,2,null,reservada,estadias);
	
	//Habitacion 3
	Habitacion h3=new Habitacion(3,6,null,reservada,estadias);
	
	//Habitacion 4
	Habitacion h4=new Habitacion(108,4,null,libre,estadias);
	
	
	ArrayList<Habitacion>hab1=new ArrayList<Habitacion>();
	hab1.add(h1);
	
	ArrayList<Habitacion>hab2=new ArrayList<Habitacion>();
	hab2.add(h2);
	
	ArrayList<Habitacion>hab3=new ArrayList<Habitacion>();
	hab3.add(h3);
	
	ArrayList<Habitacion>hab4=new ArrayList<Habitacion>();
	hab4.add(h4);
	
	Hotel hotel1=new Hotel();
	hotel1.ciudad="Bernal";
	hotel1.habitaciones=hab1;
	hotel1.setNombre("ELDANI");
	hotel1.setEmail("eldani@gmail.com");
	
	
	Hotel hotel2=new Hotel();
	hotel2.ciudad="Quilmes";
	hotel2.habitaciones=hab2;
	hotel2.setNombre("PEPE");
	
	Hotel hotel3=new Hotel();
	hotel3.ciudad="Bosques";
	hotel3.habitaciones=hab3;
	hotel3.setNombre("BOSQUE");
	
	Hotel hotel4=new Hotel();
	hotel4.ciudad="Bernal";
	hotel4.habitaciones=hab4;
	hotel4.setNombre("Shell");
	
	
	ArrayList<Hotel>hoteles=new ArrayList<Hotel>();
	hoteles.add(hotel1);
	hoteles.add(hotel2);
	hoteles.add(hotel3);
	hoteles.add(hotel4);
	
	Sistema sis=new Sistema();
	sis.hoteles=hoteles;
	
	Pasajero pas=new Pasajero();
	pas.setSistema(sis);
	pas.setMail("pasajero@gmail.com");
	Pasajero pas1=new Pasajero();
	pas.setSistema(sis);
	Busqueda busqueda= new Busqueda("Bernal",in,out,4);
	
	pas.buscarHotelesPor(busqueda);
	sis.imprimirResultadoBusqueda();
	
	//sis.reservarHabitacion(hotel1,h1,pas);
	//sis.reservarHabitacion(hotel1,h1,pas1);
	
	//pas.buscarHotelesPor(busqueda);
	//sis.imprimirResultadoBusqueda();
	
	//sis.reservarHabitacion(hotel4,h4,pas);

	
	//pas.buscarHotelesPor(busqueda);
	//sis.imprimirResultadoBusqueda();
	
	
	
	
	
	
	
	
	
	
	
 }
	
		
}