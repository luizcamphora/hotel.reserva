package br.com.reservas.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MoneyUtils {

	public static BigDecimal formatarValor(String valorString) {
		String valor = valorString.replace(".", "");
		valor = valor.replace(",", ".");
		valor = valor.trim();
		return new BigDecimal(valor);
	}

	public static String getValorPadrao(String campo) {
		if (campo.isEmpty())
			return "0,00";
		return campo;
	}

	public static String formatarValor(BigDecimal valor) {
		DecimalFormat decFormat = new DecimalFormat("#,###,##0.00");
		return decFormat.format(valor);
	}

}
