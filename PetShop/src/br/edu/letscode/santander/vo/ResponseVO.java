package br.edu.letscode.santander.vo;

import br.edu.letscode.santander.enumeration.Servico;
import br.edu.letscode.santander.model.Cliente;

import java.math.BigDecimal;

public class ResponseVO {
    private Integer id;
    private Servico servico;
    private BigDecimal preco;
    private Cliente cliente;

    public ResponseVO(Integer id, Servico servico, BigDecimal preco, Cliente cliente) {
        this.id = id;
        this.servico = servico;
        this.preco = preco;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

	@Override
	public String toString() {
		return "ResponseVO [id=" + id + ", servico=" + servico + ", preco=" + preco + ", cliente=" + cliente.getNome() + "]";
	}
}
