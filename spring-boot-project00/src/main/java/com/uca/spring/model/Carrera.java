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
	@Table(name = "Carrera")

public class Carrera {
	
	@Id
	@Column(name="id_carrera")
	Integer idCarrera;
	
	@Column(name="uv_aprobadas")
	Integer uvAprobadas;
	
	@Column(name="cantidad_materias_aprobadas")
	Integer cantidadMateriasAprobadas;
	
	@Column(name="materias_aprobadas")
	String materiasAprobadas;
	
	@Column(name="cantidad_materias_posibles")
	Integer cantidadMateriasPosibles;
	
	@Column(name="materias_posibles")
	String materiasPosibles;
	
	@Column(name="cantidad_actividades_extra")
	Integer cantidadActividadesExtracurriculares;
	
	@Column(name="nota_aprobada")
	String notaAprobada;
	
}
