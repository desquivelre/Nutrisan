package pe.edu.upc.pandemia.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.pandemia.entities.Nutricionista;
import pe.edu.upc.pandemia.service.crud.NutricionistaService;


@Controller
@RequestMapping("/nutricionist")
public class NutricionistaController {
	@Autowired
	private NutricionistaService nutricionistaService;
	

    @GetMapping()
    public String response(Model model) {
    	try {
    		Optional<Nutricionista> nutricionista = nutricionistaService.findById(12345678);
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
    
	     

	
	
}