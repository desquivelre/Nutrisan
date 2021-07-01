package pe.edu.upc.pandemia.controller;

import java.nio.file.Path;
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
import pe.edu.upc.pandemia.entities.Curriculum;
import pe.edu.upc.pandemia.entities.Horario;
import pe.edu.upc.pandemia.entities.Nutricionista;
import pe.edu.upc.pandemia.entities.Paciente;
import pe.edu.upc.pandemia.service.crud.CitasService;
import pe.edu.upc.pandemia.service.crud.ComentarioService;
import pe.edu.upc.pandemia.service.crud.CurriculumService;
import pe.edu.upc.pandemia.service.crud.HorarioService;
import pe.edu.upc.pandemia.service.crud.NutricionistaService;
import pe.edu.upc.pandemia.service.crud.PacienteService;

@Controller
@RequestMapping("/inicio")
public class PacienteController {

	@Autowired
	private NutricionistaService nutricionistaService;

	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private CitasService citasService;
	
	@Autowired
	private HorarioService horarioService;
	
	@Autowired
	private ComentarioService comentarioService;
	
	

	@GetMapping
	public String response() {
		return "/index.html";
	}
	
	@GetMapping("/news")
	public String news(){
		
		return "news.html";
	}

	
	@GetMapping("/myaccount/{id}")
    public String response_2(Model model,@PathVariable("id")Integer id) {
        try {

            Optional<Paciente> paciente = pacienteService.findById(id);
            if(paciente.isPresent()) {
                model.addAttribute("paciente", paciente.get());
                return "paciente/pacientAccount.html"; // Archivo Html
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

        return "redirect:/inicio";
    }
	

	@GetMapping("{dni}/list")
	public String response_Especialist_List(Model model, @PathVariable("dni") Integer dni) {
		try {
			Optional<Paciente> paciente = pacienteService.findById(dni);
			
			if(paciente.isPresent()) {
				model.addAttribute("paciente", paciente.get());
				
				List<Nutricionista> nutricionistas = nutricionistaService.getAll();
				model.addAttribute("nutricionistas", nutricionistas);
				
				return "paciente/pacientEspecialistList.html"; 
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/inicio";
	}

	@GetMapping("{dni_1}/select/{dni}")
	public String response_Select(Model model, @PathVariable("dni_1") Integer dni_1, @PathVariable("dni") Integer dni) {
		try {
			
			Optional<Nutricionista> nutricionista = nutricionistaService.findById(dni_1);
			
			List<Horario> horarios = horarioService.filterByDNI_Libre(dni_1);
			model.addAttribute("horarios", horarios);
			
			Optional<Paciente> paciente = pacienteService.findById(dni);
			
			
			if(paciente.isPresent()) {
				model.addAttribute("paciente", paciente.get());
				
				if(nutricionista.isPresent()) {
					model.addAttribute("nutricionista", nutricionista.get());
					return "paciente/pacientSelectSchedule.html";
				}
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/inicio";
	}
	
	@GetMapping("/myappointments/{id}") 
    public String response_3(Model model, @PathVariable("id")Integer id) {
		
		
        try {      	
        	List<Citas> citas = citasService.filterById(id);
            model.addAttribute("citas", citas);
        } catch (Exception e) {

            e.printStackTrace();
            System.err.println(e.getMessage());
        }

        return "paciente/pacientAppointments.html";
    }
	
	@GetMapping("{id}/appointmentDetail")
	public String response_4(Model model, @PathVariable("id")Integer id) {
		 
		try {
			Optional<Citas> citas = citasService.findById(id);
		
			
			int codigonutricionista = citas.get().getHorario().getNutricionista().getDni();		
			List<Comentario>comentarios= comentarioService.filterbycita(codigonutricionista);
					
			
			
			 if(citas.isPresent()) {
				 
				    
					Optional<Citas> citasmodificar= citasService.findById(id);
					Comentario nuevocomentario = new Comentario();
					
					model.addAttribute("citasmodificar", citasmodificar);
	                model.addAttribute("citas", citas.get());
	                model.addAttribute("comentarios", comentarios);
	                
	                model.addAttribute("nuevocomentario", nuevocomentario);
	                
	                return "paciente/pacientAppointmentDetail.html";
	            }
		} catch (Exception e) {
			e.printStackTrace();
            System.err.println(e.getMessage());
		}
		
		return "paciente/pacientAppointment.html";
	}
	
	@PostMapping("/save/{id}")	
	public String saveEdit(Model model, @ModelAttribute("citasmodificar") Citas citasmodificar, @ModelAttribute("nuevocomentario") Comentario nuevocomentario, @PathVariable("id") Integer id) {
		try {
			
			Optional<Citas> citas = citasService.findById(id);
			
			citasmodificar.setCita_id(citas.get().getCita_id());
			citasmodificar.setFecha(citas.get().getFecha());
			citasmodificar.setAsunto(citas.get().getAsunto());
			citasmodificar.setHorario(citas.get().getHorario());
			citasmodificar.setLink(citas.get().getLink());
			citasmodificar.setPaciente(citas.get().getPaciente());
			citasmodificar.setRecomendacion(citas.get().getRecomendacion());
			
			Citas citasmodificado = citasService.update(citasmodificar); 
			
					
			return "redirect:/inicio/"+citas.get().getCita_id()+"/appointmentDetail"; 
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		
		return "redirect:/inicio";
	}
	
	@PostMapping("/savecomentario/{id}")	
	public String saveEdit(Model model, @ModelAttribute("nuevocomentario") Comentario nuevocomentario, @PathVariable("id") Integer id) {
		try {
			
			Optional<Citas> citas = citasService.findById(id);
			
			List<Comentario>numComentarios=comentarioService.getAll();
		
			nuevocomentario.setComentarioId(numComentarios.size()+1);
			nuevocomentario.setPaciente(citas.get().getPaciente());
			nuevocomentario.setNutricionista(citas.get().getHorario().getNutricionista());
			
			Comentario comentarioReturn = comentarioService.create(nuevocomentario);
			
			return "redirect:/inicio/"+citas.get().getCita_id()+"/appointmentDetail"; 
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		
		return "redirect:/inicio";
	}
	
	
	@GetMapping("{horario_id}/save_cita/{paciente_dni}")
	public String response_Save(Model model, @PathVariable("horario_id") Integer horario_id, @PathVariable("paciente_dni") Integer paciente_dni) {
		
		try {
			Optional<Horario> horario = horarioService.findById(horario_id);
			Optional<Paciente> paciente = pacienteService.findById(paciente_dni);
			
			if(paciente.isPresent()) {
				model.addAttribute("paciente", paciente.get());
								
				if(paciente.isPresent()) {
					model.addAttribute("horario", horario.get());
					
					return "paciente/pacientConfirmation.html";
				}
			}
		} catch (Exception e) {
			 e.printStackTrace();
	         System.err.println(e.getMessage());
		}
	
		
		return "redirect:/inicio";
	}
	
	@PostMapping("{horario_id}/assign/{paciente_dni}")
	public String response_assign(Model model, @PathVariable("horario_id") Integer horario_id, @PathVariable("paciente_dni") Integer paciente_dni,
			@ModelAttribute("citaNew") Citas cita_creado) {
		
		try {
			Optional<Horario> horario = horarioService.findById(horario_id);
			Optional<Paciente> paciente = pacienteService.findById(paciente_dni);
			
			List<Citas> citas = citasService.getAll();
			
			if(horario.isPresent()) {

				Citas cita = new Citas();
				cita.setAsunto(null);
				cita.setCita_id(1+citas.size());
				cita.setFecha(horario.get().getHora_inicio());
				cita.setLink("https://meet.google.com/rag-nbxc-bgv");
				cita.setRecomendacion(null);
				
				if(paciente.isPresent()) {
					cita.setPaciente(paciente.get());
					
					cita_creado = cita;
					
					Citas citasReturn = citasService.create(cita_creado);
					model.addAttribute("cita", citasReturn);
					
					return "paciente/pacientAccount";
				}
			}
		} catch (Exception e) {
			 e.printStackTrace();
	         System.err.println(e.getMessage());
		}
		return "redirect:/inicio";
	}
	
	@GetMapping("/doctoraccount")
	public String response_3() {
		return "nutricionista/doctorAccount.html";
	}
	
	@GetMapping("/plan")
    public String response_plan() {
        return "paciente/planPacient.html";
    }
	
	@GetMapping("{pacient_id}/actualizar")
	public String response_actualizar(Model model, @PathVariable("pacient_id") Integer id) {
		try {
			Optional<Paciente> paciente = pacienteService.findById(id);
			model.addAttribute("paciente", paciente.get());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "paciente/pacientUpdate.html";
	}
	
	@PostMapping("update")
	public String update(Model model, @ModelAttribute("paciente") Paciente paciente) {
		try {
			Paciente pacienteUpdate = pacienteService.update(paciente);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/";
	}
	
}
