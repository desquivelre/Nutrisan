package pe.edu.upc.pandemia.service.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import pe.edu.upc.pandemia.entities.Citas;
import pe.edu.upc.pandemia.repository.CitasRepository;
import pe.edu.upc.pandemia.service.crud.CitasService;

@Service
public class CitasServiceImpl implements CitasService {

	@Autowired
	private CitasRepository citasRepository;
	@Override
	public JpaRepository<Citas, Integer> getRepository() {
		return citasRepository;
	}
	@Override
	public List<Citas> filterById(Integer dni) throws Exception {
		return citasRepository.filterById(dni);
	}
	@Override
	public List<Citas> filterById_nutricionsita(Integer dni) throws Exception {
		return citasRepository.filterById_nutricionsita(dni);
	}
	
	
	
}
