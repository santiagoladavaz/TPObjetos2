package Test;

import org.junit.Before;
import java.util.Calendar;

import org.junit.*;
import org.mockito.Mock;

import Excepsiones.ElRemateEstaEnCurso;
import Excepsiones.ElRemateFinalizo;
import Remate.Finalizada;
import Remate.Remate;
import Sistema.Pasajero;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
@SuppressWarnings("unused")


public class TestFinalizada {
	
	Remate remate;
	Finalizada finalizada;
	Pasajero p;

	@Before
	public void SetUp(){
		remate=mock(Remate.class);
		p=mock(Pasajero.class);
		finalizada=new Finalizada();
	}
	
	@Test
	public void ofertarTest() throws Exception{
		try{
			finalizada.ofertar(p,10,remate);
			fail("Exception not captured");
		}catch(ElRemateFinalizo e){
		}
	}
	
	@Test
	public void anunciarGanadorTest() throws Exception{
		finalizada.anunciarGanador(remate);
		verify(remate).getPosibleGanador();
	}
	
	
	
	
}
