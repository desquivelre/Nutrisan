package pe.edu.upc.pandemia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.pandemia.entities.Plan;
import pe.edu.upc.pandemia.service.crud.PlanService;

@Controller
@RequestMapping("/plans")
public class PlanController {
	
	@Autowired
	private PlanService planService;
	
	@GetMapping		
	public String listar( Model model ) {
		try {
			List<Plan> plans = planService.getAll();
			model.addAttribute("plans", plans);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "paciente/planPacient.html";
	}

}
