package ar.edu.unlam.pb2;

import java.util.Random;

public class CriaturasSalvajes extends Criaturas {
	Random random = new Random();

	public CriaturasSalvajes(String nombre, AfinidadElementalEnum afinidadElemental,
			ComportamientoEmocionalEnum comportamiento) {
		super(nombre, afinidadElemental, comportamiento.Inestable);
	}


	public void entrenar(Criaturas criatura, int intensidad) throws UncheckedException {

		int random = this.random.nextInt(5) + (10);
		this.energia += (random * intensidad);


		if (energia > 200) {
			throw new UncheckedException("el nivel de energía no puede superar las 200 unidades");
		}
	}

}
