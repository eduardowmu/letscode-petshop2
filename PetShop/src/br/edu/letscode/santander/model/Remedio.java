package br.edu.letscode.santander.model;

import java.math.BigDecimal;

public class Remedio extends Produto{
	public Remedio(Integer id, String nome, BigDecimal preco) {
		super(id, nome, preco);
	}

	@Override
	public String toString() {
		return "Remedio [id=" + id + ", nome=" + nome + ", preco=" + preco + "]";
	}
}