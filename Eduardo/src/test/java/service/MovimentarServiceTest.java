package service;

public interface MovimentarServiceTest {
    void naoDeveTerVelocidadeDesligado();
    void deveAumentarVelocidade();
    void deveReduzirVelocidade();
    void naoDeveAumentarAlemDaVelocidadeMaxima();
    void naoDeveReduzirAbaixoDaVelocidadeMinima();
}
