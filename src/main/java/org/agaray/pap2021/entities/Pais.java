package org.agaray.pap2021.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String nombre;
	
	@OneToMany(mappedBy = "nace", cascade = CascadeType.ALL)
	private Collection<Persona> nativos;

	@OneToMany(mappedBy = "vive", cascade = CascadeType.ALL)
	private Collection<Persona> habitantes;
	//========================
	public Pais() {
		this.nombre="Atlantida";
		this.nativos = new ArrayList<Persona>();
		this.habitantes= new ArrayList<Persona>();
	}
	
	public Pais(String nombre) {
		this.nombre = nombre;
		this.nativos = new ArrayList<Persona>();
		this.habitantes= new ArrayList<Persona>();
	}
	//========================

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<Persona> getNativos() {
		return nativos;
	}

	public void setNativos(Collection<Persona> nativos) {
		this.nativos = nativos;
	}

	public Collection<Persona> getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(Collection<Persona> habitantes) {
		this.habitantes = habitantes;
	}
	
	
	//========================
	
}
