package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Funciones {
	public static boolean esBisiesto(int anio) {
		int DivCuatro = anio%4;
		int DivCien= anio%100;
		int DivCuatroCientos= anio%400;
		
		
		return (DivCuatro==0 && DivCien!=0)||(DivCuatro==0 && DivCien==0 && DivCuatroCientos==0);
	}

	public static String traerFechaCorta (LocalDate fecha) { 
		return fecha.getDayOfMonth() + "/" + fecha.getMonthValue() + "/" + fecha.getYear();
	}
	
	public static String traerHoraCorta (LocalTime hora) {
	  return " "+ hora.getHour()+ ":"+ hora.getMinute()+"";
	}
	
	public static boolean esDiaHabil (LocalDate fecha) {
		return (fecha.getDayOfWeek().getValue()<6);
	}
	public static String traerDiaDeLaSemana (LocalDate fecha ) {
		String dia = null;
		switch(fecha.getDayOfWeek().getValue()) {
		case 1:
			dia="Lunes ";
			break;
		case 2:
			dia="Martes ";
			break;
		case 3:
			dia="Miercoles ";
			break;
		case 4:
			dia="Jueves ";
			break;
		case 5:
			dia="Viernes ";
			break;
		case 6:
			dia="Sabado ";
			break;
		case 7:
			dia="Domingo ";
			break;
		}
		
		return dia ;
	}
	public static String traerMesEnLetras(LocalDate fecha ) {
		String mes = null;
		switch(fecha.getMonthValue()) {
		case 1:
			mes="Enero";
			break;
		case 2:
			mes="Febrero";
			break;
		case 3:
			mes="Marzo";
			break;
		case 4:
			mes="Abril";
			break;
		case 5:
			mes="Mayo";
			break;
		case 6:
			mes="Junio";
			break;
		case 7:
			mes="Julio";
			break;
		case 8:
			mes="Agosto";
			break;
		case 9:
			mes="Septiembre";
			break;
		case 10:
			mes="Octubre";
			break;
		case 11:
			mes="Noviembre";
			break;
		case 12:
			mes="Diciembre";
			break;
		}
		
		return mes ;
	}
	
	public static String traerFechaLarga (LocalDate fecha) {
		return Funciones.traerDiaDeLaSemana(fecha) + fecha.getDayOfMonth() + " de "+ Funciones.traerMesEnLetras(fecha) + " del "+ fecha.getYear(); 
	}

	public static int traerCantDiasDeUnMes (int anio, int mes) {
		int dias =0;
		if (Funciones.esBisiesto(anio)&& mes==2) {
			dias = 29;
		}else if (!Funciones.esBisiesto(anio) && mes==2) {
			dias =28;
		}else if (mes==1||mes==3||mes==5||mes==7||mes==8||mes==10||mes==12) {
			dias =31;
		}else {
			dias=30;
		}
		return dias;
	}
	
	public static double aproximarDosDecimales (double valor) {
		return ((double)Math.round(valor*100))/100;
		 
	}
	
	public static boolean esNumero(char c) {
		return Character.isDigit(c);
	}
	public static boolean esLetra(char c) {
		return !(Character.isDigit(c));
	}

	public static boolean esCadenaNros (String cadena) {
		
		int longitud=cadena.length();
		char[] chars = cadena.toCharArray();
		int contador=0;
		for (int i=0;i<longitud;i++) {
			if(Funciones.esNumero(chars[i])==true) {
				contador+=1;
				
				
			}
		}
	
		return (contador==longitud);
}
	
	public static boolean esCadenaLetras (String cadena) {
		
		int longitud=cadena.length();
		char[] chars = cadena.toCharArray();
		int contador=0;
		for (int i=0;i<longitud;i++) {
			if(Funciones.esLetra(chars[i])==true) {
				contador+=1;
				
				
			}
		}
	
		return (contador==longitud);

	}



}
