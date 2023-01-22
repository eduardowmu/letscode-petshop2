package br.edu.letscode.santander.model;

import java.util.List;

public class Cliente extends Pessoa {
    private Integer id;
    private List<Animal> animais;
    
    public Cliente(Integer id, List<Animal> animais, String nome, String cpf, String email, Endereco endereco, String telefone) {
		super(nome, cpf, email, endereco, telefone);
		this.id = id;
		this.animais = animais;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }
}
