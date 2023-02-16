package controller;

import model.Esteira;

public class ControladorEsteira {

    public void contarTempo(Esteira esteira) {
        for(int i = 0; i <= (esteira.getMinutoProgramado()*60); i++) {
            esteira.setSegundoAtual(i);
            if(esteira.getVelocidadeAtual() > 0 && esteira.getLigado()) {
                this.contarTempo(i);
                esteira.setMinutoAtual(i/60);
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
                //setado para meio segundo para ir mais rápido
                Thread.sleep(250);
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
