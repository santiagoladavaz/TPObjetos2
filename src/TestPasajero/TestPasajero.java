package TestPasajero;


import java.util.ArrayList;
import org.junit.*;

import Excepsiones.LaHabitacionYaEstaReservada;
import Sistema.Busqueda;
import Sistema.Pasajero;
import Sistema.Reserva;
import Sistema.Sistema;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;



public class TestPasajero {

	Pasajero pas;
	Sistema sis;
	Reserva reserva;
	Busqueda busqueda;
	
	@Before
	public void setUp() throws Exception {
		ArrayList<Reserva>reservas=new ArrayList<Reserva>();
		sis=mock(Sistema.class);
		reserva=mock(Reserva.class);
		busqueda=mock(Busqueda.class);
		pas=new Pasajero("Santi", reservas, sis, "Santi@hotmail.com");
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
public void reservarHabitacion() throws LaHabitacionYaEstaReservada{
	pas.reservarHabitacion(null, null, null, null, null);
	verify(sis).reservarHabitacion(null, null, pas,null,null);
}




}
