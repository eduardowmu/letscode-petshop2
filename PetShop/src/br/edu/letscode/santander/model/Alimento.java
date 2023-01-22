package br.edu.letscode.santander.model;

import java.math.BigDecimal;

public class Alimento extends Produto {
	public Alimento(Integer id, String nome, BigDecimal preco) {
		super(id, nome, preco);
	}

	@Override
	public String toString() {
		return "Alimento [id=" + id + ", nome=" + nome + ", preco=" + preco + "]";
	}
}
