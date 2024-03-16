package com.uca.spring.model;
import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class MateriaAprobada {

	private Integer idMateria; 
	private String nombreMateria;
	private Integer uv;
	private String preRequisito;
	private String nota;
	
}