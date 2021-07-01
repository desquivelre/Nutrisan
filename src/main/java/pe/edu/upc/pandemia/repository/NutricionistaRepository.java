package pe.edu.upc.pandemia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.pandemia.entities.Citas;
import pe.edu.upc.pandemia.entities.Nutricionista;

@Repository
public interface NutricionistaRepository extends JpaRepository<Nutricionista, Integer>{
	
	@Query("SELECT n FROM  Nutricionista n JOIN Curriculum c ON n.dni = c.nutricionista.dni WHERE c.especialidad.id= :speciality_id")
	List<Nutricionista>filterBy_speciality(@Param("speciality_id") Integer speciality_id);
	
	@Query("SELECT n FROM  Nutricionista n JOIN Curriculum c ON n.dni = c.nutricionista.dni WHERE c.gradoAcademico.id= :gradoAcademico_id")
	List<Nutricionista>filterBy_Academic(@Param("gradoAcademico_id") Integer gradoAcademico_id);
	
	@Query("SELECT n FROM  Nutricionista n JOIN Curriculum c ON n.dni = c.nutricionista.dni WHERE c.casaDeEstudios.id = :casaDeEstudios_id")
	List<Nutricionista>filterBy_Alma(@Param("casaDeEstudios_id") Integer casaDeEstudios_id);
}
