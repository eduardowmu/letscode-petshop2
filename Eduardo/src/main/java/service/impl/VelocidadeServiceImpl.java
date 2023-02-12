package service.impl;

import controller.ControladorEsteira;
import model.Esteira;
import org.mockito.InjectMocks;
import service.VelocidadeService;
import org.mockito.Mock;
public class VelocidadeServiceImpl implements VelocidadeService {
    private ControladorEsteira controladorEsteira;
    @Override
    public void aumentarVelocidade(Esteira esteira) {
        controladorEsteira = new ControladorEsteira();
        if(esteira.getLigado()) {
            if(esteira.getVelocidadeAtual() < controladorEsteira.getVelocidadeMaxima()) {
                esteira.setVelocidadeAtual(esteira.getVelocidadeAtual() + 1);
            } else {
                esteira.setVelocidadeAtual(controladorEsteira.getVelocidadeMaxima());
            }
        }
    }

    @Override
    public void reduzirVelocidade(Esteira esteira) {
        controladorEsteira = new ControladorEsteira();
        if(esteira.getLigado()) {
            if(esteira.getVelocidadeAtual() > controladorEsteira.getVelocidadeMinima()) {
                esteira.setVelocidadeAtual(esteira.getVelocidadeAtual() - 1);
            } else {
                esteira.setVelocidadeAtual(controladorEsteira.getVelocidadeMinima());
            }
        }
    }
}