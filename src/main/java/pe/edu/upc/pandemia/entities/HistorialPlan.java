package pe.edu.upc.pandemia.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "HistorialPlan")
@IdClass(HistorialPlanID.class)
public class HistorialPlan {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "paciente_dni", nullable = false)
    private Paciente paciente;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "plan_id", nullable = false)
    private Plan plan;

    @Id
    @Column(name = "DFechaInicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

	public HistorialPlan(Paciente paciente, Plan plan, Date fechaInicio) {
		super();
		this.paciente = paciente;
		this.plan = plan;
		this.fechaInicio = fechaInicio;
	}

	public HistorialPlan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	
    
    
}