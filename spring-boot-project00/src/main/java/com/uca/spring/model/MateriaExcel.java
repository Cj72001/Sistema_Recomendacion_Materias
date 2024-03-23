package com.uca.spring.model;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class MateriaExcel {

	private String idMateria; 
	private String nombreMateria;
	//private Integer uv;
	private List<MateriaExcel> preRequisito = new ArrayList<>();
	private String nota;
	
}