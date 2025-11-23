package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Maestros implements Pacificar{
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Maestros other = (Maestros) obj;
		return Objects.equals(nombre, other.nombre);
	}


	protected String nombre;
	protected Integer nivelDeMaestria;
	protected Set<AfinidadElementalEnum> AfinidadElemental = new HashSet<>();
	protected HashMap<String, Criaturas> criaturas = new HashMap<>();
	protected List<Maestros> maestros = new ArrayList<>();

	public Maestros(String nombre, AfinidadElementalEnum afinidadElemental) {
		super();
		this.nombre = nombre;
		this.nivelDeMaestria = 0;
		this.AfinidadElemental.add(afinidadElemental);
		this.criaturas = criaturas;
	}

	public void agregarCriatura(Criaturas criatura) {
	    if (criatura != null) {
	    	this.criaturas.put(criatura.getNombre(), criatura);
	    }
	}

	public void entrenar(Criaturas criatura, int intensidad) {
		    	criatura.entrenar(criatura, intensidad);
		    	
		    	if(criatura.getAfinidadElemental() == this.AfinidadElemental) {
		    		nivelDeMaestria += 10;
		    	}else {
				    this.nivelDeMaestria += 5;
			    }
		    	if(nivelDeMaestria >= 20) {
	    			AfinidadElemental.addAll(criatura.getAfinidadElemental());
	    			nivelDeMaestria = 0;
			    
		    }    
	}
 
	public Integer getNivelDeMaestria() {
		return nivelDeMaestria;
	}

	public void setNivelDeMaestria(Integer nivelDeMaestria) {
		this.nivelDeMaestria = nivelDeMaestria;
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

	public Set<AfinidadElementalEnum> getAfinidadElemental() {
		return AfinidadElemental;
	}


	@Override
	public void pacificar(Criaturas criatura, Integer nivelDeMaestria) {
		criatura.pacificar(criatura, nivelDeMaestria);
	}

	
}
