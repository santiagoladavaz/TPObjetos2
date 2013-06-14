package Hotel;
import Excepsiones.LaHabitacionYaEstaReservada;
import Sistema.Busqueda;


public abstract class EstadoEstadia {
	
	
	public abstract void reservar(Estadia estadia) throws LaHabitacionYaEstaReservada;
	
	
	public abstract boolean cumpleCondiciones(Busqueda busqueda,Habitacion hab,Estadia estadia);
	

}
