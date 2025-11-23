package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Set;

public class InteraccionesDeCriaturas{
	
	public static void interactuar (Criaturas c1, Criaturas c2) {
		Set<AfinidadElementalEnum> a = c1.getAfinidadElemental();
		Set<AfinidadElementalEnum> b = c2.getAfinidadElemental();
		
		Set<AfinidadElementalEnum> copia = new HashSet<>(a);
		copia.retainAll(b);
		
		// comparte afinidad
		if(!copia.isEmpty()) {
			c1.setEnergía(c1.getEnergía() + 10);
			c2.setEnergía(c2.getEnergía() + 10);
		} 
		// elementos opuestos
		if(c1.getAfinidadElemental().contains(AfinidadElementalEnum.AGUA) &&
			c2.getAfinidadElemental().contains(AfinidadElementalEnum.FUEGO) ||
			c2.getAfinidadElemental().contains(AfinidadElementalEnum.AGUA) &&
			c1.getAfinidadElemental().contains(AfinidadElementalEnum.FUEGO) ||
			c1.getAfinidadElemental().contains(AfinidadElementalEnum.TIERRA) &&
			c2.getAfinidadElemental().contains(AfinidadElementalEnum.AIRE) ||
			c2.getAfinidadElemental().contains(AfinidadElementalEnum.TIERRA) &&
			c1.getAfinidadElemental().contains(AfinidadElementalEnum.AIRE)) {
			
			c1.setComportamiento(ComportamientoEmocionalEnum.Inestable);
			c2.setComportamiento(ComportamientoEmocionalEnum.Inestable);
			
			c1.setEnergía(Math.max(c2.getEnergía() - 20, 0));
			c2.setEnergía(Math.max(c2.getEnergía() - 20, 0));
		} 
		// son ancestros
		if (c1 instanceof CriaturasAncestrales && !(c2 instanceof CriaturasAncestrales)) {
			c1.setEnergía(c1.getEnergía() + 20);
			c2.setEnergía(c2.getEnergía() - 15);
		}
		if (!(c1 instanceof CriaturasAncestrales) && c2 instanceof CriaturasAncestrales) {
			c2.setEnergía(c2.getEnergía() + 20);
			c1.setEnergía(c1.getEnergía() - 15);
		}
		if (c1 instanceof CriaturasAncestrales && c2 instanceof CriaturasAncestrales) {
			c2.setEnergía(c2.getEnergía() + 20);
			c1.setEnergía(c1.getEnergía() + 20);
		}
	}
}
