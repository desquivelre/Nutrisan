package pe.edu.upc.pandemia.service.crud;
import java.util.List;

import org.springframework.data.repository.query.Param;


import pe.edu.upc.pandemia.entities.Nutricionista;
import pe.edu.upc.pandemia.entities.Paciente;
import pe.edu.upc.pandemia.entities.User;


public interface RegisterService  extends CrudService<User, Integer> {

	
	public User findByUsername(String username);
	public User registrar(User u);


}
