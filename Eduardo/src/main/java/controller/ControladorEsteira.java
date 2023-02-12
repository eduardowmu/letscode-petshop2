package controller;

import model.Esteira;

public class ControladorEsteira {
    public void contarTempo(Esteira esteira) {
        Thread t = new Thread();
        for(int i = 0; i < esteira.getMinutoProgramado(); i++) {
            if(esteira.getVelocidadeAtual() > 0 && esteira.getLigado()) {
                this.contarTempo(i, t);
            } else {
                esteira.setVelocidadeAtual(0);
                break;
            }
        }
    }

    private void contarTempo(int i, Thread t) {
        try {
            if(i > 0) {
                t = new Thread();
                t.wait(1000);
                System.out.println(i);
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
