package pe.edu.upc.pandemia.entities;

import java.sql.Time;
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

	@Column(name = "fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Column(name = "hora_inicio", nullable = false)
	private Time hora_inicio;

	@Column(name = "hora_fin", nullable = false)
	private Time hora_fin;

	
	@OneToMany(mappedBy = "horario", fetch = FetchType.LAZY)
    private List<Citas> Citas;

	public Horario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Horario(Integer id, Nutricionista nutricionista, Date fecha, Time hora_inicio, Time hora_fin,
			List<pe.edu.upc.pandemia.entities.Citas> citas) {
		super();
		this.id = id;
		this.nutricionista = nutricionista;
		this.fecha = fecha;
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


	public List<Citas> getCitas() {
		return Citas;
	}

	public void setCitas(List<Citas> citas) {
		Citas = citas;
	}
	
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setHora_inicio(Time hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public void setHora_fin(Time hora_fin) {
		this.hora_fin = hora_fin;
	}
	
	public Time getHora_inicio() {
		return hora_inicio;
	}

	public Time getHora_fin() {
		return hora_fin;
	}
	
	
}