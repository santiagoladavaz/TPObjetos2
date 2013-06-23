package Hotel;


import java.util.ArrayList;

//Clase creada por Diego
public class ServiciosHotel {

	private ServicioHotel wifi= new ServicioHotel("WiFi", "El hotel cuenta con el servicio de internet inalámbrico (6 mb)", 50);
	private ServicioHotel sauna= new ServicioHotel("Sauna", "El hotel cuenta con un amplio sauna de ultima generación", 100);
	private ServicioHotel gimnasio= new ServicioHotel("Gimanasio", "El hotel cuenta con un gimnasio de primera línea", 80);
	private ServicioHotel cochera= new ServicioHotel("Cochera", "El hotel cuenta con una amplia cochera", 200);
	private ServicioHotel pileta= new ServicioHotel("Pileta", "El hotel cuenta con una gran pileta", 20);
	private ServicioHotel showEnVivo= new ServicioHotel("Show en vivo", "El hotel cuenta con un show en vivo todas las noches", 100);
	
	private ArrayList<ServicioHotel> serviciosH= new ArrayList<ServicioHotel>();
	
	
	public ArrayList<ServicioHotel> getServiciosH() {
		return serviciosH;
	}

	public void setServiciosH(ArrayList<ServicioHotel> serviciosH) {
		this.serviciosH = serviciosH;
	}

	public ServiciosHotel(){
		serviciosH.add(wifi);
		serviciosH.add(sauna);
		serviciosH.add(gimnasio);
		serviciosH.add(cochera);
		serviciosH.add(pileta);
		serviciosH.add(showEnVivo);
	}

	

}
	
	
	
	
	
	
	


