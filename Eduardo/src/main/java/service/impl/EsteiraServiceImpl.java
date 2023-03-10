package service.impl;

import controller.ControladorEsteira;
import model.Esteira;
import service.EsteiraService;

public class EsteiraServiceImpl implements EsteiraService {
    /*Método que converte o tempo de duração da esteira em movimento
    *de minuto para segundo*/
    @Override
    public void programarTempo(Esteira esteira, Integer minuto) {
        if(esteira.getLigado()) {
            esteira.setMinutoProgramado(minuto);
        }
    }

    @Override
    public void aumentarSegundo(Esteira esteira, ControladorEsteira controladorEsteira) {
        if(esteira.getLigado() && esteira.getVelocidadeAtual() > 0) {
            controladorEsteira.contarTempo(esteira);
            esteira.setVelocidadeAtual(0);
            System.out.println("Treino finalizado");
        }
    }

    @Override
    public void zerarTempo(Esteira esteira) {
        if(esteira.getLigado() && esteira.getVelocidadeAtual() == 0) {
            esteira.setMinutoProgramado(0);
            esteira.setMinutoAtual(0);
            esteira.setSegundoAtual(0);
        }
    }

    @Override
    public void inclinar(Esteira esteira) {
        if(esteira.getLigado() && esteira.getInclinacao() < esteira.getInclinacaoMaxima()) {
            esteira.setInclinacao(esteira.getInclinacao() + 1);
        }
    }

    @Override
    public void declinar(Esteira esteira) {
        if(esteira.getLigado() && esteira.getInclinacao() > esteira.getInclinacaoMinima()) {
            esteira.setInclinacao(esteira.getInclinacao() - 1);
        }
    }

    @Override
    public void desligar(Esteira esteira) {
        if(esteira.getLigado()) {
            esteira.setLigado(false);
            esteira.setVelocidadeAtual(0);
            esteira.setInclinacao(0);
            esteira.setMinutoProgramado(0);
            esteira.setSegundoAtual(0);
        }
    }

    @Override
    public void ligar(Esteira esteira) {
        if(!esteira.getLigado()) {
            esteira.setLigado(true);
        }
    }
}
