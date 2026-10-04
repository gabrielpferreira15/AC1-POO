package br.edu.cs.poo.ac.seguro.mediators;

public class ValidadorCpfCnpj {

    private ValidadorCpfCnpj() {}

    public static boolean ehCpfValido(String cpf) {

        if (StringUtils.ehNuloOuBranco(cpf)) {
            return false;
        }

        if (!cpf.matches("[0-9.\\-]+")) {
            return false;
        }

        cpf = cpf.replaceAll("[^0-9]", "");

        if (!StringUtils.temSomenteNumeros(cpf) || cpf.length() != 11) {
            return false;
        }

        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        int soma = 0;

        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }

        int resto = soma % 11;
        int digito1 = resto < 2 ? 0 : 11 - resto;

        if (Character.getNumericValue(cpf.charAt(9)) != digito1) {
            return false;
        }

        soma = 0;

        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }

        resto = soma % 11;
        int digito2 = resto < 2 ? 0 : 11 - resto;

        return Character.getNumericValue(cpf.charAt(10)) == digito2;
    }

    public static boolean ehCnpjValido(String cnpj) {

        if (StringUtils.ehNuloOuBranco(cnpj)) {
            return false;
        }

        if (!cnpj.matches("[0-9./\\-]+")) {
            return false;
        }

        cnpj = cnpj.replaceAll("[^0-9]", "");

        if (!StringUtils.temSomenteNumeros(cnpj) || cnpj.length() != 14) {
            return false;
        }

        if (cnpj.matches("(\\d)\\1{13}")) {
            return false;
        }

        int[] pesos1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] pesos2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        int soma = 0;

        for (int i = 0; i < 12; i++) {
            soma += Character.getNumericValue(cnpj.charAt(i)) * pesos1[i];
        }

        int resto = soma % 11;
        int digito1 = resto < 2 ? 0 : 11 - resto;

        if (Character.getNumericValue(cnpj.charAt(12)) != digito1) {
            return false;
        }

        soma = 0;

        for (int i = 0; i < 13; i++) {
            soma += Character.getNumericValue(cnpj.charAt(i)) * pesos2[i];
        }

        resto = soma % 11;
        int digito2 = resto < 2 ? 0 : 11 - resto;

        return Character.getNumericValue(cnpj.charAt(13)) == digito2;
    }
}
