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

import static org.junit.Assert.assertThrows;

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
        //Dado uma esteira ligada e programada para movimentar por 1 min
        this.esteiraService.ligar(this.esteira);
        this.esteiraService.programarTempo(this.esteira, 1);

        //Quando estiver em movimento com velocidade 10
        this.aumentarVelocidade10(this.esteira);
        this.esteiraService.aumentarSegundo(this.esteira, this.controladorEsteira);

        //Então o tempo final em segundo vale 60 s
        Assertions.assertTrue(this.esteira.getSegundoAtual() == 60);
    }

    @Test
    @Override
    public void deveVariarMinuto() {
        //Dado uma esteira ligada e programada para movimentar por 1 min
        this.esteiraService.ligar(this.esteira);
        this.esteiraService.programarTempo(this.esteira, 1);

        //Quando estiver em movimento com velocidade 10
        this.aumentarVelocidade10(this.esteira);
        this.esteiraService.aumentarSegundo(this.esteira, this.controladorEsteira);

        //Então o tempo final em minuto vale 1 m
        Assertions.assertFalse(this.esteira.getMinutoAtual() != this.esteira.getMinutoProgramado());
    }

    @Test
    @Override
    public void deveZerarOsTemposAoFinalizarTreino() {
        //Dado uma esteira ligada e programada para movimentar por 1 min na velocidade 10
        this.esteiraService.ligar(this.esteira);
        this.esteiraService.programarTempo(this.esteira, 1);

        this.aumentarVelocidade10(this.esteira);
        this.esteiraService.aumentarSegundo(this.esteira, this.controladorEsteira);

        //Quando finalizar o treino
        this.esteiraService.zerarTempo(esteira);

        //Então os tempos devem zerar
        Assertions.assertEquals(0, this.esteira.getMinutoAtual());
        Assertions.assertEquals(0, this.esteira.getSegundoAtual());
        Assertions.assertEquals(0, this.esteira.getMinutoProgramado());
    }
    private void aumentarVelocidade10(Esteira esteira) {
        for(int i = 0; i < 10; i++) {
            this.velocidadeService.aumentarVelocidade(esteira);
        }
    }
}
