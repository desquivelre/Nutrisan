package pe.edu.upc.pandemia.controller;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.pandemia.entities.Horario;
import pe.edu.upc.pandemia.entities.Nutricionista;
import pe.edu.upc.pandemia.service.crud.HorarioService;
import pe.edu.upc.pandemia.service.crud.NutricionistaService;


@Controller
@RequestMapping("/schedule")
@SessionAttributes("horarioEdit")
//@ComponentScan({"pe.edu.upc.pandemia"})
public class HorarioController {
	@Autowired
	private NutricionistaService nutricionistaService;
	
	@Autowired
	private HorarioService horarioService;
	
	@GetMapping		// GET: /schedule
	public String listar( Model model ) {
		try {
			List<Horario> horarios = horarioService.getAll();
			model.addAttribute("horarios", horarios);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "schedule/list";
	}
	
	@GetMapping("/viewhorario/{nutricionista_dni}/{horario_id}")
	public String saveHorario(Model model,@PathVariable("nutricionista_dni") Integer dni,@PathVariable("horario_id") Integer id)
	{
		try {
			Optional<Nutricionista> nutricionista=nutricionistaService.findById(dni);
			Optional<Horario> horario=horarioService.findById(id);
			model.addAttribute("nutricionista",nutricionista.get());
			model.addAttribute("horario",horario.get());
			return "schedule/view.html";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "schedule/view.html";
	}
	
	public static Date convertirhora(Date stamp){
		Date newdate=new Date(stamp.getTime());
	    return newdate;
	  }
	
	public static Date convertirfecha(Time stamp){
		Time newtime=new Time(stamp.getTime());
	    return newtime;
	  }

}
