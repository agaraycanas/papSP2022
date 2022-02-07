package org.agaray.pap2021.controller;

import javax.servlet.http.HttpSession;

import org.agaray.pap2021.entities.Persona;
import org.agaray.pap2021.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@Autowired
	private PersonaRepository personaRepository;

	@GetMapping("/login")
	public String login(ModelMap m) {
		m.put("view", "home/login");
		return "_t/frame";
	}

	@PostMapping("/login")
	public String loginPost(@RequestParam("nombre") String nombre, @RequestParam("pwd") String pwd, HttpSession s) {
		String returnLocation = "redirect:/";
		try {
			Persona persona = personaRepository.getByNombre(nombre);
			if (new BCryptPasswordEncoder().matches(pwd, persona.getPwd())) {
				s.setAttribute("persona", persona);
			}
			else {
				returnLocation="redirect:/errorDisplay?msg=Password incorrecta";
			}
		} catch (Exception e) {
			returnLocation="redirect:/errorDisplay?msg=Usuario incorrecto";
		}
		return returnLocation;
	}
	
	@GetMapping("/logout")
	public String logout(
			HttpSession s) {
		s.invalidate();
		return "redirect:/";
	}

	@GetMapping("/")
	public String index(ModelMap m) {
		m.put("view", "home/index");
		return "_t/frame";
	}
}
