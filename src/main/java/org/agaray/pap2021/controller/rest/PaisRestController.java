package org.agaray.pap2021.controller.rest;

import java.util.List;

import org.agaray.pap2021.entities.Pais;
import org.agaray.pap2021.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/pais")
public class PaisRestController {
	
	@Autowired
	private PaisService paisService;

	@GetMapping("r")
	public List<Pais> r() {
		List<Pais> paises = paisService.findAll();
		return paises;
	}
}
