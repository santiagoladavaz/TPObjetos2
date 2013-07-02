package TestHotel;

import org.junit.*;
import Hotel.*;
import Sistema.Busqueda;
import static org.mockito.Mockito.*;


public class TestEstadiaLibre {
	Libre libre;
	Estadia estadia;
	Reservada reservada;
	Reservada res;
	Busqueda bus;
	Estadia est;
	Habitacion hab;
	
	@Before
	public void setUp(){
		libre =new Libre();
		reservada=mock(Reservada.class);
		bus=mock(Busqueda.class);
		est=mock(Estadia.class);
		hab=mock(Habitacion.class);
		estadia=mock(Estadia.class);
		
		
	}
	
	
	
	//@Test
	public void testReservar(){
		libre.reservar(estadia);
	    verify(estadia).setEstado(new Reservada());
	}
	
	@Test
	public void testCumpleCondiciones(){
		libre.cumpleCondiciones(bus,hab,estadia);
		verify(hab).cumpleCapacidad(bus.getCantHuespedes());
		verify(estadia).cumpleCheckIn(null);
		verify(estadia).cumpleCheckOut(null);
	}
	
}
