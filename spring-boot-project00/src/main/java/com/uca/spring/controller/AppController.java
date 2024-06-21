package com.uca.spring.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.uca.spring.model.Carrera;
import com.uca.spring.model.Estudiante;
import com.uca.spring.model.Logs;
import com.uca.spring.model.Materia;
import com.uca.spring.model.MateriaAprobada;
import com.uca.spring.model.MateriaExcel;
import com.uca.spring.service.CarreraService;
import com.uca.spring.service.EstudianteService;
import com.uca.spring.service.LogsService;
import com.uca.spring.service.MateriaService;
import com.uca.spring.util.Util;

@Controller
@RequestMapping("/")
public class AppController {

	// services para DML de la bdd
	@Autowired
	CarreraService carreraService;
	@Autowired
	EstudianteService estudianteService;
	@Autowired
	MateriaService materiaService;
	@Autowired
	LogsService logsService;
	
	Estudiante estudianteEjemplo = new Estudiante();
	Carrera carreraEstudianteEjemplo = new Carrera();

	// Creando estudiante ejemplo:
	Estudiante estudiante1 = new Estudiante();
	boolean estudianteExiste = false;
	Estudiante estudianteLogeado = new Estudiante();

	// Creando carrera para Estudiante1:
	Carrera carreraEstudiante1 = new Carrera();
	Carrera carreraEstudianteLogeado = new Carrera(); // carrera que se inicializara respecto al estudiante que se
														// loguea


	// Crear todos los objetos para la malla curricular (ing informatica):
	Materia materiaEstudianteEjemplo0 = new Materia();
	Materia materiaEstudianteEjemplo1 = new Materia();
	Materia materiaEstudianteEjemplo2 = new Materia();
	Materia materiaEstudianteEjemplo3 = new Materia();
	Materia materiaEstudianteEjemplo4 = new Materia();
	Materia materiaEstudianteEjemplo5 = new Materia();
	Materia materiaEstudianteEjemplo6 = new Materia();
	Materia materiaEstudianteEjemplo7 = new Materia();
	Materia materiaEstudianteEjemplo8 = new Materia();
	Materia materiaEstudianteEjemplo9 = new Materia();
	Materia materiaEstudianteEjemplo10 = new Materia();
	Materia materiaEstudianteEjemplo11 = new Materia();
	Materia materiaEstudianteEjemplo12 = new Materia();
	Materia materiaEstudianteEjemplo13 = new Materia();
	Materia materiaEstudianteEjemplo14 = new Materia();
	Materia materiaEstudianteEjemplo15 = new Materia();
	Materia materiaEstudianteEjemplo16 = new Materia();
	Materia materiaEstudianteEjemplo17 = new Materia();
	Materia materiaEstudianteEjemplo18 = new Materia();
	Materia materiaEstudianteEjemplo19 = new Materia();
	Materia materiaEstudianteEjemplo20 = new Materia();
	Materia materiaEstudianteEjemplo21 = new Materia();
	Materia materiaEstudianteEjemplo22 = new Materia();
	Materia materiaEstudianteEjemplo23 = new Materia();
	Materia materiaEstudianteEjemplo24 = new Materia();
	Materia materiaEstudianteEjemplo25 = new Materia();
	Materia materiaEstudianteEjemplo26 = new Materia();
	Materia materiaEstudianteEjemplo27 = new Materia();
	Materia materiaEstudianteEjemplo28 = new Materia();
	Materia materiaEstudianteEjemplo29 = new Materia();
	Materia materiaEstudianteEjemplo30 = new Materia();
	Materia materiaEstudianteEjemplo31 = new Materia();
	Materia materiaEstudianteEjemplo32 = new Materia();
	Materia materiaEstudianteEjemplo33 = new Materia();
	Materia materiaEstudianteEjemplo34 = new Materia();
	Materia materiaEstudianteEjemplo35 = new Materia();
	Materia materiaEstudianteEjemplo36 = new Materia();
	Materia materiaEstudianteEjemplo37 = new Materia();
	Materia materiaEstudianteEjemplo38 = new Materia();
	Materia materiaEstudianteEjemplo39 = new Materia();
	Materia materiaEstudianteEjemplo40 = new Materia();
	Materia materiaEstudianteEjemplo41 = new Materia();
	Materia materiaEstudianteEjemplo42 = new Materia();
	Materia materiaEstudianteEjemplo43 = new Materia();
	Materia materiaEstudianteEjemplo44 = new Materia();

	

	//// ACTIONS PARA RUTAS (para cargar jsp):
	// -------------------------------------------------------------------------------------------------------------------------

