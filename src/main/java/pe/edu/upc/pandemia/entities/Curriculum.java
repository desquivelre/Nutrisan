package pe.edu.upc.pandemia.entities;


import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;


@Entity
@Table(name="Curriculum")
@IdClass(CurriculumId.class)
public class Curriculum {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="nutricionista_dni",nullable = false)
    private Nutricionista nutricionista;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="especialidad_id",nullable = false)
    private Especialidad especialidad;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="gradoAcademico_id",nullable = false)
    private GradoAcademico gradoAcademico;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="casaDeEstudios_id",nullable = false)
    private CasaDeEstudios casaDeEstudios;

	public Curriculum() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Curriculum(Nutricionista nutricionista, Especialidad especialidad, GradoAcademico gradoAcademico,
			CasaDeEstudios casaDeEstudio_Id) {
		super();
		this.nutricionista = nutricionista;
		this.especialidad = especialidad;
		this.gradoAcademico = gradoAcademico;
		this.casaDeEstudios = casaDeEstudio_Id;
	}

	public Nutricionista getNutricionista() {
		return nutricionista;
	}

	public void setNutricionista(Nutricionista nutricionista) {
		this.nutricionista = nutricionista;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public GradoAcademico getGradoAcademico() {
		return gradoAcademico;
	}

	public void setGradoAcademico(GradoAcademico gradoAcademico) {
		this.gradoAcademico = gradoAcademico;
	}

	public CasaDeEstudios getCasaDeEstudio_Id() {
		return casaDeEstudios;
	}

	public void setCasaDeEstudio_Id(CasaDeEstudios casaDeEstudio_Id) {
		casaDeEstudios= casaDeEstudio_Id;
	}

    
	
   
	
	

}