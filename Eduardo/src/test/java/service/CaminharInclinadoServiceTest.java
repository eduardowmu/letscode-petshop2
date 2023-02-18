package service;

import model.Esteira;

public interface CaminharInclinadoServiceTest {
    void naoDeveInclinarDesligado();
    void deveAumentarInclinacao();

    void deveReduzirInclinacao();
    void naoDeveInclinarMaisQueMaximo();

    void naoDeveInclinarMenosQueMinimo();
}
