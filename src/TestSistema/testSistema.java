package TestSistema;


import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import Excepsiones.LaHabitacionYaEstaReservada;
import Excepsiones.NoPuedeCalificar;
import Excepsiones.NoPuedeComentar;
import Hotel.Estadia;
import Hotel.Habitacion;
import Hotel.Hotel;
import Hotel.Oferta;
import Remate.Remate;
import Sistema.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
public class testSistema {

	Sistema sis;
	Pasajero pas;
	Reserva res;
	Hotel hotel;
	ArrayList<Hotel>hoteles=new ArrayList<Hotel>();
	ArrayList<Resultado>resultadosBusqueda=new ArrayList<Resultado>();
	ArrayList<Habitacion>resHabitaciones=new ArrayList<Habitacion>();
	Habitacion habitacion;
	Remate remate;
	Estadia estadia;
	Busqueda busqueda;
	Resultado resultado;
	Calendar in;
	Calendar out;
	Oferta oferta;
	
	@Before
	public void setUp() throws Exception {
		//Fecha in = 29/5/2013
		in= Calendar.getInstance();
		in.set(Calendar.DAY_OF_MONTH,29);
		in.set(Calendar.MONTH,5);
		in.set(Calendar.YEAR,2013);

		//Fecha out = 12/12/2013
		out= Calendar.getInstance();
		out.set(Calendar.DAY_OF_MONTH,12);
		out.set(Calendar.MONTH,12);
		out.set(Calendar.YEAR,2013);
		
		//Mock de remate
		remate=mock(Remate.class);

		//Mock de busqueda
		busqueda=mock(Busqueda.class);
		when(busqueda.getCantHuespedes()).thenReturn(4);
		when(busqueda.getFechaIngreso()).thenReturn(in);
		when(busqueda.getFechaSalida()).thenReturn(out);
		when(busqueda.getUnDestino()).thenReturn("Bernal");
		
		//Mock de habitacion
		habitacion=mock(Habitacion.class);
		
		//Mock de resultado
		resultado=mock(Resultado.class);
		when(resultado.getHotel()).thenReturn(hotel);
		//Mock de pasajero
		pas=mock(Pasajero.class);
		//Mock de hotel
		hotel=mock(Hotel.class);
		when(hotel.getCiudad()).thenReturn("Bernal");
		when(hotel.mismoHotel(hotel)).thenReturn(true);
		when(hotel.mismaHabitacion(habitacion)).thenReturn(true);
		
		//Mock de estadia
		estadia=mock(Estadia.class);
		when(estadia.getCheckIn()).thenReturn(in);
		when(estadia.getCheckOut()).thenReturn(out);
		
		//mock de reserva
		res=mock(Reserva.class);
		when(res.getHotel()).thenReturn(hotel);
		when(res.getEstadia()).thenReturn(estadia);
		
	
		hoteles.add(hotel);
		when(hotel.cumpleCondicionHotel(busqueda)).thenReturn(true);
		when(hotel.cumpleTodasCondiciones(busqueda)).thenReturn(resHabitaciones);
		
		//Mock de Oferta
		oferta=mock(Oferta.class);
		
		//Instancia de sistema
		sis=new Sistema(hoteles,resultadosBusqueda,remate,estadia);
		}
	

	
	@Test
	public void testOfertar() throws Exception{
		sis.ofertar(pas,10);
		verify(remate).ofertar(pas,10,remate);
	}
	
	
	@Test
	public void testPuedeCalificar(){
		assertTrue(sis.puedeCalificarYComentarAHotel(hotel, pas));
		
	}
	
	@Test
	public void testCalificarHotel(){
		try{  
			sis.calificarHotel(hotel, 10,pas);
		    fail("Exception not captured");
	        }catch(NoPuedeCalificar e){
	       }
	}

	@Test
	public void testAgregarComentario(){
		try{
			sis.comentarHotel(hotel, "Gran Hotel",pas);
			  fail("Exception not captured");
		}catch(NoPuedeComentar e){
		}
	}
	
	
   @Test
   public void testBuscarHoteles(){
	   System.out.println(sis.getResultadosBusqueda().size());
	   sis.buscarHotelesPor(busqueda);
	   System.out.println(sis.getResultadosBusqueda().size());
	   assertTrue(sis.getResultadosBusqueda().size()==1);
   }
	
   
   @Test
   public void testAgregarResultado(){
	   sis.agregarResultado(resultado);
	   assertTrue(sis.getResultadosBusqueda().size()==1);
   }
   
   
   @Test
   public void testAgregarOfertas(){
	   sis.agregarOferta(oferta);
	   assertTrue(sis.getOfertas().size()==1);
   }
   
   @Test
   public void testConcretarReserva(){
	   sis.concretarReserva(hotel, pas);
	   verify(hotel).getEmail();
	   verify(pas).getMail();
   }
   
   @Test
	public void testReservarHotel() throws LaHabitacionYaEstaReservada{
		sis.reservarHabitacion(hotel, habitacion, pas, in, out);
		verify(habitacion).reservate(estadia);
		verify(pas).agregarReserva(res);
		verify(hotel).agregarReserva(res);
	}
	
   
   
}
