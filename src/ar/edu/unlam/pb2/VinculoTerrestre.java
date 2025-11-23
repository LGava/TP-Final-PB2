package ar.edu.unlam.pb2;

public class VinculoTerrestre extends Transformaciones{

	public VinculoTerrestre(Criaturas criatura) {
		super(criatura);
		
		if(criatura.getEnergía() < 50) {
			criatura.setEnergía(50);
		}
	
	}

	@Override
	public void transformacion(Criaturas criatura) {
		int energiaActual = criatura.getEnergía();
	}
 
	@Override
	public Integer getEnergia() {
		return criatura.getEnergía();
	}
	@Override
	public String getNombre() {
		return criatura.getNombre();
	}
	
	@Override
	public ComportamientoEmocionalEnum getComportamiento() {
		return criatura.getComportamiento();
	}
}
