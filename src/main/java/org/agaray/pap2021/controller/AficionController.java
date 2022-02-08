package org.agaray.pap2021.controller;

import java.util.List;

import org.agaray.pap2021.entities.Aficion;
import org.agaray.pap2021.repository.AficionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AficionController {

	@Autowired
	private AficionRepository aficionRepository;

	@GetMapping("/aficion/r")
	public String r(ModelMap m) {
		List<Aficion> aficiones = aficionRepository.findAll();
		m.put("aficiones", aficiones);
		m.put("view", "aficion/r");
		return "_t/frame";
	}

	@GetMapping("/aficion/c")
	public String c(ModelMap m) {
		m.put("view", "aficion/c");
		return "_t/frame";
	}

	@PostMapping("/aficion/c")
	public String cPost(@RequestParam("nombre") String nombre) {
		String returnLocation = "";
		try {
			aficionRepository.save(new Aficion(nombre));
			returnLocation = "redirect:/aficion/r";
		} catch (Exception e) {
			returnLocation = "redirect:/errorDisplay?msg=La afición " + nombre + " ya existe";
		}
		return returnLocation;
	}
}
