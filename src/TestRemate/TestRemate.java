package TestRemate;

import java.util.Calendar;

import org.junit.*;
import org.mockito.Mock;

import Excepsiones.ElRemateEstaEnCurso;
import Hotel.Habitacion;
import Remate.*;
import Sistema.Pasajero;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;


@SuppressWarnings("unused")
public class TestRemate {

	Habitacion h;
	Pasajero p;
	Pasajero p1;
	Calendar inicio= Calendar.getInstance();
	Calendar fin= Calendar.getInstance();
	Estado estado;
	Remate remate;
	EnCurso enCurso;
	Finalizada finalizada;
	
@Before
public void SetUp() throws Exception{
	//Mock de habitacion
	h=mock(Habitacion.class);
	//Mock de pasajero
	p=mock(Pasajero.class);
	p1=mock(Pasajero.class);
	//Mock de fecha de inicio de remate
	inicio.set(Calendar.DAY_OF_MONTH,29);
	inicio.set(Calendar.MONTH,5);
	inicio.set(Calendar.YEAR,2013);
	//Mock de fecha fin de remate
	fin.set(Calendar.DAY_OF_MONTH,2);
	fin.set(Calendar.MONTH,6);
	fin.set(Calendar.YEAR,2013);
	//Creacion de estado
	enCurso=mock(EnCurso.class);
	//Precio inicial
	int precio=10;
	//Creacion de Objeto Remate
	remate=new Remate(h,precio,inicio,fin,enCurso,p);
	//Mock de finalizada
	finalizada=mock(Finalizada.class);
	when(enCurso.anunciarGanador(remate)).thenReturn(p);
}

@Test
public void testOfertar() throws Exception{
	remate.ofertar(p,20,remate);
	verify(enCurso).ofertar(p,20,remate);
}
@Test
public void testAnunciarGanador() throws Exception{
	remate.anunciarGanador(remate);
	verify(enCurso).anunciarGanador(remate);
}
	
@Test
public void testEstaElGanadorEnCurso() throws Exception{
	try{
		remate.ofertar(p,20,remate);
		remate.anunciarGanador(remate);
		}catch(ElRemateEstaEnCurso e){
			}
     }


}