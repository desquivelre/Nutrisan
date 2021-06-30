package pe.edu.upc.pandemia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.pandemia.entities.Comentario;

@Repository
public interface ComentarioRespository extends JpaRepository<Comentario, Integer>{

	@Query("SELECT c FROM Comentario c WHERE c.nutricionista.dni = :id")
	List<Comentario>filterbycita(@Param("id")Integer id);
	
}
