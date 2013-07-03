package TestDescuento;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import Descuento.DescuentoPorPeriodo;
import Hotel.Estadia;


public class TestDescuentoPorPeriodo {

	
	DescuentoPorPeriodo desc;
	Estadia est;
	
	
	@Before
	public void setUp(){
		desc=new DescuentoPorPeriodo(10,null,null,null);
		est=mock(Estadia.class);
		when(est.getPrecio()).thenReturn(200);
	}
	
	
	@Test
	public void testAplicarDescuento(){
		assertTrue(desc.aplicarDescuento(est)==180);
	}
	
}
