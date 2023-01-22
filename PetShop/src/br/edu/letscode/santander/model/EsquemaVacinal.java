package br.edu.letscode.santander.model;

import br.edu.letscode.santander.enumeration.Vacina;

import java.time.LocalDate;

public class EsquemaVacinal {
    private LocalDate data;
    private Vacina vacina;
    private String obs;
    
    public EsquemaVacinal(LocalDate data, Vacina vacina, String obs) {
		this.data = data;
		this.vacina = vacina;
		this.obs = obs;
	}
    
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Vacina getVacina() {
		return vacina;
	}
	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}   
}