package service;

import model.Carro;
import org.junit.Assert;
import org.junit.Test;

public class CarroServiceImplTest {
    @Test
    public void deveLigarCorretamente() {
        CarroService carroService = new CarroServiceImpl();

        //Given
        Carro carro = new Carro("Azul", "Honda",
                            "Honda Fit", 2017,
                            false, 0, 150);

        //When we put it on
        carroService.ligar(carro);

        //Then it must be onned
        Assert.assertTrue(carro.isLigado());
    }

    @Test
    public void deveAcelerarCorretamente() {
        // Given
        CarroService carroService = new CarroServiceImpl();
        Carro carro =
                new Carro("cor", "marca", "modelo", 2022, false, 0, 150);

        // When
        carroService.ligar(carro);
        carroService.acelerar(carro, 10);

        // Then
        Assert.assertTrue(carro.getVelocidadeAtual() == 10);
    }

    @Test
    public void deveFrearCorretamente() {
        // Given
        CarroService carroService = new CarroServiceImpl();
        Carro carro = new Carro("cor", "marca", "modelo",
                            2022, false, 0, 150);

        // When
        carroService.ligar(carro);
        carroService.acelerar(carro, 10);
        carroService.frear(carro, 5);

        // Then
        Assert.assertTrue(carro.getVelocidadeAtual() == 5);
    }
}