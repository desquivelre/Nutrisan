package pe.edu.upc.pandemia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.pandemia.entities.Horario;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Integer> {
	
	@Query("Select h from Horario h where h.nutricionista.id = :dni")
	List<Horario> filterByDNI_Libre(@Param ("dni") Integer dni);
}
