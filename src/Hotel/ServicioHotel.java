package Hotel;



// Nueva clase creada by Diego ;)
public class ServicioHotel extends Servicio{
	
	private int precio;
	
	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public ServicioHotel(String nombre, String descripcion, int precio) {
		super(nombre, descripcion);
		this.precio = precio;
	}

	



	
	

}
