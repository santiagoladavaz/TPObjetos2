package Hotel;

import java.util.Calendar;

import Descuento.Descuento;
import Excepsiones.LaHabitacionYaEstaReservada;
import Sistema.Busqueda;

public class Estadia {

	Calendar checkIn;
	Calendar checkOut;
	int precio;
	EstadoEstadia estado;
	public String nombre;
	private Descuento descuento;
	
	//Constructor
	public Estadia(Calendar checkIn, Calendar checkOut, int precio,EstadoEstadia estado) {
		super();
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.precio = precio;
		this.estado=estado;
	}	
	
	
	//Getters and Setters
	
	public Descuento getDescuento() {
		return descuento;
	}

	public void setDescuento(Descuento descuento) {
		this.descuento = descuento;
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
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public EstadoEstadia getEstado() {
		return estado;
	}
	public void setEstado(EstadoEstadia estado) {
		this.estado = estado;
	}
	
	
	/////////
	//Metodos
	/////////
	
	
	//Dado un CheckIn se fija se coincide con el de la Estadia
	public boolean cumpleCheckIn(Calendar checkIn){
		return this.getCheckIn().equals(checkIn);
	}
	
	//Dado un CheckOut se fija se coincide con el de la Estadia
	public boolean cumpleCheckOut(Calendar checkOut){
		return this.getCheckOut().equals(checkOut);
	}
	
	//Le pregunta a su Estado si se cumplen las condiciones de busqueda
	public boolean cumpleCondiciones(Busqueda busqueda,Habitacion hab) {
		return this.getEstado().cumpleCondiciones(busqueda,hab,this);
		
	}
	
	
	//Le dice a su estado que reserve
	public void reservar() throws LaHabitacionYaEstaReservada{
		this.getEstado().reservar(this);
	}
	
	
	//dado un precio me dice si es menor al de la estadia
	public boolean esMenor(int precio){
		 return this.getPrecio()<=precio;
	}
	
	
	//dado un precio me dice si es mayor al de la estadia
	public boolean esMayor(int precio){
	  return this.getPrecio()>=precio;
	}
	
	
	//Test desde aca
	
	// Chequea que la estadia tenga un descuento y que la fecha límite de reserva sea posterior a la fecha actual
	public boolean estaVigenteDescuento() {
	
	boolean res = false;
	
	if(!this.getDescuento().equals(null)) {
		if(this.getDescuento().getFechaLimiteDeReserva().after(Calendar.getInstance())) {
			res=true;
		}
	}
	
	return res;
}
	
	// Imprime en pantalla la habitación, el precio y el precio con descuento siempre y cuando la estadía este dentro de las 
	// fechas pasadas por parámetro	
	public void estadiaEntre(Habitacion h, Calendar f1, Calendar f2) {
		if(this.getCheckIn().after(f1) & this.getCheckOut().before(f2)) {
			System.out.println("Habitación:"+h + "Precio:" +this.getPrecio() + 
					           "Precio con descuento" +this.precioConDescuento());
				
			}
	}
	
	
	// Imprime en pantalla la habitación, el precio y el precio con descuento siempre y cuando la estadía sea anterior a la
	// fecha pasada por parámetro
		public void estadiaAnteriorA(Habitacion h, Calendar f1) {
			if(this.getCheckOut().before(f1)) {
				System.out.println("Habitación:"+h + "Precio:" +this.getPrecio() + 
						            "Precio con descuento" +this.precioConDescuento());
				}
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
		
		Estadia estadia=new Estadia(in,out,200,libre);
		
		//Busqueda busqueda= new Busqueda(null,in,out,4);
		
		//Habitacion h1=new Habitacion(1,4,null,null);
		
		System.out.println(estadia.esMayor(300));
		
		
		
	}
}
