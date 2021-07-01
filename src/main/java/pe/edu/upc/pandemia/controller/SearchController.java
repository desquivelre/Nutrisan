package pe.edu.upc.pandemia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.pandemia.entities.CasaDeEstudios;
import pe.edu.upc.pandemia.entities.Especialidad;
import pe.edu.upc.pandemia.entities.GradoAcademico;
import pe.edu.upc.pandemia.entities.Nutricionista;
import pe.edu.upc.pandemia.entities.Paciente;
import pe.edu.upc.pandemia.service.crud.CasadeEstudiosService;
import pe.edu.upc.pandemia.service.crud.EspecialidadService;
import pe.edu.upc.pandemia.service.crud.GradoAcademicoService;
import pe.edu.upc.pandemia.service.crud.NutricionistaService;
import pe.edu.upc.pandemia.service.crud.PacienteService;

@Controller
@RequestMapping("/filter")
public class SearchController {

	@Autowired
	private CasadeEstudiosService casadeEstudiosService;
	
	@Autowired
	private EspecialidadService especialidadService;
	
	@Autowired
	private GradoAcademicoService gradoAcademicoService;
	
	@Autowired
	private NutricionistaService nutricionistaService;
	
	@Autowired
	private PacienteService pacienteService;
	
	@GetMapping("/alma/{alma_id}/{paciente_id}")
	public String filter_by_alma(Model model, @PathVariable("alma_id") Integer alma_id, @PathVariable("paciente_id")Integer paciente_id) {
		try {
			Optional<Paciente> paciente = pacienteService.findById(paciente_id);
			Optional<CasaDeEstudios> casa = casadeEstudiosService.findById(alma_id);
			
			List<CasaDeEstudios> casas = casadeEstudiosService.getAll();
			List<GradoAcademico> grados = gradoAcademicoService.getAll();
			List<Especialidad> especialidades = especialidadService.getAll();
			
			List<Nutricionista> nutricionistas_filtrados = nutricionistaService.filterBy_Alma(alma_id);
			
			model.addAttribute("casas", casas);
			model.addAttribute("grados", grados);
			model.addAttribute("especialidades", especialidades);
			model.addAttribute("paciente", paciente.get());
			model.addAttribute("casa", casa.get());
			
			model.addAttribute("nutricionistas_filtrados", nutricionistas_filtrados);
			
			return "paciente/pacientEspecialistListAlma.html";
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/inicio";
	}
	
	@GetMapping("/speciality/{speciality_id}/{paciente_id}")
	public String filter_by_speciality(Model model, @PathVariable("speciality_id") Integer speciality_id, @PathVariable("paciente_id")Integer paciente_id) {
		try {
			Optional<Paciente> paciente = pacienteService.findById(paciente_id);
			Optional<Especialidad> especialidad = especialidadService.findById(speciality_id);
			
			List<CasaDeEstudios> casas = casadeEstudiosService.getAll();
			List<GradoAcademico> grados = gradoAcademicoService.getAll();
			List<Especialidad> especialidades = especialidadService.getAll();
			
			List<Nutricionista> nutricionistas_filtrados = nutricionistaService.filterBy_speciality(speciality_id);
			
			model.addAttribute("casas", casas);
			model.addAttribute("grados", grados);
			model.addAttribute("especialidades", especialidades);
			model.addAttribute("paciente", paciente.get());
			model.addAttribute("especialidad", especialidad.get());
			
			model.addAttribute("nutricionistas_filtrados", nutricionistas_filtrados);
			
			return "paciente/pacientEspecialistListSpeciality.html";
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/inicio";
	}
	
	
	@GetMapping("/academic/{academic_id}/{paciente_id}")
	public String filter_by_academic(Model model, @PathVariable("academic_id") Integer academic_id, @PathVariable("paciente_id")Integer paciente_id) {
		try {
			
			Optional<Paciente> paciente = pacienteService.findById(paciente_id);
			Optional<GradoAcademico> grado = gradoAcademicoService.findById(academic_id);
			
			List<CasaDeEstudios> casas = casadeEstudiosService.getAll();
			List<GradoAcademico> grados = gradoAcademicoService.getAll();
			List<Especialidad> especialidades = especialidadService.getAll();
			
			List<Nutricionista> nutricionistas_filtrados = nutricionistaService.filterBy_Academic(academic_id);
			
			model.addAttribute("casas", casas);
			model.addAttribute("grados", grados);
			model.addAttribute("especialidades", especialidades);
			model.addAttribute("paciente", paciente.get());
			model.addAttribute("grado", grado.get());
			
			model.addAttribute("nutricionistas_filtrados", nutricionistas_filtrados);
			
			return "paciente/pacientEspecialistListAcademic.html";
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/inicio";
	}
}
