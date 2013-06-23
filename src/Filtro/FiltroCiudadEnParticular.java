package Filtro;

import Sistema.Reserva;





public class FiltroCiudadEnParticular extends Filtro{

	String ciudad;

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	
	//Se fija que la ciudad dada sea igual a la ciudad del Hotel reservado.
	public boolean cumpleCondicion(Reserva res) {
		return res.getHotel().getCiudad().equals(this.getCiudad());
	}
	
	//Constructor.
	public FiltroCiudadEnParticular(String ciudad) {
		super();
		this.ciudad = ciudad;
	}
}
