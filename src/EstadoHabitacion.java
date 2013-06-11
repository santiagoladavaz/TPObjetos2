import Excepsiones.LaHabitacionYaEstaReservada;


public abstract class EstadoHabitacion {
	
	
	public abstract void reservar(Habitacion hab) throws LaHabitacionYaEstaReservada;
	
	
	public abstract boolean cumpleCondiciones(Busqueda busqueda,Habitacion hab);
	

}
