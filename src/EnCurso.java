import Excepsiones.*;


public class EnCurso extends Estado {

	

	@Override
	public void ofertar(Pasajero unPasajero,int unPrecio,Remate rem) {
		if(rem.getPrecio()<unPrecio){
			rem.setPrecio(unPrecio);
			rem.setPosibleGanador(unPasajero);
			System.out.println(rem.getPrecio());
			}
		else{
			System.out.println("La oferta es menor al monto propuesto");
		}
		}

	@Override
	public Pasajero anunciarGanador(Remate rem) throws ElRemateEstaEnCurso {
		throw new ElRemateEstaEnCurso();
	}


	
	
}
