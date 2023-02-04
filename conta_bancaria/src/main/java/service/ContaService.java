package service;

import model.Conta;

public class ContaService {

    public void depositar (Conta conta, Double valor) {
        if(valor > 0) {
            conta.setSaldo(conta.getSaldo() + valor);
        }
    }

    public void sacar (Conta conta, Double valor) throws Exception {
        if(valor <= 0) {
            throw new Exception("Valor inválido");
        }

        if (conta.getSaldo() >= valor) {
            conta.setSaldo(conta.getSaldo() - valor);
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void transferir (Conta contaTransferindo, Conta contaRecebendo, Double valor) {
        if (contaTransferindo.getSaldo() >= valor) {
            contaTransferindo.setSaldo(contaTransferindo.getSaldo() - valor);
            contaRecebendo.setSaldo(contaRecebendo.getSaldo() + valor);
        }
    }

    public Conta criarConta(String agencia, String numero, String nome) {
        if(agencia != null && numero != null && nome != null) {
            return new Conta(agencia, numero, nome);
        }
        return null;
    }
}
