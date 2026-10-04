package br.edu.cs.poo.ac.seguro.mediators;

public class StringUtils {
	
	private StringUtils() {}
	
	public static boolean ehNuloOuBranco(String str) {
		return str == null || str.trim().isEmpty();
	}
	public static boolean temSomenteNumeros(String input) {
		if (ehNuloOuBranco(input)) {
			return false;
		}
		return input.matches("[0-9]+");
	}
	
}