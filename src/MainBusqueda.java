import java.util.ArrayList;
import java.util.Calendar;


public class MainBusqueda {
	
	public static void main(String[] args) {
		
	
	
	Calendar in= Calendar.getInstance();
	Calendar out= Calendar.getInstance();
	in.set(Calendar.DAY_OF_MONTH,29);
	in.set(Calendar.MONTH,5);
	in.set(Calendar.YEAR,2013);
	out.set(Calendar.DAY_OF_MONTH,2);
	out.set(Calendar.MONTH,6);
	out.set(Calendar.YEAR,2013);
	Habitacion h1=new Habitacion(1,4,null,null,in,out);
	
	Calendar in2= Calendar.getInstance();
	Calendar out2= Calendar.getInstance();
	in2.set(Calendar.DAY_OF_MONTH,29);
	in2.set(Calendar.MONTH,5);
	in2.set(Calendar.YEAR,2013);
	out2.set(Calendar.DAY_OF_MONTH,2);
	out2.set(Calendar.MONTH,6);
	out2.set(Calendar.YEAR,2013);
	Habitacion h2=new Habitacion(2,2,null,null,in2,out2);
	
	
	Calendar in3= Calendar.getInstance();
	Calendar out3= Calendar.getInstance();
	in3.set(Calendar.DAY_OF_MONTH,29);
	in3.set(Calendar.MONTH,5);
	in3.set(Calendar.YEAR,2013);
	out3.set(Calendar.DAY_OF_MONTH,2);
	out3.set(Calendar.MONTH,6);
	out3.set(Calendar.YEAR,2013);
	Habitacion h3=new Habitacion(3,6,null,null,in3,out3);
	
	ArrayList<Habitacion>hab=new ArrayList<Habitacion>();
	hab.add(h1);
	
	ArrayList<Habitacion>hab2=new ArrayList<Habitacion>();
	hab.add(h2);
	
	ArrayList<Habitacion>hab3=new ArrayList<Habitacion>();
	hab.add(h3);
	
	Hotel hotel1=new Hotel();
	hotel1.ciudad="Bernal";
	hotel1.habitaciones=hab;
	hotel1.nombre="ELDANI";
	
	
	Hotel hotel2=new Hotel();
	hotel2.ciudad="Quilmes";
	hotel2.habitaciones=hab2;
	hotel2.nombre="PEPE";
	
	Hotel hotel3=new Hotel();
	hotel3.ciudad="Ezeiza";
	hotel3.habitaciones=hab3;
	hotel3.nombre="BOSQUE";
	
	
	ArrayList<Hotel>hoteles=new ArrayList<Hotel>();
	hoteles.add(hotel1);
	hoteles.add(hotel2);
	hoteles.add(hotel3);
	
	Sistema sis=new Sistema();
	sis.hoteles=hoteles;
	
	Pasajero pas=new Pasajero();
	pas.setSistema(sis);
	
	Busqueda busqueda= new Busqueda("Bernal",in,out,4);
	
	pas.buscarHotelesPor(busqueda);
	sis.imprimirResultadoBusqueda();
	
	
	
	
	
	
	
	
	
	
	
	
 }
	
		
}
