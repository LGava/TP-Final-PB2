package ar.edu.unlam.pb2;

import java.util.HashMap;

public class Maestros {
	protected String nombre;
	protected Integer nivelDeMaestria;
	protected AfinidadElementalEnum AfinidadElemental;
	protected HashMap<String, Criaturas> criaturas = new HashMap<>();
	

	public Maestros(String nombre, AfinidadElementalEnum afinidadElemental,
			HashMap<String, Criaturas> criaturas) {
		super();
		this.nombre = nombre;
		this.nivelDeMaestria = 0;
		AfinidadElemental = afinidadElemental;
		this.criaturas = criaturas;
	}

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
	}

	public void pacificar(Criaturas criatura) {
		if (criatura.getComportamiento() == ComportamientoEmocionalEnum.Inestable) {
			criatura.setComportamiento(ComportamientoEmocionalEnum.Tranquilo);
		}
	}
}
