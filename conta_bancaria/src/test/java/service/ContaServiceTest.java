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
        String agencia = "001";
        String conta = "0000002";
        String cliente = "Eduardo";

        //Quando criar uma conta
        conta01 = new Conta(agencia, conta, cliente);
    }

    @Test
    public void deveCriarConta() {
        //Então
        Assert.assertNotNull(conta01);
    }

    @Test
    public void deveAbrirContaComSaldoZero() {
        //Então
        Assert.assertTrue(conta01.getSaldo() == 0);
    }

    @Test
    public void deveSerPossivelDepositar() {
        //Então

    }
}
