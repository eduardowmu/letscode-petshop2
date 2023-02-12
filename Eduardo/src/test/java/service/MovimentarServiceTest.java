package service;

public interface MovimentarServiceTest {
    void deveAumentarVelocidade();
    void deveReduzirVelocidade();
    void naoDeveAumentarAlemDaVelocidadeMaxima();
    void naoDeveReduzirAbaixoDaVelocidadeMinima();
}
