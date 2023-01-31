package service;

import model.Carro;
import org.junit.Assert;
import org.junit.Test;

public class CarroServiceTeste {
    @Test
    public void deveAcelerarCorretamente() {
        //Dado
        CarroService carroService = new CarroServiceIpml();

        Carro carro = new Carro("azzul", "fiat", "uno", 2023, 100);

        carroService.ligar(carro);

        //Quando:
        carroService.acelerar(carro, 10);


    }

    @Test
    public void naoDevePassarDaVelocidadeMaxima() {
        //Dado
        CarroService carroService = new CarroServiceIpml();

        Carro carro = new Carro("azzul", "fiat", "uno", 2023, 100);

        carroService.ligar(carro);

        //Quando:
        carroService.acelerar(carro, 100);
        carroService.acelerar(carro, 100);

        Assert.assertTrue(carro.getVelocidadeAtual() == carro.getVelocidadeMaxima());
    }
}
