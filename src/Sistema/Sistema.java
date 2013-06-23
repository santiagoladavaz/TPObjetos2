package Sistema;

import java.util.ArrayList;
import java.util.Calendar;

import Excepsiones.LaHabitacionYaEstaReservada;
import Hotel.*;
import Remate.Remate;


public class Sistema{
	ArrayList<Hotel>hoteles=new ArrayList<Hotel>();
	ArrayList<Resultado>resultadosBusqueda=new ArrayList<Resultado>();
	Remate remate;
	Estadia estadia;
	
	//Constructor
	public Sistema(ArrayList<Hotel> hoteles,
			ArrayList<Resultado> resultadosBusqueda, Remate remate,
			Estadia estadia) {
		super();
		this.hoteles = hoteles;
		this.resultadosBusqueda = resultadosBusqueda;
		this.remate = remate;
		this.estadia = estadia;
	}


	//Getters & Setters
	public ArrayList<Hotel> getHoteles() {
		return hoteles;
	}

	
	public void setHoteles(ArrayList<Hotel> hoteles) {
		this.hoteles = hoteles;
	}


	public Remate getRemate() {
		return remate;
	}


	public void setRemate(Remate remate) {
		this.remate = remate;
	}


	public ArrayList<Resultado> getResultadosBusqueda() {
		return resultadosBusqueda;
	}


	public void setResultadosBusqueda(ArrayList<Resultado> resultadosBusqueda) {
		this.resultadosBusqueda = resultadosBusqueda;
	}

	
	//Metodos 
	public void buscarHotelesPor(Busqueda busqueda){
		ArrayList<Resultado>res=new ArrayList<Resultado>();
		Resultado resultado;
		 
		  for(Hotel hotel:this.getHoteles()){
			if(hotel.cumpleCondicionHotel(busqueda)){
				resultado=new Resultado(hotel,hotel.cumpleTodasCondiciones(busqueda));
				res.add(resultado);
				}
		}	
		this.setResultadosBusqueda(res);
	}
	

	
	
	//Le dice a su variable Remate que oferte
	public void ofertar(Pasajero pasajero, int unPrecio) throws Exception {
		this.getRemate().ofertar(pasajero,unPrecio,this.getRemate());
		
	}

	
	
	//Permite imprimir los resultados de la busqueda de los hoteles
	public void imprimirResultadoBusqueda(){
	  if(this.getResultadosBusqueda().size()==0)
		  System.out.println("No hay resultados");
		
		for(Resultado r:this.getResultadosBusqueda()){
			System.out.println("El hotel es "+r.getHotel().getNombre());
			for(Habitacion h:r.getHabitaciones()){
				System.out.println("Habitacion Numero "+h.getNumero());
			}
		  }
		}


	
	public void enviarMailA(String email){
		System.out.println("Se envio un email a la casilla  "+email);
		}		
	
	
	public void concretarReserva(Hotel hotel,Pasajero pas){
		this.enviarMailA(hotel.getEmail());
		this.enviarMailA(pas.getMail());
	}
	
	// Método creado por Diego
	public void enviarDatosAMail(String mail, Hotel h, Habitacion hab, Pasajero p, Estadia e)
	{
		System.out.println("Se envio un email a la casilla  "+mail);
		System.out.println("Se acaba de Reservar "+hab.getNumero()+" En el hotel "+h.getNombre());
		System.out.println("La Reserva esta hecha a nombre de:"+p.getNombre() );
		System.out.println("La estadia es del "+e.getCheckIn()+"Hasta el" +e.getCheckOut()); 
	}
	
	
	//Reserva una habitacion 
	// <<<<<<< Método modificado por Diego >>>>>>>
	public void reservarHabitacion(Hotel hotel,Habitacion habitacion,Pasajero pas,Calendar in,Calendar out) throws LaHabitacionYaEstaReservada {
		
		Estadia estadia=habitacion.esIgualEstadia(in,out);
		
		for(Resultado res:this.getResultadosBusqueda()){
			if(res.getHotel().mismoHotel(hotel)){
				if(res.getHotel().mismaHabitacion(habitacion)){
					habitacion.reservate(estadia);
					Reserva reserva=new Reserva(hotel, habitacion,pas,estadia);
					pas.agregarReserva(reserva);
					hotel.agregarReserva(reserva);
					this.enviarDatosAMail(pas.getMail(), hotel, habitacion, pas, estadia); // Modificado por Diego
					this.enviarDatosAMail(hotel.getEmail(), hotel, habitacion, pas, estadia); // Modificado por Diego
					
				   }
				  }
		         }
	            }

	
		
}
