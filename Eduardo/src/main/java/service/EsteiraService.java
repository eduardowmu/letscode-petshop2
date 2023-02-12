package service;

import controller.ControladorEsteira;
import model.Esteira;

public interface EsteiraService {
    void programarTempo(Esteira esteira, Integer minuto);
    void aumentarSegundo(Esteira esteira, ControladorEsteira controladorEsteira);
    void inclinar(Esteira esteira,  Integer inclinacaoMais);
    void declinar(Esteira esteira,  Integer inclinacaoMenos);
    void desligar(Esteira esteira);
    void ligar(Esteira esteira);
}
