package pe.edu.upc.pandemia.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Problema")
public class Problema {
	@Id
	@Column(name = "problemaId", nullable = false)
	private Integer problemaId;
	
	@Column(name = "tipo", length = 255)
	private String tipo;
	
	
	@Column(name = "texto", length = 500)
	private String texto;
	
	@Column(name = "repuesta", length = 500, nullable=true)
	private String respuesta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pacienteId", nullable = false)
	private Paciente pacienteId;

	public Problema() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Problema(Integer problemaId, String tipo, String texto, String respuesta, Paciente pacienteId) {
		super();
		this.problemaId = problemaId;
		this.tipo = tipo;
		this.texto = texto;
		this.respuesta = respuesta;
		this.pacienteId = pacienteId;
	}

	public Integer getProblemaId() {
		return problemaId;
	}

	public void setProblemaId(Integer problemaId) {
		this.problemaId = problemaId;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public Paciente getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Paciente pacienteId) {
		this.pacienteId = pacienteId;
	}

	


	

}
