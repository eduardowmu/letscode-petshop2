package service;

public interface TemporizadorServiceTest {
    void naoDeveContarDesligado();
    void deveContarTempoSegundo();
    void deveVariarMinuto();

    void deveZerarOsTemposAoFinalizarTreino();
}
