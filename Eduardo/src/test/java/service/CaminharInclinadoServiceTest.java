package service;

import model.Esteira;

public interface CaminharInclinadoServiceTest {
    void deveAumentarInclinacao();

    void deveReduzirInclinacao();
    void naoDeveInclinarMaisQueMaximo();

    void naoDeveInclinarMenosQueMinimo();
}
