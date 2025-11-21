package ar.edu.unlam.pb2;

public abstract class BendicionDelRio extends Transformaciones {

	public BendicionDelRio(Criaturas criatura) {
		super(criatura);
	}

	@Override
	public void transformacion(Criaturas criatura) {
		this.criatura = criatura;
		
		criatura.setEnergía(Math.min(getEnergia() * 2, 180));
	}

}
