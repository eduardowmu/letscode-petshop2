package br.edu.letscode.santander.model;

import br.edu.letscode.santander.enumeration.Cargo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario {
    private Integer id;
    private Cargo cargo;
    private BigDecimal preco;
    private LocalDate admissao;
    private LocalDate desligamento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public LocalDate getAdmissao() {
        return admissao;
    }

    public void setAdmissao(LocalDate admissao) {
        this.admissao = admissao;
    }

    public LocalDate getDesligamento() {
        return desligamento;
    }

    public void setDesligamento(LocalDate desligamento) {
        this.desligamento = desligamento;
    }
}
