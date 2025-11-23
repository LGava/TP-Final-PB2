package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.junit.Test;

public class TestCriaturas {
	
	//clase criatura
	

	@Test
	public void NoSeRepitenCriaturas(){    
		Set<Criaturas> listaDeCriaturas = new HashSet<Criaturas>();
		Criaturas c1 = new CriaturasAncestrales("pepe grillo", AfinidadElementalEnum.TIERRA); 

		listaDeCriaturas.add(c1);
		listaDeCriaturas.add(c1);

		assertEquals(1, listaDeCriaturas.size());
	}
	
	@Test
	public void CrearCriaturaConNombreYAfinidad() {
		Criaturas c1 = new CriaturasDomesticas("El gato con botas", AfinidadElementalEnum.FUEGO);
		
		assertEquals("El gato con botas", c1.getNombre());
		assertEquals(1, c1.getAfinidadElemental().size());
		assertTrue(c1.getAfinidadElemental().contains(AfinidadElementalEnum.FUEGO));
		assertEquals(Integer.valueOf(0), c1.getEnergía());
		assertEquals(ComportamientoEmocionalEnum.Tranquilo, c1.getComportamiento());
	}
	@Test
	public void CriaturaDomesticaNoPuedeSerCambiadaAInestable() {
		Criaturas c1 = new CriaturasDomesticas("El gato con botas", AfinidadElementalEnum.FUEGO);
		c1.setComportamiento(ComportamientoEmocionalEnum.Inestable);
		
		assertEquals(ComportamientoEmocionalEnum.Tranquilo, c1.getComportamiento());
	}
	@Test
	public void EnergiaDeCriaturaNoBajaDe0() {
		Criaturas c1 = new CriaturasDomesticas("Burro", AfinidadElementalEnum.FUEGO);
		c1.setEnergía(-10);
		assertEquals(Integer.valueOf(0), c1.getEnergía());
	}
	@Test
	public void EnergiaDeCriaturaNoSubeDe200() {
		Criaturas c1 = new CriaturasDomesticas("sherk", AfinidadElementalEnum.FUEGO);
		c1.setEnergía(300);
		assertEquals(Integer.valueOf(200), c1.getEnergía());
	}
	@Test
	public void CambiarNombreYAfinidadDeCriatura() {
		Criaturas c1 = new CriaturasDomesticas("sherk", AfinidadElementalEnum.FUEGO);
		c1.setNombre("Fiona");
		c1.setAfinidadSolo(AfinidadElementalEnum.AIRE);
		
		assertEquals("Fiona", c1.getNombre());
		assertFalse(c1.getAfinidadElemental().contains(AfinidadElementalEnum.FUEGO));
		assertTrue(c1.getAfinidadElemental().contains(AfinidadElementalEnum.AIRE));
		assertEquals(1, c1.getAfinidadElemental().size());
	}
	
	 @Test
	 public void queSeCreaUnaCriatura(){
	    List<Criaturas> listaDeCriaturas = new ArrayList<>();
	    Criaturas c1 = new CriaturasAncestrales("sapo pepe",AfinidadElementalEnum.AGUA);

	    listaDeCriaturas.add(c1);

	    assertEquals(1, listaDeCriaturas.size());
	}

		
	// tipo de criatura

	@Test
	public void EntrenarCriaturaDomestica() {
		Criaturas c1 = new CriaturasDomesticas("Gato gordo", AfinidadElementalEnum.AGUA);
		
		Maestros m1 = new Maestros("Dueño", AfinidadElementalEnum.AGUA);
		m1.entrenar(c1, 1);
		assertEquals(Integer.valueOf(5), c1.getEnergía());
	}
	@Test
	public void EntrenarCriaturaDomesticaConEnergiaDe200() {
		Criaturas c1 = new CriaturasDomesticas("Gato gordo", AfinidadElementalEnum.AGUA);
		c1.setEnergía(200);
		Maestros m1 = new Maestros("Dueño", AfinidadElementalEnum.AGUA);
		m1.entrenar(c1, 1);
		assertEquals(Integer.valueOf(200), c1.getEnergía());
	}
	@Test
	public void CriaturaDomesticaNoPuedeSerInestable() {
		Criaturas c1 = new CriaturasDomesticas("Gato gordo", AfinidadElementalEnum.AGUA);
		c1.setComportamiento(ComportamientoEmocionalEnum.Inestable);
		
		assertEquals(ComportamientoEmocionalEnum.Tranquilo, c1.getComportamiento());
	}
	
	@Test
	public void EntrenarCriaturaSalvaje() {
		Criaturas c1 = new CriaturasSalvajes("Gato flaco", AfinidadElementalEnum.AGUA);
		
		Maestros m1 = new Maestros("Dueño", AfinidadElementalEnum.AGUA);
		m1.entrenar(c1, 3);
		int energia = c1.getEnergía();
		
		assertTrue(energia >= 0 && energia <= 30);
	}
	@Test
	public void EntrenarCriaturaSalvajeCon200DeEnergia() {
		Criaturas c1 = new CriaturasSalvajes("Gato flaco", AfinidadElementalEnum.AGUA);
		c1.setEnergía(200);
		
		Random randomControlado = new Random(123);
		Maestros m1 = new Maestros("Dueño", AfinidadElementalEnum.AGUA);
	
		try {
			m1.entrenar(c1, 3);
			fail("se tuvo que haber lanzado un exception");
		} catch (UncheckedException e) {
			assertEquals("el nivel de energía no puede superar las 200 unidades", e.getMessage());
		}
	}
	
	
	@Test
	public void EntrenarCriaturaAncestral() {
		Criaturas c1 = new CriaturasAncestrales("Gato viejo", AfinidadElementalEnum.AGUA);
		
		Maestros m1 = new Maestros("Dueño", AfinidadElementalEnum.AGUA);
		m1.entrenar(c1, 3);
	
		assertEquals(Integer.valueOf(130), c1.getEnergía());
	}
	@Test
	public void EntrenarCriaturaAncestralConIntensidadAlta() {
		Criaturas c1 = new CriaturasAncestrales("Gato viejo", AfinidadElementalEnum.AGUA);
		
		Maestros m1 = new Maestros("Dueño", AfinidadElementalEnum.AGUA);
		m1.entrenar(c1, 3);
		m1.entrenar(c1, 6);
	
		assertEquals(Integer.valueOf(100), c1.getEnergía());
		assertEquals(ComportamientoEmocionalEnum.Inestable, c1.getComportamiento());
	}
	
}
