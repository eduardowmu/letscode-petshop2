package br.edu.letscode.santander.model;

public class Endereco {
    private String rua;
    private String bairro;
    private String complemento;
    private Integer numero;
    private String cep;
    private String cidade;
    private String estado;
    private String pontoReferencia;
    
    public Endereco(String rua, String bairro, String complemento, Integer numero, String cep, String cidade,
			String estado, String pontoReferencia) {
		super();
		this.rua = rua;
		this.bairro = bairro;
		this.complemento = complemento;
		this.numero = numero;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.pontoReferencia = pontoReferencia;
	}

	public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }
}
