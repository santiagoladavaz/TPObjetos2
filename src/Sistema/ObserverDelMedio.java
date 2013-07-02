package Sistema;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;
import Excepsiones.NoSeEncuentraEstadia;
import Hotel.Estadia;
import Hotel.Habitacion;
import Hotel.Libre;
import Hotel.Oferta;

public class ObserverDelMedio implements Observer{

  ArrayList<Pasajero>pasajeros=new ArrayList<Pasajero>();
  
  

   //Getters & Setters
   public ArrayList<Pasajero> getPasajeros() {
	return pasajeros;
   }

   public void setPasajeros(ArrayList<Pasajero> pasajeros) {
	   this.pasajeros = pasajeros;
   }


   
   public void update(Observable arg0, Object arg) {
		Oferta oferta = (Oferta)arg;
		
		
		for(Pasajero pas:this.pasajeros){	
	    	if(hayEstadiaEntreFechas(oferta, pas.getPreferencias().getFechaInicio(), pas.getPreferencias().getFechaFin())) {
	    		
			try {
				Estadia e = this.dameEstadiaEntreFechas(oferta, pas.getPreferencias().getFechaInicio(), pas.getPreferencias().getFechaFin());
				// Pregunta si el precio de la estadia es menor o igual al precio que está dispuesto
				// pagar el Pasajero
				if(e.esMenor(pas.getPreferencias().getPrecioMenor())) {
					this.mandarMail(pas);
				}
				else {
					// Pregunta si el precio de la estadia es mayor al mínimo que pretende pagar
					if(e.esMayor(pas.getPreferencias().getPrecioMayor())) {
						this.mandarMail(pas);
					}
					else {
						if(e.esMenor(pas.getPreferencias().getPrecioMaximo()) & e.esMayor(pas.getPreferencias().getPrecioMinimo())) {
							this.mandarMail(pas);
						}
					}
				}
			}catch (NoSeEncuentraEstadia e) {
				e.printStackTrace();
			}
		}
	}
}
	
	
   //Agregado por Diego	//Testeado - no corre
	public Estadia dameEstadiaEntreFechas(Oferta oferta, Calendar fechaInicial, Calendar fechaFinal) throws NoSeEncuentraEstadia {
		Estadia res = null;
		for(Estadia e: oferta.getHabitacion().getEstadias()){
			if(this.hayEstadiaEntreFechas(oferta, fechaInicial, fechaFinal)) {
				res = e;
			}
			else {
				throw new NoSeEncuentraEstadia();}
		         }
		return res;
	}
	
	
	public boolean hayEstadiaEntreFechas(Oferta o, Calendar fechaInicial, Calendar fechaFinal) {
		boolean res = false;
		for(Estadia e: o.getHabitacion().getEstadias()){
			if(e.getCheckIn().after(fechaInicial) & e.getCheckOut().before(fechaFinal))
			      {res = true;
			       break;}
			}
	return res;
 }
	
	
	public void mandarMail(Pasajero pas)
	{
		System.out.println(pas.getNombre()+" Llego una nueva oferta de si interes");
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		//Fecha in = 29/5/2013
		Calendar in= Calendar.getInstance();
		in.set(Calendar.DAY_OF_MONTH,29);
		in.set(Calendar.MONTH,5);
		in.set(Calendar.YEAR,2013);

		//Fecha out = 12/12/2013
		Calendar out= Calendar.getInstance();
		out.set(Calendar.DAY_OF_MONTH,12);
		out.set(Calendar.MONTH,12);
		out.set(Calendar.YEAR,2013);
		
		
		
		Libre libre=new Libre();
		Estadia estadia=new Estadia(in,out, 100, libre);
		ArrayList<Estadia>estadias=new ArrayList<Estadia>();
		estadias.add(estadia);
		Habitacion hab=new Habitacion(1,3, estadias,null);
		Oferta oferta=new Oferta(hab,"Arg","Bernal");
		
		Pasajero pas=new Pasajero("Santi",null,null,"santi@g");
		PreferenciasPasajero pref=new PreferenciasPasajero(100,200,400,50,in,out,"Bernal","Arg");
		
		pas.setPreferencias(pref);
		ArrayList<Pasajero>pasajeros=new ArrayList<Pasajero>();
		pasajeros.add(pas);
		
		ObserverDelMedio delMedio=new ObserverDelMedio();
		delMedio.setPasajeros(pasajeros);
		
		delMedio.update(null,oferta);
		
		
		
		
	}
	
	
	
}