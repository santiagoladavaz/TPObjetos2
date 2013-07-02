package Hotel;

import java.util.ArrayList;

import Sistema.Sistema;


public class Hotelero {
	ArrayList<Hotel>hoteles=new ArrayList<Hotel>();
	Sistema sistema;
	
	
	//Constructor
	public Hotelero(ArrayList<Hotel> hoteles, Sistema sistema) {
		super();
		this.hoteles = hoteles;
		this.sistema = sistema;
	}

	//Getters & Setters
	public ArrayList<Hotel> getHoteles() {
		return hoteles;
	}

	public void setHoteles(ArrayList<Hotel> hoteles) {
		this.hoteles = hoteles;
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}
	
	//Mensaje
	
	 // Agregado por Diego
	public void agregarOferta(Oferta o)
	{
		this.getSistema().agregarOferta(o);
	}

	//Agrega un hotel al sistema
	public void agregarHotel(Hotel hotel){
		this.getSistema().agregarHotel(hotel);
	}
	
}
