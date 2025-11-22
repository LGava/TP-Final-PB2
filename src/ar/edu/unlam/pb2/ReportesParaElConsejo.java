package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ReportesParaElConsejo {

	// Listar todas las criaturas registradas por todos los maestros
	public List<Criaturas> criaturasRegistradas(HashMap<String, Maestros> maestros) {
		List<Criaturas> criatura = new ArrayList<>();
		for (Maestros maestro : maestros.values()) {
			criatura.addAll(maestro.getCriaturasMap().values());
		}
		return criatura;

	}

	// Obtener la criatura con mayor energía total.
	public Criaturas criaturaConMayorEnergiaTotal(HashMap<String, Maestros> maestros) {

		Maestros[] maestro = maestros.values().toArray(new Maestros[0]);
		int total = 0;
		for (int i = 0; i < maestro.length; i++) {
			total += maestro[i].getCriaturasMap().size();
		}
		Criaturas[] criaturasTotales = new Criaturas[total];
		int num = 0;
		for (int i = 0; i < maestro.length; i++) {

			HashMap<String, Criaturas> c = maestro[i].getCriaturasMap();

			Criaturas[] criaturasActuales = c.values().toArray(new Criaturas[0]);

			for (int j = 0; j < criaturasActuales.length; j++) {
				criaturasTotales[num++] = criaturasActuales[j];
			}

		}

		for (int i = 0; i < criaturasTotales.length - 1; i++) {
			if (criaturasTotales[i] != null && criaturasTotales[i + 1] != null) {
				if (criaturasTotales[i].getEnergía() > criaturasTotales[i + 1].getEnergía()) {
					Criaturas aux = criaturasTotales[i];
					criaturasTotales[i] = criaturasTotales[i + 1];
					criaturasTotales[i + 1] = aux;
				}
			}
		}
		return criaturasTotales[criaturasTotales.length - 1];
	}

	// Determinar qué maestro tiene más criaturas transformadas

	public Maestros maestroConMayorCantidadDeCriaturasTransformadas(HashMap<String, Maestros> maestros) {
		int aux = 0;
		Maestros maestroConMayorCantidadDeCriaturasTransformadas = null;
		Maestros[] maestro = maestros.values().toArray(new Maestros[0]);

		for (int i = 0; i < maestros.size(); i++) {
			Maestros maestro2 = maestro[i];
			Criaturas[] criaturas = maestro2.getCriaturasMap().values().toArray(new Criaturas[0]);
			int contadorDeTransformaciones = 0;
			for (int j = 0; j < criaturas.length; j++) {
				Criaturas criatura2 = criaturas[i];
				if (criatura2 instanceof Transformaciones) {
					contadorDeTransformaciones++;
				}
			}
			if (contadorDeTransformaciones > aux) {
				aux = contadorDeTransformaciones;
				maestroConMayorCantidadDeCriaturasTransformadas = maestro2;
			}
		}

		return maestroConMayorCantidadDeCriaturasTransformadas;
	}

	public HashMap<AfinidadElementalEnum, Integer> obtenerCantidadPorAfinidad(HashMap<String, Maestros> maestros) {
		HashMap<AfinidadElementalEnum, Integer> reporte = new HashMap<>();

		for (Maestros maestro : maestros.values()) {
			for (Criaturas criatura : maestro.getCriaturasMap().values()) {
				for (AfinidadElementalEnum afinidad : criatura.getAfinidades()) {
					if (reporte.containsKey(afinidad)) {
						reporte.put(afinidad, reporte.get(afinidad) + 1);
					} else {
						reporte.put(afinidad, 1);
					}
				}
			}
		}
		return reporte;
	}

}