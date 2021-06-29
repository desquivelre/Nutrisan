package pe.edu.upc.pandemia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.pandemia.entities.HistorialPlan;
import pe.edu.upc.pandemia.entities.HistorialPlanID;

@Repository
public interface HistorialPlanRepository extends JpaRepository<HistorialPlan, HistorialPlanID> {

}
