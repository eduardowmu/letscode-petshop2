package br.edu.letscode.santander.model;

import java.time.LocalDate;
import java.util.List;

import br.edu.letscode.santander.enumeration.EstadoAnimal;
import br.edu.letscode.santander.enumeration.Porte;

public class Gato extends Animal {
	public Gato(String nome, LocalDate nascimento, String raca, Porte porte, Double peso, 
			EstadoAnimal estadoAnimal, List<EsquemaVacinal> esquemasVacinais) {
		super(nome, nascimento, raca, porte, peso, estadoAnimal, esquemasVacinais);
	}
}