package model;

import java.util.Objects;

public class Conta {
    private String agencia;
    private String numeroConta;
    private Double saldo;
    private String nomeDocliente;

    public Conta(String agencia, String numeroConta, String nomeDocliente) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.nomeDocliente = nomeDocliente;
        this.saldo = 0.0;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return agencia.equals(conta.agencia) && numeroConta.equals(conta.numeroConta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agencia, numeroConta);
    }
}
