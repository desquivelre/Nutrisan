package pe.edu.upc.pandemia.service.crud;

import java.util.List;

import org.springframework.data.repository.query.Param;

import pe.edu.upc.pandemia.entities.Horario;

public interface HorarioService extends CrudService<Horario, Integer> {
	List<Horario> filterByDNI_Libre(Integer dni) throws Exception;
}
