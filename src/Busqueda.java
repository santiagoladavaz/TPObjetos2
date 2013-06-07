import java.util.Calendar;


public class Busqueda {
	
	String unDestino;
	Calendar fechaIngreso;
	Calendar fechaSalida;
	int cantHuespedes;
	
	
	
	//Constructor
	public Busqueda(String unDestino, Calendar fechaIngreso,
			Calendar fechaSalida, int cantHuespedes) {
		super();
		this.unDestino = unDestino;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.cantHuespedes = cantHuespedes;
	}
	//Getters & Setters
	public String getUnDestino() {
		return unDestino;
	}
	public void setUnDestino(String unDestino) {
		this.unDestino = unDestino;
	}
	public Calendar getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Calendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Calendar getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Calendar fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public int getCantHuespedes() {
		return cantHuespedes;
	}
	public void setCantHuespedes(int cantHuespedes) {
		this.cantHuespedes = cantHuespedes;
	}
	
	
	

}
