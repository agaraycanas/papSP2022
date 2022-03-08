package org.agaray.pap2021.controller.inter;


import org.agaray.pap2021.entities.Pais;
import org.agaray.pap2021.service.inter.PaisInterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/INTER/pais")
public class PaisInterController {

	@Autowired
	private PaisInterService paisInterService;
	
	@GetMapping("r")
	public String r(ModelMap m) {
		Pais[] paises = paisInterService.findAll();
		m.put("paises", paises);
		m.put("view", "INTER/pais/r");
		return "_t/frame";
	}
}
