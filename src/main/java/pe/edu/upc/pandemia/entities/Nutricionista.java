package pe.edu.upc.pandemia.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "nutricionista")
public class Nutricionista {

	@Id
	@Column(name = "nutricionista_dni", length = 8, nullable = false)
	private Integer dni;

	@Column(name = "nombre", length = 30, nullable = false)
	private String nombre;

	// Recien agregado
	@Column(name = "apellido", length = 30, nullable = false)
	private String apellido;

	@Column(name = "password", length = 20, nullable = false)
	private String password;

	@Column(name = "numTelefono", length = 9, nullable = false)
	private Integer numTelefono;

	@Column(name = "email", length = 50, nullable = false)
	private String email;

	@Column(name = "puntuacion", length = 1)
	private int puntuacion;
	
	@Column(name = "habilitado", length = 1, nullable = false)
	private int habilitado;

	
	@OneToMany(mappedBy = "nutricionista", fetch = FetchType.LAZY)
    private List<Curriculum> Curriculums;
	
	@OneToMany(mappedBy = "nutricionista", fetch = FetchType.LAZY)
    private List<Horario> Horarios;
	
	@OneToMany(mappedBy = "nutricionista", fetch = FetchType.LAZY)
    private List<Comentario> comentario;

	public Nutricionista() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Nutricionista(Integer dni, String nombre, String apellido, String password, Integer numTelefono,
			String email, int puntuacion, int habilitado, List<Curriculum> curriculums, List<Horario> horarios,
			List<Comentario> comentario) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.numTelefono = numTelefono;
		this.email = email;
		this.puntuacion = puntuacion;
		this.habilitado = habilitado;
		Curriculums = curriculums;
		Horarios = horarios;
		this.comentario = comentario;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(Integer numTelefono) {
		this.numTelefono = numTelefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public int getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(int habilitado) {
		this.habilitado = habilitado;
	}

	public List<Curriculum> getCurriculums() {
		return Curriculums;
	}

	public void setCurriculums(List<Curriculum> curriculums) {
		Curriculums = curriculums;
	}

	public List<Horario> getHorarios() {
		return Horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		Horarios = horarios;
	}

	public List<Comentario> getComentario() {
		return comentario;
	}

	public void setComentario(List<Comentario> comentario) {
		this.comentario = comentario;
	}



	
}
