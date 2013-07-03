package Descuento;

import java.util.Calendar;

import Hotel.Estadia;

//Este descuento sera aplicado a todas las estadías que esten entre las dos fechas puestas como variables de instancia
public class DescuentoPorPeriodo extends Descuento {
	
	private Calendar fechaInicial;
	private Calendar fechaFinal;
	
	public Calendar getFechaInicial() {
		return fechaInicial;
	}
	public void setFechaInicial(Calendar fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public Calendar getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(Calendar fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public DescuentoPorPeriodo(int porcentaje, Calendar fechaLimiteDeReserva, Calendar fechaI, Calendar fechaF) {
		
		super(porcentaje, fechaLimiteDeReserva);
		this.fechaFinal=fechaF;
		this.fechaInicial=fechaI;
	}
	
	
	// Aplica el descuento correspondiente  
	@Override
	public float aplicarDescuento(Estadia e) {
		
		return e.getPrecio()-e.getPrecio()*this.getPorcentaje() /100;

		
	}
}