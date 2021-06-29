package pe.edu.upc.pandemia.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import pe.edu.upc.pandemia.entities.Paciente;
import pe.edu.upc.pandemia.repository.PacienteRepository;
import pe.edu.upc.pandemia.service.crud.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService {
	@Autowired
	private PacienteRepository pacienteRepository;
	@Override
	public JpaRepository<Paciente, Integer> getRepository() {
		return pacienteRepository;
	}

}
