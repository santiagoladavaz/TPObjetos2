package TestFiltro;

import static org.junit.Assert.*;
import Filtro.FiltroCiudadEnParticular;
import Hotel.Hotel;
import Sistema.Reserva;
import org.junit.*;
import static org.mockito.Mockito.*;


public class TestCiudadEnParticular {

	Reserva reserva;
	Hotel hotel;
	FiltroCiudadEnParticular cp;

@Before
public void setUp(){
	reserva=mock(Reserva.class);
	hotel=mock(Hotel.class);
	when(reserva.getHotel()).thenReturn(hotel);
	when(hotel.getCiudad()).thenReturn("PASCO");
	cp=new FiltroCiudadEnParticular("PASCO");
	
}
	
@Test
public void testEsCiudadEnParticular(){
	assertTrue(cp.cumpleCondicion(reserva));
}
	
@Test
public void testNoEsCiudadEnParticular(){
	cp.setCiudad("Bernal");
	assertFalse(cp.cumpleCondicion(reserva));
}





}
