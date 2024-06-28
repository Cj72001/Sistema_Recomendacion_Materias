package com.uca.spring.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.uca.spring.model.MateriaExcel;

import weka.core.DenseInstance;
import weka.core.Instances;

public class Util {

//_________________________________________________________________________________________________
//Metodos independientes de la recomendacion:

   	public static boolean materiaAprobadaAgregada = false;
	public static List<File> obtenerArchivosExcelEstudiantes() {
		materiaAprobadaAgregada = false;

        List<File> archivosExcelEstudiantes = new ArrayList<>();

		String rutaCarpeta = "src/main/java/com/uca/spring/data";
        File carpeta = new File(rutaCarpeta);
        if (carpeta.exists() && carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    if (archivo.isFile() && archivo.getName().endsWith(".xlsx")) {
                        archivosExcelEstudiantes.add(archivo);
                    }
                }
            }
        } else {
            System.err.println("La ruta especificada no es una carpeta válida.");
        }
        return archivosExcelEstudiantes;
    }



	//Obtener materias posibles que aprobaron todos los prerrequisitos segun el excel
	public static List<MateriaExcel> getMateriasExcel(File f) throws EncryptedDocumentException, IOException{

	// String pathExcel = "C:\\Users\\omarf\\Downloads\\notas2.xlsx"; 	
	// File f = new File(pathExcel);
    InputStream inp = new FileInputStream(f);
    Workbook wb = WorkbookFactory.create(inp);
    Sheet sheet = wb.getSheetAt(0);

	// se empezara desde la fila 6 porque desde ahi empiezan los datos 
	// los datos llegan hasta la fila 49
    int rowInit = 6, rowLimit = 50;
	
	//Pos de la fila
	int rowPos = rowInit;

    Row row = sheet.getRow(rowPos);

	List<MateriaExcel> materiasExcelPosible = new ArrayList<>();
	List<MateriaExcel> materiasExcelAprobadas = getMateriasExcelAprobadas(f);

      while(rowPos != rowLimit){
		Cell codigoMateriaCell = row.getCell(1),
		prerreqMateriaCell = row.getCell(2),
		notaMateriaCell = row.getCell(7),
		nombreMateriaCell = row.getCell(3);
		//unidadesValorativasMateriaCell = row.getCell(6),

		String codigoMateriaValue = codigoMateriaCell.toString(),
		notaMateriaValue = notaMateriaCell.toString(),
		nombreMateriaValue = nombreMateriaCell.toString();

		MateriaExcel newMateria = new MateriaExcel();
					 newMateria.setNombreMateria(nombreMateriaValue);
					 newMateria.setIdMateria(getCorrelativoByCodigo(codigoMateriaValue).toString());
					 newMateria.setNota(notaMateriaValue);


		//vamos a ignorar los casos donde no existen prerrequisitos: prerreqMateriaCell.toString() == "-", es decir, primer ciclo
		if(notaMateriaValue == "" && prerreqMateriaCell.toString() != "-"){

			String prerreqMateriaStr = prerreqMateriaCell.toString();
			List<String> prerreqMateriaValue = Arrays.asList(prerreqMateriaStr.split(","));
			List<String> prerreqMateria = new ArrayList<>();

			//Obteniendo todos los ids prerrequisito
			prerreqMateriaValue.forEach(p->{
				prerreqMateria.add(Util.getCorrelativoByCodigo(p).toString());
			});

			List<String> idsMateriasAprobadasExcel = new ArrayList<>();

			materiasExcelAprobadas.forEach(m->{
				idsMateriasAprobadasExcel.add(m.getIdMateria());
			});

			if(idsMateriasAprobadasExcel.containsAll(prerreqMateria)){
				
				materiasExcelAprobadas.forEach(m->{
					prerreqMateria.forEach(m2->{

						if(m.getIdMateria().equals(m2) && !newMateria.getPreRequisito().contains(m)){

							newMateria.getPreRequisito().add(m);

							
						}
						
					});
				});

				materiasExcelPosible.add(newMateria);
			}
		}

          rowPos++;  
          row = sheet.getRow(rowPos);
      }



	  return materiasExcelPosible;
	}

	//Obtener materias aprobadas desde excel
	public static List<MateriaExcel> getMateriasExcelAprobadas(File f) throws EncryptedDocumentException, IOException{

		// File f = new File(pathExcel);
		InputStream inp = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(inp);
		Sheet sheet = wb.getSheetAt(0);
	
		// se empezara desde la fila 6 porque desde ahi empiezan los datos 
		// los datos llegan hasta la fila 49
		int rowInit = 6, rowLimit = 50;
		
		//Pos de la fila
		int rowPos = rowInit;
		Row row = sheet.getRow(rowPos);
	
		List<MateriaExcel> materiasExcelAprobadas = new ArrayList<>();
	
		  while(rowPos != rowLimit){
			Cell codigoMateriaCell = row.getCell(1),
			notaMateriaCell = row.getCell(7),
			nombreMateriaCell = row.getCell(3);
			//unidadesValorativasMateriaCell = row.getCell(6),
	
			String codigoMateriaValue = codigoMateriaCell.toString(),
			notaMateriaValue = notaMateriaCell.toString(),
			nombreMateriaValue = nombreMateriaCell.toString();
	
			MateriaExcel newMateria = new MateriaExcel();
						 newMateria.setNombreMateria(nombreMateriaValue);
						 newMateria.setIdMateria(getCorrelativoByCodigo(codigoMateriaValue).toString());
						 newMateria.setNota(notaMateriaValue);
	
	
			//Agregando materias aprobadas:
			if( !(notaMateriaValue == "")){
				
				materiasExcelAprobadas.forEach(m->{
								if(m.getIdMateria().equals(newMateria.getIdMateria())){
									materiaAprobadaAgregada = true;
								}
							});
				
							if(!materiaAprobadaAgregada && Double.parseDouble(newMateria.getNota()) >= 6.0){
								materiasExcelAprobadas.add(newMateria);
							}
				
			}
			  rowPos++;  
			  row = sheet.getRow(rowPos);
		  }
	
		  return materiasExcelAprobadas;
		}

	//Obtener notas del excel de tutorias (materias aprobadas)
	public static HashMap<String, String> getNotasExcel(File f) throws EncryptedDocumentException, IOException{

		// String pathExcel = "C:\\Users\\omarf\\Downloads\\notas2.xlsx"; 	
		// File f = new File(pathExcel);
		InputStream inp = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(inp);
		Sheet sheet = wb.getSheetAt(0);
	
		// se empezara desde la fila 6 porque desde ahi empiezan los datos 
		// los datos llegan hasta la fila 49
		int rowInit = 6, rowLimit = 50;
		
		//Pos de la fila
		int rowPos = rowInit;
	
		Row row = sheet.getRow(rowPos);
	
		//En el siguiente map se almacenaran (numeroCorrelativo, nota)
		HashMap<String, String> notasExcel = new HashMap<>();
	
		  while(rowPos != rowLimit){
			Cell codigoMateriaCell = row.getCell(1),
			notaMateriaCell = row.getCell(7);
	
			String codigoMateriaValue = codigoMateriaCell.toString();
			String notaMateriaValue = notaMateriaCell.toString();
			
			   if(!(notaMateriaValue == "")){
				notasExcel.put( getCorrelativoByCodigo(codigoMateriaValue).toString(), notaMateriaValue);
			   }
			  
			  rowPos++;  
			  row = sheet.getRow(rowPos);
		  }
	
		  return notasExcel;
		}


		public static Integer getCorrelativoByCodigo(String codigo) {
			 // Eliminar ceros iniciales
			 codigo = codigo.replaceFirst("^0+(?!$)", "");
    
			 switch (codigo) {
				 case "0":
					 return 0;
				 case "10180":
				 case "10180.0":
					 return 1;
				 case "997701":
				 case "997701.0":
					 return 2;
				 case "10142":
				 case "10142.0":
					 return 3;
				 case "190153":
				 case "190153.0":
					 return 4;
				 case "10112":
				 case "10112.0":
					 return 5;
				 case "10181":
				 case "10181.0":
					 return 6;
				 case "190154":
				 case "190154.0":
					 return 7;
				 case "10143":
				 case "10143.0":
					 return 8;
				 case "200068":
				 case "200068.0":
					 return 9;
				 case "10182":
				 case "10182.0":
					 return 10;
				 case "190175":
				 case "190175.0":
					 return 11;
				 case "190155":
				 case "190155.0":
					 return 12;
				 case "200084":
				 case "200084.0":
					 return 13;
				 case "10183":
				 case "10183.0":
					 return 14;
				 case "190156":
				 case "190156.0":
					 return 15;
				 case "190157":
				 case "190157.0":
					 return 16;
				 case "992501":
				 case "992501.0":
					 return 17;
				 case "10141":
				 case "10141.0":
					 return 18;
				 case "190158":
				 case "190158.0":
					 return 19;
				 case "190159":
				 case "190159.0":
					 return 20;
				 case "190160":
				 case "190160.0":
					 return 21;
				 case "200069":
				 case "200069.0":
					 return 22;
				 case "992601":
				 case "992601.0":
					 return 23;
				 case "190161":
				 case "190161.0":
					 return 24;
				 case "190162":
				 case "190162.0":
					 return 25;
				 case "10118":
				 case "10118.0":
					 return 26;
				 case "190163":
				 case "190163.0":
					 return 27;
				 case "190065":
				 case "190065.0":
					 return 28;
				 case "190164":
				 case "190164.0":
					 return 29;
				 case "190165":
				 case "190165.0":
					 return 30;
				 case "190176":
				 case "190176.0":
					 return 31;
				 case "992701":
				 case "992701.0":
					 return 32;
				 case "190166":
				 case "190166.0":
					 return 33;
				 case "190167":
				 case "190167.0":
					 return 34;
				 case "190168":
				 case "190168.0":
					 return 35;
				 case "250055":
				 case "250055.0":
					 return 36;
				 case "992801":
				 case "992801.0":
					 return 37;
				 case "997402":
				 case "997402.0":
					 return 38;
				 case "190169":
				 case "190169.0":
					 return 39;
				 case "190170":
				 case "190170.0":
					 return 40;
				 case "997403":
				 case "997403.0":
					 return 41;
				 case "190171":
				 case "190171.0":
					 return 42;
				 case "992901":
				 case "992901.0":
					 return 43;
				 case "190172":
				 case "190172.0":
					 return 44;
				 default:
					 return -1;
			 }
		}
		

	
}
