package Hotel;
import Excepsiones.LaHabitacionYaEstaReservada;
import Sistema.Busqueda;


public class Reservada extends EstadoEstadia {

	
	public void reservar(Estadia estadia) throws LaHabitacionYaEstaReservada {
		throw new LaHabitacionYaEstaReservada();
	}

	
	public boolean cumpleCondiciones(Busqueda busqueda,Habitacion hab,Estadia estadia){
		return false;
	}

}
