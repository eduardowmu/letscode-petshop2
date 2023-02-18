package service.impl;

import controller.ControladorEsteira;
import model.Esteira;;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import service.CaminharInclinadoServiceTest;

import static org.junit.Assert.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CaminharInclinadoServiceTestImpl implements CaminharInclinadoServiceTest {
    @Mock
    private ControladorEsteira controladorEsteira;

    @Spy
    @InjectMocks
    private EsteiraServiceImpl esteiraService;

    private Esteira esteira;

    @BeforeEach
    public void start() {
        MockitoAnnotations.openMocks(this);
        this.esteira = new Esteira();
    }

    @Test
    @Override
    public void naoDeveInclinarDesligado() {
        Throwable throwable = assertThrows(Exception.class,
                () -> esteiraService.inclinar(esteira)
        );
    }

    @Test
    @Override
    public void deveAumentarInclinacao() {
        //Dado que uma esteira está ligada
        this.esteiraService.ligar(esteira);

        //Quando aumentarmos a inclinação em 1x
        this.esteiraService.inclinar(esteira);

        //Então a inclinação atual deve ser igual a 1
        Assertions.assertTrue(esteira.getInclinacao() == 1);
    }

    @Test
    @Override
    public void deveReduzirInclinacao() {
        //Dado que uma esteira está ligada e inclinada 1x
        this.esteiraService.ligar(esteira);
        this.esteiraService.inclinar(esteira);

        System.out.println("Quando reduzirmos a inclinação em 1x");
        this.esteiraService.declinar(esteira);

        System.out.println("Então a inclinação atual deve ser ser zerada");
        Assertions.assertEquals(0, esteira.getInclinacao());
    }

    @Test
    @Override
    public void naoDeveInclinarMaisQueMaximo() {
        //Dado que uma esteira está ligada e com inclinação máxima
        this.esteiraService.ligar(esteira);

        for(int i = 0; i < esteira.getInclinacaoMaxima(); i++) {
            this.esteiraService.inclinar(esteira);
        }

        //Quando aumentarmos a inclinação 1x
        this.esteiraService.inclinar(esteira);

        //Então a inclinação atual não deve ultrapassar o máximo
        Assertions.assertFalse(esteira.getInclinacao() > esteira.getInclinacaoMaxima());
    }

    @Test
    @Override
    public void naoDeveInclinarMenosQueMinimo() {
        //Dado que uma esteira está ligada e com inclinação mínima
        this.esteiraService.ligar(esteira);

        //Quando reduzirmos a inclinação 1x
        this.esteiraService.declinar(esteira);

        //Então a inclinação atual não deve ser menor que zero
        Assertions.assertNotEquals(-1, esteira.getInclinacao(),
                "Inclinação inválida");
    }
}