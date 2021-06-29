package pe.edu.upc.pandemia.entities;

import java.io.Serializable;

import java.util.Objects;


public class CurriculumId implements Serializable{
	
	private static final long serialVersionUID=1L;
	
    private Integer nutricionista;
    private Integer especialidad;
    private Integer gradoAcademico;
    private Integer casaDeEstudios;

  

	@Override
    public int hashCode() {
    	return Objects.hash(nutricionista,especialidad,gradoAcademico,casaDeEstudios);
    }
    
    @Override
    public boolean equals(Object obj) {
    	if(this==obj)
    		return true;
    	if(obj==null||this.getClass()!=obj.getClass())
    		return true;
    	
    	CurriculumId CurriculumId=(CurriculumId)obj;
    	if(this.casaDeEstudios!=CurriculumId.casaDeEstudios)
    		return false;
      	if(this.especialidad!=CurriculumId.especialidad)
    		return false;
      	if(this.gradoAcademico!=CurriculumId.gradoAcademico)
    		return false;
      	if(this.nutricionista!=CurriculumId.nutricionista)
    		return false;
      	return true;
    	
    }
    
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CurriculumId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CurriculumId(Integer nutricionista, Integer especialidad, Integer gradoAcademico, Integer casaDeEstudio) {
		super();
		this.nutricionista = nutricionista;
		this.especialidad = especialidad;
		this.gradoAcademico = gradoAcademico;
		this.casaDeEstudios = casaDeEstudio;
	}

	public Integer getNutricionista() {
		return nutricionista;
	}

	public void setNutricionista(Integer nutricionista) {
		this.nutricionista = nutricionista;
	}

	public Integer getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Integer especialidad) {
		this.especialidad = especialidad;
	}

	public Integer getGradoAcademico() {
		return gradoAcademico;
	}

	public void setGradoAcademico(Integer gradoAcademico) {
		this.gradoAcademico = gradoAcademico;
	}

	public Integer getCasaDeEstudio() {
		return casaDeEstudios;
	}

	public void setCasaDeEstudio(Integer casaDeEstudio) {
		this.casaDeEstudios = casaDeEstudio;
	}
	
	
    
    
    
}