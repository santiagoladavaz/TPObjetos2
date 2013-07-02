package TestRemate;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import org.junit.Before;
import org.junit.Test;
import Excepsiones.ElRemateNoSeInicio;
import Remate.Remate;
import Remate.SinIniciar;
import Sistema.Pasajero;

public class TestSinIniciar {
	
	Remate remate;
	SinIniciar sinI;
	Pasajero p;
	
	
	@Before
	public void SetUp(){
		remate=mock(Remate.class);
		p=mock(Pasajero.class);
		sinI=new SinIniciar();
		
	}
	
	@Test
	public void testAnunciarGanador() throws Exception{
		try{
			sinI.anunciarGanador(remate);
			fail("Exception not captured");
		}catch(ElRemateNoSeInicio e){;
		   }
	}
	
	
	@Test
	public void testOfertar() throws Exception{
		try{
			sinI.ofertar(p,10,remate);
			fail("Exception not captured");
		}catch(ElRemateNoSeInicio e){;
		   }
	}

	
}