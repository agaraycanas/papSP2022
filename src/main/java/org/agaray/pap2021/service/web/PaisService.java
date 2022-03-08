package org.agaray.pap2021.service.web;

import java.util.List;

import org.agaray.pap2021.entities.Pais;
import org.agaray.pap2021.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisService {

	@Autowired
	PaisRepository paisRepository;
	
	public List<Pais> findAll() {
		return paisRepository.findAll();
	}

	public Pais save(String nombre) {
		return paisRepository.save(new Pais(nombre));
	}
	
	public Pais update(Pais pais) {
		Pais p = paisRepository.getById(pais.getId());
		p.setNombre(pais.getNombre());
		paisRepository.saveAndFlush(p);
		return pais;
	}

	public void delete(Long id) {
		paisRepository.deleteById(id);
	}


}
