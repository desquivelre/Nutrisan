package pe.edu.upc.pandemia.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Citas",
		indexes = {@Index(columnList = "paciente_id", name="citas_index_paciente_id")})
public class Citas {

	@Id
	@Column(name = "id", columnDefinition = "NUMERIC(10)", nullable = false)
	private Integer cita_id;



	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "paciente_id", nullable = false)
	private Paciente paciente;

	@Column(name = "date", nullable = false)
	private Date fecha;

	@Column(name = "trecomendacion", length = 255, nullable = true)
	private String recomendacion;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "horario_id", nullable = false)
	private Horario horario;

	@Column(name = "asunto", length = 255, nullable = true)
	private String asunto;
	
	@Column(name = "link", length = 255, nullable = true)
	private String link;

	@Column(name = "puntuacion", length = 255, nullable = true)
	private Integer puntuacion;

	public Citas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Citas(Integer cita_id, Paciente paciente, Date fecha, String recomendacion, Horario horario, String asunto,
			String link, Integer puntuacion) {
		super();
		this.cita_id = cita_id;
		this.paciente = paciente;
		this.fecha = fecha;
		this.recomendacion = recomendacion;
		this.horario = horario;
		this.asunto = asunto;
		this.link = link;
		this.puntuacion = puntuacion;
	}

	public Integer getCita_id() {
		return cita_id;
	}

	public void setCita_id(Integer cita_id) {
		this.cita_id = cita_id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getRecomendacion() {
		return recomendacion;
	}

	public void setRecomendacion(String recomendacion) {
		this.recomendacion = recomendacion;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Integer getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(Integer puntuacion) {
		this.puntuacion = puntuacion;
	}

	
	
	
	
}