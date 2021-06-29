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
import java.util.List;;

@Entity
@Table(name = "Plan",indexes = {@Index(columnList = "nombre",name="plan_index_nombre") })
public class Plan {

    @Id
    @Column(name ="plan_id", columnDefinition = "NUMERIC(10)",nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 40, nullable = false)
    private String nombre;

    @Column(name = "caracteristicas", length = 150, nullable = false)
    private String caracteristicas;

    @Column(name = "monto", columnDefinition = "DECIMAL(5,2)")
    private float monto;

    @OneToMany(mappedBy = "plan", fetch = FetchType.LAZY)
    private List<HistorialPlan> historialPlan;
    
  

	public Plan(Integer id, String nombre, String caracteristicas, float monto, List<HistorialPlan> historialPlan) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.caracteristicas = caracteristicas;
		this.monto = monto;
		this.historialPlan = historialPlan;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public List<HistorialPlan> getHistorialPlan() {
		return historialPlan;
	}

	public void setHistorialPlan(List<HistorialPlan> historialPlan) {
		this.historialPlan = historialPlan;
	}

	public Plan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    
}