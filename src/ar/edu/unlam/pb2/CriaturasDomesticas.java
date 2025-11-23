package ar.edu.unlam.pb2;

public class CriaturasDomesticas extends Criaturas{

	public CriaturasDomesticas(String nombre, AfinidadElementalEnum afinidadElemental) {
		super(nombre, afinidadElemental);
		this.comportamiento = comportamiento.Tranquilo;
		
	}

	@Override
	public void entrenar(Criaturas criatura, int intensidad) {
		int energiaBase = criatura.getEnergía();
		
		int nuevaEnergia = energiaBase + (5 * intensidad);
		if (nuevaEnergia > 200) {
			nuevaEnergia = 200;
		}
		criatura.setEnergía(nuevaEnergia);
	}
	
	@Override
	public void setComportamiento(ComportamientoEmocionalEnum comportamiento) {
	    if (this.comportamiento == ComportamientoEmocionalEnum.Inestable) {
	        this.comportamiento = ComportamientoEmocionalEnum.Tranquilo;
	    } else {
	    	this.comportamiento = ComportamientoEmocionalEnum.Tranquilo;
	    }
	}

}
