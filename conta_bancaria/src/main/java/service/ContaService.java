package service;

import model.Conta;

public class ContaService {

    private void depositar (Conta conta, Double valor) {
        conta.setSaldo(conta.getSaldo() + valor);
    }

    private void sacar (Conta conta, Double valor) {
        if (conta.getSaldo() >= valor) {
            conta.setSaldo(conta.getSaldo() - valor);
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    private void transferir (Conta contaTransferindo, Conta contaRecebendo, Double valor) {
        if (contaTransferindo.getSaldo() >= valor) {
            contaTransferindo.setSaldo(contaTransferindo.getSaldo() - valor);
            contaRecebendo.setSaldo(contaRecebendo.getSaldo() + valor);
        }
    }
}
