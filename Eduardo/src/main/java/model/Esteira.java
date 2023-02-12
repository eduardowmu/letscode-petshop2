package model;

public class Esteira {

    private Integer velocidadeAtual;

    private final Integer velocidadeMaxima = 15;
    private final Integer velocidadeMinima = 0;
    private Integer minutoProgramado;
    private Integer segundoAtual;
    private Integer inclinacao;
    private final Integer inclinacaoMaxima = 12;
    private final Integer inclinacaoMinima = 0;
    private Boolean ligado;

    public Esteira() {
        this.ligado = false;
        this.inclinacao = 0;
        this.segundoAtual = 0;
        this.velocidadeAtual = 0;
    }

    public Integer getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public void setVelocidadeAtual(Integer velocidadeAtual) {
        this.velocidadeAtual = velocidadeAtual;
    }

    public Integer getMinutoProgramado() {
        return minutoProgramado;
    }

    public void setMinutoProgramado(Integer minutoProgramado) {
        this.minutoProgramado = minutoProgramado;
    }

    public Integer getSegundoAtual() {
        return segundoAtual;
    }

    public void setSegundoAtual(Integer segundoAtual) {
        this.segundoAtual = segundoAtual;
    }

    public Integer getInclinacao() {
        return inclinacao;
    }

    public void setInclinacao(Integer inclinacao) {
        this.inclinacao = inclinacao;
    }

    public Boolean getLigado() {
        return ligado;
    }

    public void setLigado(Boolean ligado) {
        this.ligado = ligado;
    }

    public Integer getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public Integer getVelocidadeMinima() {
        return velocidadeMinima;
    }

    public Integer getInclinacaoMaxima() {
        return inclinacaoMaxima;
    }

    public Integer getInclinacaoMinima() {
        return inclinacaoMinima;
    }
}
