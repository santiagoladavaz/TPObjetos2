package Sistema;
import Hotel.Estadia;
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
		
	

	
	//Estados de las Estadias de las Habitaciones
	Libre libre=new Libre();
	Reservada reservada=new Reservada();

//Fechas de las Estadias(usadas tambien para crear Busqueda)	
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
	Estadia estadia=new Estadia(in,out,0,libre);
	estadia.nombre="CENA";
	
	//Creo Lista estadias 
	ArrayList<Estadia>estadias= new ArrayList<Estadia>();
	
	//Creo Lista estadias 1
	ArrayList<Estadia>estadias1= new ArrayList<Estadia>();
	

	
    //Fecha in1 = 27/5/2013
	Calendar in1= Calendar.getInstance();
	in1.set(Calendar.DAY_OF_MONTH,27);
	in1.set(Calendar.MONTH,5);
	in1.set(Calendar.YEAR,2013);
	
	//Fecha out1 = 2/6/2013
	Calendar out1= Calendar.getInstance();
	out1.set(Calendar.DAY_OF_MONTH,2);
	out1.set(Calendar.MONTH,6);
	out1.set(Calendar.YEAR,2013);
	Estadia estadia1=new Estadia(in1,out1,0,libre);
	estadia1.nombre="GALA";

	
	//Estadia Diciembre
	Calendar in2= Calendar.getInstance();
	in2.set(Calendar.DAY_OF_MONTH,2);
	in2.set(Calendar.MONTH,12);
	in2.set(Calendar.YEAR,2013);

	//Fecha out = 2/6/2013
	Calendar out2= Calendar.getInstance();
	out2.set(Calendar.DAY_OF_MONTH,30);
	out2.set(Calendar.MONTH,12);
	out2.set(Calendar.YEAR,2013);
	Estadia diciembre=new Estadia(in2,out2,0,libre);
	estadia.nombre="Diciembre";
	
	
	
	estadias.add(estadia);//estadia con in:29/5/2013, out:2/6/2013 y Libre
	estadias.add(diciembre);
	
	
	estadias1.add(estadia1);//estadia1 con in:27/5/2013 out:2/6/2013 y Libre
	
	
	//estadias1.add(estadia);//estadia con in:29/5/2013, out:2/6/2013 y Libre
	
	//Habitacion 1
	Habitacion h1=new Habitacion(1,4,null,estadias);
	
	//Habitacion 2
	Habitacion h2=new Habitacion(2,2,null,estadias1);
	
	//Habitacion 3
	Habitacion h3=new Habitacion(3,6,null,estadias1);
	
	//Habitacion 4
	Habitacion h4=new Habitacion(108,4,null,estadias1);
	
	
	//Contiene Habitacion 1
	ArrayList<Habitacion>hab1=new ArrayList<Habitacion>();
	hab1.add(h1);
	
	//Contiene Habitacion 2
	ArrayList<Habitacion>hab2=new ArrayList<Habitacion>();
	hab2.add(h2);
	
	//Contiene Habitacion 3
	ArrayList<Habitacion>hab3=new ArrayList<Habitacion>();
	hab3.add(h3);
	
	//Contiene Habitacion 4
	ArrayList<Habitacion>hab4=new ArrayList<Habitacion>();
	hab4.add(h4);
	
	
	//Hotel 1
	Hotel hotel1=new Hotel();
	hotel1.ciudad="Bernal";
	hotel1.habitaciones=hab1;
	hotel1.setNombre("EL DANI");
	hotel1.setEmail("eldani@gmail.com");
	
	//Hotel 2
	Hotel hotel2=new Hotel();
	hotel2.ciudad="Quilmes";
	hotel2.habitaciones=hab2;
	hotel2.setNombre("PEPE");
	
	//Hotel 3
	Hotel hotel3=new Hotel();
	hotel3.ciudad="Ezeiza";
	hotel3.habitaciones=hab3;
	hotel3.setNombre("BOSQUE");
	
	//Hotel 4
	Hotel hotel4=new Hotel();
	hotel4.ciudad="Bernal";
	hotel4.habitaciones=hab4;
	hotel4.setNombre("Sheraton");
	
	//Lista de Hoteles para el Sistema
	ArrayList<Hotel>hoteles=new ArrayList<Hotel>();
	hoteles.add(hotel1);
	hoteles.add(hotel2);
	hoteles.add(hotel3);
	hoteles.add(hotel4);
	
	//Sistema con su Lista de hoteles
	Sistema sis=new Sistema();
	sis.hoteles=hoteles;
	
	//Pasajero1 con su Sistema
	Pasajero pas=new Pasajero();
	pas.setSistema(sis);
	pas.setMail("pasajero@gmail.com");
	Pasajero pas1=new Pasajero();
	pas.setSistema(sis);
	
	//Busqueda con: destino:"Bernal" in:29/5/2013 out:2/6/2013 y 4 huespedes.
	Busqueda busqueda= new Busqueda("Bernal",in,out,4);
	
	//Busqueda con: destino:"Bernal" in:27/5/2013 out:2/6/2013 y 4 huespedes.
	Busqueda busqueda1=new Busqueda("Bernal",in1,out1,4);
	
	
	Busqueda busquedaDic=new Busqueda("Bernal",in2,out2,4);
////////////////////	
//Metodos a probar//
///////////////////	
	
	pas.buscarHotelesPor(busquedaDic);
	sis.imprimirResultadoBusqueda();
	
	
	//sis.reservarHabitacion(hotel1,h1,pas,in,out);    // Alquila el dani,con busqueda
	//sis.reservarHabitacion(hotel4,h4,pas,in1,out1);  // Alquila el sheraton,con busqueda1
	
	pas.buscarHotelesPor(busqueda);
	sis.imprimirResultadoBusqueda();
	
	pas.buscarHotelesPor(busqueda1);
	sis.imprimirResultadoBusqueda();
	
	sis.reservarHabitacion(hotel1,h1,pas,in2,out2);
	sis.reservarHabitacion(hotel1,h1,pas,in,out);
	
	System.out.println(h1.getEstadias().get(0).getEstado());
	System.out.println(h1.getEstadias().get(1).getEstado());
	

	
	//pas.buscarHotelesPor(busqueda);
	//sis.imprimirResultadoBusqueda();
	

	
	
	
	
	
	
	
	
	
 }
	
		
}
