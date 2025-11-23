package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Set;

public abstract class Criaturas implements Entrenar{

	protected String nombre;
	protected Integer energia;
	protected Set<AfinidadElementalEnum> afinidades = new HashSet<>(2);
	protected ComportamientoEmocionalEnum comportamiento;

	public Criaturas(String nombre, AfinidadElementalEnum afinidadInicial) {
		super();
		this.nombre = nombre;
		this.energia = 0;
		this.comportamiento = ComportamientoEmocionalEnum.Tranquilo;
		
		this.afinidades.add(afinidadInicial);
	}
	

	// getters y setters
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEnergía() {
		if(energia < 0) {
			energia = 0;
		}
		if (energia > 200) {
			energia = 200;
		}
		return energia;
	}

	public void setEnergía(Integer energía) {
		this.energia = energía;
	}
	

	public ComportamientoEmocionalEnum getComportamiento() {
		return comportamiento;
	}

	public void setComportamiento(ComportamientoEmocionalEnum comportamiento) {
		this.comportamiento = comportamiento;
	}
	
    public Set<AfinidadElementalEnum> getAfinidadElemental() {
        return afinidades;
    }

    public void setAfinidadSolo(AfinidadElementalEnum afinidad) {
        this.afinidades.clear();
        this.afinidades.add(afinidad);
    }


	public Set<AfinidadElementalEnum> getAfinidades() {
		return afinidades;
	}

	public void setAfinidades(Set<AfinidadElementalEnum> afinidades) {
		this.afinidades = afinidades;
	}

	@Override
	public void entrenar(Criaturas criatura, int intensidad) {
		int nuevaEnergia = energia + intensidad;
		criatura.setEnergía(nuevaEnergia);
	}
	
	public void pacificar (Criaturas criatura, Integer nivelDeMaestria) {
		if(criatura.getComportamiento() == ComportamientoEmocionalEnum.Inestable) {
			if(nivelDeMaestria >= 10) {
				criatura.setComportamiento(comportamiento.Tranquilo);
			}
		}
	}

}
