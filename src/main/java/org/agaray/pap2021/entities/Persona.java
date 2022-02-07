package org.agaray.pap2021.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String nombre;
	private String pwd;

	//========================
	public Persona() {
		this.nombre="dormir";
	}
	
	public Persona(String nombre,String pwd) {
		this.nombre = nombre;
		this.pwd = encriptar(pwd);
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
	
	
	//========================
	
	private String encriptar(String pwd) {
		return (new BCryptPasswordEncoder()).encode(pwd); 
	}
}
