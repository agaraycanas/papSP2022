package org.agaray.pap2021.repository;

import org.agaray.pap2021.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{
	public Persona getByNombre(String nombre);
}
