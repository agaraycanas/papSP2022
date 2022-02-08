package org.agaray.pap2021.controller;

import java.util.List;

import org.agaray.pap2021.entities.Pais;
import org.agaray.pap2021.exception.DangerException;
import org.agaray.pap2021.exception.PRG;
import org.agaray.pap2021.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaisController {

	@Autowired
	private PaisRepository paisRepository;

	@GetMapping("/pais/r")
	public String r(ModelMap m) {
		List<Pais> paises = paisRepository.findAll();
		m.put("paises", paises);
		m.put("view", "pais/r");
		return "_t/frame";
	}

	@GetMapping("/pais/c")
	public String c(ModelMap m) {
		m.put("view", "pais/c");
		return "_t/frame";
	}

	@PostMapping("/pais/c")
	public String cPost(@RequestParam("nombre") String nombre) throws DangerException {
		try {
			paisRepository.save(new Pais(nombre));
		} catch (Exception e) {
			PRG.error("El país "+nombre+" ya existe", "/pais/c");
		}
		return "redirect:/pais/r";
	}
}
