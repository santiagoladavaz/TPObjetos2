package Hotel;
import Excepsiones.LaHabitacionYaEstaReservada;
import Sistema.Busqueda;


public class Reservada extends EstadoHabitacion {

	@Override
	public void reservar(Habitacion hab) throws LaHabitacionYaEstaReservada {
		throw new LaHabitacionYaEstaReservada();
	}

	
	public boolean cumpleCondiciones(Busqueda busqueda,Habitacion hab){
		return false;
	}

}
