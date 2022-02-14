package org.agaray.pap2021.controller;

import java.util.List;

import org.agaray.pap2021.entities.Pais;
import org.agaray.pap2021.entities.Persona;
import org.agaray.pap2021.exception.DangerException;
import org.agaray.pap2021.exception.PRG;
import org.agaray.pap2021.repository.PaisRepository;
import org.agaray.pap2021.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pais")
public class PaisController {

	@Autowired
	private PaisRepository paisRepository;
	
	@Autowired
	private PersonaRepository personaRepository;

	@GetMapping("r")
	public String r(ModelMap m) {
		List<Pais> paises = paisRepository.findAll();
		m.put("paises", paises);
		m.put("view", "pais/r");
		return "_t/frame";
	}

	@GetMapping("c")
	public String c(ModelMap m) {
		m.put("view", "pais/c");
		return "_t/frame";
	}

	@PostMapping("c")
	public String cPost(@RequestParam("nombre") String nombre) throws DangerException {
		try {
			paisRepository.save(new Pais(nombre));
		} catch (Exception e) {
			PRG.error("El país "+nombre+" ya existe", "/pais/c");
		}
		return "redirect:/pais/r";
	}
	
	@GetMapping("u")
	public String u(
			@RequestParam("idPais") Long idPais,
			ModelMap m
			) {
		m.put("pais", paisRepository.getById(idPais));
		m.put("view", "pais/u");
		return "_t/frame";
	}

	@PostMapping("u")
	public String uPost(
			@RequestParam("idPais") Long idPais,
			@RequestParam("nombre") String nombre
			) throws DangerException {
		try {
			Pais pais = paisRepository.getById(idPais);
			pais.setNombre(nombre);
			paisRepository.save(pais);
		} catch (Exception e) {
			PRG.error("El país "+nombre+" ya existe", "/pais/r");
		}
		return "redirect:/pais/r";
	}
	
	@PostMapping("d")
	public String dPost(
			@RequestParam("idPais") Long idPais
			) {
		Pais pais = paisRepository.getById(idPais);

		System.out.print("========= NATIVOS =========> ");
		System.out.println(pais.getNativos());
		
		for (Persona p1:pais.getNativos()) {
			p1.setNace(null);
			personaRepository.saveAndFlush(p1);
			paisRepository.saveAndFlush(pais);
		}
		
		System.out.print("======== HABITANTES ==========> ");
		System.out.println(pais.getHabitantes());
		
		for (Persona p:pais.getHabitantes()) {
			p.setVive(null);
			personaRepository.saveAndFlush(p);
			paisRepository.saveAndFlush(pais);
		}
		//paisRepository.delete(pais);
		return "redirect:/pais/r";
	}
}
