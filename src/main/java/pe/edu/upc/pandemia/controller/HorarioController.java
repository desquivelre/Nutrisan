package pe.edu.upc.pandemia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.pandemia.entities.Horario;
import pe.edu.upc.pandemia.entities.Nutricionista;
import pe.edu.upc.pandemia.service.crud.HorarioService;
import pe.edu.upc.pandemia.service.crud.NutricionistaService;


@Controller
@RequestMapping("/schedule")
@SessionAttributes("horarioEdit")
//@ComponentScan({"pe.edu.upc.pandemia"})
public class HorarioController {
	@Autowired
	private NutricionistaService nutricionistaService;
	
	@Autowired
	private HorarioService horarioService;
	
	@GetMapping		// GET: /apartments
	public String listar( Model model ) {
		try {
			List<Horario> horarios = horarioService.getAll();
			model.addAttribute("horarios", horarios);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "schedule/list";
	}
	
	@GetMapping("new")	
	public String newItem(Model model) {
		try {
			Horario horario = new Horario();
			//Optional<Nutricionista> nutricionista= nutricionistaService.findById(12345678);
			//horario.setNutricionista(nutricionista.get());
			model.addAttribute("horarioNew", horario);
			//horarioService.create(horario);
			return "schedule/new";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/schedule";	// url
	}
	
	@PostMapping("savenew")	// GET: /schedule/savenew
	public String saveNew(Model model, @ModelAttribute("horarioNew") Horario horario) {
		try {
			Optional<Nutricionista> nutricionista= nutricionistaService.findById(12345678);
			horario.setNutricionista(nutricionista.get());
			
			
			
			Horario horarioReturn = horarioService.create(horario);
			model.addAttribute("horario", horarioReturn);			
			return "schedule/view"; // Archivo Html
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/schedule";
	}	

}
