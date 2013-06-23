package TestSistema;


import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Hotel.Estadia;
import Hotel.Habitacion;
import Hotel.Hotel;
import Remate.Remate;
import Sistema.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
public class testSistema {

	Sistema sis;
	Pasajero pas;
	Reserva res;
	Hotel hotel;
	ArrayList<Hotel>hoteles=new ArrayList<Hotel>();
	ArrayList<Resultado>resultadosBusqueda=new ArrayList<Resultado>();
	ArrayList<Habitacion>resHabitaciones=new ArrayList<Habitacion>();
	Habitacion habitacion;
	Remate remate;
	Estadia estadia;
	Busqueda busqueda;
	Resultado resultado;
	
	@Before
	public void setUp() throws Exception {
		remate=mock(Remate.class);
		estadia=mock(Estadia.class);
		busqueda=mock(Busqueda.class);
		habitacion=mock(Habitacion.class);
		resultado=mock(Resultado.class);
		hoteles.add(hotel);
		when(hotel.cumpleCondicionHotel(busqueda)).thenReturn(true);
		when(hotel.cumpleTodasCondiciones(busqueda)).thenReturn(resHabitaciones);
		sis=new Sistema(hoteles,resultadosBusqueda,remate,estadia);
		}
	
	
	public void testBuscarHotelesPor(){
		sis.buscarHotelesPor(busqueda);
		assertTrue(sis.getResultadosBusqueda().size()==1);
	}

	
	@Test
	public void testOfertar() throws Exception{
		sis.ofertar(pas, 0);
		verify(remate).ofertar(pas,0,remate);
	}
	
	
}
