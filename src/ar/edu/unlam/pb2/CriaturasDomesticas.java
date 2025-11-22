package ar.edu.unlam.pb2;

public class CriaturasDomesticas extends Criaturas{

	public CriaturasDomesticas(String nombre, AfinidadElementalEnum afinidadElemental, 
			ComportamientoEmocionalEnum comportamiento) {
		super(nombre, afinidadElemental, comportamiento);
	}

<<<<<<< HEAD
	@Override
	public void entrenar(int intensidad) {
=======
	public void entrenar(Criaturas criatura, int intensidad) {
>>>>>>> master
		
		if (energia > 200) {
			energia = 200;
		}
		this.energia += (5 * intensidad);
	}

}
