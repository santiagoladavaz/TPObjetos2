package TestHotelero;


import org.junit.Before;
import org.junit.Test;
import Hotel.Hotelero;
import Sistema.Sistema;
import Hotel.Oferta;
import static org.mockito.Mockito.*;

public class TestHotelero {

	Hotelero h;
	Sistema s;
	Oferta o;
	
	
	@Before
	public void setUp(){
		s=mock(Sistema.class);
		o=mock(Oferta.class);
		h=new Hotelero(null,s);
	}
	
	
	@Test
	public void testLLegaOferta(){
		h.agregarOferta(o);
		verify(s).agregarOferta(o);
	}
	
	
}
