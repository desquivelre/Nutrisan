package pe.edu.upc.pandemia.service.crud;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.edu.upc.pandemia.entities.Nutricionista;

public interface NutricionistaService extends CrudService<Nutricionista, Integer> {
	List<Nutricionista>filterBy_speciality(Integer speciality_id) throws Exception;
	
	List<Nutricionista>filterBy_Academic(Integer gradoAcademico_id) throws Exception;
	
	List<Nutricionista>filterBy_Alma(Integer casaDeEstudios_id) throws Exception;
	

}
