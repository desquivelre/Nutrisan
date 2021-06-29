package pe.edu.upc.pandemia.service.crud;

import java.util.List;

import org.springframework.data.repository.query.Param;

import pe.edu.upc.pandemia.entities.Citas;

public interface CitasService extends CrudService<Citas, Integer>{
	List<Citas> filterById(Integer dni) throws Exception;
	
	List<Citas>filterById_nutricionsita(Integer dni) throws Exception;
}
