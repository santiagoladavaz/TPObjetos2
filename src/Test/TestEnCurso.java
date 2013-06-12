package Test;



import org.junit.Before;
import java.util.Calendar;

import org.junit.*;
import org.mockito.Mock;

import Excepsiones.ElRemateEstaEnCurso;
import Remate.EnCurso;
import Remate.Remate;
import Sistema.Pasajero;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
@SuppressWarnings("unused")



public class TestEnCurso {
	
	Remate remate;
	EnCurso enCurso;
	Pasajero p;
	
@Before
public void SetUp(){
	remate=mock(Remate.class);
	p=mock(Pasajero.class);
	enCurso=new EnCurso();
	
}

@Test
public void ofertarTest(){
	enCurso.ofertar(p,10,remate);
	verify(remate).setPrecio(10);
	verify(remate).setPosibleGanador(p);
}
	
@Test
public void setearGanador(){
	enCurso.ofertar(p,10,remate);
	verify(remate).setPosibleGanador(p);
}

@Test
public void anunciarGanadorTest(){
	try{
		enCurso.anunciarGanador(remate);
		fail("Exception not captured");
	}catch(ElRemateEstaEnCurso e){;
		
	}


}


}
