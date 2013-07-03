package TestHotel;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import Excepsiones.LaHabitacionYaEstaReservada;
import Hotel.*;
import Sistema.Busqueda;
import static org.mockito.Mockito.*;


public class TestHabitacion {
	
	Estadia estadia;
	Habitacion hab;
	Busqueda bus;
	ArrayList<Estadia>estadias=new ArrayList<Estadia>();
	Calendar in= Calendar.getInstance();
	Calendar out= Calendar.getInstance();
	
	
	@Before
	public void setUp(){
		estadia=mock(Estadia.class);
		when(estadia.cumpleCondiciones(bus, hab)).thenReturn(true);
		estadias.add(estadia);
		bus=mock(Busqueda.class);
		hab=new Habitacion(1,4,estadias,null);
		
		in= Calendar.getInstance();
		in.set(Calendar.DAY_OF_MONTH,29);
		in.set(Calendar.MONTH,5);
		in.set(Calendar.YEAR,2013);
		
		out= Calendar.getInstance();
		out.set(Calendar.DAY_OF_MONTH,2);
		out.set(Calendar.MONTH,6);
		out.set(Calendar.YEAR,2013);
		
		when(estadia.getCheckIn()).thenReturn(in);
		when(estadia.getCheckOut()).thenReturn(out);
		when(estadia.cumpleCheckIn(in)).thenReturn(true);
		when(estadia.cumpleCheckOut(out)).thenReturn(true);
		when(estadia.estaVigenteDescuento()).thenReturn(true);
	}
	


	
	@Test
	public void testCumpleCapacidad(){
		assertTrue(hab.cumpleCapacidad(4));
	}

	@Test
	public void testCumpleCondicion(){
		hab.cumpleCondiciones(bus);
		verify(estadia).cumpleCondiciones(bus,hab);
	}
	
	@Test
	public void testMismaHabitacin(){
		assertTrue(hab.mismaHabitacion(hab));
	}
	
	@Test
	public void testReservate() throws LaHabitacionYaEstaReservada{
		hab.reservate(estadia);
		verify(estadia).reservar();
		}
	
	@Test
	public void testEsIgualEstadia(){
		assertEquals(hab.esIgualEstadia(in,out),estadia);
	}
	
	@Test
	public void testEsIgualEstadia2(){
		hab.esIgualEstadia(in,out);
		verify(estadia).cumpleCheckIn(in);
		verify(estadia).cumpleCheckOut(out);
	}
	
	
	@Test
	public void testEstadiasConDescuentosVigentes(){
		assertTrue(hab.estadiasConDescuentosVigentes().size()==1);
	}
	
	
	@Test
	public void testHayEstadias(){
		assertFalse(hab.hayEstadias());
	}

	@Test
	public void testFiltrarHabitacionesSinDescuentos(){
		hab.filtrarHabitacionesSinDescuentos();
		assertTrue(hab.getEstadias().size()==1);
	}
	
	@Test
	public void testHabitacionesConEstadiaEntre(){
		hab.habitacionesConEstadiaEntre(in,out);
		verify(estadia).estadiaEntre(hab,in,out);
	}

	@Test
	public void testHabitacionesConEstadiaAnteriorA(){
		hab.habitacionesConEstadiaAnteriorA(in);
		verify(estadia).estadiaAnteriorA(hab,in);
	}

}
