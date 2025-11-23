package ar.edu.unlam.pb2;

import java.util.Set;

public class LlamaInterna extends Transformaciones {

	public LlamaInterna(Criaturas criatura) {
		super(criatura);
	}

	@Override
	public void transformacion(Criaturas criatura) {

	    Set<AfinidadElementalEnum> afinidades = criatura.getAfinidadElemental();

	    if (afinidades.contains(AfinidadElementalEnum.FUEGO)) {
	        int energiaActual = criatura.getEnergía() + 30;
	        criatura.setEnergía(Math.min(energiaActual, 200));
	    }
	    if (!afinidades.contains(AfinidadElementalEnum.FUEGO)){
	        criatura.setComportamiento(ComportamientoEmocionalEnum.Inestable);
	    }
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
