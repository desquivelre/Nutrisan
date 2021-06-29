package pe.edu.upc.pandemia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.pandemia.entities.Curriculum;
import pe.edu.upc.pandemia.entities.CurriculumId;

@Repository
public interface CurriculumRepository extends JpaRepository<Curriculum, CurriculumId>{

}
