import java.util.ArrayList;


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
		
		for(Hotel h:this.getHoteles()){
			if(h.cumpleCondicionHotel(busqueda)){
				resultado=new Resultado(h,h.cumpleTodasCondiciones(busqueda));
				res.add(resultado);
			}
		}	
		this.setResultadosBusqueda(res);
	}
	

	
	
	//Le dice a su variable Remate que oferte
	public void ofertar(Pasajero pasajero, int unPrecio) throws Exception {
		this.getRemate().ofertar(pasajero,unPrecio,this.getRemate());
		
	}


	public void imprimirResultadoBusqueda(){
	for(Resultado r:this.getResultadosBusqueda()){
			System.out.println("El hotel es"+r.getHotel().nombre);
			for(Habitacion h:r.getHabitaciones()){
				System.out.println("Habitacion Numero"+h.numero);
			}
	}	
}
	
	
	public void reservarHabitacion(Hotel hotel, int nroHabitacion) {
		
		
	
	}

	
}
