package Sistema;

import java.util.ArrayList;

import Excepsiones.LaHabitacionYaEstaReservada;
import Hotel.*;
import Remate.Remate;


public class Sistema{
	ArrayList<Hotel>hoteles=new ArrayList<Hotel>();
	ArrayList<Resultado>resultadosBusqueda=new ArrayList<Resultado>();
	Remate remate;

	
	
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
	
	
	
	//Reserva una habitacion 
	public void reservarHabitacion(Hotel hotel,Habitacion habitacion,Pasajero pas) throws LaHabitacionYaEstaReservada {
		for(Resultado res:this.getResultadosBusqueda()){
			if(res.getHotel().mismoHotel(hotel)){
				if(res.getHotel().mismaHabitacion(habitacion)){
					habitacion.reservate();
					Reserva reserva=new Reserva(hotel, habitacion,pas,habitacion.getCheckIn(),habitacion.getCheckOut());
					pas.getReservas().add(reserva);
					hotel.getReservas().add(reserva);
					System.out.println("Se acaba de Reservar "+habitacion.getNumero()+" En el hotel "+hotel.getNombre());
					this.concretarReserva(hotel,pas);
				   }
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
	
	
	
		
}
