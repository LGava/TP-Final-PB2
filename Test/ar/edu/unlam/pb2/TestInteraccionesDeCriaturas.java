package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestInteraccionesDeCriaturas {

	@Test
	public void CriaturasCompartenAfinidadesYGanan10DeEnergia() {
		Criaturas c1 = new CriaturasDomesticas("Raul", AfinidadElementalEnum.AGUA);
		Criaturas c2 = new CriaturasDomesticas("agua", AfinidadElementalEnum.AGUA);
		
		InteraccionesDeCriaturas.interactuar(c1, c2);
		
		assertEquals(Integer.valueOf(10), c1.getEnergía());
		assertEquals(Integer.valueOf(10), c2.getEnergía());
	}
	
	//afinidad opuestas
	@Test
	public void CriaturasConAfinidadOpuestaDeAireYTierraSeDesestabilizan() {
		Criaturas c1 = new CriaturasAncestrales("Paloma mami", AfinidadElementalEnum.AIRE);
		Criaturas c2 = new CriaturasAncestrales("La Roca", AfinidadElementalEnum.TIERRA);
		
		InteraccionesDeCriaturas.interactuar(c1, c2);
		
		assertEquals(ComportamientoEmocionalEnum.Inestable, c2.getComportamiento());
		assertEquals(ComportamientoEmocionalEnum.Inestable, c1.getComportamiento());
	}
	@Test
	public void CriaturasConAfinidadOpuestaDeFuegoYAguaSeDesestabilizan() {
		Criaturas c1 = new CriaturasAncestrales("Paloma mami", AfinidadElementalEnum.FUEGO);
		Criaturas c2 = new CriaturasAncestrales("La Roca", AfinidadElementalEnum.AGUA);
		
		InteraccionesDeCriaturas.interactuar(c1, c2);
		
		assertEquals(ComportamientoEmocionalEnum.Inestable, c1.getComportamiento());
		assertEquals(ComportamientoEmocionalEnum.Inestable, c2.getComportamiento());
	}
	@Test
	public void CriaturasConAfinidadOpuestaDeTierraYAireSeDesestabilizan() {
		Criaturas c1 = new CriaturasAncestrales("Jose maria listorti", AfinidadElementalEnum.TIERRA);
		Criaturas c2 = new CriaturasAncestrales("el hee hee", AfinidadElementalEnum.AIRE);
		
		InteraccionesDeCriaturas.interactuar(c1, c2);
		
		assertEquals(ComportamientoEmocionalEnum.Inestable, c1.getComportamiento());
		assertEquals(ComportamientoEmocionalEnum.Inestable, c2.getComportamiento());
	}
	@Test
	public void CriaturasConAfinidadOpuestaDeAguaYFuegoSeDesestabilizan() {
		Criaturas c1 = new CriaturasAncestrales("ave maria", AfinidadElementalEnum.AGUA);
		Criaturas c2 = new CriaturasAncestrales("chatgpt", AfinidadElementalEnum.FUEGO);
		
		InteraccionesDeCriaturas.interactuar(c1, c2);
		
		assertEquals(ComportamientoEmocionalEnum.Inestable, c1.getComportamiento());
		assertEquals(ComportamientoEmocionalEnum.Inestable, c2.getComportamiento());
	}
	
	//criatura ancestral
	
	@Test
	public void CriaturaAncestral1Gana20DeEnergiaContraOtraCriaturaNoAncestral() {
		Criaturas c1 = new CriaturasAncestrales("un viejo de la calle", AfinidadElementalEnum.AIRE);
		Criaturas c2 = new CriaturasDomesticas("niño mimado", AfinidadElementalEnum.AGUA);
		
		Maestros m1 = new Maestros("Speedy Gonzalez", AfinidadElementalEnum.AIRE);
		m1.entrenar(c2, 4);
		
		InteraccionesDeCriaturas.interactuar(c1, c2);
		assertEquals(Integer.valueOf(5), c2.getEnergía());
		assertEquals(Integer.valueOf(120), c1.getEnergía());
	}
	
	@Test
	public void CriaturaAncestral2Gana20DeEnergiaContraOtraCriaturaNoAncestral() {
		Criaturas c1 = new CriaturasDomesticas("un viejo de la calle", AfinidadElementalEnum.AIRE);
		Criaturas c2 = new CriaturasAncestrales("niño mimado", AfinidadElementalEnum.AGUA);
		
		Maestros m1 = new Maestros("Speedy Gonzalez", AfinidadElementalEnum.AIRE);
		m1.entrenar(c1, 4);
		
		InteraccionesDeCriaturas.interactuar(c1, c2);
		assertEquals(Integer.valueOf(5), c1.getEnergía());
		assertEquals(Integer.valueOf(120), c2.getEnergía());
	}
	
	@Test
	public void AmbasCriaturaAncestral2Ganan20DeEnergia() {
		Criaturas c1 = new CriaturasAncestrales("verde", AfinidadElementalEnum.AIRE);
		Criaturas c2 = new CriaturasAncestrales("voldemort", AfinidadElementalEnum.AGUA);
		
		Maestros m1 = new Maestros("Speedy Gonzalez", AfinidadElementalEnum.AIRE);
	
		InteraccionesDeCriaturas.interactuar(c1, c2);
		
		assertEquals(Integer.valueOf(120), c1.getEnergía());
		assertEquals(Integer.valueOf(120), c2.getEnergía());
	}
}
