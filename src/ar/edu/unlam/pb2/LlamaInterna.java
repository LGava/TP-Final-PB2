package ar.edu.unlam.pb2;

import java.util.Set;

<<<<<<< HEAD
public abstract class LlamaInterna extends Transformaciones {
=======
public class LlamaInterna extends Transformaciones {
>>>>>>> master

	public LlamaInterna(Criaturas criatura) {
		super(criatura);
	}

	@Override
	public void transformacion(Criaturas criatura) {
		this.criatura = criatura;
		
		Set<AfinidadElementalEnum> afinidades = criatura.getAfinidadElemental();

		if (afinidades.contains(AfinidadElementalEnum.FUEGO)) {
			criatura.setEnergía(getEnergía() + 30);
		} else {
			criatura.setComportamiento(ComportamientoEmocionalEnum.Inestable);
		}

	}

}
