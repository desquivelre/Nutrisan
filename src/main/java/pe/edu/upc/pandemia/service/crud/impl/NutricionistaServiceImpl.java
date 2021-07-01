package pe.edu.upc.pandemia.service.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import pe.edu.upc.pandemia.entities.Nutricionista;
import pe.edu.upc.pandemia.repository.NutricionistaRepository;
import pe.edu.upc.pandemia.service.crud.NutricionistaService;

@Service
public class NutricionistaServiceImpl implements NutricionistaService {
	@Autowired
	private NutricionistaRepository nutricionistaRepository;
	@Override
	public JpaRepository<Nutricionista, Integer> getRepository() {
		return nutricionistaRepository;
	}
	@Override
	public List<Nutricionista> filterBy_speciality(Integer speciality_id) throws Exception {
		return nutricionistaRepository.filterBy_speciality(speciality_id);
	}
	@Override
	public List<Nutricionista> filterBy_Academic(Integer gradoAcademico_id) throws Exception {
		return nutricionistaRepository.filterBy_Academic(gradoAcademico_id);
	}
	@Override
	public List<Nutricionista> filterBy_Alma(Integer casaDeEstudios_id) throws Exception {
		return nutricionistaRepository.filterBy_Alma(casaDeEstudios_id);
	}

}
