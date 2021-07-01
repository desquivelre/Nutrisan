package pe.edu.upc.pandemia.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pe.edu.upc.pandemia.entities.Nutricionista;
import pe.edu.upc.pandemia.entities.Paciente;
import pe.edu.upc.pandemia.entities.User;
import pe.edu.upc.pandemia.service.crud.RegisterService;

@Controller
public class RegisterController {

	@Autowired
	private RegisterService registerService;
	
	@GetMapping("/auth/login")
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	
	@GetMapping("/auth/registro")
	public String registroForm(Model model) {
		model.addAttribute("user", new User());
		return "loginvista";
	}
	
	
	@PostMapping("/auth/registro")
	public String registro(@Valid @ModelAttribute User user, BindingResult result, Model model) {
	if(result.hasErrors()) {
		
		System.out.println("Existen errores");

		return "loginvista";
	}else {
		model.addAttribute("user",registerService.registrar(user));
		System.out.println("Creado Correctamente");
	}
	return "redirect:/login";
}
	
	
	
	

	
}