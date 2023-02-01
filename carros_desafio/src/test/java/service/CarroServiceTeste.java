package service;

import model.Carro;
import org.junit.Assert;
import org.junit.Test;

public class CarroServiceTeste {
    @Test
    public void deveLigarCorretamente() {
        //Dado um carro desligado
        CarroService carroService = new CarroServiceIpml();

        Carro carro = new Carro("azzul", "fiat", "uno", 2023, 100);

        //Quando ligá-lo
        carroService.ligar(carro);

        //Então, deve mudar para estado ligado
        Assert.assertTrue(carro.isLigado());
    }

    @Test
    public void deveDesligarCorretamente() {
        //Dado um carro ligado
        CarroService carroService = new CarroServiceIpml();

        Carro carro = new Carro(0, true, 100);

        //Quando desligá-lo
        carroService.desligar(carro);

        //Então deverá mudar para estado desligado
        Assert.assertTrue(!carro.isLigado());
    }

    @Test
    public void deveAcelerarCorretamente() {
        //Dado
        CarroService carroService = new CarroServiceIpml();

        Carro carro = new Carro(0, false, 100);

        carroService.ligar(carro);

        //Quando acelerar 2x:
        carroService.acelerar(carro, 10*2);

        //Então sua velocidade deve ser 20
        Assert.assertEquals(20, carro.getVelocidadeAtual());
    }

    @Test
    public void naoDevePassarDaVelocidadeMaxima() {
        //Dado
        CarroService carroService = new CarroServiceIpml();

        Carro carro = new Carro("azul", "fiat", "uno", 2023, 100);

        carroService.ligar(carro);

        //Quando:
        carroService.acelerar(carro, 100);
        carroService.acelerar(carro, 100);

        Assert.assertTrue(carro.getVelocidadeAtual() == carro.getVelocidadeMaxima());
    }

    @Test
    public void deveFrearCorretamente() {
        //Dado um carro com velocidade máxima
        CarroService carroService = new CarroServiceIpml();

        Carro carro = new Carro(100, true, 100);

        //Quando frear 11x
        carroService.frear(carro, 10*11);

        //Então a velocidade deve ser zero e o carro deve estar parado
        Assert.assertEquals(0, carro.getVelocidadeAtual());
    }
}
