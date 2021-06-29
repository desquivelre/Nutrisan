package pe.edu.upc.pandemia.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class HistorialPlanID implements Serializable{

    private static final long serialVersionUID = 1L;
    private Integer paciente;
    private Integer plan;
    private Date fechaInicio;
    
  
    @Override
    public int hashCode() {
        return Objects.hash(paciente, plan, fechaInicio);
    }

    @Override
    public boolean equals(Object obj) {


        if(this == obj)
            return true;

        if(this == null || this.getClass() != obj.getClass())
            return false;

        HistorialPlanID historialPlanID = (HistorialPlanID)obj;

        if(this.paciente != historialPlanID.paciente)
            return false;
        if(this.plan != historialPlanID.plan)
            return false;
        if(this.fechaInicio != historialPlanID.fechaInicio)
            return false;
        return true;
    }

	public HistorialPlanID(Integer paciente, Integer plan, Date fechaInicio) {
		super();
		this.paciente = paciente;
		this.plan = plan;
		this.fechaInicio = fechaInicio;
	}

	public HistorialPlanID() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getPaciente() {
		return paciente;
	}

	public void setPaciente(Integer paciente) {
		this.paciente = paciente;
	}

	public Integer getPlan() {
		return plan;
	}

	public void setPlan(Integer plan) {
		this.plan = plan;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    


}