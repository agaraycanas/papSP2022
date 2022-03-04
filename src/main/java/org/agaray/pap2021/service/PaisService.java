package org.agaray.pap2021.service;

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

	public void save(String nombre) {
		paisRepository.save(new Pais(nombre));
	}


}
