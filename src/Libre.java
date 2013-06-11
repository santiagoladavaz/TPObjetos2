
public class Libre extends EstadoHabitacion {

	@Override
public void reservar(Habitacion hab){
	hab.setEstado(new Reservada());
 }

public boolean cumpleCondiciones(Busqueda bus,Habitacion hab){
	return hab.cumpleCapacidad(bus.getCantHuespedes())&hab.cumpleCheckIn(bus.getFechaIngreso())&hab.cumpleCheckOut(bus.getFechaSalida());
 }
	
	
}
