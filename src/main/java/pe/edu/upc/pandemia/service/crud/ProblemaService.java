package pe.edu.upc.pandemia.service.crud;

import java.util.List;

import pe.edu.upc.pandemia.entities.Problema;

public interface ProblemaService extends CrudService<Problema, Integer> {
	List<Problema> filterById_paciente(Integer dni) throws Exception;

}
