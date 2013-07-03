package TestDescuento;

import java.util.Calendar;

import org.junit.Before;

import Descuento.DescuentoHastaFecha;
import Hotel.Estadia;
import org.junit.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class TestDescuentoHastaFecha {

	
	Estadia est;
	DescuentoHastaFecha desc;
	Calendar limite;
	Calendar tope;
	Calendar in;
	
	@Before
	public void setUp(){
		//Fecha limite = 29/5/2013
		limite= Calendar.getInstance();
		limite.set(Calendar.DAY_OF_MONTH,29);
		limite.set(Calendar.MONTH,5);
		limite.set(Calendar.YEAR,2013);

		//Fecha tope = 23/6/2013
		tope= Calendar.getInstance();
		tope.set(Calendar.DAY_OF_MONTH,23);
		tope.set(Calendar.MONTH,6);
		tope.set(Calendar.YEAR,2013);
		
		
		
		//Fecha limite = 3/3/2013
		in= Calendar.getInstance();
		in.set(Calendar.DAY_OF_MONTH,3);
		in.set(Calendar.MONTH,3);
		in.set(Calendar.YEAR,2013);
		
		desc=new DescuentoHastaFecha(10,limite,tope);
		est=mock(Estadia.class);
		when(est.getCheckIn()).thenReturn(in);
		when(est.getPrecio()).thenReturn(200);
		}
	
	
	@Test
	public void testAplicarDescuento(){
		System.out.println(desc.getFechaTope());
		assertTrue(desc.aplicarDescuento(est)==180);
	}
}
