package pe.edu.upc.pandemia.service.crud;

import java.util.List;

import pe.edu.upc.pandemia.entities.Citas;
import pe.edu.upc.pandemia.entities.Comentario;

public interface ComentarioService extends CrudService<Comentario, Integer> {
	List<Comentario> filterbycita(Integer id) throws Exception;
}
