package TestHotel;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Hotel.Habitacion;
import Hotel.Hotel;
import Hotel.Servicio;
import Hotel.ServicioHotel;
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
	ServicioHotel sh;
	Servicio ser;
	
	@Before
	public void setUp(){
		hab=mock(Habitacion.class);
		habitaciones.add(hab);
		busqueda=mock(Busqueda.class);
		when(busqueda.getUnDestino()).thenReturn("Bernal");
		when(hab.cumpleCondiciones(busqueda)).thenReturn(true);
		reserva=mock(Reserva.class);
		ArrayList<Integer> cals = new ArrayList<Integer>();
		ArrayList<Servicio> servicios =new ArrayList<Servicio> ();
		cals.add(10);
		cals.add(10);
		cals.add(10);
		ser=mock(Servicio.class);
		sh=mock(ServicioHotel.class);
		ArrayList<String> comentarios = new ArrayList<String>();
		hotel=new Hotel(habitaciones, reservas, servicios, "ElDani","Argentina","Bernal",0,"Cerrito",42515622,
				 		"eldani@hotmail.com",comentarios,cals);
		
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
	
	@Test
	public void testPuntajePromedio(){
		assertTrue(hotel.puntajePromedio()==10);
	}
	
	@Test
	public void testAgregarServicio(){
		hotel.agregarServicioAHotel(hotel,sh);
		assertTrue(hotel.getServicios().size()==0);
	}
	
	@Test
	public void testAgregarComentario(){
		hotel.agregarComentario("Gran Hotel");
		assertTrue(hotel.getComentarios().size()==1);
	}
	

	@Test
	public void testAgregarCalificacion(){
		hotel.agregarCalificacion(10);
		assertTrue(hotel.getCalificaciones().size()==4);
	}
	

}


