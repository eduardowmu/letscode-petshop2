package service;

import model.Conta;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContaServiceTest {
    ContaService contaService;
    Conta conta01;

    @Before
    public void setup() {
        contaService = new ContaService();

        //Dado
        String agencia = "1";
        String conta = "1";
        String cliente = "Joel";

        //Quando criar uma conta
        conta01 = this.contaService.criarConta(agencia, conta, cliente);
    }

    @Test
    public void deveCriarConta() {
        //Então
        Assert.assertTrue(conta01 != null);
    }

    @Test
    public void deveAbrirContaComSaldoZero() {
        //Então
        Assert.assertFalse(conta01.getSaldo() > 0);
    }

    @Test
    public void deveSerPossivelDepositar() {
        //Dado
        Double valorDisponivel = conta01.getSaldo();
        Double valorDepositar = 100.;

        //Quando
        this.contaService.depositar(conta01, valorDepositar);

        //Então
        Assert.assertEquals(conta01.getSaldo(), valorDisponivel + valorDepositar, 0);
    }

    @Test
    public void deveSerPossivelSacar() {
        //Dado
        Double valorDepositar = 100.;
        Double valorSacar = 50.;

        this.contaService.depositar(conta01, valorDepositar);

        //Quando
        try {
            this.contaService.sacar(conta01, valorSacar);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        //Então
        Assert.assertEquals("Saldo insuficiente", 50., conta01.getSaldo(), 0);
    }

    @Test
    public void deveSerPossivelTransferir() {
        //Dado
        String agencia2 = "2";
        String numero2 = "2";
        String nome2 = "Eduardo";

        Conta conta02 = new Conta(agencia2, numero2, nome2);

        this.contaService.depositar(conta01, 100.);

        //Quando
        this.contaService.transferir(conta01, conta02, 80.);

        //Então
        Assert.assertNotEquals(0, conta02.getSaldo());
    }

    @Test
    public void contasMesmoNumeroAgenciaSaoIguais() {
        //Dado
        String agencia2 = "1";
        String numero2 = "1";
        String nome2 = "Eduardo";

        //Quando
        Conta conta02 = this.contaService.criarConta(agencia2, numero2, nome2);

        //Então
        Assert.assertEquals(conta01, conta02);
    }
}
