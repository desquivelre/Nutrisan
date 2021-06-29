package pe.edu.upc.pandemia.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import pe.edu.upc.pandemia.entities.Plan;
import pe.edu.upc.pandemia.repository.PlanRepository;
import pe.edu.upc.pandemia.service.crud.PlanService;

@Service
public class PlanServiceImpl implements PlanService {
	@Autowired
	private PlanRepository planRepository;
	@Override
	public JpaRepository<Plan, Integer> getRepository() {
		return planRepository;
	}

}
