package service.impl;

import controller.ControladorEsteira;
import model.Esteira;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import service.MovimentarServiceTest;
import service.VelocidadeService;

public class MovimentarServiceTestImpl implements MovimentarServiceTest {
    @Mock
    private ControladorEsteira controladorEsteira;

    @InjectMocks
    private VelocidadeService velocidadeService;

    private Esteira esteira;

    @Test
    @Override
    public void deveAumentarVelocidade() {

    }

    @Test
    @Override
    public void deveReduzirVelocidade() {

    }
}