	// Action que se invoca al iniciar la app en la ruta (/)
	@GetMapping("/")
	public String getForm() {

		// Seteando atributos para estudiante1 y crearlo en bdd para ejemplo:
		estudiante1.setCarnetEstudiante(38619);
		estudiante1.setIdEstudiante(1);
		estudiante1.setNombreEstudiante("Omar Flores Alas");
		estudiante1.setContrasenaEstudiante("123");
		estudiante1.setCarreraEstudiante(1);
		estudianteService.createEstudiante(estudiante1);

		// seteando carrera1 para ejemplo (este objeto se enlazara con Estudiante por
		// medio de su FK)
		carreraEstudiante1.setIdCarrera(1);
		carreraEstudiante1.setUvAprobadas(102);
		carreraEstudiante1.setCantidadMateriasAprobadas(4);
		carreraEstudiante1.setMateriasAprobadas("1,2,3,4");
		// carreraEstudiante1.setNotaAprobada("10,5,5,5");
		carreraEstudiante1.setNotaAprobada("10,5,10,5");
		carreraEstudiante1.setCantidadMateriasPosibles(4);
		carreraEstudiante1.setMateriasPosibles("5,6,7,8");
		carreraEstudiante1.setCantidadActividadesExtracurriculares(2);
		carreraService.createCarrera(carreraEstudiante1);

		// seteando materias (seran las materias aprobadas relacionadas al estudiante)
		// para ejemplo (este objeto se enlazara con Estudiante por medio de su FK)
		// OBJETO DE MALLA (prerequisito =0 cuando sea bachillerato)
		// materias de ingenieria informatica:
		materiaEstudianteEjemplo0.setNombreMateria("Bachillerato");
		materiaEstudianteEjemplo0.setIdMateria(0);
		materiaEstudianteEjemplo0.setUv(0);
		materiaEstudianteEjemplo0.setPreRequisito("0");
		materiaService.createMateria(materiaEstudianteEjemplo0);
		
		materiaEstudianteEjemplo1.setNombreMateria("Precálculo");
		materiaEstudianteEjemplo1.setIdMateria(1);
		materiaEstudianteEjemplo1.setUv(4);
		materiaEstudianteEjemplo1.setPreRequisito("0");
		materiaService.createMateria(materiaEstudianteEjemplo1);
		
		materiaEstudianteEjemplo2.setNombreMateria("Optativa Técnica I");
		materiaEstudianteEjemplo2.setIdMateria(2);
		materiaEstudianteEjemplo2.setUv(3);
		materiaEstudianteEjemplo2.setPreRequisito("0");
		materiaService.createMateria(materiaEstudianteEjemplo2);

		materiaEstudianteEjemplo3.setNombreMateria("Matemática Discreta I");
		materiaEstudianteEjemplo3.setIdMateria(3);
		materiaEstudianteEjemplo3.setUv(3);
		materiaEstudianteEjemplo3.setPreRequisito("0");
		materiaService.createMateria(materiaEstudianteEjemplo3);
		
		materiaEstudianteEjemplo4.setNombreMateria("Fundamentos de Programación");
		materiaEstudianteEjemplo4.setIdMateria(4);
		materiaEstudianteEjemplo4.setUv(4);
		materiaEstudianteEjemplo4.setPreRequisito("0");
		materiaService.createMateria(materiaEstudianteEjemplo4);

		materiaEstudianteEjemplo5.setNombreMateria("Álgebra Vectorial y Matrices");
		materiaEstudianteEjemplo5.setIdMateria(5);
		materiaEstudianteEjemplo5.setUv(4);
		materiaEstudianteEjemplo5.setPreRequisito("1");
		materiaService.createMateria(materiaEstudianteEjemplo5);

		materiaEstudianteEjemplo6.setNombreMateria("Cálculo I");
		materiaEstudianteEjemplo6.setIdMateria(6);
		materiaEstudianteEjemplo6.setUv(4);
		materiaEstudianteEjemplo6.setPreRequisito("1");
		materiaService.createMateria(materiaEstudianteEjemplo6);

		materiaEstudianteEjemplo7.setNombreMateria("Programación de Estructuras Dinámicas");
		materiaEstudianteEjemplo7.setIdMateria(7);
		materiaEstudianteEjemplo7.setUv(4);
		materiaEstudianteEjemplo7.setPreRequisito("3,4");
		materiaService.createMateria(materiaEstudianteEjemplo7);

		materiaEstudianteEjemplo8.setNombreMateria("Matemática Discreta II");
		materiaEstudianteEjemplo8.setIdMateria(8);
		materiaEstudianteEjemplo8.setUv(3);
		materiaEstudianteEjemplo8.setPreRequisito("3");
		materiaService.createMateria(materiaEstudianteEjemplo8);

		materiaEstudianteEjemplo9.setNombreMateria("Física I");
		materiaEstudianteEjemplo9.setIdMateria(9);
		materiaEstudianteEjemplo9.setUv(5);
		materiaEstudianteEjemplo9.setPreRequisito("5,6");
		materiaService.createMateria(materiaEstudianteEjemplo9);

		materiaEstudianteEjemplo10.setNombreMateria("Cálculo II");
		materiaEstudianteEjemplo10.setIdMateria(10);
		materiaEstudianteEjemplo10.setUv(4);
		materiaEstudianteEjemplo10.setPreRequisito("5,6");
		materiaService.createMateria(materiaEstudianteEjemplo10);

		materiaEstudianteEjemplo11.setNombreMateria("Programación Orientada a Objetos");
		materiaEstudianteEjemplo11.setIdMateria(11);
		materiaEstudianteEjemplo11.setUv(4);
		materiaEstudianteEjemplo11.setPreRequisito("7");
		materiaService.createMateria(materiaEstudianteEjemplo11);

		materiaEstudianteEjemplo12.setNombreMateria("Bases de Datos");
		materiaEstudianteEjemplo12.setIdMateria(12);
		materiaEstudianteEjemplo12.setUv(4);
		materiaEstudianteEjemplo12.setPreRequisito("7");
		materiaService.createMateria(materiaEstudianteEjemplo12);

		materiaEstudianteEjemplo13.setNombreMateria("Electricidad y Magnetismo");
		materiaEstudianteEjemplo13.setIdMateria(13);
		materiaEstudianteEjemplo13.setUv(5);
		materiaEstudianteEjemplo13.setPreRequisito("9,10");
		materiaService.createMateria(materiaEstudianteEjemplo13);

		materiaEstudianteEjemplo14.setNombreMateria("Cálculo III");
		materiaEstudianteEjemplo14.setIdMateria(14);
		materiaEstudianteEjemplo14.setUv(4);
		materiaEstudianteEjemplo14.setPreRequisito("10");
		materiaService.createMateria(materiaEstudianteEjemplo14);

		materiaEstudianteEjemplo15.setNombreMateria("Programación WEB");
		materiaEstudianteEjemplo15.setIdMateria(15);
		materiaEstudianteEjemplo15.setUv(4);
		materiaEstudianteEjemplo15.setPreRequisito("11");
		materiaService.createMateria(materiaEstudianteEjemplo15);

		materiaEstudianteEjemplo16.setNombreMateria("Administración de Bases de Datos");
		materiaEstudianteEjemplo16.setIdMateria(16);
		materiaEstudianteEjemplo16.setUv(4);
		materiaEstudianteEjemplo16.setPreRequisito("12");
		materiaService.createMateria(materiaEstudianteEjemplo16);

		materiaEstudianteEjemplo17.setNombreMateria("Optativa Humanístico Social I");
		materiaEstudianteEjemplo17.setIdMateria(17);
		materiaEstudianteEjemplo17.setUv(3);
		materiaEstudianteEjemplo17.setPreRequisito("0");
		materiaService.createMateria(materiaEstudianteEjemplo17);

		materiaEstudianteEjemplo18.setNombreMateria("Análisis Numérico");
		materiaEstudianteEjemplo18.setIdMateria(18);
		materiaEstudianteEjemplo18.setUv(4);
		materiaEstudianteEjemplo18.setPreRequisito("14");
		materiaService.createMateria(materiaEstudianteEjemplo18);

		materiaEstudianteEjemplo19.setNombreMateria("Redes de Computadoras");
		materiaEstudianteEjemplo19.setIdMateria(19);
		materiaEstudianteEjemplo19.setUv(4);
		materiaEstudianteEjemplo19.setPreRequisito("15");
		materiaService.createMateria(materiaEstudianteEjemplo19);

		materiaEstudianteEjemplo20.setNombreMateria("Programación de Dispositivos Móviles");
		materiaEstudianteEjemplo20.setIdMateria(20);
		materiaEstudianteEjemplo20.setUv(4);
		materiaEstudianteEjemplo20.setPreRequisito("11");
		materiaService.createMateria(materiaEstudianteEjemplo20);

		materiaEstudianteEjemplo21.setNombreMateria("Análisis de Sistemas");
		materiaEstudianteEjemplo21.setIdMateria(21);
		materiaEstudianteEjemplo21.setUv(3);
		materiaEstudianteEjemplo21.setPreRequisito("15");
		materiaService.createMateria(materiaEstudianteEjemplo21);

		materiaEstudianteEjemplo22.setNombreMateria("Física II");
		materiaEstudianteEjemplo22.setIdMateria(22);
		materiaEstudianteEjemplo22.setUv(5);
		materiaEstudianteEjemplo22.setPreRequisito("9,10");
		materiaService.createMateria(materiaEstudianteEjemplo22);

		materiaEstudianteEjemplo23.setNombreMateria("Optativa Humanístico Social II");
		materiaEstudianteEjemplo23.setIdMateria(23);
		materiaEstudianteEjemplo23.setUv(3);
		materiaEstudianteEjemplo23.setPreRequisito("0");
		materiaService.createMateria(materiaEstudianteEjemplo23);

		materiaEstudianteEjemplo24.setNombreMateria("Análisis de Algoritmos");
		materiaEstudianteEjemplo24.setIdMateria(24);
		materiaEstudianteEjemplo24.setUv(4);
		materiaEstudianteEjemplo24.setPreRequisito("8");
		materiaService.createMateria(materiaEstudianteEjemplo24);

		materiaEstudianteEjemplo25.setNombreMateria("Programación de Artefactos");
		materiaEstudianteEjemplo25.setIdMateria(25);
		materiaEstudianteEjemplo25.setUv(4);
		materiaEstudianteEjemplo25.setPreRequisito("13,15");
		materiaService.createMateria(materiaEstudianteEjemplo25);

		materiaEstudianteEjemplo26.setNombreMateria("Probabilidad y Estadística");
		materiaEstudianteEjemplo26.setIdMateria(26);
		materiaEstudianteEjemplo26.setUv(4);
		materiaEstudianteEjemplo26.setPreRequisito("14");
		materiaService.createMateria(materiaEstudianteEjemplo26);

		materiaEstudianteEjemplo27.setNombreMateria("Seguridad en Entornos de Desarrollo");
		materiaEstudianteEjemplo27.setIdMateria(27);
		materiaEstudianteEjemplo27.setUv(4);
		materiaEstudianteEjemplo27.setPreRequisito("8,16");
		materiaService.createMateria(materiaEstudianteEjemplo27);

		materiaEstudianteEjemplo28.setNombreMateria("Arquitectura de Computadoras");
		materiaEstudianteEjemplo28.setIdMateria(28);
		materiaEstudianteEjemplo28.setUv(4);
		materiaEstudianteEjemplo28.setPreRequisito("13");
		materiaService.createMateria(materiaEstudianteEjemplo28);

		materiaEstudianteEjemplo29.setNombreMateria("Técnicas de Simulación en Computadoras");
		materiaEstudianteEjemplo29.setIdMateria(29);
		materiaEstudianteEjemplo29.setUv(4);
		materiaEstudianteEjemplo29.setPreRequisito("26");
		materiaService.createMateria(materiaEstudianteEjemplo29);

		materiaEstudianteEjemplo30.setNombreMateria("Programación N-Capas");
		materiaEstudianteEjemplo30.setIdMateria(30);
		materiaEstudianteEjemplo30.setUv(4);
		materiaEstudianteEjemplo30.setPreRequisito("11");
		materiaService.createMateria(materiaEstudianteEjemplo30);

		materiaEstudianteEjemplo31.setNombreMateria("Fundamentos de Inteligencia de Negocios");
		materiaEstudianteEjemplo31.setIdMateria(31);
		materiaEstudianteEjemplo31.setUv(4);
		materiaEstudianteEjemplo31.setPreRequisito("16");
		materiaService.createMateria(materiaEstudianteEjemplo31);

		materiaEstudianteEjemplo32.setNombreMateria("Optativa Humanístico Social III");
		materiaEstudianteEjemplo32.setIdMateria(32);
		materiaEstudianteEjemplo32.setUv(3);
		materiaEstudianteEjemplo32.setPreRequisito("0");
		materiaService.createMateria(materiaEstudianteEjemplo32);

		materiaEstudianteEjemplo33.setNombreMateria("Sistemas Operativos");
		materiaEstudianteEjemplo33.setIdMateria(33);
		materiaEstudianteEjemplo33.setUv(4);
		materiaEstudianteEjemplo33.setPreRequisito("28");
		materiaService.createMateria(materiaEstudianteEjemplo33);

		materiaEstudianteEjemplo34.setNombreMateria("Programación Declarativa");
		materiaEstudianteEjemplo34.setIdMateria(34);
		materiaEstudianteEjemplo34.setUv(4);
		materiaEstudianteEjemplo34.setPreRequisito("15");
		materiaService.createMateria(materiaEstudianteEjemplo34);

		materiaEstudianteEjemplo35.setNombreMateria("Ingeniería de Software");
		materiaEstudianteEjemplo35.setIdMateria(35);
		materiaEstudianteEjemplo35.setUv(4);
		materiaEstudianteEjemplo35.setPreRequisito("21");
		materiaService.createMateria(materiaEstudianteEjemplo35);

		materiaEstudianteEjemplo36.setNombreMateria("Formulación y Evaluación de Proyectos");
		materiaEstudianteEjemplo36.setIdMateria(36);
		materiaEstudianteEjemplo36.setUv(4);
		materiaEstudianteEjemplo36.setPreRequisito("21");
		materiaService.createMateria(materiaEstudianteEjemplo36);

		materiaEstudianteEjemplo37.setNombreMateria("Optativa Humanístico Social IV");
		materiaEstudianteEjemplo37.setIdMateria(37);
		materiaEstudianteEjemplo37.setUv(3);
		materiaEstudianteEjemplo37.setPreRequisito("0");
		materiaService.createMateria(materiaEstudianteEjemplo37);

		materiaEstudianteEjemplo38.setNombreMateria("Optativa Técnica II");
		materiaEstudianteEjemplo38.setIdMateria(38);
		materiaEstudianteEjemplo38.setUv(4);
		materiaEstudianteEjemplo38.setPreRequisito("0");
		materiaService.createMateria(materiaEstudianteEjemplo38);

		materiaEstudianteEjemplo39.setNombreMateria("Aplicaciones de Código Abierto");
		materiaEstudianteEjemplo39.setIdMateria(39);
		materiaEstudianteEjemplo39.setUv(4);
		materiaEstudianteEjemplo39.setPreRequisito("21");
		materiaService.createMateria(materiaEstudianteEjemplo39);

		materiaEstudianteEjemplo40.setNombreMateria("Práctica Profesional I");
		materiaEstudianteEjemplo40.setIdMateria(40);
		materiaEstudianteEjemplo40.setUv(4);
		materiaEstudianteEjemplo40.setPreRequisito("36");
		materiaService.createMateria(materiaEstudianteEjemplo40);

		materiaEstudianteEjemplo41.setNombreMateria("Optativa Técnica III");
		materiaEstudianteEjemplo41.setIdMateria(41);
		materiaEstudianteEjemplo41.setUv(4);
		materiaEstudianteEjemplo41.setPreRequisito("0");
		materiaService.createMateria(materiaEstudianteEjemplo41);

		materiaEstudianteEjemplo42.setNombreMateria("Teorías de Lenguaje de Programación");
		materiaEstudianteEjemplo42.setIdMateria(42);
		materiaEstudianteEjemplo42.setUv(4);
		materiaEstudianteEjemplo42.setPreRequisito("24");
		materiaService.createMateria(materiaEstudianteEjemplo42);

		materiaEstudianteEjemplo43.setNombreMateria("Optativa Humanístico Social V");
		materiaEstudianteEjemplo43.setIdMateria(43);
		materiaEstudianteEjemplo43.setUv(3);
		materiaEstudianteEjemplo43.setPreRequisito("0");
		materiaService.createMateria(materiaEstudianteEjemplo43);

		materiaEstudianteEjemplo44.setNombreMateria("Práctica Profesional II");
		materiaEstudianteEjemplo44.setIdMateria(44);
		materiaEstudianteEjemplo44.setUv(4);
		materiaEstudianteEjemplo44.setPreRequisito("40");
		materiaService.createMateria(materiaEstudianteEjemplo44);


		return "login.jsp";
	}

