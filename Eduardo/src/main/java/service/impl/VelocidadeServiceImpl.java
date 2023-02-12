package service.impl;

import controller.ControladorEsteira;
import model.Esteira;
import service.VelocidadeService;

public class VelocidadeServiceImpl implements VelocidadeService {
    @Override
    public void aumentarVelocidade(Esteira esteira) {
        if(esteira.getLigado()) {
            if(esteira.getVelocidadeAtual() < esteira.getVelocidadeMaxima()) {
                esteira.setVelocidadeAtual(esteira.getVelocidadeAtual() + 1);
            } else {
                esteira.setVelocidadeAtual(esteira.getVelocidadeMaxima());
            }
        }
    }

    @Override
    public void reduzirVelocidade(Esteira esteira) {
        if(esteira.getLigado()) {
            if(esteira.getVelocidadeAtual() > esteira.getVelocidadeMinima()) {
                esteira.setVelocidadeAtual(esteira.getVelocidadeAtual() - 1);
            } else {
                esteira.setVelocidadeAtual(esteira.getVelocidadeMinima());
            }
        }
    }
}