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
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.pandemia.entities.Citas;
import pe.edu.upc.pandemia.entities.Nutricionista;
import pe.edu.upc.pandemia.service.crud.CitasService;
import pe.edu.upc.pandemia.service.crud.NutricionistaService;

@Controller
@RequestMapping("/appoimentlist")
@SessionAttributes("citas")
public class CitasController {

    @Autowired
	private CitasService citasService;
	
    @Autowired
    private NutricionistaService nutricionistaService; 
	
    
    @GetMapping("{id_nutricionista}")
    public String Listar(Model model, @PathVariable("id_nutricionista") Integer id_nutricionista) {
     try {
    	 Optional<Nutricionista> nutricionista = nutricionistaService.findById(id_nutricionista);
    	 model.addAttribute("nutricionista", nutricionista.get());
    	 
		List<Citas> citas= citasService.filterById_nutricionsita(id_nutricionista);
		model.addAttribute("citas", citas);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.err.println(e.getMessage());
	}
     
     return "nutricionista/appoimentList.html";
    }
    
    
    
    @GetMapping("{id}/appoimentDetails")
    public String response(Model model,@PathVariable("id")Integer id) {
    	try {
    		Optional<Citas> citas = citasService.findById(id);
    		if(citas.isPresent()) {
    			model.addAttribute("citas", citas.get());
    			return "nutricionista/appoimentDetails.html";
    		}
    		
    	}catch (Exception e) {
    		e.printStackTrace();
    		System.err.println(e.getMessage());
    	}
    	
    	
    	return "redirect:/inicio";
    	
    }
    
    @GetMapping("{id}/edit")
    public String findNyId2(Model model,@PathVariable("id")Integer id) {
     try {
		Optional<Citas> citas = citasService.findById(id);
		model.addAttribute("citas", citas.get());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.err.println(e.getMessage());
	}
     
     return "nutricionista/appoimentList.html";
    }
    
    @PostMapping("save")
    public String saveEdit(Model model,@ModelAttribute("citas") Citas citas) {
    
    try {    
     Citas citaReturn =citasService.update(citas);
     model.addAttribute("citas", citaReturn);
 	return "nutricionista/appoimentDetails.html";
    } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.err.println(e.getMessage());
	}
    	return "nutricionista/appoimentList.html";
    }
    
    
    @PostMapping("saveLink")
    public String saveLink(Model model,@ModelAttribute("citas") Citas citas) {
    
    try {    
     Citas citaReturn =citasService.update(citas);
     model.addAttribute("citas", citaReturn);
 	return "nutricionista/appoimentDetails.html";
    } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.err.println(e.getMessage());
	}
    	return "nutricionista/appoimentList.html";
    }
    

    
}
