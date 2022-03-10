package org.agaray.pap2021.service.inter;


import org.agaray.pap2021.entities.Pais;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaisInterService {
	public Pais[] findAll() {
		RestTemplate rt= new RestTemplate();
		return rt.getForEntity("http://localhost:8080/REST/pais/r",Pais[].class).getBody();
	}
}
