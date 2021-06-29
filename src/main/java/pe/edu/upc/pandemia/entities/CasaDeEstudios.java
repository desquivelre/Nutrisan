package pe.edu.upc.pandemia.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CasaDeEstudios", indexes = {@Index(columnList = "Nombre",name="casaDeEstudis_index_Nombre") })
public class CasaDeEstudios {
    @Id
    @Column(name="casaDeEstudios_id",columnDefinition = "NUMERIC(10)",nullable = false)
    private Integer id;

    @Column(name="Nombre",length=40)
    private String Nombre;
    @Column(name="NumContacto",length=9)
    private Integer NumContacto;

    @OneToMany(mappedBy = "casaDeEstudios", fetch = FetchType.LAZY)
    private List<Curriculum> Curriculums;

    
	public CasaDeEstudios() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public Integer getNumContacto() {
		return NumContacto;
	}

	public void setNumContacto(Integer numContacto) {
		NumContacto = numContacto;
	}

	public List<Curriculum> getCurriculums() {
		return Curriculums;
	}

	public void setCurriculums(List<Curriculum> curriculums) {
		Curriculums = curriculums;
	}

	public CasaDeEstudios(Integer id, String nombre, Integer numContacto, List<Curriculum> curriculums) {
		super();
		this.id = id;
		Nombre = nombre;
		NumContacto = numContacto;
		Curriculums = curriculums;
	}

    
  
	
    
	
    
    
}