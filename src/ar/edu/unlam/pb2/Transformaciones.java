package ar.edu.unlam.pb2;

import java.util.Set;

public abstract class Transformaciones extends Criaturas {

	public Transformaciones(Criaturas criatura) {
		super(criatura.getNombre(), 
				criatura.getAfinidadElemental().iterator().next(),
				criatura.getComportamiento());
		this.criatura = criatura;
	}

	protected Criaturas criatura;

	public Set<AfinidadElementalEnum> getAfinidad() {
        return criatura.getAfinidadElemental();
    }

	public ComportamientoEmocionalEnum esInestable() {
		return criatura.getComportamiento();
	}

	public Integer getEnergia() {
		return criatura.getEnergía();
	}

	public abstract void transformacion(Criaturas criatura);

	
}
