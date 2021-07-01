package pe.edu.upc.pandemia.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="Curriculum")
@SequenceGenerator(name = "getCurriculum", initialValue = 1, allocationSize = 1)
public class Curriculum {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "getCurriculum")
    @Column(name = "curriculum_id",columnDefinition = "NUMERIC(10)", nullable = false)
    private Integer id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="nutricionista_dni",nullable = false)
    private Nutricionista nutricionista;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="especialidad_id",nullable = false)
    private Especialidad especialidad;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="gradoAcademico_id",nullable = false)
    private GradoAcademico gradoAcademico;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="casaDeEstudios_id",nullable = false)
    private CasaDeEstudios casaDeEstudios;

	public Curriculum() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Curriculum(Integer id, Nutricionista nutricionista, Especialidad especialidad, GradoAcademico gradoAcademico,
			CasaDeEstudios casaDeEstudios) {
		super();
		this.id = id;
		this.nutricionista = nutricionista;
		this.especialidad = especialidad;
		this.gradoAcademico = gradoAcademico;
		this.casaDeEstudios = casaDeEstudios;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public CasaDeEstudios getCasaDeEstudios() {
		return casaDeEstudios;
	}

	public void setCasaDeEstudios(CasaDeEstudios casaDeEstudios) {
		this.casaDeEstudios = casaDeEstudios;
	}

	
}