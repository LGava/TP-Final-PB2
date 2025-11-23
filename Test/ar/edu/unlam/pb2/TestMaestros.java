package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class TestMaestros {
	
	@Test
    public void CrearMaestroYCambiarNombreYNivelDeMaestria(){

    Maestros m1 = new Maestros("pepe grillo", AfinidadElementalEnum.TIERRA);
    
    assertEquals("pepe grillo", m1.getNombre());
    
    m1.setNombre("pepe");
    m1.setNivelDeMaestria(20);
    
    assertEquals("pepe", m1.getNombre());
    assertEquals(Integer.valueOf(20), m1.getNivelDeMaestria());
    }

	@Test
    public void queUnMaestroTieneUnaCriatura(){

    Maestros m1 = new Maestros("pepe grillo", AfinidadElementalEnum.TIERRA);
    Criaturas c1 = new CriaturasAncestrales("sapo pepe", AfinidadElementalEnum.AGUA);

    m1.agregarCriatura(c1);
    assertEquals(1, m1.getCriaturasMap().size());
    }

    @Test
    public void queUnMaestroTieneMasDeUnaCriatura(){
    Maestros m1 = new Maestros("pepe grillo", AfinidadElementalEnum.AGUA);
    Criaturas c1 = new CriaturasDomesticas ("sapo pepe", AfinidadElementalEnum.AGUA);
    Criaturas c2 = new CriaturasAncestrales ("Don julio", AfinidadElementalEnum.TIERRA);

    m1.agregarCriatura(c1);
    m1.agregarCriatura(c2);
    assertEquals(2, m1.getCriaturasMap().size());
    }


    @Test
    public void SeAgregaUnMaestro(){    
        List<Maestros> listaDeMaestros = new ArrayList<>();
        Maestros m1 = new Maestros("pepe grillo", AfinidadElementalEnum.TIERRA); 

        listaDeMaestros.add(m1);

        assertEquals(1, listaDeMaestros.size());
    }
	@Test
    public void NoSeRepitenMaestros(){    
        Set<Maestros> listaDeMaestros = new HashSet<Maestros>();
        Maestros m1 = new Maestros("pepe grillo", AfinidadElementalEnum.TIERRA); 

        listaDeMaestros.add(m1);
        listaDeMaestros.add(m1);

        assertEquals(1, listaDeMaestros.size());
    }
    @Test
    public void UnMaestroObtieneAfinidadesPorEntrenarCriatura() {
        Maestros m1 = new Maestros("pepe grillo", AfinidadElementalEnum.AGUA);
        Criaturas c1 = new CriaturasAncestrales("rana rene", AfinidadElementalEnum.TIERRA);

        m1.setNivelDeMaestria(15);
        m1.agregarCriatura(c1);
        m1.entrenar(c1, 1);

        Set<AfinidadElementalEnum> afinidadesMaestro = m1.getAfinidadElemental();

        assertEquals(Integer.valueOf(0), m1.getNivelDeMaestria());
        
        assertEquals(2, afinidadesMaestro.size());
        assertTrue(afinidadesMaestro.contains(AfinidadElementalEnum.AGUA));
        assertTrue(afinidadesMaestro.contains(AfinidadElementalEnum.TIERRA));
    }

    
    @Test
    public void UnMaestroPacificaACriaturaAncestral(){
    Maestros m1 = new Maestros("pepe grillo", AfinidadElementalEnum.AGUA);
    Criaturas c1 = new CriaturasAncestrales("sapo pepe", AfinidadElementalEnum.AGUA);
    
    m1.agregarCriatura(c1);
    m1.entrenar(c1, 2);
    m1.entrenar(c1, 2);
    
    c1.setComportamiento(ComportamientoEmocionalEnum.Inestable);
    
    m1.pacificar(c1, m1.getNivelDeMaestria());
  
    assertEquals(ComportamientoEmocionalEnum.Tranquilo, c1.getComportamiento());
    }
    @Test
    public void UnMaestroPacificaACriaturaSalvaje(){
    Maestros m1 = new Maestros("pepe grillo", AfinidadElementalEnum.AGUA);
    Criaturas c1 = new CriaturasSalvajes("sapo pepe", AfinidadElementalEnum.AGUA);
    
    m1.agregarCriatura(c1);
    m1.entrenar(c1, 2);
    m1.setNivelDeMaestria(15);
    
    m1.pacificar(c1, m1.getNivelDeMaestria());
  
    assertEquals(ComportamientoEmocionalEnum.Tranquilo, c1.getComportamiento());
    }

}
