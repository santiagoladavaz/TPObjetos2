package TestHotel;

import Hotel.Hotel;
import Hotel.Hotelero;
import Hotel.Oferta;
import Sistema.Sistema;
import static org.mockito.Mockito.mock;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;


public class TestHotelero {

	
	Sistema sis;
	Hotelero hotelero;
	Hotel hotel;
	Oferta of;
	
	
	@Before
	public void setUp(){
		sis=mock(Sistema.class);
		of=mock(Oferta.class);
		hotel=mock(Hotel.class);
		hotelero=new Hotelero(null,sis);
	}
	
	
	@Test
	public void testAgregarOferta(){
		hotelero.agregarOferta(of);
		verify(sis).agregarOferta(of);
	}
	
	@Test
	public void testAgregarHotel(){
		hotelero.agregarHotel(hotel);
		verify(sis).agregarHotel(hotel);
		}


}
