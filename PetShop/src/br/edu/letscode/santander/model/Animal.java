package br.edu.letscode.santander.model;

import br.edu.letscode.santander.enumeration.EstadoAnimal;
import br.edu.letscode.santander.enumeration.Porte;

import java.time.LocalDate;
import java.util.List;

public abstract class Animal {
    protected String nome;
    protected LocalDate nascimento;
    protected String raca;
    protected Porte porte;
    protected Double peso;
    protected EstadoAnimal estadoAnimal;
    protected List<EsquemaVacinal> esquemasVacinal;
    

	public Animal(String nome, LocalDate nascimento, String raca, Porte porte, 
    		Double peso, EstadoAnimal estadoAnimal, List<EsquemaVacinal> esquemasVacinal) {
		this.nome = nome;
		this.nascimento = nascimento;
		this.raca = raca;
		this.porte = porte;
		this.peso = peso;
		this.estadoAnimal = estadoAnimal;
		this.esquemasVacinal = esquemasVacinal;
	}
    
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getNascimento() {
		return nascimento;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public Porte getPorte() {
		return porte;
	}
	public void setPorte(Porte porte) {
		this.porte = porte;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public EstadoAnimal getEstadoAnimal() {
		return estadoAnimal;
	}
	public void setEstadoAnimal(EstadoAnimal estadoAnimal) {
		this.estadoAnimal = estadoAnimal;
	}
	public List<EsquemaVacinal> getEsquemasVacinal() {
		return esquemasVacinal;
	}

	public void setEsquemasVacinal(List<EsquemaVacinal> esquemasVacinal) {
		this.esquemasVacinal = esquemasVacinal;
	}
}
