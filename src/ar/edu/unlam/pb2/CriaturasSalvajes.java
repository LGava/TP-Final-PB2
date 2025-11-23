package ar.edu.unlam.pb2;

import java.util.Random;

public class CriaturasSalvajes extends Criaturas {
	Random random = new Random();

	public CriaturasSalvajes(String nombre, AfinidadElementalEnum afinidadElemental) {
		super(nombre, afinidadElemental);
		this.comportamiento = comportamiento.Inestable;
	}

	@Override
	public void entrenar(Criaturas criatura, int intensidad) throws UncheckedException {
		int random = this.random.nextInt(10);
		
		if(random > 0) {
			int nuevaEnergia = criatura.getEnergía() + (random * intensidad);

			if (nuevaEnergia > 200) {
				throw new UncheckedException("el nivel de energía no puede superar las 200 unidades");
			}
			
			criatura.setEnergía(nuevaEnergia);
		}
	}

	@Override
	public void pacificar(Criaturas criatura, Integer nivelDeMaestria) {
		if(criatura.getComportamiento() == ComportamientoEmocionalEnum.Inestable) {
			if(nivelDeMaestria >= 15) {
				criatura.setComportamiento(comportamiento.Tranquilo);
			}
		}
	}
}
