package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class TestReportes {

	// criaturas registradas
	@Test
	public void queDevuelveTodasLasCriaturasRegistradasPorTodosLosMaestros() {

		ReportesParaElConsejo reporte = new ReportesParaElConsejo();

		Maestros m1 = new Maestros("Shifu", AfinidadElementalEnum.AGUA);
		Maestros m2 = new Maestros("Yoda", AfinidadElementalEnum.FUEGO);
		Maestros m3 = new Maestros("Marce", AfinidadElementalEnum.TIERRA);

		Criaturas c1 = new CriaturasDomesticas("Pikachu", AfinidadElementalEnum.AGUA);
		Criaturas c2 = new CriaturasSalvajes("Doby", AfinidadElementalEnum.TIERRA);
		Criaturas c3 = new CriaturasAncestrales("Gollum", AfinidadElementalEnum.AIRE);

		Criaturas c4 = new CriaturasAncestrales("TigresaVoladoraGiganteRealista", AfinidadElementalEnum.AIRE);
		HashMap<String, Maestros> maestros = new HashMap<>();

		m1.agregarCriatura(c1);
		m1.agregarCriatura(c2);
		m2.agregarCriatura(c3);
		m3.agregarCriatura(c4);
		maestros.put(m1.getNombre(), m1);
		maestros.put(m3.getNombre(), m3);
		maestros.put(m2.getNombre(), m2);

		List<Criaturas> criaturas = reporte.criaturasRegistradas(maestros);

		assertEquals(4, criaturas.size());
	}
	
	 @Test
	 public void CriaturasRegistradasPeroConMaestroSinCriaturas() {
		ReportesParaElConsejo reporte = new ReportesParaElConsejo();
		 
	    Maestros m1 = new Maestros("Gandalf",AfinidadElementalEnum.AGUA);
	    HashMap<String, Maestros> maestros = new HashMap<>();
	    maestros.put(m1.getNombre(), m1);

	    assertTrue(reporte.criaturasRegistradas(maestros).isEmpty());
	    }

	// criatura con mayor energia
	@Test
	public void queSePuedeObtenerLaCriaturaConMayorEnergiaTotal() {
		ReportesParaElConsejo reporte = new ReportesParaElConsejo();
		Maestros m1 = new Maestros("Shifu", AfinidadElementalEnum.AGUA);
		Maestros m2 = new Maestros("Yoda", AfinidadElementalEnum.FUEGO);

		Criaturas c1 = new CriaturasDomesticas("Pikachu", AfinidadElementalEnum.AGUA);

		Criaturas c2 = new CriaturasSalvajes("Doby", AfinidadElementalEnum.TIERRA);

		Criaturas c3 = new CriaturasSalvajes("PizzaSteve", AfinidadElementalEnum.TIERRA);

		HashMap<String, Criaturas> criaturas = new HashMap<>();
		m1.agregarCriatura(c1);

		criaturas.put(c1.getNombre(), c1);
		criaturas.put(c2.getNombre(), c2);
		criaturas.put(c3.getNombre(), c3);

		m1.setCriaturas(criaturas);

		HashMap<String, Criaturas> criaturas2 = new HashMap<>();
		m2.agregarCriatura(c2);

		criaturas.put(c1.getNombre(), c1);
		criaturas.put(c2.getNombre(), c2);

		m2.setCriaturas(criaturas2);

		HashMap<String, Maestros> maestros = new HashMap<>();
		maestros.put(m1.getNombre(), m1);
		maestros.put(m2.getNombre(), m2);

		m1.entrenar(c1, 2);
		m1.entrenar(c1, 1);
		m2.entrenar(c2, 1);
		Criaturas criaturaConMayorEnergia = reporte.criaturaConMayorEnergiaTotal(maestros);
		assertEquals(c1, criaturaConMayorEnergia);
	}
	
	@Test
    public void CriaturaConEnegiaTotalIgual() {
		ReportesParaElConsejo reporte = new ReportesParaElConsejo();
		
        Maestros m1 = new Maestros("Harry Pote",AfinidadElementalEnum.AGUA);
        Maestros m2 = new Maestros("Batman", AfinidadElementalEnum.FUEGO);

        Criaturas c1 = new CriaturasDomesticas("Marea", AfinidadElementalEnum.AGUA);
        Criaturas c2 = new CriaturasSalvajes("Fogon", AfinidadElementalEnum.FUEGO);

        m1.getCriaturasMap().put(c1.getNombre(), c1);
        m2.getCriaturasMap().put(c2.getNombre(), c2);

        HashMap<String, Maestros> maestros = new HashMap<>();
        maestros.put(m1.getNombre(), m1);
        maestros.put(m2.getNombre(), m2);

        
        Criaturas criaturas = reporte.criaturaConMayorEnergiaTotal(maestros);
        assertTrue(criaturas == c1 || criaturas == c2);
    }

	//maestro con criatura mas trasformada
	@Test
	public void QuesePuedaObtenerElmaestroConMayorCantidadDeCriaturasTransformadas() {

		ReportesParaElConsejo reporte = new ReportesParaElConsejo();
		Maestros m1 = new Maestros("Shifu", AfinidadElementalEnum.AGUA);
		Maestros m2 = new Maestros("Yoda", AfinidadElementalEnum.FUEGO);

		Criaturas c1 = new CriaturasDomesticas("Pikachu", AfinidadElementalEnum.AGUA);
		Criaturas c2 = new CriaturasSalvajes("Doby", AfinidadElementalEnum.TIERRA);
		Criaturas c3 = new CriaturasSalvajes("PizzaSteve", AfinidadElementalEnum.TIERRA);

		HashMap<String, Criaturas> criaturas = new HashMap<>();
		m1.agregarCriatura(c1);

		criaturas.put(c1.getNombre(), c1);
		criaturas.put(c2.getNombre(), c2);
		criaturas.put(c3.getNombre(), c3);

		m1.setCriaturas(criaturas);

		HashMap<String, Criaturas> criaturas2 = new HashMap<>();
		m2.agregarCriatura(c2);

		criaturas2.put(c1.getNombre(), c1); 
		criaturas2.put(c2.getNombre(), c2);

		m2.setCriaturas(criaturas2);
		
		HashMap<String, Maestros> maestros = new HashMap<>();
		maestros.put(m1.getNombre(), m1);
		maestros.put(m2.getNombre(), m2);

		m1.transformar(c1, new LlamaInterna(c1));
		m2.transformar(c2, new BendicionDelRio(c2));

		Maestros maestroConMayorCantidadDeCriaturasTransformadas = reporte.maestroConMayorCantidadDeCriaturasTransformadas(maestros);

		assertEquals(m1, maestroConMayorCantidadDeCriaturasTransformadas);
	}
	
	// mapa con cant. criaturas por afinidad
	@Test
	public void queSeObtenieUnMapaConlaCantidadDeCriaturasPorAfinidadElemental(){

		ReportesParaElConsejo reporte = new ReportesParaElConsejo();
		Maestros m1 = new Maestros("Shifu", AfinidadElementalEnum.AGUA);
		Maestros m2 = new Maestros("Yoda", AfinidadElementalEnum.FUEGO);

		Criaturas c1 = new CriaturasDomesticas("Pikachu", AfinidadElementalEnum.AGUA);
		Criaturas c2 = new CriaturasSalvajes("Doby", AfinidadElementalEnum.TIERRA);
		Criaturas c3 = new CriaturasSalvajes("PizzaSteve", AfinidadElementalEnum.TIERRA);

		HashMap<String, Criaturas> criaturas = new HashMap<>();
		m1.agregarCriatura(c1);

		criaturas.put(c1.getNombre(), c1);
		criaturas.put(c2.getNombre(), c2);
		criaturas.put(c3.getNombre(), c3);

		m1.setCriaturas(criaturas);

		HashMap<String, Criaturas> criaturas2 = new HashMap<>();
		m2.agregarCriatura(c2);

		criaturas.put(c1.getNombre(), c1);
		criaturas.put(c2.getNombre(), c2);

		m2.setCriaturas(criaturas2);

		HashMap<String, Maestros> maestros = new HashMap<>();
		maestros.put(m1.getNombre(), m1);
		maestros.put(m2.getNombre(), m2);
		
		HashMap<AfinidadElementalEnum, Integer> CantidadDeCriaturasPorAfinidadElemental = reporte.obtenerCantidadPorAfinidad(maestros);
		assertEquals(Integer.valueOf(1), CantidadDeCriaturasPorAfinidadElemental.get(AfinidadElementalEnum.AGUA));
		assertEquals(Integer.valueOf(2), CantidadDeCriaturasPorAfinidadElemental.get(AfinidadElementalEnum.TIERRA));
	}

}
