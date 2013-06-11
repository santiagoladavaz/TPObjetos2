import java.util.ArrayList;

import Excepsiones.LaHabitacionYaEstaReservada;


public class Sistema{
	ArrayList<Hotel>hoteles=new ArrayList<Hotel>();
	ArrayList<Resultado>resultadosBusqueda=new ArrayList<Resultado>();
	ArrayList<Reserva>reservas=new ArrayList<Reserva>();
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
	
	public ArrayList<Reserva> getReservas() {
		return reservas;
	}


	public void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
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
			System.out.println("El hotel es" +r.getHotel().nombre);
			for(Habitacion h:r.getHabitaciones()){
				System.out.println("Habitacion Numero"+h.numero);
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
					this.getReservas().add(reserva);
					System.out.println("Se acaba de Reservar"+habitacion.getNumero()+"En el hotel"+hotel.getNombre());
				   }
				  }
		         }
	            }

	
	
	
	public void enviarMailA(String email){
		
		}		
		
}
