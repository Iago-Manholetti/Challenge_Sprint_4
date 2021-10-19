package br.com.fiap.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {

	//Formatacao de data
	public static String format(Calendar data) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(data.getTime());
	}
	
}