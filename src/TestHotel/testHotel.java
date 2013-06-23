package TestHotel;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Hotel.Habitacion;
import Hotel.Hotel;
import Sistema.Busqueda;
import Sistema.Reserva;
import static org.mockito.Mockito.*;



public class testHotel {
	Hotel hotel;
	Habitacion hab;
	ArrayList<Habitacion>habitaciones=new ArrayList<Habitacion>();	
	ArrayList<Reserva>reservas=new ArrayList<Reserva>();	
	Busqueda busqueda;
	Reserva reserva;
	
	@Before
	public void setUp(){
		hab=mock(Habitacion.class);
		habitaciones.add(hab);
		busqueda=mock(Busqueda.class);
		when(busqueda.getUnDestino()).thenReturn("Bernal");
		when(hab.cumpleCondiciones(busqueda)).thenReturn(true);
		reserva=mock(Reserva.class);
		hotel=new Hotel(habitaciones, reservas, null, "ElDani","Argentina","Bernal",0,"Cerrito",42515622,
				 		"eldani@hotmail.com",null,null);
		
	}
	
	
	@Test
	public void testIgualDestino(){
		assertTrue(hotel.igualDestino("Bernal"));
	}
	
	
	@Test
	public void testCumpleCondicionLleganMsj(){
		hotel.cumpleTodasCondiciones(busqueda);
		verify(hab).cumpleCondiciones(busqueda);
	}

	@Test
	public void testCumpleCondicionDevuelveTrue(){
		assertTrue(hotel.cumpleTodasCondiciones(busqueda).size()==1);
	}
	
	@Test
	public void testCumpleCondicionHotel(){
		assertTrue(hotel.cumpleCondicionHotel(busqueda));
	}
	
	
	@Test
	public void testMismoHotel(){
		assertTrue(hotel.mismoHotel(hotel));
	}
	
	@Test
	public void testMismaHabitacion(){
		assertTrue(hotel.mismaHabitacion(hab));
	}
	
	@Test
	public void testAgregarReserva(){
		hotel.agregarReserva(reserva);
		assertTrue(hotel.getReservas().size()==1);
	}
}


