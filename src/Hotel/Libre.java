package Hotel;

import Sistema.Busqueda;


public class Libre extends EstadoEstadia {

	@Override
public void reservar(Estadia estadia){
	estadia.setEstado(new Reservada());
 }

public boolean cumpleCondiciones(Busqueda bus,Habitacion hab,Estadia estadia){
	return hab.cumpleCapacidad(bus.getCantHuespedes())
	       &estadia.cumpleCheckIn(bus.getFechaIngreso())
	       &estadia.cumpleCheckOut(bus.getFechaSalida());
 }
	
	
}
