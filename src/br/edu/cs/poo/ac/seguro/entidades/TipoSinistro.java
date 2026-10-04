package br.edu.cs.poo.ac.seguro.entidades;

/*
 * Implementar um enum com as seguintes constantes:
 * 
 * 	COLISAO(1,"Colisão"),
	INCENDIO(2,"Incêndio"),
	FURTO(3, "Furto"),
	ENCHENTE(4, "Enchente"),
	DEPREDACAO(5, "Depredação");
 * 
 * O enum deve ter construtor privado, métodos get públicos para os atributos codigo e nome,
 * e um método público e estático TipoSinistro getTipoSinistro(int codigo), que 
 * retorna o tipo de sinistro correspondente ao código recebido como parâmetro
 */

public enum TipoSinistro {
	
		COLISAO(1,"Colisão"),
		INCENDIO(2,"Incêndio"),
		FURTO(3, "Furto"),
		ENCHENTE(4, "Enchente"),
		DEPREDACAO(5, "Depredação");
	
	private int codigo;
	private String nome;
	
	private TipoSinistro(int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public static TipoSinistro getTipoSinistro(int codigo) {
		for (TipoSinistro ts : TipoSinistro.values()) {
			if (ts.getCodigo() == codigo) {
				return ts;
			}
		}
		return null;
	}

}