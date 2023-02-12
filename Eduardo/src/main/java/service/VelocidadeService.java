package service;

import controller.ControladorEsteira;
import model.Esteira;

public interface VelocidadeService {
    void aumentarVelocidade(Esteira esteira);
    void reduzirVelocidade(Esteira esteira);
}
