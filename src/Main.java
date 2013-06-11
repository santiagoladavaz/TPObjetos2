import java.util.Calendar;


public class Main {

	
	public static void main(String[] args) throws Exception {
		
		Pasajero pas1=new Pasajero();
		Pasajero pas2=new Pasajero();
		Pasajero pas3=new Pasajero();
		Sistema sis=new Sistema();
		pas3.setNombre("Santi");
		pas1.setSistema(sis);
		pas2.setSistema(sis);
		pas3.setSistema(sis);
		Habitacion h=new Habitacion(1,1,null,null, null, null);
		Calendar inicio= Calendar.getInstance();
		Calendar fin= Calendar.getInstance();
		inicio.set(Calendar.DAY_OF_MONTH,10);
		inicio.set(Calendar.MONTH,6);
		inicio.set(Calendar.YEAR,2013);
		fin.set(Calendar.DAY_OF_MONTH,2);
		fin.set(Calendar.MONTH,6);
		fin.set(Calendar.YEAR,2013);
		EnCurso encurso=new EnCurso();
		Finalizada finalizada=new Finalizada();
		Remate rem =new Remate(h,10,inicio,fin,encurso,null);
		sis.setRemate(rem);
		pas1.ofertar(pas1,11);
		pas2.ofertar(pas2,11);
		pas3.ofertar(pas3,20);
		rem.estado=finalizada;
		rem.anunciarGanador(rem);
	}
}
