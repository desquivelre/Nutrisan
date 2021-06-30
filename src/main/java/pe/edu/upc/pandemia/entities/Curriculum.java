package pe.edu.upc.pandemia.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;


@Entity
@Table(name="Curriculum")
public class Curriculum {

    @Id
    @Column(name = "curriculum_id", nullable = false)
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

	
}