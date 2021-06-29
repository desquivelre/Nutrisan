package pe.edu.upc.pandemia.entities;
import java.awt.Image;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="paciente")
public class Paciente {
    @Id
    @Column(name="paciente_dni",columnDefinition = "NUMERIC(8)", nullable=false)
    private Integer dni;

    @Column(name="password", length=60)
    private String password;

    @Column(name="nombre", length=30)
    private String nombre;

    @Column(name="apellido", length=30)
    private String apellido;

    @Column(name="email", length=60)
    private String email;

    @Column(name = "habilitado", length = 1, nullable = false)
	private int habilitado;

	@OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    private List<Citas> Citas;
	
	@OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    private List<HistorialPlan> historialPlan;
	


	public Paciente(Integer dni, String password, String nombre, String apellido, String email, int habilitado,
			List<Citas> citas, List<HistorialPlan> historialPlan) {
		super();
		this.dni = dni;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.habilitado = habilitado;
		Citas = citas;
		this.historialPlan = historialPlan;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(int habilitado) {
		this.habilitado = habilitado;
	}

	public List<Citas> getCita() {
		return Citas;
	}

	public void setCita(List<Citas> cita) {
		Citas = cita;
	}

	public List<HistorialPlan> getHistorialPlan() {
		return historialPlan;
	}

	public void setHistorialPlan(List<HistorialPlan> historialPlan) {
		this.historialPlan = historialPlan;
	}

	public Paciente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
    
    
    