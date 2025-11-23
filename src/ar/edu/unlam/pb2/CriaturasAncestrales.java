package ar.edu.unlam.pb2;

import java.util.HashMap;

public class CriaturasAncestrales extends Criaturas{

	public CriaturasAncestrales(String nombre, AfinidadElementalEnum afinidadElemental) {
		super(nombre, afinidadElemental);
		this.comportamiento = comportamiento.Tranquilo;
		this.energia = 100;
	}

	@Override
	public void entrenar(Criaturas criatura, int intensidad) {
		int nuevaEnergia = criatura.getEnergía();
		
		if(intensidad >= 5) {
			nuevaEnergia -= (5 * intensidad);
			ComportamientoEmocionalEnum comportamientoNuevo = ComportamientoEmocionalEnum.Inestable;
			criatura.setComportamiento(comportamientoNuevo);
		} 
		else {
			nuevaEnergia += (10 * intensidad);		
		}
		if (nuevaEnergia < 100) {
			nuevaEnergia = 100;
		}
		if (nuevaEnergia > 200) {
			nuevaEnergia = 200;
		}
		
		criatura.setEnergía(nuevaEnergia);
	}
}
