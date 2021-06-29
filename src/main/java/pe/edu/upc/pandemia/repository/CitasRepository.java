package pe.edu.upc.pandemia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.pandemia.entities.Citas;
@Repository
public interface CitasRepository extends JpaRepository<Citas, Integer> {
	
	@Query("SELECT c FROM Citas c WHERE c.paciente.dni = :dni")
	List<Citas> filterById(
			@Param("dni") Integer dni);
	
	@Query("SELECT c FROM Citas c WHERE c.horario.nutricionista.dni= :dni")
	List<Citas>filterById_nutricionsita(@Param("dni")Integer dni);

}
