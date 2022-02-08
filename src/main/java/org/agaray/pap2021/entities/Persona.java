package org.agaray.pap2021.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String nombre;
	private String pwd;
	
	@ManyToOne
	private Pais nace;

	//========================
	public Persona() {
		this.nombre="dormir";
	}
	
	public Persona(String nombre,String pwd,Pais nace) {
		this.nombre = nombre;
		this.pwd = encriptar(pwd);
		this.nace = nace;
		this.nace.getNativos().add(this);
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

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = encriptar(pwd);
	}
	
	public Pais getNace() {
		return nace;
	}

	public void setNace(Pais nace) {
		this.nace = nace;
		this.nace.getNativos().add(this);
	}
	//========================
	


	private String encriptar(String pwd) {
		return (new BCryptPasswordEncoder()).encode(pwd); 
	}
}
