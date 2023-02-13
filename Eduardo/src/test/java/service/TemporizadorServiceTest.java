package service;

public interface TemporizadorServiceTest {
    void deveContarTempoSegundo();
    void deveVariarMinuto();
    void naoDeveUltrapassarTempoProgramado();
    void naoDevePararAntesDoTempo();
}
