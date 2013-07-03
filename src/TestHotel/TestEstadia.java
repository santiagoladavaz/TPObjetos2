package TestHotel;

import org.junit.Before;
import java.util.Calendar;
import org.junit.*;

import Descuento.Descuento;
import Excepsiones.LaHabitacionYaEstaReservada;
import Hotel.Estadia;
import Hotel.Libre;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
public class TestEstadia {

	
	Estadia est;
	Calendar in;
	Calendar out;
	Calendar in1;
	Calendar out1;
	Libre libre;
	Descuento descuento;
	
	
	@Before
	public void setUp() throws Exception {
		libre=mock(Libre.class);
		
		//Fecha in = 29/5/2013
		in= Calendar.getInstance();
		in.set(Calendar.DAY_OF_MONTH,29);
		in.set(Calendar.MONTH,5);
		in.set(Calendar.YEAR,2013);

		//Fecha out = 2/6/2013
		out= Calendar.getInstance();
		out.set(Calendar.DAY_OF_MONTH,2);
		out.set(Calendar.MONTH,6);
		out.set(Calendar.YEAR,2013);
		
	
		in1= Calendar.getInstance();
		in1.set(Calendar.DAY_OF_MONTH,30);
		in1.set(Calendar.MONTH,5);
		in1.set(Calendar.YEAR,2013);
		
		out1= Calendar.getInstance();
		out1.set(Calendar.DAY_OF_MONTH,27);
		out1.set(Calendar.MONTH,8);
		out1.set(Calendar.YEAR,2013);
		
		descuento=mock(Descuento.class);
		when(descuento.getFechaLimiteDeReserva()).thenReturn(out1);
		
		//Se crea la estadia
		est=new Estadia(in,out,200,libre);
		est.setDescuento(descuento);

		
	}

	@Test
	public void testIgualCheckIn(){
		assertFalse(est.cumpleCheckIn(in1));
	}

	@Test
	public void testIgualCheckOut(){
		assertTrue(est.cumpleCheckOut(out));
	}
	
	@Test
	public void testCumpleCondicion(){
		est.cumpleCondiciones(null, null);
		verify(libre).cumpleCondiciones(null,null,est);
	}
	
	
	@Test
	public void testReservar() throws LaHabitacionYaEstaReservada{
		est.reservar();
		verify(libre).reservar(est);
		}
	
	
	@Test
	public void testEsMenor(){
		assertTrue(est.esMenor(300));
	}
	
	@Test
	public void testEsMayor(){
		assertTrue(est.esMayor(100));
   }

   @Test
   public void testAplicarDescuento(){
	   est.precioConDescuento();
	   verify(descuento).aplicarDescuento(est);
   }

   
   @Test
   public void testEstaVigenteDescuento(){
	   assertTrue(est.estaVigenteDescuento());
   }
   
   
   
   
}
