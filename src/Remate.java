import java.util.Calendar;

public class Remate {
	Habitacion h;
	int precio;
	Calendar fechaInicio;
	Calendar fechaFin;
	Estado estado;
	Pasajero posibleGanador;
	
	
	//Constructor
	public Remate(Habitacion h, int precio, Calendar fechaInicio,
			Calendar fechaFin, Estado estado, Pasajero posibleGanador) {
		this.h = h;
		this.precio = precio;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
		this.posibleGanador = posibleGanador;
	}


	//Getters y Setters
	
	public Habitacion getH() {
		return h;
	}


	public void setH(Habitacion h) {
		this.h = h;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
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


	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	public Pasajero getPosibleGanador() {
		return posibleGanador;
	}


	public void setPosibleGanador(Pasajero posibleGanador) {
		this.posibleGanador = posibleGanador;
	}

/////////////////////////////////////////////////
	
	
	//Le dice a su estado que oferte
	public void ofertar(Pasajero unPasajero,int unPrecio,Remate rem) throws Exception{
		this.getEstado().ofertar(unPasajero,unPrecio,this);
	}


	
	
	//Si la fecha es de hoy es igual a la fecha de cierre del remate,este se finaliza
	public void finalizarRemate(){
		Calendar fechaActual = Calendar.getInstance();
		if(fechaActual.equals(this.getFechaFin())){
			this.setEstado(new Finalizada());
		}
	}	
	
	


	//Si la fecha es de hoy es igual a la fecha de incio del remate,este se inicia
	public void IniciarRemate(){
	  Calendar fechaActual = Calendar.getInstance();
		if(fechaActual.equals(this.getFechaInicio())){
			this.setEstado(new EnCurso());
		}
	}
	
	public Pasajero anunciarGanador(Remate rem) throws Exception{
		return this.getEstado().anunciarGanador(this);
	}
	
	
	
	public static void main(String[] args) throws Exception {
		Habitacion h=new Habitacion(1,1,null,null, null, null);
		Calendar inicio= Calendar.getInstance();
		Calendar fin= Calendar.getInstance();
		inicio.set(Calendar.DAY_OF_MONTH,29);
		inicio.set(Calendar.MONTH,5);
		inicio.set(Calendar.YEAR,2013);
		fin.set(Calendar.DAY_OF_MONTH,2);
		fin.set(Calendar.MONTH,6);
		fin.set(Calendar.YEAR,2013);
		Pasajero pas1=new Pasajero();
		Pasajero pas2=new Pasajero();
		Pasajero pas3=new Pasajero();
		pas3.setNombre("Santi");
		EnCurso encurso=new EnCurso();
		Finalizada finalizada=new Finalizada();
		Remate rem =new Remate(h,10,inicio,fin,encurso,null);
		rem.ofertar(pas1,15,rem);
		rem.ofertar(pas2,11,rem);
		rem.ofertar(pas3,21, rem);
		rem.estado=finalizada;
		rem.anunciarGanador(rem);

		
	}
	
}
