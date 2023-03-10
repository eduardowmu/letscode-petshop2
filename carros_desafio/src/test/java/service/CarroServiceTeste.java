package service;

import model.Carro;
import org.junit.Assert;
import org.junit.Test;

public class CarroServiceTeste {
    private static final String LIGADO = "LIGADO";
    private static final String DESLIGADO = "DESLIGADO";

    @Test
    public void deveLigarCorretamente() {
        //Dado um carro desligado
        CarroService carroService = new CarroServiceIpml();

        Carro carro = new Carro("azul", "fiat", "uno", 2023, 100);

        //Quando ligá-lo
        carroService.ligar(carro);

        //Então, deve mudar para estado ligado
        System.out.println("Carro ".concat(carroService.estadoAtual(carro).toLowerCase()));
        Assert.assertTrue(LIGADO.equalsIgnoreCase(carroService.estadoAtual(carro)));
    }

    @Test
    public void deveDesligarCorretamente() {
        //Dado um carro ligado
        CarroService carroService = new CarroServiceIpml();

        Carro carro = new Carro(0, false, 100);

        carroService.ligar(carro);

        //Quando desligá-lo
        carroService.desligar(carro);

        //Então deverá mudar para estado desligado
        Assert.assertEquals(carroService.estadoAtual(carro), DESLIGADO);
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

        Assert.assertEquals(carro.getVelocidadeAtual(), carro.getVelocidadeMaxima());
    }

    @Test
    public void deveFrearCorretamente() {
        //Dado um carro com velocidade máxima
        CarroService carroService = new CarroServiceIpml();

        Carro carro = new Carro(100, true, 100);

        //Quando frear 11x
        carroService.frear(carro, 10*11);

        //Então a velocidade deve ser zero e o carro deve estar parado
        Assert.assertFalse(carro.getVelocidadeAtual() < 0);
    }
}
