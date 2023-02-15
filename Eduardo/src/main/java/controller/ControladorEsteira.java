package controller;

import model.Esteira;

public class ControladorEsteira {

    public void contarTempo(Esteira esteira) {
        for(int i = 0; i <= esteira.getMinutoProgramado(); i++) {
            esteira.setSegundoAtual(i);
            if(esteira.getVelocidadeAtual() > 0 && esteira.getLigado()) {
                this.contarTempo(i);
            } else {
                esteira.setVelocidadeAtual(0);
                break;
            }
        }

    }

    private void contarTempo(int i) {
        try {
            if(i > 0) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
