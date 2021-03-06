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

import pe.edu.upc.pandemia.entities.Curriculum;
import pe.edu.upc.pandemia.entities.Horario;
import pe.edu.upc.pandemia.entities.Nutricionista;
import pe.edu.upc.pandemia.service.crud.CurriculumService;
import pe.edu.upc.pandemia.service.crud.HorarioService;
import pe.edu.upc.pandemia.service.crud.NutricionistaService;


@Controller
@RequestMapping("/nutricionist")
public class NutricionistaController {
	@Autowired
	private NutricionistaService nutricionistaService;
	
	@Autowired
	private HorarioService horarioService;
	
	@Autowired
	private CurriculumService curriculumService;

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
	
	@PostMapping("update/{dni}")
	public String update(Model model, @ModelAttribute("nutricionista") Nutricionista nutricionista,@PathVariable("dni") Integer dni) {
		try {
			Optional<Nutricionista> nutricionistaEdit=nutricionistaService.findById(dni);
			nutricionista.setDni(nutricionistaEdit.get().getDni());
			nutricionista.setHabilitado(nutricionistaEdit.get().getHabilitado());
			nutricionista.setPuntuacion(nutricionistaEdit.get().getPuntuacion());
			nutricionista.setApellido(nutricionistaEdit.get().getApellido());
			nutricionista.setNombre(nutricionistaEdit.get().getNombre());
			nutricionista.setPassword(nutricionistaEdit.get().getPassword());
			nutricionista.setUsername(nutricionistaEdit.get().getUsername());
			nutricionista.setComentario(nutricionistaEdit.get().getComentario());
			nutricionista.setCurriculums(nutricionistaEdit.get().getCurriculums());
			nutricionista.setHorarios(nutricionistaEdit.get().getHorarios());
			Nutricionista nutricionistaUpdate = nutricionistaService.update(nutricionista);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/nutricionist/"+nutricionista.getDni();
	}     
	
	@GetMapping("{dni}/curriculum")	
	public String setCurriculum(Model model, @PathVariable("dni") Integer dni) {
		try {
			Curriculum curriculum = new Curriculum();
			Optional<Nutricionista> nutricionista= nutricionistaService.findById(dni);
			curriculum.setNutricionista(nutricionista.get());
			model.addAttribute("curriculumNew", curriculum);
			
			model.addAttribute("nutricionista",nutricionista.get());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "nutricionista/setCurriculum.html";	// url
	}
	
	@PostMapping("curriculum/savenew/{dni}")	// GET: /schedule/savenew
	public String saveNew(Model model,@ModelAttribute("curriculumNew") Curriculum curriculum,@PathVariable("dni") Integer dni) {
		try {
			Optional<Nutricionista> nutricionista= nutricionistaService.findById(dni);
				
			Curriculum curriculumReturn = curriculumService.create(curriculum);
			model.addAttribute("curriculum", curriculum);
			model.addAttribute("nutricionista",nutricionista);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "redirect:/nutricionist";
	}	
	
}