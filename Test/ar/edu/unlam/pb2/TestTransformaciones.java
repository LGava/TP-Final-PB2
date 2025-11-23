package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

public class TestTransformaciones {
	
	//criatura con ascenso del viento
	@Test
	public void CrearCriaturaConTranformacionAscensoDelVientoSeYMostrarComportamientoYNombre() {
		Criaturas c1 = new CriaturasSalvajes("fenix", AfinidadElementalEnum.FUEGO);
		
		AscensoDelViento transformacion = new AscensoDelViento(c1);
		transformacion.transformacion(c1);
		
		Set<AfinidadElementalEnum> afinidades = c1.getAfinidadElemental();
		
		assertTrue(afinidades.contains(AfinidadElementalEnum.FUEGO));
		assertTrue(afinidades.contains(AfinidadElementalEnum.AIRE));
		
		assertEquals("fenix", transformacion.getNombre());
		assertEquals(Integer.valueOf(0), transformacion.getEnergia());
		assertEquals(ComportamientoEmocionalEnum.Inestable, transformacion.getComportamiento());
	}
	@Test
	public void CriaturaConTranformacionAscensoDelVientoSeLeAgregaLaAfinidadDeAire() {
		Criaturas c1 = new CriaturasSalvajes("fenix", AfinidadElementalEnum.FUEGO);
		
		AscensoDelViento transformacion = new AscensoDelViento(c1);
		transformacion.transformacion(c1);
		
		Set<AfinidadElementalEnum> afinidades = c1.getAfinidadElemental();
		
		assertTrue(afinidades.contains(AfinidadElementalEnum.FUEGO));
		assertTrue(afinidades.contains(AfinidadElementalEnum.AIRE));

		assertEquals(Integer.valueOf(0), transformacion.getEnergia());
	}
	
	//criatura con bendicion del rio
	@Test
	public void CrearCriaturaConTranformacionBendicionDelRioYMostrarNombreyComportamiento() {
		Criaturas c1 = new CriaturasDomesticas("heladera", AfinidadElementalEnum.AGUA);
		
		Maestros m1 = new Maestros("Aylen Tejas", AfinidadElementalEnum.TIERRA);
		m1.entrenar(c1, 3);
		
		BendicionDelRio transformacion = new BendicionDelRio(c1);
		transformacion.transformacion(c1);
		
		assertEquals("heladera", transformacion.getNombre());
		assertEquals(ComportamientoEmocionalEnum.Tranquilo, transformacion.getComportamiento());
	}
	@Test
	public void CriaturaConTranformacionBendicionDelRioDuplicaSuEnergiaPor2() {
		Criaturas c1 = new CriaturasDomesticas("heladera", AfinidadElementalEnum.AGUA);
		
		Maestros m1 = new Maestros("Aylen Tejas", AfinidadElementalEnum.TIERRA);
		m1.entrenar(c1, 3);
		
		BendicionDelRio transformacion = new BendicionDelRio(c1);
		transformacion.transformacion(c1);
		
		assertEquals(Integer.valueOf(30), transformacion.getEnergia());
	}
	@Test
	public void CriaturaConTranformacionBendicionDelRioSuperaLos180DeEnergia() {
		Criaturas c1 = new CriaturasDomesticas("heladera", AfinidadElementalEnum.AGUA);
		
		c1.setEnergía(190);
	
		try {
			new BendicionDelRio(c1);
			fail("se tuvo que haber lanzado un exception");
		} catch (IllegalArgumentException e) {
			assertEquals("no se puede aplicar porque  ya tiene 180 de energia", e.getMessage());
		}
	}
	
	// criatura con llama interna
	
	@Test
	public void CrearCriaturaConTranformacionLlamaInternaYMostrarNombre() {
		 Criaturas c1 = new CriaturasDomesticas("Puerco araña", AfinidadElementalEnum.FUEGO);
		
		 LlamaInterna transformacion = new LlamaInterna(c1);
		 Set<AfinidadElementalEnum> afinidades = c1.getAfinidadElemental();
		 
		 transformacion.transformacion(c1);
	
		 assertEquals("Puerco araña", transformacion.getNombre());
	 
	}
	@Test
	public void CriaturaConTranformacionLlamaInternaObtiene30DeEnergiaSiTieneAfinidadDeFuego() {
		 Criaturas c1 = new CriaturasDomesticas("Puerco araña", AfinidadElementalEnum.FUEGO);
		
		 LlamaInterna transformacion = new LlamaInterna(c1);
		 Set<AfinidadElementalEnum> afinidades = c1.getAfinidadElemental();
		 
		 transformacion.transformacion(c1);
		 
		 assertTrue(afinidades.contains(AfinidadElementalEnum.FUEGO));
		 assertEquals(Integer.valueOf(30), transformacion.getEnergia());
	 
	}
	@Test
	public void CriaturaConTranformacionLlamaInternaSePoneInestablePorNoTenerAfinidadDeFuego() {
	    Criaturas c1 = new CriaturasAncestrales("Spider ham", AfinidadElementalEnum.AGUA);

	    LlamaInterna transformacion = new LlamaInterna(c1);
	    Set<AfinidadElementalEnum> afinidades = c1.getAfinidadElemental();

	    transformacion.transformacion(c1);

	    assertFalse(afinidades.contains(AfinidadElementalEnum.FUEGO));
	    assertEquals(ComportamientoEmocionalEnum.Inestable, transformacion.getComportamiento()); // 👈 acá
	}
	
	//criatura con vinculo terrestre
	@Test
	public void CrearCriaturaConTranformacionVinculoTerrestreYMostrarNombreYComportamiento() {
		 Criaturas c1 = new CriaturasDomesticas("hombre man", AfinidadElementalEnum.AGUA);
		 
		 c1.setEnergía(60);
		 
		 VinculoTerrestre transformacion = new VinculoTerrestre(c1);
		 transformacion.transformacion(c1);
		 
		 assertEquals("hombre man", transformacion.getNombre());
		 assertEquals(ComportamientoEmocionalEnum.Tranquilo, transformacion.getComportamiento());
	}
	@Test
	public void CriaturaConTranformacionVinculoTerrestreNoPuedeTenerEnergiaMenorA50() {
		 Criaturas c1 = new CriaturasDomesticas("hombre man", AfinidadElementalEnum.AGUA);
		 
		 c1.setEnergía(60);
		 
		 VinculoTerrestre transformacion = new VinculoTerrestre(c1);
		 transformacion.transformacion(c1);
		 
		 assertEquals(Integer.valueOf(60), transformacion.getEnergia());
	}
	@Test
	public void CriaturaConTranformacionVinculoTerrestreNoPuedeTenerBajarSuEnergiaDe50() {
		 Criaturas c1 = new CriaturasDomesticas("hombre man", AfinidadElementalEnum.AGUA);
		 
		 c1.setEnergía(40);
		 
		 VinculoTerrestre transformacion = new VinculoTerrestre(c1);
		 transformacion.transformacion(c1);
		 
		 assertEquals(Integer.valueOf(50), transformacion.getEnergia());
		 
		 c1.setEnergía(49);
		 
	}
	
}
