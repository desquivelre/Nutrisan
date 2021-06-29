package pe.edu.upc.pandemia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.pandemia.entities.CasaDeEstudios;

@Repository
public interface CasadeEstudiosRepository extends JpaRepository<CasaDeEstudios, Integer> {

}
