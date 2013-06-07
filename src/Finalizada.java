import Excepsiones.ElRemateFinalizo;


public class Finalizada extends Estado{
	
	
	
	

	@Override
	public void ofertar(Pasajero unPasajero, int unPrecio,Remate rem) throws Exception {
		throw new ElRemateFinalizo();
	}

	@Override
	public Pasajero anunciarGanador(Remate rem) throws Exception {
		System.out.println(rem.getPosibleGanador().getNombre());
		return rem.getPosibleGanador();
		
	}


	
	
	

}