	// Para menu:
	@GetMapping("/mainPage")
	public String mainPage(ModelMap modelMap) {

		// Lista de tabla Estudiante
		List<Estudiante> estudiantes = new ArrayList<Estudiante>();
		estudianteService.getEstudiantes().forEach(e -> estudiantes.add(e));

		estudiantes.forEach(e -> {
			if (e.getIdEstudiante().toString().equals(estudianteLogeado.getIdEstudiante().toString())) {
				estudianteLogeado = e;
				carreraEstudianteLogeado = carreraService.getCarreraById(e.getIdEstudiante());
			}
		});

		// menu atributos sobre la carrera del estudiante:
		modelMap.put("nombreEstudiante", estudianteLogeado.getNombreEstudiante());
		modelMap.put("numeroMateriasAprobadasEstudiante", carreraEstudianteLogeado.getCantidadMateriasAprobadas());
		modelMap.put("materiasDisponiblesEstudiante", carreraEstudianteLogeado.getCantidadMateriasPosibles());
		modelMap.put("actividadesExtracurricularesEstudiante",
				carreraEstudianteLogeado.getCantidadActividadesExtracurriculares());
		return "mainPage.jsp";
	}

	// Para las materias habiles:
	@GetMapping("/availableSubjects")
	public String availableSubjects(ModelMap modelmap) {

		// Separa las el id de las materias aprobadas que tiene el estudiante en la
		// tabla carrera
		// y busca las materias en la tabla Materia y las agrega a la lista materias
		// para mostrarlas
		List<Materia> materiasP = new ArrayList<Materia>();
		List<Materia> materiasA = new ArrayList<Materia>();
		List<Double> notaAprobada = new ArrayList<Double>();

		String[] split1 = carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()).getMateriasPosibles()
				.split(",");
		String[] split2 = carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()).getMateriasAprobadas()
				.split(",");
		String[] split3 = carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()).getNotaAprobada()
				.split(",");

		// Agregando las materias posibles
		for (int i = 0; i < split1.length; i++) {
			materiasP.add(materiaService.getMateriaById(Integer.parseInt(split1[i])));
		}
		materiasP.remove(null);

		// Crear un Comparator para ordenar por id
        Comparator<Materia> comparator = new Comparator<Materia>() {
            @Override
            public int compare(Materia o1, Materia o2) {
                return Integer.compare(o1.getIdMateria(), o2.getIdMateria());
            }
        };

		// Ordenar la lista usando Collections.sort
        Collections.sort(materiasP, comparator);

		// Agregando las materias aprobadas y sus notas
		for (int i = 0; i < split2.length; i++) {
			materiasA.add(materiaService.getMateriaById(Integer.parseInt(split2[i])));
			notaAprobada.add(Double.valueOf(split3[i]));
		}
		materiasA.remove(null);

		if(materiasA.size()==1 && materiasA.get(0).getNombreMateria().equals("Bachillerato")){
			materiasA.remove(0);
		}

		notaAprobada.remove(null);

		// Obteniendo las materias recomendadas desde la clase Util
		File f = new File(pathExcelEstudiante);
		List<Materia> materiasR = new ArrayList<>();

		if(f.exists()){
			List<MateriaExcel> materiasExcel = Util.materiasRecomendadas(f);
		List<Materia> materias = materiaService.getMaterias();

		materias.forEach(m->{
			materiasExcel.forEach(m2->{
				if(m.getIdMateria().toString().equals(m2.getIdMateria())){
					materiasR.add(m);
				}
			});
		});
		}
		
		

		if (materiasP.isEmpty()) {
			modelmap.addAttribute("errorSem3", "En este momento no tienes materias disponibles, Por favor agregar EXCEL");
			return "availableSubjects.jsp";
		} else {

			if (materiasA.isEmpty() || !(f.exists())) {
				modelmap.addAttribute("materias", materiasP);
				modelmap.addAttribute("errorSem3", "En este momento no tienes materias recomendadas");
				return "availableSubjects.jsp";
			} else {
				modelmap.addAttribute("materias", materiasP);
				modelmap.addAttribute("materiasR", materiasR);
				return "availableSubjects.jsp";
			}

		}

	}

	// Para las materias aprovadas:
	@GetMapping("/approvedSubjects")
	public String approvedSubjects(ModelMap modelmap) {

		// Separa las el id de las materias aprobadas que tiene el estudiante en la
		// tabla carrera
		// y busca las materias en la tabla Materia y las agrega a la lista materias
		// para mostrarlas
		List<Materia> materiasMA = new ArrayList<Materia>();

		String materiasAprobadasIdsEstudiante = carreraService.getCarreraById(estudianteLogeado.getIdEstudiante())
				.getMateriasAprobadas();
		String[] split = materiasAprobadasIdsEstudiante.split(",");

		for (int i = 0; i < split.length; i++) {

			//TODO: ARREGLAR CUANDO EL ID SEA -1
			//
			//
			if(split[i].equals("-1")){
				materiasMA.add(new Materia());
				continue;
			}
			materiasMA.add(materiaService.getMateriaById(Integer.parseInt(split[i])));
		}
		
		List<MateriaAprobada> materiasAprobadasIds = new ArrayList<MateriaAprobada>();
		int sizeMA = materiasMA.size();
		
		String[] split2 = carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()).getNotaAprobada().split(",");
		
		for(int i=0; i<sizeMA; i++) {
			
			MateriaAprobada ma = new MateriaAprobada();
			ma.setIdMateria(materiasMA.get(i).getIdMateria());
			ma.setNombreMateria(materiasMA.get(i).getNombreMateria());
			ma.setUv(materiasMA.get(i).getUv());
			ma.setPreRequisito(materiasMA.get(i).getPreRequisito());
			ma.setNota(split2[i]);
			
			materiasAprobadasIds.add(ma);
		}

		materiasMA.remove(null);
		materiasAprobadasIds.remove(null);

		if (materiasMA.size() == 1 && materiasMA.get(0).getNombreMateria().equals("Bachillerato")) {
			modelmap.addAttribute("errorMA0", "En este momento no tienes materias aprobadas");
			return "approvedSubjects.jsp";
		} else {
			modelmap.addAttribute("materiasMA", materiasAprobadasIds);
			return "approvedSubjects.jsp";
		}

	}

	// Al volver al login o al deslogearse para que reinicie el estudiante logeado
	@GetMapping("/login")
	public String login() throws IOException {

		carreraEstudianteLogeado = null;
		estudianteLogeado = null;
		estudianteExiste = false;

		pathExcelEstudiante = BASE_PATH + "";


		return "login.jsp";
	}

	@GetMapping("/dataUpdate")
	public String dataUpdate() {
		return "dataUpdate.jsp";
	}

	@GetMapping("/semester")
	public String semester() {
		return "availableSubjects.jsp";
	}

	@GetMapping("/userUpdate")
	public String userUpdate() {
		return "userUpdate.jsp";
	}


	@GetMapping("/register")
	public String register() {
		return "register.jsp";
	}

	@GetMapping("/closeSemester")
	public String closeSemester(ModelMap modelMap) {
		modelMap.put("nombreEstudianteCS", estudianteEjemplo.getNombreEstudiante());
		return "closeSemester.jsp";
	}

	@GetMapping("/socialUpdate")
	public String socialUpdate() {
		return "socialUpdate.jsp";
	}

	@GetMapping("/activitiesUpdate")
	public String activitiesUpdate() {
		return "activitiesUpdate.jsp";
	}

	//// ACTIONS PARA post mapping (para botones):
	// -------------------------------------------------------------------------------------------------------------------------

	// Actualizar nombre de usuario:
	@PostMapping("/userUpdateSuccess")
	public String userUpdateSuccess(@RequestParam("name") String name, @RequestParam("carnet") String carnet,
			ModelMap modelMap) {

		// Lista de tabla Estudiante
		List<Estudiante> estudiantes = new ArrayList<Estudiante>();
		estudianteService.getEstudiantes().forEach(e -> estudiantes.add(e));

		if (name.isEmpty() || carnet.isEmpty()) {
			modelMap.put("errorUU", "No deje espacios en blanco");
			return "userUpdate.jsp";
		}
		// Si el usuario que modificara no esta en la bdd
		else if (!carnet.equals(estudianteLogeado.getCarnetEstudiante().toString())) {
			modelMap.put("errorUU", "Carnet incorrecto");
			return "userUpdate.jsp";
		} else {

			estudiantes.forEach(e -> {
				if (e.getCarnetEstudiante().toString().equals(estudianteLogeado.getCarnetEstudiante().toString())) {

					estudianteService.updateEstudianteName(e, name);
				}
			});

			modelMap.put("nombreEstudianteUUS", estudianteEjemplo.getNombreEstudiante());
			return "userUpdateSuccess.jsp";
		}

	}

	// Action para marcar una materia de "materias habiles" (por medio se su
	// correlativo) como aprobada
	// y removerla de las posibles y agregar las nuevas posibles en funcion de esa
	// aprobada
	
	List<String> prerrequisitos;

	@PostMapping("/subjectsUpdateSuccess2")
	public String subjectsUpdateSuccess2(@RequestParam("subject") String subject, ModelMap modelMap) {

		if (subject.isEmpty()) {
			modelMap.put("errorMA", "No deje espacios en blanco");

			approvedSubjects(modelMap);
			return "approvedSubjects.jsp";
		} else if (subject.equals("0")) {
			modelMap.put("errorMA", "No puede remover 'Bachillerato'");

			approvedSubjects(modelMap);
			return "approvedSubjects.jsp";
		} else {

			// POSIBLES MATERIAS DEL ESTUDIANTE LOGEADO:
			List<String> materiasPosiblesIds = new ArrayList<String>();

			String materiasPosiblesIdsEstudianteLogeado = carreraService
					.getCarreraById(estudianteLogeado.getIdEstudiante()).getMateriasPosibles();
			String[] split = materiasPosiblesIdsEstudianteLogeado.split(",");

			for (int i = 0; i < split.length; i++) {
				materiasPosiblesIds.add(split[i]);
			}

			cantMateriasPosibles = (carreraService.getCarreraById(estudianteLogeado.getIdEstudiante())
					.getCantidadMateriasPosibles());

			// materias aprobadas del estudiante logueado:
			List<String> materiasAprobadasIds = new ArrayList<String>();

			String materiasAprobadasIdsEstudianteLogeado = carreraService
					.getCarreraById(estudianteLogeado.getIdEstudiante()).getMateriasAprobadas();
			String[] split1 = materiasAprobadasIdsEstudianteLogeado.split(",");

			for (int i = 0; i < split1.length; i++) {
				materiasAprobadasIds.add(split1[i]);
			}

			cantMateriasAprobadas = (carreraService.getCarreraById(estudianteLogeado.getIdEstudiante())
					.getCantidadMateriasAprobadas());

			// verificamos si la materia que quiere remover en subject
			// la tiene disponible y la puede agregar
			if (!materiasAprobadasIds.contains(subject)) {
				modelMap.put("errorMA", "No puede remover una materia que no tiene aprobada");

				approvedSubjects(modelMap);
				return "approvedSubjects.jsp";
			} else {
				// sino se elimina de la lista de ids de materias aprobadas y
				// se pasa al string de las materias posibles (eliminado de aqui todas aquellas
				// en las cuales
				// esta removida es prequisito)

				// Agregando las materias posibles en funcion de la que se esta removiendo:
				//
				//

				// Lista de tabla Materia
				List<Materia> materias = new ArrayList<Materia>();
				materiaService.getMaterias().forEach(m -> {
					materias.add(m);
				});

				// obteniendo las materias posibles a partir del id aprobado removido
				// y buscando las materias que tengan ese prerrequisito
				materias.forEach(m -> {

					// por cada materia existente, se iran guardando los prerrequisitos
					prerrequisitos = Arrays.asList(m.getPreRequisito().split(","));

					prerrequisitos.forEach(p -> {

						// para cada prerrequisito veremos si es el mismo id de la materia aprobada
						// removida
						if (subject.equals(p)) {

							// entonces si el prerrequisito es el mismo
							// seleccionaremos la materia
							// si esa materia esta en materias posibles ya la removeremos:
							if (materiasPosiblesIds.contains(m.getIdMateria().toString())) {

								materiasPosiblesIds.remove(m.getIdMateria().toString());
								cantMateriasPosibles--;

							}
						}
					});

				});

				// Sumandole la aprobada removida
				cantMateriasPosibles += 1;

				// Agregando la aprobada removida a las posibles
				materiasPosiblesIds.add(subject);
				nuevasMateriasPosibles = String.join(",", materiasPosiblesIds);

				// Removiendo la materia aprobada de las materias aprobadas:
				int indexNota = materiasAprobadasIds.indexOf(subject);
				materiasAprobadasIds.remove(subject);
				nuevasMateriasAprobadas = String.join(",", materiasAprobadasIds);

				// eliminando la nota de la materia a remover (en su indice respectivo)
				String[] notasAprobadas = carreraService.getCarreraById(estudianteLogeado.getIdEstudiante())
						.getNotaAprobada().split(",");

				List<String> na = new ArrayList<>();

				for (int i = 0; i < notasAprobadas.length; i++) {
					if (i != indexNota) {
						na.add(notasAprobadas[i]);
					}
				}

				String nuevasNotasAprobadas = String.join(",", na);

				// cantidad de materia aprobadas
				cantMateriasAprobadas -= 1;

				// Actualizando materias posibles y materias aprobadas
				Carrera newCarrera = carreraService.getCarreraById(estudianteLogeado.getIdEstudiante());
				newCarrera.setMateriasPosibles(nuevasMateriasPosibles);
				newCarrera.setMateriasAprobadas(nuevasMateriasAprobadas);
				newCarrera.setNotaAprobada(nuevasNotasAprobadas);
				newCarrera.setCantidadMateriasPosibles(cantMateriasPosibles);
				newCarrera.setCantidadMateriasAprobadas(cantMateriasAprobadas);
				carreraService.updateCarreraG(newCarrera,
						carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()));

				// Reiniciando variables:
				cantMateriasAprobadas = 0;
				cantMateriasPosibles = 0;
				prerrequisitos = new ArrayList<>();

			}

			// mostrar mensaje que la lista se ha actualizado correctamente
			modelMap.put("nombreEstudianteUS", estudianteEjemplo.getNombreEstudiante());

			return "subjectsUpdateSuccess.jsp";

		}

	}

	// Action para marcar una materia de "materias habiles" (por medio se su
	// correlativo) como aprobada
	// y removerla de las posibles y agregar las nuevas posibles en funcion de esa
	// aprobada

	@PostMapping("/subjectsUpdateSuccess")
	public String subjectsUpdateSuccess(ModelMap modelMap, @RequestParam("file") MultipartFile file) throws EncryptedDocumentException, IOException {

		 if (!file.isEmpty()) {
            try {
                
				eliminarFiles();

				String newFileName = file.getOriginalFilename();
					// Construir la nueva ruta del archivo
					pathExcelEstudiante = BASE_PATH + newFileName;
	
					// Guardar el nuevo archivo en la ruta especificada
					byte[] bytes = file.getBytes();
					Path path = Paths.get(pathExcelEstudiante);
					Files.write(path, bytes);
				

			// LAS POSIBLES MATERIAS DEL ESTUDIANTE LOGEADO:
			List<String> materiasPosiblesIds = new ArrayList<String>();



			// Materias aprobadas del estudiante logueado:
			List<String> materiasAprobadasIds = new ArrayList<String>();

			nuevasNotasAprobadas = "0";
			cantMateriasAprobadas = 0;

			materiasAprobadasIds. add("0");
			notasExcel = Util.getNotasExcel(new File(pathExcelEstudiante));
			notasExcel.forEach((numeroCorrelativo, nota) -> {
				materiasAprobadasIds.add(numeroCorrelativo);

				nuevasNotasAprobadas += "," + nota;

				cantMateriasAprobadas = cantMateriasAprobadas + 1;
			});

			nuevasMateriasAprobadas = String.join(",", materiasAprobadasIds);

				
				notasExcel.forEach((numeroCorrelativo, nota) -> {
					materiasPosiblesIds.remove(numeroCorrelativo);

				});

				// Lista de tabla Materia
				List<Materia> materias = materiaService.getMaterias();

				List<MateriaExcel> materiasExcelPosibles = Util.getMateriasExcel(new File(pathExcelEstudiante));

				cantMateriasPosibles = 0;

				materiasExcelPosibles.forEach(m->{
					materiasPosiblesIds.add(m.getIdMateria().toString());
					cantMateriasPosibles++;
				});

				materias.forEach(m->{
					if(m.getNombreMateria().toLowerCase().startsWith("optativa")){
						materiasPosiblesIds.add(m.getIdMateria().toString());
						cantMateriasPosibles++;
					}
				});

				
				 //Si en materias posibles esta "Bachillerato"
				if(materiasPosiblesIds.contains("0")){
					materiasPosiblesIds.remove("0");
					cantMateriasPosibles = cantMateriasPosibles - 1;
				}

				nuevasMateriasPosibles = String.join(",", materiasPosiblesIds);


				// Actualizando materias posibles y materias aprobadas
				Carrera newCarrera = carreraService.getCarreraById(estudianteLogeado.getIdEstudiante());
				newCarrera.setMateriasPosibles(nuevasMateriasPosibles);
				newCarrera.setMateriasAprobadas(nuevasMateriasAprobadas);
				newCarrera.setNotaAprobada(nuevasNotasAprobadas);
				newCarrera.setCantidadMateriasPosibles(cantMateriasPosibles);
				newCarrera.setCantidadMateriasAprobadas(cantMateriasAprobadas);
				carreraService.updateCarreraG(newCarrera,
						carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()));

				// Reiniciando variables:
				prerrequisitos = new ArrayList<>();


			// mostrar mensaje que la lista se ha actualizado correctamente
			modelMap.put("nombreEstudianteUS", estudianteEjemplo.getNombreEstudiante());

			return "subjectsUpdateSuccess.jsp";

            } catch (IOException e) {
                e.printStackTrace();

				modelMap.put("errorSU", "Error al subir el archivo.");
				return "availableSubjects.jsp";
            }
        } else {
            
			modelMap.put("errorSU", "El archivo está vacío.");
			return "availableSubjects.jsp";
        }

			


	}

}
