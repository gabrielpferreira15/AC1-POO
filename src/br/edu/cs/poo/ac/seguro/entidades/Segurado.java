package br.edu.cs.poo.ac.seguro.entidades;
import java.math.*;
import java.time.*;


public class Segurado {
	
	private String nome;
	private Endereco endereco;
	private LocalDate dataCriacao;
	private BigDecimal bonus;
	
	public Segurado() {}
	
	public void setNome(String nome) {
	    this.nome = nome;
	}
	
	public String getNome(){
	    return this.nome;
	}

	public void setEndereco(Endereco endereco) {
	    this.endereco = endereco;
	}
	
	public Endereco getEndereco(){
	    return this.endereco;
	}
	
	protected void setDataCriacao(LocalDate dataCriacao) {
	    this.dataCriacao = dataCriacao; 
	}
	    
	protected LocalDate getDataCriacao() {
	    return this.dataCriacao;
	}

	public BigDecimal getBonus() {
	    return this.bonus;
	}
	
	public Segurado(String nome, Endereco endereco, LocalDate dataCriacao, BigDecimal bonus) {
		this.nome = nome;
		this.endereco = endereco;
		this.dataCriacao = dataCriacao;
		this.bonus = bonus;
	}
	
	public int getIdade() {
		int idade = Period.between(dataCriacao, LocalDate.now()).getYears();
		return idade;
	}
	
	public void creditarBonus(BigDecimal valor) {
		this.bonus = this.bonus.add(valor);
	}
	
	public void debitarBonus(BigDecimal valor) {
		this.bonus = this.bonus.subtract(valor);
	}
	
}