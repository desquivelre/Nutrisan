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
@Table(name="Especialidad",indexes  = {@Index(columnList = "Nombre",name = "Especialidad_index_Nombre")})
public class Especialidad {
    @Id
    @Column(name="especialidad_id",columnDefinition = "NUMERIC(10)",nullable = false)
    private Integer id;

    @Column(name="Nombre",length=40)
    private String Nombre;

    @OneToMany(mappedBy = "especialidad", fetch = FetchType.LAZY)
    private List<Curriculum> Curriculums;
    
    
    
     public Especialidad() {
    	 Curriculums = new ArrayList<Curriculum>();
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



	public List<Curriculum> getCurriculums() {
		return Curriculums;
	}



	public void setCurriculums(List<Curriculum> curriculums) {
		Curriculums = curriculums;
	}



	public Especialidad(Integer id, String nombre, List<Curriculum> curriculums) {
		super();
		this.id = id;
		Nombre = nombre;
		Curriculums = curriculums;
	}
     
	
}