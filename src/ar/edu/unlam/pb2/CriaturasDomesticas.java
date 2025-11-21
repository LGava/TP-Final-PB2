package ar.edu.unlam.pb2;

public class CriaturasDomesticas extends Criaturas{

	public CriaturasDomesticas(String nombre, AfinidadElementalEnum afinidadElemental, 
			ComportamientoEmocionalEnum comportamiento) {
		super(nombre, afinidadElemental, comportamiento);
	}

	@Override
	public void entrenar(int intensidad) {
		
		if (energia > 200) {
			energia = 200;
		}
		this.energia += (5 * intensidad);
	}

}
