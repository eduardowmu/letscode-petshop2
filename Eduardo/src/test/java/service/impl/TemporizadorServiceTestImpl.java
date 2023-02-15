package service.impl;

import controller.ControladorEsteira;
import model.Esteira;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import service.TemporizadorServiceTest;

public class TemporizadorServiceTestImpl implements TemporizadorServiceTest {

    @Mock
    private ControladorEsteira controladorEsteira;

    @InjectMocks
    private EsteiraServiceImpl esteiraService;

    @InjectMocks
    private VelocidadeServiceImpl velocidadeService;

    private Esteira esteira;

    @BeforeEach
    public void start() {
        MockitoAnnotations.openMocks(this);
        this.esteira = new Esteira();
        this.controladorEsteira = new ControladorEsteira();
    }

    @Test
    @Override
    public void deveContarTempoSegundo() {
        System.out.println("Dado uma esteira ligada e programada para movimentar por 1 min.");
        this.esteiraService.ligar(this.esteira);
        this.esteiraService.programarTempo(this.esteira, 1);

        System.out.println("Quando estiver em movimento com velocidade 10");
        for(int i = 0; i < 10; i++) {
            this.velocidadeService.aumentarVelocidade(this.esteira);
        }
        this.esteiraService.aumentarSegundo(this.esteira, this.controladorEsteira);

        System.out.println("Então o tempo final em segundo vale 60 s");
        Assertions.assertTrue(this.esteira.getSegundoAtual() == 60);
    }

    @Test
    @Override
    public void deveVariarMinuto() {

    }

    @Test
    @Override
    public void naoDeveUltrapassarTempoProgramado() {

    }

    @Test
    @Override
    public void naoDevePararAntesDoTempo() {

    }
}
