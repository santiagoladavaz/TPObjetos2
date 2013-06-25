package Hotel;

public class Oferta {
	
	Habitacion habitacion;
	private String pais;
	private String ciudad;

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public Oferta(Habitacion habitacion, String pais, String ciudad) {
		super();
		this.habitacion = habitacion;
		this.pais = pais;
		this.ciudad = ciudad;
	}

	
	
	
	

}
