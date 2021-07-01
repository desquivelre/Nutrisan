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

import pe.edu.upc.pandemia.entities.CasaDeEstudios;
import pe.edu.upc.pandemia.entities.Citas;
import pe.edu.upc.pandemia.entities.Comentario;
import pe.edu.upc.pandemia.entities.Curriculum;
import pe.edu.upc.pandemia.entities.Especialidad;
import pe.edu.upc.pandemia.entities.GradoAcademico;
import pe.edu.upc.pandemia.entities.Horario;
import pe.edu.upc.pandemia.entities.Nutricionista;
import pe.edu.upc.pandemia.entities.Paciente;
import pe.edu.upc.pandemia.service.crud.CasadeEstudiosService;
import pe.edu.upc.pandemia.service.crud.CitasService;
import pe.edu.upc.pandemia.service.crud.ComentarioService;
import pe.edu.upc.pandemia.service.crud.CurriculumService;
import pe.edu.upc.pandemia.service.crud.EspecialidadService;
import pe.edu.upc.pandemia.service.crud.GradoAcademicoService;
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

	@Autowired
	private CasadeEstudiosService casadeEstudiosService;
	
	@Autowired
	private EspecialidadService especialidadService;
	
	@Autowired
	private GradoAcademicoService gradoAcademicoService;

	
	

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
	

	//listar los especialistas 
	
	
	@GetMapping("{dni}/list")
	public String response_Especialist_List(Model model, @PathVariable("dni") Integer dni) {
		try {
			Optional<Paciente> paciente = pacienteService.findById(dni);
			
			if(paciente.isPresent()) {
				model.addAttribute("paciente", paciente.get());
				
				List<Nutricionista> nutricionistas = nutricionistaService.getAll();
				
				List<CasaDeEstudios> casas = casadeEstudiosService.getAll();
				List<GradoAcademico> grados = gradoAcademicoService.getAll();
				List<Especialidad> especialidades = especialidadService.getAll();
				
				model.addAttribute("nutricionistas", nutricionistas);
				model.addAttribute("casas", casas);
				model.addAttribute("grados", grados);
				model.addAttribute("especialidades", especialidades);
				
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
			
			List<Nutricionista> nutricionistas = nutricionistaService.getAll();
			model.addAttribute("nutricionistas", nutricionistas);
			
			
			Optional<Nutricionista> nutricionista = nutricionistaService.findById(dni_1);
			
			List<Horario> horarios = horarioService.filterByDNI_Libre(dni_1);
			model.addAttribute("horarios", horarios);
			
			Optional<Paciente> paciente = pacienteService.findById(dni);
			
			List<Citas> citas = citasService.getAll();
			
			Citas cita_new = new Citas();
			cita_new.setCita_id(citas.size()+1);
			
			int puntuacion = 0;
			int cantidad = 0;
			int puntuacion_total = 0;
			
		///	for (Citas citas2 : citas) {
			//	if(citas2.getHorario().getNutricionista().getDni() == nutricionista.get().getDni()) {
			///		puntuacion_total = puntuacion_total + citas2.getPuntuacion();
			//		cantidad++;
			//	}
			//}
			
		//	if( cantidad > 0) {
			//	puntuacion = puntuacion_total / cantidad;
			//}
			
			//puntuacion = (puntuacion / 5) * 100;
			
			//nutricionista.get().setPuntuacion(puntuacion);
			
			
			if(paciente.isPresent()) {
				model.addAttribute("paciente", paciente.get());
				
				if(nutricionista.isPresent()) {
					
					model.addAttribute("nutricionista", nutricionista.get());
					model.addAttribute("cita", cita_new);
					
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
        	Optional<Paciente> paciente = pacienteService.findById(id);
        	
        	List<Citas> citas = citasService.filterById(id);
            model.addAttribute("citas", citas);
            model.addAttribute("paciente", paciente.get());
        } catch (Exception e) {

            e.printStackTrace();
            System.err.println(e.getMessage());
        }

        return "paciente/pacientAppointments.html";
    }
	
	@GetMapping("{id}/appointmentDetail/{id_paciente}")
	public String response_4(Model model, @PathVariable("id")Integer id, @PathVariable("id_paciente")Integer id_paciente) {
		 
		try {
			Optional<Paciente> paciente = pacienteService.findById(id_paciente);
			
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
	                model.addAttribute("paciente", paciente.get());
	                
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
			
					
			return "redirect:/inicio/"+citas.get().getCita_id()+"/appointmentDetail/"+citas.get().getPaciente().getDni(); 
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

            return "redirect:/inicio/"+citas.get().getCita_id()+"/appointmentDetail/"+citas.get().getPaciente().getDni(); 
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
					
					//Here you should create the appointment
					
					List<Citas> citas = citasService.getAll();
					
					Citas cita_new = new Citas();
					cita_new.setCita_id(citas.size()+1);
					cita_new.setAsunto(null);
					cita_new.setFecha(horario.get().getHora_inicio());
					
					cita_new.setLink(null);
					
					
					cita_new.setRecomendacion(null);
					cita_new.setHorario(horario.get());
					cita_new.setPaciente(paciente.get());
					
					Citas cita_creada = citasService.create(cita_new);
					
					model.addAttribute("cita", cita_new);
					
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
			return "redirect:/inicio/myaccount/" + paciente.getDni();
		} catch (Exception e) {
			e.printStackTrace();
	        System.err.println(e.getMessage());
		}
		
		System.out.println(paciente.getDni());
		System.out.println(paciente.getApellido());
		System.out.println(paciente.getEmail());
		System.out.println(paciente.getHabilitado());
		System.out.println(paciente.getNombre());
		System.out.println(paciente.getPassword());
		System.out.println(paciente.getUsername());
		
		return "redirect:/inicio/myaccount/" + paciente.getDni();
	}
	
}
