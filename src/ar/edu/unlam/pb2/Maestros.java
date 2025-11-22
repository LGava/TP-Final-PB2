package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Maestros {
	protected String nombre;
	protected Integer nivelDeMaestria;
	protected AfinidadElementalEnum AfinidadElemental;
	protected HashMap<String, Criaturas> criaturas = new HashMap<>();
	protected List<Maestros> maestros = new ArrayList<>();

	public Maestros(String nombre, AfinidadElementalEnum afinidadElemental) {

		super();
		this.nombre = nombre;
		this.nivelDeMaestria = 0;
		AfinidadElemental = afinidadElemental;
		this.criaturas = criaturas;
	}

	public void agregarCriatura(Criaturas criatura) {
	    if (criatura == null) return;
	    
	    this.criaturas.put(criatura.getNombre(), criatura);
	}

	public void entrenar(Criaturas criatura, int intensidad) {
		    if (criatura != null) {

		        int energiaActual = criatura.getEnergia(); 
		        

		        int nuevaEnergia = energiaActual + intensidad; 
		        

		        criatura.setEnergia(nuevaEnergia);

		        this.nivelDeMaestria += 2;
		    }
		
	}

	public void pacificar(Criaturas criatura) {
		if (criatura.getComportamiento() == ComportamientoEmocionalEnum.Inestable) {
			criatura.setComportamiento(ComportamientoEmocionalEnum.Tranquilo);
		}
	}

	
	public void registrarMaestros(Maestros maestro) {
		maestros.add(maestro);
	}

	public List<Maestros> getMaestros() {
		return maestros;
	}

	public void setMaestros(List<Maestros> maestros) {
		this.maestros = maestros;
	}

	public HashMap<String, Criaturas> getCriaturasMap() {
	    return this.criaturas;
	}

	public void setCriaturas(HashMap<String, Criaturas> criaturas) {
		this.criaturas = criaturas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void transformar(Criaturas criatura, Transformaciones transformacion) {
		criaturas.put(criatura.getNombre(), transformacion);
		
	}

}
