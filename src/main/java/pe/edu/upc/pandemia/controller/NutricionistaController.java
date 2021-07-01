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

import pe.edu.upc.pandemia.entities.Horario;
import pe.edu.upc.pandemia.entities.Nutricionista;
import pe.edu.upc.pandemia.service.crud.HorarioService;
import pe.edu.upc.pandemia.service.crud.NutricionistaService;


@Controller
@RequestMapping("/nutricionist")
public class NutricionistaController {
	@Autowired
	private NutricionistaService nutricionistaService;
	
	@Autowired
	private HorarioService horarioService;

	@GetMapping("{id}")
    public String response(Model model , @PathVariable("id") Integer id ) {
        try {
            Optional<Nutricionista> nutricionista = nutricionistaService.findById(id);
            if(nutricionista.isPresent()) {
                model.addAttribute("nutricionista", nutricionista.get());
                return "nutricionista/doctorAccount.html";
            }

        }catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    	return "redirect:/inicio";
    }
    
    @GetMapping("{dni}/schedules")
	public String response_Especialist_List(Model model, @PathVariable("dni") Integer dni) {
		try {
			Optional<Nutricionista> nutricionista = nutricionistaService.findById(dni);
			
			if(nutricionista.isPresent()) {
				model.addAttribute("nutricionista", nutricionista.get());
				List<Horario> horarios = horarioService.filterByDNI_Libre(dni);
				model.addAttribute("horarios", horarios);
				
				return "schedule/list.html"; 
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/nutricionist";
	}
    
    @GetMapping("{dni}/schedules/new")	
	public String newItem(Model model, @PathVariable("dni") Integer dni) {
		try {
			Horario horario = new Horario();
			Optional<Nutricionista> nutricionista= nutricionistaService.findById(dni);
			horario.setNutricionista(nutricionista.get());
			model.addAttribute("horarioNew", horario);
			
			model.addAttribute("nutricionista",nutricionista.get());
			return "schedule/new.html";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/nutricionist";	// url
	}
	
	@PostMapping("/savenew/{dni}")	// GET: /schedule/savenew
	public String saveNew(Model model,@ModelAttribute("horarioNew") Horario horario,@PathVariable("dni") Integer dni) {
		try {
			Optional<Nutricionista> nutricionista= nutricionistaService.findById(dni);
			
			Horario horarioReturn = horarioService.create(horario);
			model.addAttribute("horario", horario);
			model.addAttribute("nutricionista",nutricionista);
			return "redirect:/schedule/viewhorario/"+nutricionista.get().getDni()+"/"+horarioReturn.getId();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "redirect:/nutricionist";
	}	
    
    
    
    @GetMapping("{nutricionista_id}/actualizar")
	public String response_actualizar(Model model, @PathVariable("nutricionista_id") Integer id) {
		try {
			Optional<Nutricionista> nutricionista = nutricionistaService.findById(id);
			model.addAttribute("nutricionista", nutricionista.get());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "nutricionista/nutritionistUpdate.html";
	}
	
	@PostMapping("update")
	public String update(Model model, @ModelAttribute("nutricionista") Nutricionista nutricionista) {
		try {
			Nutricionista nutricionistaUpdate = nutricionistaService.update(nutricionista);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/nutricionist";
	}     
	
	
	
}