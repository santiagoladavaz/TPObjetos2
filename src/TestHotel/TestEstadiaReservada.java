package TestHotel;

import static org.junit.Assert.*;

import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import Excepsiones.LaHabitacionYaEstaReservada;
import Hotel.Estadia;
import Hotel.Habitacion;
import Hotel.Reservada;
import Sistema.Busqueda;


public class TestEstadiaReservada {

	Reservada reservada;
	Reservada res;
	Busqueda bus;
	Estadia est;
	Habitacion hab;
	
	
	@Before
	public void setUp(){
		
		reservada=new Reservada();
		bus=mock(Busqueda.class);
		est=mock(Estadia.class);
		hab=mock(Habitacion.class);
		
	}
	
	@Test
	public void testReservar(){
		try{
			reservada.reservar(est);
			fail("Exception not captured");
		}catch(LaHabitacionYaEstaReservada e){
		}
	}
	
	
	@Test
	public void testCumpleCondicion(){
		assertFalse(reservada.cumpleCondiciones(bus, hab, est));
	}
	
}


