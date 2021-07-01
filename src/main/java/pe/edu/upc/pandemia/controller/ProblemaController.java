package pe.edu.upc.pandemia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.pandemia.entities.Citas;
import pe.edu.upc.pandemia.entities.Comentario;
import pe.edu.upc.pandemia.entities.Horario;
import pe.edu.upc.pandemia.entities.Nutricionista;
import pe.edu.upc.pandemia.entities.Paciente;
import pe.edu.upc.pandemia.entities.Problema;
import pe.edu.upc.pandemia.service.crud.PacienteService;
import pe.edu.upc.pandemia.service.crud.ProblemaService;

@Controller
@RequestMapping("/problema")
public class ProblemaController {
	@Autowired
	private ProblemaService problemaService;
	
	
	
	@Autowired
	private PacienteService pacienteService;
	
	@GetMapping("{id}")
	public String listar(Model model, @PathVariable("id") Integer id)
	{
		try {
			Optional<Paciente> paciente = pacienteService.findById(id);
			model.addAttribute("paciente", paciente.get());
			
			List<Problema> problemas =problemaService.filterById_paciente(id);
			model.addAttribute("problemas", problemas);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "problema/list";
	}
	
	@GetMapping("new/{id}")	
	public String newItem(Model model, @PathVariable("id")Integer id) {
		try {
			Optional<Paciente> paciente = pacienteService.findById(id);
			model.addAttribute("paciente", paciente.get());
			
			Problema problema = new Problema();
			model.addAttribute("problemaNew", problema);
			//horarioService.create(horario);
			return "problema/new";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/problema";	// url
	}
	
	@PostMapping("savenew")	// GET: /schedule/savenew
	public String saveNew(Model model, @ModelAttribute("problemaNew") Problema problema) {
		try {
			
			List<Problema>numProblemas=problemaService.getAll();

			
			problema.setProblemaId(numProblemas.size()+1);
			Optional<Paciente> paciente= pacienteService.findById(41139875);
			problema.setPacienteId(paciente.get());
			
			
			
			Problema problemaReturn = problemaService.create(problema);
			model.addAttribute("problema", problemaReturn);			
			return "redirect:/problema";	// url
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/problema";	// url
	}	
	
    
    @GetMapping("{problemaId}/detalleReporte")
    public String response(Model model,@PathVariable("problemaId")Integer id) {
    	try {
    		Optional<Problema> problemas = problemaService.findById(id);
    		if(problemas.isPresent()) {
    			model.addAttribute("problemas", problemas.get());
    			return "problema/details.html";
    		}
    		
    	}catch (Exception e) {
    		e.printStackTrace();
    		System.err.println(e.getMessage());
    	}
    	
    	
    	return "redirect:/inicio";
    	
    }
	
}
