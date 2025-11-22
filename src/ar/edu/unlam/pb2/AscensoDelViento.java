package ar.edu.unlam.pb2;

import java.util.Set;

public abstract class AscensoDelViento extends Transformaciones{

	public AscensoDelViento (Criaturas criatura) {
		super(criatura);
	}

	@Override
	 public void transformacion(Criaturas criatura) {
        this.criatura = criatura;
        
        Set<AfinidadElementalEnum> afinidades = criatura.getAfinidadElemental();
        afinidades.add(AfinidadElementalEnum.AIRE);
	}
}
