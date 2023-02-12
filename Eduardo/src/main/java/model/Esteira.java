package model;

public class Esteira {

    private Integer velocidadeAtual;
    private Integer minutoProgramado;
    private Integer segundoAtual;
    private Integer inclinacao;
    private Boolean ligado;
    private Boolean movimento;

    public Esteira() {
        this.ligado = false;
        this.movimento = false;
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

    public Boolean getMovimento() {
        return movimento;
    }

    public void setMovimento(Boolean movimento) {
        this.movimento = movimento;
    }
}
