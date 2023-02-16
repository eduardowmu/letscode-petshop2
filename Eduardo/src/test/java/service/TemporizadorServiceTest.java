package service;

public interface TemporizadorServiceTest {
    void deveContarTempoSegundo();
    void deveVariarMinuto();

    void deveZerarOsTemposAoFinalizarTreino();
    void naoDeveUltrapassarTempoProgramado();
    void naoDevePararAntesDoTempo();
}
