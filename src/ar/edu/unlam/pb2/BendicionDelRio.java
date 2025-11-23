package ar.edu.unlam.pb2;

public class BendicionDelRio extends Transformaciones {

	public BendicionDelRio(Criaturas criatura) {
		super(criatura);
		
		if(criatura.getEnergía() * 2 > 180) {
			throw new IllegalArgumentException("no se puede aplicar porque  ya tiene 180 de energia");
		}
	}

	@Override
	public void transformacion(Criaturas criatura) {
		int energiaActual = criatura.getEnergía() * 2;
		criatura.setEnergía(Math.min(energiaActual , 180));
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
