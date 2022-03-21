package org.agaray.pap2021.controller.rest;

import java.util.List;

import org.agaray.pap2021.entities.Pais;
import org.agaray.pap2021.service.web.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RestController
@RequestMapping("/REST/pais")
public class PaisRestController {
	
	@Autowired
	private PaisService paisService;

	@GetMapping("r")
	public List<Pais> r() {
		List<Pais> paises = paisService.findAll();
		return paises;
	}
	
	@PostMapping("c")
	public Pais c(
			@RequestParam("nombre") String nombre)  {
		Pais pais = null;
		try {
			pais = paisService.save(nombre);
		} catch (Exception e) {
		}
		return pais;
	}
	
	@PutMapping("u")
	public Pais u(
		@RequestBody Pais pais)  {
		try {
			pais = paisService.update(pais);
		} catch (Exception e) {
		}
		return pais;
	}
	
	@DeleteMapping("d")
	public Pais d(
			@RequestParam("id") Long id
			) {
		
		try {
			paisService.delete(id);
		}
		catch (Exception e) {
			
		}
		return null;
	}
	
}
