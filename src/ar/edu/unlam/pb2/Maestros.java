package ar.edu.unlam.pb2;

<<<<<<< HEAD
import java.util.HashMap;
=======
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
>>>>>>> master

public class Maestros {
	protected String nombre;
	protected Integer nivelDeMaestria;
	protected AfinidadElementalEnum AfinidadElemental;
	protected HashMap<String, Criaturas> criaturas = new HashMap<>();
<<<<<<< HEAD
	

	public Maestros(String nombre, AfinidadElementalEnum afinidadElemental,
			HashMap<String, Criaturas> criaturas) {
=======
	protected List<Maestros> maestros = new ArrayList<>();

	public Maestros(String nombre, AfinidadElementalEnum afinidadElemental) {
>>>>>>> master
		super();
		this.nombre = nombre;
		this.nivelDeMaestria = 0;
		AfinidadElemental = afinidadElemental;
		this.criaturas = criaturas;
	}

<<<<<<< HEAD
	public void agregarCriatura(String nombre, Criaturas criatura) {

		if (nombre == null || nombre.trim().isEmpty()) {
			return;
		}

		if (criatura == null) {
			return;
		}

		criaturas.put(nombre, criatura);
	}

	public void entrenar(Criaturas criatura, int intensidad) {
		criatura.entrenar(intensidad);
		nivelDeMaestria += 2;
=======
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
		
>>>>>>> master
	}

	public void pacificar(Criaturas criatura) {
		if (criatura.getComportamiento() == ComportamientoEmocionalEnum.Inestable) {
			criatura.setComportamiento(ComportamientoEmocionalEnum.Tranquilo);
		}
	}
<<<<<<< HEAD
=======
	
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

	
>>>>>>> master
}
