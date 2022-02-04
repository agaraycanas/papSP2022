package org.agaray.pap2021.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ErrorController {
	
	@GetMapping("/errorDisplay")
	public String mensajeError(
			@RequestParam("msg") String mensajeError,
			ModelMap m 
			) {
		m.put("mensajeError", mensajeError);
		return "error/error";
	}
}
