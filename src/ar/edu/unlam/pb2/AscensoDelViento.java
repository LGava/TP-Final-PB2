package ar.edu.unlam.pb2;

import java.util.Set;

public class AscensoDelViento extends Transformaciones{

	public AscensoDelViento (Criaturas criatura) {
		super(criatura);
	}

	@Override
	 public void transformacion(Criaturas criatura) {
        this.criatura = criatura;
        
        Set<AfinidadElementalEnum> afinidades = criatura.getAfinidadElemental();
        afinidades.add(AfinidadElementalEnum.AIRE);
        criatura.setAfinidades(afinidades);
	}
	
	@Override
	public Integer getEnergia() {
		return criatura.getEnergía();
	}
	@Override
	public String getNombre() {
		return criatura.getNombre();
	}
	
	@Override
	public ComportamientoEmocionalEnum getComportamiento() {
		return criatura.getComportamiento();
	}
}
