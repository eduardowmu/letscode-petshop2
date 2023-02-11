package service;

import model.Esteira;

public interface EsteiraService {
    void programarTempo(Esteira esteira);
    void aumentarSegundo(Esteira esteira);
    void inclinar(Esteira esteira);
    void declinar(Esteira esteira);
    void desligar(Esteira esteira);
    void ligar(Esteira esteira);
}
