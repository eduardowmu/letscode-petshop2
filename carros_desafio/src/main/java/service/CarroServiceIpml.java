package service;

import model.Carro;

public class CarroServiceIpml implements CarroService {

    private static final String LIGADO = "LIGADO";
    private static final String DESLIGADO = "DESLIGADO";

    @Override
    public void acelerar(Carro carro, int velocidadeAMais) {
        var velocidadeNova = carro.getVelocidadeAtual() + velocidadeAMais;
        carro.setVelocidadeAtual(velocidadeNova <= carro.getVelocidadeMaxima() ?
                velocidadeNova : carro.getVelocidadeMaxima());
    }

    @Override
    public void frear(Carro carro, int velocidadeAMenos) {
        if((carro.getVelocidadeAtual() - velocidadeAMenos) <= 0) {
            carro.setVelocidadeAtual(0);
        } else {
            carro.setVelocidadeAtual(carro.getVelocidadeAtual() - velocidadeAMenos);
        }
    }

    @Override
    public void ligar(Carro carro) {
        carro.setLigado(true);
    }

    @Override
    public void desligar(Carro carro) {
        carro.setLigado(false);
    }

    @Override
    public String estadoAtual(Carro carro) {
        return carro.isLigado() ? LIGADO : DESLIGADO;
    }
}
