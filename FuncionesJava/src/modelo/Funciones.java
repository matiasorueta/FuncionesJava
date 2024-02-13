package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Esta clase contiene una serie de funciones útiles relacionadas con fechas, horas y validaciones.
 */
public class Funciones {

    /**
     * Determina si un año dado es bisiesto.
     *
     * @param anio El año a verificar
     * @return true si el año es bisiesto, false en caso contrario
     */
    public static boolean esBisiesto(int anio) {
        int DivCuatro = anio % 4;
        int DivCien = anio % 100;
        int DivCuatroCientos = anio % 400;

        return (DivCuatro == 0 && DivCien != 0) || (DivCuatro == 0 && DivCien == 0 && DivCuatroCientos == 0);
    }

    /**
     * Convierte una fecha en formato corto (día/mes/año).
     *
     * @param fecha La fecha a convertir
     * @return La fecha en formato corto
     */
    public static String traerFechaCorta(LocalDate fecha) {
        return fecha.getDayOfMonth() + "/" + fecha.getMonthValue() + "/" + fecha.getYear();
    }

    /**
     * Convierte una hora en formato corto (hora:minutos).
     *
     * @param hora La hora a convertir
     * @return La hora en formato corto
     */
    public static String traerHoraCorta(LocalTime hora) {
        return " " + hora.getHour() + ":" + hora.getMinute() + "";
    }

    /**
     * Determina si una fecha es un día hábil (de lunes a viernes).
     *
     * @param fecha La fecha a verificar
     * @return true si la fecha es un día hábil, false en caso contrario
     */
    public static boolean esDiaHabil(LocalDate fecha) {
        return (fecha.getDayOfWeek().getValue() < 6);
    }

    /**
     * Devuelve el nombre del día de la semana de una fecha dada.
     *
     * @param fecha La fecha de la cual se quiere obtener el día de la semana
     * @return El nombre del día de la semana
     */
    public static String traerDiaDeLaSemana(LocalDate fecha) {
        String dia = null;
        switch (fecha.getDayOfWeek().getValue()) {
            case 1:
                dia = "Lunes ";
                break;
            case 2:
                dia = "Martes ";
                break;
            case 3:
                dia = "Miércoles ";
                break;
            case 4:
                dia = "Jueves ";
                break;
            case 5:
                dia = "Viernes ";
                break;
            case 6:
                dia = "Sábado ";
                break;
            case 7:
                dia = "Domingo ";
                break;
        }
        return dia;
    }

    /**
     * Devuelve el nombre del mes en letras de una fecha dada.
     *
     * @param fecha La fecha de la cual se quiere obtener el mes en letras
     * @return El nombre del mes en letras
     */
    public static String traerMesEnLetras(LocalDate fecha) {
        String mes = null;
        switch (fecha.getMonthValue()) {
            case 1:
                mes = "Enero";
                break;
            case 2:
                mes = "Febrero";
                break;
            case 3:
                mes = "Marzo";
                break;
            case 4:
                mes = "Abril";
                break;
            case 5:
                mes = "Mayo";
                break;
            case 6:
                mes = "Junio";
                break;
            case 7:
                mes = "Julio";
                break;
            case 8:
                mes = "Agosto";
                break;
            case 9:
                mes = "Septiembre";
                break;
            case 10:
                mes = "Octubre";
                break;
            case 11:
                mes = "Noviembre";
                break;
            case 12:
                mes = "Diciembre";
                break;
        }
        return mes;
    }

    /**
     * Devuelve la fecha en formato largo (día de la semana, día de mes de año).
     *
     * @param fecha La fecha a convertir
     * @return La fecha en formato largo
     */
    public static String traerFechaLarga(LocalDate fecha) {
        return Funciones.traerDiaDeLaSemana(fecha) + fecha.getDayOfMonth() + " de " + Funciones.traerMesEnLetras(fecha) + " del " + fecha.getYear();
    }

    /**
     * Devuelve la cantidad de días de un mes en un año dado.
     *
     * @param anio El año del cual se quiere conocer la cantidad de días
     * @param mes  El mes del cual se quiere conocer la cantidad de días
     * @return La cantidad de días del mes en el año dado
     */
    public static int traerCantDiasDeUnMes(int anio, int mes) {
        int dias = 0;
        if (Funciones.esBisiesto(anio) && mes == 2) {
            dias = 29;
        } else if (!Funciones.esBisiesto(anio) && mes == 2) {
            dias = 28;
        } else if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            dias = 31;
        } else {
            dias = 30;
        }
        return dias;
    }

    /**
     * Aproxima un valor con dos decimales.
     *
     * @param valor El valor a aproximar
     * @return El valor aproximado con dos decimales
     */
    public static double aproximarDosDecimales(double valor) {
        return ((double) Math.round(valor * 100)) / 100;
    }

    /**
     * Determina si un carácter es un número.
     *
     * @param c El carácter a verificar
     * @return true si el carácter es un número, false en caso contrario
     */
    public static boolean esNumero(char c) {
        return Character.isDigit(c);
    }

    /**
     * Determina si un carácter es una letra.
     *
     * @param c El carácter a verificar
     * @return true si el carácter es una letra, false en caso contrario
     */
    public static boolean esLetra(char c) {
        return !(Character.isDigit(c));
    }

    /**
     * Determina si una cadena está compuesta únicamente por números.
     *
     * @param cadena La cadena a verificar
     * @return true si la cadena está compuesta únicamente por números, false en caso contrario
     */
    public static boolean esCadenaNros(String cadena) {

        int longitud = cadena.length();
        char[] chars = cadena.toCharArray();
        int contador = 0;
        for (int i = 0; i < longitud; i++) {
            if (Funciones.esNumero(chars[i]) == true) {
                contador += 1;
            }
        }
        return (contador == longitud);
    }

    /**
     * Determina si una cadena está compuesta únicamente por letras.
     *
     * @param cadena La cadena a verificar
     * @return true si la cadena está compuesta únicamente por letras, false en caso contrario
     */
    public static boolean esCadenaLetras(String cadena) {

        int longitud = cadena.length();
        char[] chars = cadena.toCharArray();
        int contador = 0;
        for (int i = 0; i < longitud; i++) {
            if (Funciones.esLetra(chars[i]) == true) {
                contador += 1;
            }
        }
        return (contador == longitud);
    }
}
