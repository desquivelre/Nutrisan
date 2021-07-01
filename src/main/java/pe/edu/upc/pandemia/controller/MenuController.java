package pe.edu.upc.pandemia.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.pandemia.entities.Nutricionista;
import pe.edu.upc.pandemia.entities.Paciente;
import pe.edu.upc.pandemia.entities.User;
import pe.edu.upc.pandemia.service.crud.CitasService;
import pe.edu.upc.pandemia.service.crud.HorarioService;
import pe.edu.upc.pandemia.service.crud.NutricionistaService;
import pe.edu.upc.pandemia.service.crud.PacienteService;
import pe.edu.upc.pandemia.service.crud.RegisterService;
@Controller
@RequestMapping("/Menu")
public class MenuController {


	@Autowired
	private NutricionistaService nutricionistaService;

	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private CitasService citasService;
	
	@Autowired
	private HorarioService horarioService;
	
	@Autowired
	private RegisterService registerService;

	@GetMapping("/{id}")
	public String response_2(Model model,@PathVariable("id")Integer id) {
		try {
			
			Optional<User> usuario = registerService.findById(id);
			if(usuario.get().getTipoUsuario()==1) {
				Nutricionista nutricionista = new Nutricionista();
				
				nutricionista.setDni(usuario.get().getId());
				nutricionista.setUsername(usuario.get().getUsername());
				nutricionista.setPassword(usuario.get().getPassword());
				nutricionista.setNombre(usuario.get().getNombre());
				nutricionista.setApellido(usuario.get().getApellido());
				nutricionista.setEmail(usuario.get().getEmail());
				nutricionista.setHabilitado(usuario.get().getHabilitado());
				nutricionista.setPuntuacion(0);
				Nutricionista nutricionistaReturn =nutricionistaService.create(nutricionista);
				return "redirect:/nutricionist/"+nutricionista.getDni();
				
			}
			
			if(usuario.get().getTipoUsuario()==2) {
			
				Paciente paciente = new Paciente();
				paciente.setDni(usuario.get().getId());
				paciente.setUsername(usuario.get().getUsername());
				paciente.setPassword(usuario.get().getPassword());
				paciente.setNombre(usuario.get().getNombre());
				paciente.setApellido(usuario.get().getApellido());
				paciente.setEmail(usuario.get().getEmail());
			
				Paciente pacienteReturn =pacienteService.create(paciente);
				return "redirect:/inicio/myaccount/"+paciente.getDni();
			
				
			}
			return "/inicio";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "redirect:/inicio";
	}
	
	
	
}
