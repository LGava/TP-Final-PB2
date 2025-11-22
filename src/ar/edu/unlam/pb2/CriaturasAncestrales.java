package ar.edu.unlam.pb2;

import java.util.HashMap;

public class CriaturasAncestrales extends Criaturas{

	public CriaturasAncestrales(String nombre, AfinidadElementalEnum afinidadElemental,
			ComportamientoEmocionalEnum comportamiento) {
		super(nombre, afinidadElemental, comportamiento);
	}

	public void entrenar(Criaturas criatura, int intensidad) {
		
		if(intensidad > 5) {
			energia -= 10;
			this.comportamiento = comportamiento.Inestable;
		} 
		else {
			energia += (10 * intensidad);
		}
		
		if (energia < 100) {
			energia = 100;
		}
		if (energia > 200) {
			energia = 200;
		}
	}
}
