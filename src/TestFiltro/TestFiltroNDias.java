package TestFiltro;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import Filtro.*;
import Hotel.Estadia;
import Sistema.Reserva;


public class TestFiltroNDias {

	Estadia est;
	Reserva res;
	FiltroReservaNDiasHotel resNDias;
	Calendar inicio= Calendar.getInstance();
	Calendar fin= Calendar.getInstance();
	

@Before
public void setUp(){
	inicio.set(Calendar.DAY_OF_MONTH,24);
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
	resNDias= new FiltroReservaNDiasHotel(2);
	
}
	
@Test
public void testCumpleCondicion(){
	assertFalse(resNDias.cumpleCondicion(res));
}
	
	
	
	
	
	
	
}
