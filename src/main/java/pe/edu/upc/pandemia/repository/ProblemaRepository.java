package pe.edu.upc.pandemia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.pandemia.entities.Problema;

@Repository
public interface ProblemaRepository extends JpaRepository<Problema, Integer>{
	@Query("SELECT p FROM Problema p WHERE p.pacienteId.dni= :dni")
	List<Problema>filterById_paciente(@Param("dni")Integer dni);

}
