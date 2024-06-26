package com.uca.spring.util;

public class Util {

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
