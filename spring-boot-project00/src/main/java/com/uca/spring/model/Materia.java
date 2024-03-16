package com.uca.spring.model;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Materia")

public class Materia {
	@Id
	@Column(name="id_materia")
	Integer idMateria; 
	
	@Column(name="nombre_materia")
	String nombreMateria;
	
	@Column(name="uv")
	Integer uv;
	
	@Column(name="prerrequisito")
	String preRequisito;
}