package Sistema;

import java.util.Calendar;

public class PreferenciasPasajero {
	

	private int precioMaximo;
	private int precioMinimo;
	private int precioMayor;
	private int precioMenor;
	private Calendar fechaInicio;
	private Calendar fechaFin;
	private String ciudad;
	private String pais;

	
	
	public int getPrecioMaximo() {
		return precioMaximo;
	}
	public void setPrecioMaximo(int precioMaximo) {
		this.precioMaximo = precioMaximo;
	}
	public int getPrecioMinimo() {
		return precioMinimo;
	}
	public void setPrecioMinimo(int precioMinimo) {
		this.precioMinimo = precioMinimo;
	}
	public int getPrecioMayor() {
		return precioMayor;
	}
	public void setPrecioMayor(int precioMayor) {
		this.precioMayor = precioMayor;
	}
	public int getPrecioMenor() {
		return precioMenor;
	}
	public void setPrecioMenor(int precioMenor) {
		this.precioMenor = precioMenor;
	}
	public Calendar getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Calendar fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Calendar getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Calendar fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public PreferenciasPasajero(int precioMaximo, int precioMinimo,
			int precioMayor, int precioMenor, Calendar fechaInicio,
			Calendar fechaFin, String ciudad, String pais) {
		super();
		this.precioMaximo = precioMaximo;
		this.precioMinimo = precioMinimo;
		this.precioMayor = precioMayor;
		this.precioMenor = precioMenor;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.ciudad = ciudad;
		this.pais = pais;
	}
}
