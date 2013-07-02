package TestFiltro;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import Hotel.Estadia;
import Hotel.Hotel;
import Sistema.Reserva;

public class TestReserva {

	
		Estadia est;
		Reserva res;
		Calendar in;
		Calendar out;
		Calendar in1;
		Hotel hotel;
		
	@Before
	public void setUp(){
		//Fecha in = 29/5/2013
		in= Calendar.getInstance();
		in.set(Calendar.DAY_OF_MONTH,29);
		in.set(Calendar.MONTH,5);
		in.set(Calendar.YEAR,2013);

		//Fecha out = 12/12/2013
		out= Calendar.getInstance();
		out.set(Calendar.DAY_OF_MONTH,12);
		out.set(Calendar.MONTH,12);
		out.set(Calendar.YEAR,2013);
		
		est=mock(Estadia.class);
		when(est.getCheckIn()).thenReturn(in);
		when(est.getCheckIn()).thenReturn(out);
		
		
		//Fecha in1 = 5/7/2013
		in1= Calendar.getInstance();
		in1.set(Calendar.DAY_OF_MONTH,5);
		in1.set(Calendar.MONTH,7);
		in1.set(Calendar.YEAR,2013);
		
		hotel=mock(Hotel.class);
		when(hotel.getCiudad()).thenReturn("Bernal");
		
		res=new Reserva(hotel, null, null, est);
	
	
	}
	
	
	@Test
	public void testEsReservaActual(){
		assertTrue(res.esReservaActual());
	}
	
	@Test
	public void testEsReservaFutura(){
		res.getEstadia().setCheckIn(in1);
		assertTrue(res.esReservaFutura());
		
	}
	
	
	@Test
	public void testEsReservaConNDias(){
		res.getEstadia().setCheckIn(in1);
		assertTrue(res.esReservaConInicioNDias(7));
	}
	
	@Test
	public void testEsReservaCiudadParticula(){
		assertTrue(res.esReservaDeUnaCiudad("Bernal"));
	}
}
