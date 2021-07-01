package pe.edu.upc.pandemia.service.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.pandemia.entities.Problema;
import pe.edu.upc.pandemia.repository.ProblemaRepository;
import pe.edu.upc.pandemia.service.crud.ProblemaService;

@Service
public class ProblemaServiceImpl implements ProblemaService{
	@Autowired
	private ProblemaRepository problemaRepository;
	@Override
	public JpaRepository<Problema, Integer> getRepository()
	{
		return problemaRepository;
	}
	@Override
	public List<Problema> filterById_paciente(Integer dni) throws Exception {
		// TODO Auto-generated method stub
		return problemaRepository.filterById_paciente(dni);
	}

}
