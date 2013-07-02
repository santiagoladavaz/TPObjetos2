package TestPasajero;


import java.util.ArrayList;
import java.util.Calendar;

import org.junit.*;

import Excepsiones.LaHabitacionYaEstaReservada;
import Excepsiones.NoPuedeCalificar;
import Excepsiones.NoPuedeComentar;
import Excepsiones.NoSeEncuentraEstadia;
import Hotel.Estadia;
import Hotel.Habitacion;
import Hotel.Hotel;
import Hotel.Oferta;
import Sistema.Busqueda;
import Sistema.Pasajero;
import Sistema.PreferenciasPasajero;
import Sistema.Reserva;
import Sistema.Sistema;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;



public class TestPasajero {

	Pasajero pas;
	Hotel hotel;
	Sistema sis;
	Reserva reserva;
	Busqueda busqueda;
	PreferenciasPasajero pref;
	Oferta oferta;
	Calendar out;
	Calendar in;
	Calendar outUno;
	Calendar inUno;
	Estadia estadia;
	Habitacion hab;
	
	@Before
	public void setUp() throws Exception {
		//Fecha in = 29/5/2013
		in= Calendar.getInstance();
		in.set(Calendar.DAY_OF_MONTH,29);
		in.set(Calendar.MONTH,5);
		in.set(Calendar.YEAR,2013);

		//Fecha out = 23/6/2013
		out= Calendar.getInstance();
		out.set(Calendar.DAY_OF_MONTH,23);
		out.set(Calendar.MONTH,6);
		out.set(Calendar.YEAR,2013);
		
		//Fecha inUno = 12/12/2013
		inUno= Calendar.getInstance();
		inUno.set(Calendar.DAY_OF_MONTH,12);
		inUno.set(Calendar.MONTH,12);
		inUno.set(Calendar.YEAR,2013);

		//Fecha outUno = 24/12/2013
		outUno= Calendar.getInstance();
		outUno.set(Calendar.DAY_OF_MONTH,24);
		outUno.set(Calendar.MONTH,12);
		outUno.set(Calendar.YEAR,2013);
		
		
		
		
		
		ArrayList<Reserva>reservas=new ArrayList<Reserva>();
		sis=mock(Sistema.class);
		reserva=mock(Reserva.class);
		when(reserva.getEstadia()).thenReturn(estadia);
		busqueda=mock(Busqueda.class);
		hotel=mock(Hotel.class);
		pref=new PreferenciasPasajero(10,20,400, 100, in, out, "Bernal", "Argentina");
		pas=new Pasajero("Santi", reservas, sis, "Santi@hotmail.com");
		pas.setPreferencias(pref);
		estadia=mock(Estadia.class);
		when(estadia.getCheckIn()).thenReturn(inUno);
		when(estadia.getCheckOut()).thenReturn(outUno);
		hab=mock(Habitacion.class);
		ArrayList<Estadia>estadias=new ArrayList<Estadia>();
		when(hab.getEstadias()).thenReturn(estadias);
		oferta=mock(Oferta.class);
		when(oferta.getCiudad()).thenReturn("Bernal");
		when(oferta.getPais()).thenReturn("Argentina");
		when(oferta.getHabitacion()).thenReturn(hab);
	}

	
@Test
public void testAgregarReserva(){
	pas.agregarReserva(reserva);
	assertEquals(pas.getReservas().size(),1);
}

@Test
public void testBuscarHotelesPor(){
	pas.buscarHotelesPor(busqueda);
	verify(sis).buscarHotelesPor(busqueda);
}


@Test
public void testOfertar() throws Exception{
	pas.ofertar(pas,2);
	verify(sis).ofertar(pas, 2);
}

@Test
public void testReservarHabitacion() throws LaHabitacionYaEstaReservada{
	pas.reservarHabitacion(null, null, null, null, null);
	verify(sis).reservarHabitacion(null, null, pas,null,null);
}


@Test
public void testCalificarHotel() throws NoPuedeCalificar{
	pas.calificarHotel(hotel,10);
	verify(sis).calificarHotel(hotel, 10,pas);
	
}


@Test
public void testComentarHotel() throws NoPuedeComentar{
	pas.comentarHotel(hotel, null);
	verify(sis).comentarHotel(hotel, null, pas);
}


@Test
public void testIgualPaisYCiudad(){
	assertTrue(pas.igualPaisYCiudad(oferta));
}


@Test
public void testHayEstadiaEntreFechas(){
	assertTrue(pas.hayEstadiaEntreFechas(oferta,inUno,outUno));
}


@Test
public void testDameEstadiaEntreFechas() throws NoSeEncuentraEstadia{
	assertEquals(pas.dameEstadiaEntreFechas(oferta, in, out),estadia);
}



}
