package ar.edu.unlam.pb2;

public abstract class VinculoTerrestre extends Transformaciones{

	public VinculoTerrestre(Criaturas criatura) {
		super(criatura);

	}

	@Override
	public void transformacion(Criaturas criatura) {
		this.criatura = criatura;
		
		criatura.setEnergía(Math.max(getEnergia(), 50));
	}

}
