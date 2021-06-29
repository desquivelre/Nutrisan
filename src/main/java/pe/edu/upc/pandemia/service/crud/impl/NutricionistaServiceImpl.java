package pe.edu.upc.pandemia.service.crud.impl;

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

}
