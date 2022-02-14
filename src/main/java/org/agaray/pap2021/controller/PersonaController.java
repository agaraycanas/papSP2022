package org.agaray.pap2021.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.agaray.pap2021.entities.Aficion;
import org.agaray.pap2021.entities.Pais;
import org.agaray.pap2021.entities.Persona;
import org.agaray.pap2021.exception.DangerException;
import org.agaray.pap2021.exception.PRG;
import org.agaray.pap2021.repository.AficionRepository;
import org.agaray.pap2021.repository.PaisRepository;
import org.agaray.pap2021.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PersonaController {

	@Autowired
	private PersonaRepository personaRepository;

	@Autowired
	private PaisRepository paisRepository;

	@Autowired
	private AficionRepository aficionRepository;
	
	@Value("${app.uploadFolder}")
	private String UPLOADED_FOLDER;  //

	@GetMapping("/persona/r")
	public String r(ModelMap m,
			HttpSession s) throws DangerException {
		List<Persona> personas = personaRepository.findAll();
		m.put("personas", personas);
		m.put("view", "persona/r");
		return "_t/frame";	}

	@GetMapping("/persona/c")
	public String c(
			ModelMap m) {
		m.put("paises", paisRepository.findAll());
		m.put("aficiones", aficionRepository.findAll());
		m.put("view", "persona/c");
		return "_t/frame";
	}

	@PostMapping("/persona/c")
	public String cPost(
			@RequestParam("nombre") String nombre,
			@RequestParam("pwd") String pwd,
			@RequestParam(value="foto", required=false) MultipartFile foto,
			@RequestParam(value="fNac",required=false)
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			LocalDate fNac,
			@RequestParam(value="idPaisNace",required=false) Long idPaisNace,
			@RequestParam(value="idPaisVive",required=false) Long idPaisVive,
			@RequestParam(value="idAficion[]",required=false) List<Long> idsAficion
			) throws DangerException {
		try {
			Pais paisNace= idPaisNace==null?null:paisRepository.getById(idPaisNace);
			Pais paisVive = idPaisVive==null ? null :paisRepository.getById(idPaisVive);
			Persona persona = new Persona(nombre,pwd,fNac,paisNace,paisVive);
			if (idsAficion!=null) {
				for (Long idAficion:idsAficion) {
					persona.addAficionGusta(aficionRepository.getById(idAficion));
				}
			}
			
			personaRepository.save(persona);

			//Intentamos subir la foto
			try {
				if (foto!=null) {
					byte[] bytes = foto.getBytes();
					//String extension = foto.getOriginalFilename().split("\\.")[1];
					Path path = Paths.get(UPLOADED_FOLDER + "foto-"+persona.getId());
					Files.write(path, bytes);
				}
			}
			catch (Exception e) {
				PRG.error(e.getMessage());
			}

		
		} catch (Exception e) {
			PRG.error("Error indeterminado al crear la persona "+e.getMessage());
		}
		return "redirect:/persona/r";
	}
	
	@GetMapping("/persona/u")
	public String u(
			@RequestParam("idPersona") Long idPersona,
			ModelMap m) {
		m.put("persona", personaRepository.getById(idPersona));
		m.put("paises", paisRepository.findAll());
		m.put("aficiones", aficionRepository.findAll());
		m.put("view", "persona/u");
		return "_t/frame";
	}
	
	@PostMapping("/persona/u")
	public String uPost(
			@RequestParam("nombre") String nombre,
			@RequestParam("idPaisNace") Long idPaisNace,
			@RequestParam("idPersona") Long idPersona,
			@RequestParam(value="idAficion[]",required=false) List<Long> idsAficion
			) throws DangerException {
		try {
			Persona persona = personaRepository.getById(idPersona);
			persona.setNombre(nombre);
			if (idPaisNace!=persona.getNace().getId()) {
				Pais nuevoPaisNacimiento = paisRepository.getById(idPaisNace);
				persona.setNace(nuevoPaisNacimiento);
			}
			
			ArrayList<Aficion> nuevasAficiones = new ArrayList<Aficion>();
			
			if (idsAficion!=null) {
				for (Long idAficion:idsAficion) {
					nuevasAficiones.add(aficionRepository.getById(idAficion));
				}
			}
			
			persona.setAficionesGusta(nuevasAficiones);
			
			personaRepository.save(persona);
		} catch (Exception e) {
			PRG.error("Error indeterminado al crear la persona "+e.getMessage());
		}
		return "redirect:/persona/r";
	}
	
	@PostMapping("/persona/d")
	public String dPost(
			@RequestParam("idPersona") Long idPersona
			) {
		personaRepository.deleteById(idPersona);
		return "redirect:/persona/r";
	}
}
