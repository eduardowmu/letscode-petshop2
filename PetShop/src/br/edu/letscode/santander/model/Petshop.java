package br.edu.letscode.santander.model;

import br.edu.letscode.santander.enumeration.Vacina;
import br.edu.letscode.santander.vo.ResponseVO;
import br.edu.letscode.santander.enumeration.EstadoAnimal;
import br.edu.letscode.santander.enumeration.Higiene;
import br.edu.letscode.santander.enumeration.Servico;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Petshop {
	private String cnpj;
	private Endereco endereco;
	private static List<Alimento> alimentos = viewAlimentos();
	private static List<Remedio> remedios = viewRemedios();
	private static List<Vacina> vacinas = setVacinas();

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public ResponseVO higienizar(Cliente cliente, List<Animal> animais, Higiene higiene, String obs) {
		for(Animal animal : animais) {
			for(Animal a : cliente.getAnimais()) {
				if(a.equals(animal)) {
					a.setEstadoAnimal(getEstadoAnimal(higiene));
				}
			}
		}
		return new ResponseVO(3, Servico.HIGIENIZAR, new BigDecimal(300).multiply(new BigDecimal(animais.size())), cliente);
	}

	public ResponseVO atendimentoClinico(Cliente cliente, List<Animal> animais, String obs) {
		for(Animal a : cliente.getAnimais()) {
			Vacina vacina = setVacinas().get(new Random().nextInt(5));
			a.getEsquemasVacinal().add(new EsquemaVacinal(LocalDate.now(), vacina, obs.concat(vacina.name())));
		}
		return new ResponseVO(1, Servico.ATENDIMENTO_CLINICO, new BigDecimal(100).multiply(new BigDecimal(animais.size())), cliente);
	}

	public ResponseVO vacinacao(Cliente cliente, List<Animal> animais, List<Vacina> vacinas, String obs) {
		for(Animal a : animais) {
			for(Vacina vacina : vacinas) {
				for(EsquemaVacinal ev : a.getEsquemasVacinal()) {
					if(ev.getVacina().equals(vacina)) {
						ev.setObs(obs);
						ev.setData(LocalDate.now());
					}
				}
			}
		}
		return new ResponseVO(2, Servico.VACINACAO, new BigDecimal(200).multiply(new BigDecimal(animais.size())), cliente);
	}

	public void verAlimentos() {
		this.alimentos.stream().forEach(a -> System.out.println(a.toString()));
	}

	public void verRemedios() {
		this.remedios.stream().forEach(r -> System.out.println(r.toString()));
	}
	
	public void pagamento(List<ResponseVO> responses) {
		double total = 0.;
		//pois existe apenas um cliente
		Cliente cliente = responses.get(0).getCliente();
		for(ResponseVO response : responses) {
			total += response.getPreco().doubleValue();
			System.out.println("Codigo do serviço: " + response.getId());
		}
		
		//criando a lista de alimentos e remedios a serem comprados
		List<Produto> produtos = Arrays.asList(this.alimentos.get(0), this.remedios.get(0));
		
		for(Produto produto : produtos) {
			total += produto.getPreco().doubleValue() * cliente.getAnimais().size();
			System.out.println("Codigo do produto " + produto.getId() + " X" + cliente.getAnimais().size());
		}
		
		System.out.println("Total: " + new BigDecimal(total));
	}
	
	private static List<Alimento> viewAlimentos() {
		alimentos = new ArrayList<>();
		alimentos.add(new Alimento(1, "Ração Nutrilus", new BigDecimal(20)));
		alimentos.add(new Alimento(2, "Ração Premier", new BigDecimal(30)));
		alimentos.add(new Alimento(3, "Royal Canin", new BigDecimal(40)));
		return alimentos;
	}
	
	private static List<Remedio> viewRemedios() {
		remedios = new ArrayList<>();
		remedios.add(new Remedio(1, "Vetaglos Pomada Cicatrizante", new BigDecimal(30)));
		remedios.add(new Remedio(2, "Frontline Spray - 100ml - Boehringer Ingelheim", new BigDecimal(25)));
		remedios.add(new Remedio(3, "Nexgard  2-4 Kg Anti Pulgas E Carrapato - Boehringer Ingelheim", new BigDecimal(50)));
		//remedios.stream().forEach(r -> System.out.println(r.toString()));
		return remedios;
	}
	
	private static List<Vacina> setVacinas() {
		List<Vacina> vacinas = new ArrayList<>();
		vacinas.add(Vacina.VACINA_1);
		vacinas.add(Vacina.VACINA_2);
		vacinas.add(Vacina.VACINA_3);
		vacinas.add(Vacina.VACINA_4);
		vacinas.add(Vacina.VACINA_5);
		return vacinas;
	}
	
	private EstadoAnimal getEstadoAnimal(Higiene higiene) {
		switch(higiene) {
			case BANHO:
				return EstadoAnimal.LIMPO;
			case TOSA:
				return EstadoAnimal.TOSADO;
			case BANHO_E_TOSA:
				return EstadoAnimal.LIMPO_E_TOSADO;
			default:
				return EstadoAnimal.LIMPO_E_TOSADO;
		}
	}
}