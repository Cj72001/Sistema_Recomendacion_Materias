# Manual Técnico
[![uca.png](https://i.postimg.cc/44tV6yRT/uca.png)](https://postimg.cc/HjYrHpLS)

## Índice
- [Aspectos generales](#Aspectosgenerales) 
	- [Objetivos del documento](#objetivos)
	- [Descripción general](#desc)
	- [Requerimientos del Sistema](#req)
	- [Software utilizado](#soft)
 - [Modelos utilizados](#modelosutilizados) 
	 - [Patrón de diseño MVC](#mvc)
	 - [Diagrama Relacional](#diagrama)
- [Manual de usuario](#manualUsuario) 
- [Guía de instalación](#guia) 
- [Compatibilidad de licencias](#compatibilidadLic)
 
 ## Aspectos generales 
 <a name="Aspectosgenerales"></a>
 
**Objetivos del documento:**  <a name="objetivos"></a>
El presente manual técnico tiene como objetivo principal presentar y explicar de manera detallada los distintos aspectos y herramientas que se tomaron en cuenta para el desarrollo del sistema.

**Descripción general:**  <a name="desc"></a>
El sistema es una solución innovadora que utiliza Machine Learning para ayudar a los estudiantes de Ingeniería Informática de la Universidad Centroamericana José Simeón Cañas (UCA) a planificar y organizar de manera eficiente sus estudios. Con esta aplicación, los estudiantes pueden acceder fácilmente a un listado actualizado de las materias aprobadas y las materias que pueden llevar en el próximo ciclo académico, evitando el proceso engorroso de consultar la malla curricular, esperar al sistema SIM o hacer una lista manualmente.

Gracias a la integración del Machine Learning, la aplicación puede ofrecer recomendaciones personalizadas basadas en el historial académico del estudiante y de otros roadmaps, brindando una experiencia de planificación más precisa y adaptada a las necesidades individuales.
  
La aplicación se ha desarrollado utilizando tecnologías de desarrollo web, como Java para el backend, Spring y Spring Boot, y JSP (JavaServer Pages) con CSS las vistas. Además, se ha utilizado una base de datos relacional con PostgreSQL, para almacenar la información de los estudiantes y sus notas.

Pudiendo acceder a la recomendación de materias por medio del uso de un clasificador NaiveBayes previamente modelado con archivos de "Tutoría Académica" de otros estudiantes y con el archivo que puede subir el estudiante en el apartado de materias hábiles.


**Requisitos del Sistema**  <a name="req"></a>

* **Requisitos del sistema operativo**
  - El sistema debe ser compatible con los sistemas operativos Windows o macOS.
  - Se recomienda tener la versión más reciente del sistema operativo instalada para garantizar la compatibilidad y el rendimiento óptimo de la aplicación.
  
* **Requerimientos de Hardware**
  - Procesador de al menos 1 GHz.
  - Memoria RAM de al menos 2 GB (requisito mínimo).
  - Se recomienda tener al menos 8 GB de RAM para un rendimiento óptimo.
  - Espacio de almacenamiento disponible de al menos 2 GB (requisito mínimo) para la instalación de la aplicación y los datos.
  - Espacio de almacenamiento disponible de al menos 10 GB para la instalación de la aplicación y los datos para tener rendimiento óptimo.
  - Se recomienda tener al menos 4 GB de espacio en disco duro para un funcionamiento adecuado.
  
* **Requerimientos de Software**
  - Se recomienda tener al menos Windows 7 o posterior para un funcionamiento óptimo.
  - Java Development Kit (JDK) 8 o superior.
  - PostgreSQL v16.3
  - Visual Studio Code. Se recomienda tener la última versión estable instalada.
    Extensions para VS Code:
    - Spring Boot Extension Pack v0.2.1
    - Extension Pack for Java v0.27.0


 **Software utilizado** <a name="soft"></a>
 
  Para el desarrollo de la aplicación se utilizo VS Code en conjunto con las extensions necesarias para con la compatibilidad con Spring/ SpringBoot.

También se utilizaron las siguientes tecnologías:

[![Tecnologias-Utilizadas.png](https://i.postimg.cc/R0HVk3RS/Tecnologias-Utilizadas.png)](https://postimg.cc/DW7TswHH)

 - **Java**: Lenguaje de programación utilizado para el desarrollo del sistema de Registro de Notas.

- **Spring Boot**: Framework de desarrollo de aplicaciones Java que proporciona un entorno simplificado para crear aplicaciones web.

- **Spring MVC**: Framework de Spring utilizado para desarrollar la capa de controladores y manejar las solicitudes HTTP.

- **Hibernate**: Framework de mapeo objeto-relacional utilizado para interactuar con la base de datos y realizar operaciones de persistencia.

- **JSP/CSS**: JSP tecnología que para crear páginas web dinámicas basadas en HTML y XML, entre otros tipos de documentos y CSS para el estilo de las páginas web.
  
- **Gestor de Base de datos**: PostgreSQL.

- **Git/Github**: Sistema de control de versiones utilizado para gestionar y colaborar en el desarrollo del proyecto.

## Modelos utilizados <a name="modelosutilizados"></a>

**Patrón de diseño MVC**  <a name="mvc"></a>

La arquitectura del sistema se basa en el patrón de diseño Modelo-Vista-Controlador (MVC). Este patrón se utiliza para separar la lógica de negocio, la presentación de datos y la interacción con el usuario en tres componentes principales: el Modelo, la Vista y el Controlador.

La adopción del patrón MVC en nuestro sistema nos ha brindado varios beneficios. 
Por un lado, nos permite tener una separación clara de responsabilidades. Además, al separar la lógica de negocio de la presentación, se mejora la reutilización de componentes y la estructura del código, permitiendonos tener un sistema bien estructurado, modular y fácilmente mantenible. La separación de responsabilidades entre el Modelo, la Vista y el Controlador nos brinda flexibilidad y escalabilidad, permitiendo adaptarnos a cambios futuros y proporcionando una experiencia de usuario mejorada.



 **Diagrama Relacional**  <a name="diagrama"></a>
 
[![Diagrama-BDD-P-gina-1.png](https://i.postimg.cc/vHMsgz9C/Diagrama-BDD-P-gina-1.png)](https://postimg.cc/4n8MjpW1)

Aclaracion: "materiasAprobadas" y "materiasPosibles" es un String compuesto por ids de la tabla "Materia", en la tabla "Carrera" se denota lo que el estudiante registra una vez subido su archivo excel.

## Manual de usuario
<a name="manualUsuario"></a>
- Link de documento para visualziación de manual de usuario: 
https://drive.google.com/file/d/1pKahNanbmKTkWOXSuNPSWRoUFfSxvg-e/view?usp=sharing

## Guía de instalación 
<a name="guia"></a>
- Link de documento para guía de instalación: https://drive.google.com/file/d/13xMF3d7694R8EzMMIaYTl7asBafRahei/view?usp=sharing

## Compatibilidad de licencias
<a name="compatibilidadLic"></a>
- Link de documento para la compatibilidad de Licencias: 
https://drive.google.com/file/d/1wKmUjBJ2ycym5XibQG-yzYKRpVllUoJh/view?usp=sharing
