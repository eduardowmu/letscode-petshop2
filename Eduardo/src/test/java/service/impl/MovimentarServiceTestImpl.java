package service.impl;

import controller.ControladorEsteira;
import model.Esteira;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import service.MovimentarServiceTest;

public class MovimentarServiceTestImpl implements MovimentarServiceTest {
    @Mock
    private ControladorEsteira controladorEsteira;

    @InjectMocks
    private VelocidadeServiceImpl velocidadeService;

    @InjectMocks
    private EsteiraServiceImpl esteiraService;

    private Esteira esteira;

    @BeforeEach
    public void start() {
        this.esteira = new Esteira();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Override
    public void deveAumentarVelocidade() {
        System.out.println("Dado que uma esteira está ligada e parada");
        this.esteiraService.ligar(esteira);

        System.out.println("Quando aumentarmos a velocidade em 10 unidades");
        for(int i = 0; i < 10; i++) {
            this.velocidadeService.aumentarVelocidade(esteira);
        }

        System.out.println("Então a velocidade atual deve ser igual a 10");
        Assertions.assertEquals(10, esteira.getVelocidadeAtual());
    }

    @Test
    @Override
    public void deveReduzirVelocidade() {
        System.out.println("Dado que uma esteira está ligada e com velocidade inicial 10");
        this.esteiraService.ligar(esteira);

        for(int i = 0; i < 10; i++) {
            this.velocidadeService.aumentarVelocidade(esteira);
        }

        System.out.println("Quando reduzirmos a velocidade 5x");
        for(int i = 0; i < 5; i++) {
            this.velocidadeService.reduzirVelocidade(esteira);
        }

        System.out.println("Então a velocidade deverá se reduzir pela metade");
        Assertions.assertTrue(esteira.getVelocidadeAtual() == 5);
    }

    @Test
    @Override
    public void naoDeveAumentarAlemDaVelocidadeMaxima() {
        System.out.println("Dado que uma esteira está ligada e com velocidade máxima");
        this.esteiraService.ligar(esteira);

        for(int i = 0; i < 15; i++) {
            this.velocidadeService.aumentarVelocidade(esteira);
        }

        System.out.println("Quando aumentarmos a velocidade");
        this.velocidadeService.aumentarVelocidade(esteira);

        System.out.println("Então a velocidade deverá permanecer na máxima");
        Assertions.assertFalse(esteira.getVelocidadeAtual() > esteira.getVelocidadeMaxima());
    }

    @Test
    @Override
    public void naoDeveReduzirAbaixoDaVelocidadeMinima() {
        System.out.println("Dado que uma esteira está ligada e parada");
        this.esteiraService.ligar(esteira);

        System.out.println("Quando reduzirmos a velocidade");
        this.velocidadeService.reduzirVelocidade(esteira);

        System.out.println("Então a velocidade deverá permanecer zerada");
        Assertions.assertNotEquals(-1, esteira.getVelocidadeAtual(),
                "Velocidade não existe");
    }
}