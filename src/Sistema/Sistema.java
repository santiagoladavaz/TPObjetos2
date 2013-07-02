package Sistema;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Observable;

import Excepsiones.LaHabitacionYaEstaReservada;
import Excepsiones.NoPuedeCalificar;
import Excepsiones.NoPuedeComentar;
import Filtro.Filtro;
import Hotel.*;
import Remate.Remate;


public class Sistema extends Observable{
	ArrayList<Hotel>hoteles=new ArrayList<Hotel>();
	ArrayList<Resultado>resultadosBusqueda=new ArrayList<Resultado>();
	ArrayList<Oferta> ofertas = new ArrayList<Oferta> ();
	Remate remate;
	Estadia estadia;
	Filtro filtro;
	
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

	
	public Filtro getFiltro() {
		return filtro;
	}


	public void setFiltro(Filtro filtro) {
		this.filtro = filtro;
	}


	public ArrayList<Oferta> getOfertas() {
		return ofertas;
	}


	public void setOfertas(ArrayList<Oferta> ofertas) {
		this.ofertas = ofertas;
	}


	public Estadia getEstadia() {
		return estadia;
	}


	public void setEstadia(Estadia estadia) {
		this.estadia = estadia;
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
	
	//Método creado por Diego 
	public boolean puedeCalificarYComentarAHotel(Hotel unHotel, Pasajero p) {
		boolean res = false;
		for(Reserva r:p.getReservas()){
			if(r.getHotel().equals(unHotel) & r.getEstadia().getCheckOut().after(Calendar.getInstance()) ) {
				res = true; }
		}
		return res;
	}

	
	public void calificarHotel(Hotel h, int calificacion, Pasajero p) throws NoPuedeCalificar {
		if(this.puedeCalificarYComentarAHotel(h, p)) {
			h.agregarCalificacion(calificacion);
		}
		else{
			throw new NoPuedeCalificar();
		}
	}
	
	
	public void comentarHotel(Hotel h, String comentario, Pasajero p) throws NoPuedeComentar {
		if(this.puedeCalificarYComentarAHotel(h, p)) {
			h.agregarComentario(comentario);
		}
		else{
			throw new NoPuedeComentar();
		}
	}
	
	
	public void agregarResultado(Resultado res){
		this.getResultadosBusqueda().add(res);
	}
	
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
	

	// Agregado por Diego
	public void agregarOferta(Oferta o) {
		this.getOfertas().add(o);
		this.setChanged();
		this.notifyObservers(o);
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


	public void verReservasFuturas(ArrayList<Reserva> reservas) {
		this.getFiltro().filtrar(reservas);
	}


	public void verReservasDeUnaCiudad(ArrayList<Reserva> reservas,
			String ciudad) {
		
		
	}


	public void agregarHotel(Hotel hotel) {
		this.getHoteles().add(hotel);
		
	}

		
}
