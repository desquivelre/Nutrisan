package pe.edu.upc.pandemia.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Comentario")
public class Comentario {

	@Id
	@Column(name = "comentarioId", nullable = false)
	private Integer comentarioId;
	
	@Column(name = "texto", length = 255)
	private String texto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pacienteId", nullable = false)
	private Paciente paciente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nutricionistaId", nullable = false)
	private Nutricionista nutricionista;

	public Comentario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comentario(Integer comentarioId, String texto, Paciente paciente, Nutricionista nutricionista) {
		super();
		this.comentarioId = comentarioId;
		this.texto = texto;
		this.paciente = paciente;
		this.nutricionista = nutricionista;
	}

	public Integer getComentarioId() {
		return comentarioId;
	}

	public void setComentarioId(Integer comentarioId) {
		this.comentarioId = comentarioId;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Nutricionista getNutricionista() {
		return nutricionista;
	}

	public void setNutricionista(Nutricionista nutricionista) {
		this.nutricionista = nutricionista;
	}


	
	
}
