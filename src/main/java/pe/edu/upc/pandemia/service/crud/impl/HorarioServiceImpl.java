package pe.edu.upc.pandemia.service.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import pe.edu.upc.pandemia.entities.Horario;
import pe.edu.upc.pandemia.repository.HorarioRepository;
import pe.edu.upc.pandemia.service.crud.HorarioService;

@Service
public class HorarioServiceImpl implements HorarioService {
	@Autowired
	private HorarioRepository horarioRepository;
	@Override
	public JpaRepository<Horario, Integer> getRepository() {
		return horarioRepository;
	}
	@Override
	public List<Horario> filterByDNI_Libre(Integer dni) throws Exception {
		return horarioRepository.filterByDNI_Libre(dni);
	}
	

}
