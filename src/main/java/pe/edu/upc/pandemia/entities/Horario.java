package pe.edu.upc.pandemia.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Horario")
@SequenceGenerator(name = "getHorario", initialValue = 18, allocationSize = 1)
public class Horario {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "getHorario")
	@Column(name = "horario_id", columnDefinition = "NUMERIC(10)", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "nutricionista_dni", nullable = false)
	private Nutricionista nutricionista;

	@Column(name = "hora_inicio", nullable = false)
	private Date hora_inicio;

	@Column(name = "hora_fin", nullable = false)
	private Date hora_fin;

	
	@OneToMany(mappedBy = "horario", fetch = FetchType.LAZY)
    private List<Citas> Citas;

	public Horario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Horario(Integer id, Nutricionista nutricionista, Date hora_inicio, Date hora_fin, Integer reservado,
			List<pe.edu.upc.pandemia.entities.Citas> citas) {
		super();
		this.id = id;
		this.nutricionista = nutricionista;
		this.hora_inicio = hora_inicio;
		this.hora_fin = hora_fin;
		
		Citas = citas;
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

	public Date getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(Date hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public Date getHora_fin() {
		return hora_fin;
	}

	public void setHora_fin(Date hora_fin) {
		this.hora_fin = hora_fin;
	}


	public List<Citas> getCitas() {
		return Citas;
	}

	public void setCitas(List<Citas> citas) {
		Citas = citas;
	}
	
	

	
	
	
}