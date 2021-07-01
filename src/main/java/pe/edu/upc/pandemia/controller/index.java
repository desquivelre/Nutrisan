package pe.edu.upc.pandemia.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.pandemia.entities.User;
import pe.edu.upc.pandemia.service.crud.RegisterService;

@Controller
@RequestMapping("/")
public class index {
	

	@Autowired
	private RegisterService registerService ;
	
	
	@GetMapping("login")
	public String login() {
	
		
		
		
		return "login.html";
	}
	@GetMapping("loginNutricionista")
	public String loginNutricionista() {
		return "loginNutricionista.html";
	}
	
	
	
	
	@GetMapping()
	public String response(Model model) {
		
		return "/index.html";
	}
	

	
	
	
}
