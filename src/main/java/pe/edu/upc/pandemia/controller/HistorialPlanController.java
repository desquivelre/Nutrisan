package pe.edu.upc.pandemia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.pandemia.entities.HistorialPlan;
import pe.edu.upc.pandemia.service.crud.HistorialPlanService;

@Controller
@RequestMapping("/historialplanes")
public class HistorialPlanController {

	

	@Autowired
	private HistorialPlanService historialPlanService;
	
	@GetMapping("new")		// GET: /regions/{id}/edit
	public String newItem(Model model) {
		try {
			HistorialPlan historialPlan = new HistorialPlan();
			model.addAttribute("historialPlanNew", historialPlan);
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "";
	}
	
	
	@PostMapping("savenew")	// POST: /regions/savenew
	public String saveNew(Model model, @ModelAttribute("historialPlanNew") HistorialPlan historialPlan) {
		try {
			HistorialPlan historialPlanReturn = historialPlanService.create(historialPlan);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/plans";
	}
}
