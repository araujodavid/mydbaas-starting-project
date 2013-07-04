package main.java.br.com.arida.ufc.mydbaas.core.util;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Utils {
	
	public static String i18n(String text) {
		try {
			return ResourceBundle.getBundle("messages", Locale.getDefault()).getString(text);
		} catch (MissingResourceException e) {
			return "???" + text + "???";
		}
	}
}
