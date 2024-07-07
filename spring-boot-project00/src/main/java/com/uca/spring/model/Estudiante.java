package com.uca.spring.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Estudiante")

public class Estudiante {
	
	@Id
	@Column(name="id_estudiante")
	Integer idEstudiante; 
	
	@Column(name="carnet")
	Integer carnetEstudiante; 
	
	@Column(name="nombre")
	String nombreEstudiante;
	
	@Column(name="contrasena")
	String contrasenaEstudiante;
	
	@Column(name="carrera")
	Integer carreraEstudiante;

	
}
