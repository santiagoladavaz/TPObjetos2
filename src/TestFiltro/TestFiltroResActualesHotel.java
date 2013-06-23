package TestFiltro;

import java.util.Calendar;

import org.junit.Before;

import Filtro.FiltroResActualesHotel;
import Hotel.*;
import Sistema.*;
import org.junit.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestFiltroResActualesHotel {

	Estadia est;
	Reserva res;
	FiltroResActualesHotel resActual;
	Calendar inicio= Calendar.getInstance();
	Calendar fin= Calendar.getInstance();
	

@Before
public void setUp(){
	inicio.set(Calendar.DAY_OF_MONTH,22);
	inicio.set(Calendar.MONTH,6);
	inicio.set(Calendar.YEAR,2013);
	
	fin.set(Calendar.DAY_OF_MONTH,27);
	fin.set(Calendar.MONTH,6);
	fin.set(Calendar.YEAR,2013);
	
	est=mock(Estadia.class);
	res=mock(Reserva.class);
	when(res.getEstadia()).thenReturn(est);
	when(est.getCheckOut()).thenReturn(fin);
	when(est.getCheckIn()).thenReturn(inicio);
	resActual= new FiltroResActualesHotel();
	
}
	

@Test
public void testCumpleCondicion(){
	assertFalse(resActual.cumpleCondicion(res));
}
	


}
