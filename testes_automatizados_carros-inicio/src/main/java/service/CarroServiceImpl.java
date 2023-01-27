package service;

import model.Carro;

public class CarroServiceImpl implements CarroService {
    @Override
    public void acelerar(Carro carro, int velocidadeAMais) {
        carro.setVelocidadeAtual(carro.getVelocidadeAtual() + velocidadeAMais);
    }

    @Override
    public void frear(Carro carro, int velocidadeAMenos) {
        carro.setVelocidadeAtual(carro.getVelocidadeAtual() - velocidadeAMenos);
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
        return carro.toString();
    }
}
