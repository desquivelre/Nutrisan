package pe.edu.upc.pandemia.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import pe.edu.upc.pandemia.entities.HistorialPlan;
import pe.edu.upc.pandemia.entities.HistorialPlanID;
import pe.edu.upc.pandemia.repository.HistorialPlanRepository;
import pe.edu.upc.pandemia.service.crud.HistorialPlanService;

@Service
public class HistorialPlanServiceImpl implements HistorialPlanService {
	@Autowired
	private HistorialPlanRepository historialPlanRepository;
	@Override
	public JpaRepository<HistorialPlan, HistorialPlanID> getRepository() {
		return historialPlanRepository;
	}

}
