package pe.edu.upc.pandemia.service.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.pandemia.entities.Comentario;
import pe.edu.upc.pandemia.repository.ComentarioRespository;
import pe.edu.upc.pandemia.service.crud.ComentarioService;

@Service
public class ComentarioServiceImpl implements ComentarioService{

	@Autowired
	private ComentarioRespository comentarioRepository;

	@Override
	public JpaRepository<Comentario, Integer> getRepository() {
		// TODO Auto-generated method stub
		return comentarioRepository;
	}

	@Override
	public List<Comentario> filterbycita(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return comentarioRepository.filterbycita(id);
	}
	


}
