package br.com.reservas.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataUtils {

	public static String converterLocalDateParaString(LocalDate localDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataFormatada = localDate.format(formatter);
		return dataFormatada;
	}

	public static String converterLocalDateTimeParaStringDateTime(LocalDateTime localDateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		String dataFormatada = localDateTime.format(formatter);
		return dataFormatada;
	}

	public static String converterLocalDateTimeParaStringDate(LocalDateTime localDateTime) {

		if (localDateTime != null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String dataFormatada = localDateTime.format(formatter);
			return dataFormatada;
		}
		return "";
	}

	/**
	 * Converter String (dd/mm/aaaa) para LocalDate
	 * 
	 * @param dataString
	 * @return {@link LocalDate}
	 */
	public static LocalDate converterStringParaLocalDate(String dataString) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

		LocalDate localDate = LocalDate.parse(dataString, formatter);

		return localDate;
	}

	/**
	 * Converter String (aaaa-mm-dd hh:mm) para LocalDataTime
	 * 
	 * @param dataString
	 * @return {@link LocalDateTime}
	 */
	public static LocalDateTime converterStringParaLocalDateTime(String dataString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(dataString, formatter);
	}
	
}
