package br.edu.letscode.santander;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.sun.tools.javac.code.Attribute.Array;

import br.edu.letscode.santander.enumeration.EstadoAnimal;
import br.edu.letscode.santander.enumeration.Higiene;
import br.edu.letscode.santander.enumeration.Porte;
import br.edu.letscode.santander.enumeration.Vacina;
import br.edu.letscode.santander.model.Animal;
import br.edu.letscode.santander.model.Cachorro;
import br.edu.letscode.santander.model.Cliente;
import br.edu.letscode.santander.model.Endereco;
import br.edu.letscode.santander.model.EsquemaVacinal;
import br.edu.letscode.santander.model.Gato;
import br.edu.letscode.santander.model.Pessoa;
import br.edu.letscode.santander.model.Petshop;
import br.edu.letscode.santander.vo.ResponseVO;

public class Main {
    public static void main(String[] args) {
        Petshop petShop = new Petshop();
    	
    	List<EsquemaVacinal> esquemasVacinais = new ArrayList<>();
        
    	Animal minski = new Cachorro("Minski", LocalDate.of(2000, 1, 20), "Pastor alemão", Porte.MEDIO, 40.0, 
    			EstadoAnimal.SUJO, esquemasVacinais);
        Animal maia = new Cachorro("Maia", LocalDate.of(2002, 1, 20), "Pastor alemão", Porte.MEDIO, 45.0, 
        		EstadoAnimal.SUJO, esquemasVacinais);
        
        List<Animal> cachorros = new ArrayList<>();
        cachorros.add(minski);
        cachorros.add(maia);
        
        Cliente eduardo = new Cliente(1, cachorros, "Eduardo", "12345678901", "eduwm@gmail.com", new Endereco("Alameda Santos", 
        		"Centro", "Casa", 222, "0123456", "São Paulo", "SP", "Próximo a Avenida Paulista"), "11999999999");
        
        List<EsquemaVacinal> esquemas = new ArrayList<>();
        
        Animal helloKit = new Gato("Hellokit", LocalDate.of(2000, 2, 10), "Maine Coon", Porte.PEQUENO, 21.0, 
        		EstadoAnimal.SUJO, esquemas);
        List<Animal> gatos = new ArrayList<>();
        gatos.add(helloKit);
        
        Cliente camila = new Cliente(2, gatos, "Camila", "23456789012", "camila@gmail.com", new Endereco("Rua Capitão Cavalcanti", 
        		"Vila Martiana", "apto 23", 541, "1234567", "São Paulo", "SP", "Próximo a estação de metro Vila Mariana"), "11987456123");
        
        /*Chame o método atendimentoClinico do petshop, e faça-o retornar no
		campo observações o pedido do médico para o pet tomar a vacina X*/
        ResponseVO response_1 = petShop.atendimentoClinico(camila, gatos, String.valueOf(helloKit.getNome()).concat(" tomar "));
        System.out.println(response_1.getCliente().getAnimais().get(
        		camila.getAnimais().indexOf(helloKit)).getEsquemasVacinal().get(0).getObs());
        
        /*Valide se o retorno do método atendimentoClinico possui o id do
		serviço, o serviço prestado, o valor e valide principalmente, se há no
		campo observação do animal, o pedido do médico para a vacina*/
        System.out.println(response_1.toString());
        
        /*
         * Chame o método vacinação do pet shop, e faça o pet tomar a vacina
		 * pedido no retorno do atendimentoClinico
         */
        List<Vacina> vacinas = new ArrayList<>();
        Vacina vacina = helloKit.getEsquemasVacinal().get(0).getVacina();
        vacinas.add(vacina);
        ResponseVO response_2 = petShop.vacinacao(camila, gatos, vacinas, helloKit.getNome().concat(" vacinado com "));
        System.out.println(response_2.getCliente().getAnimais().get(camila.getAnimais().indexOf(helloKit)).getEsquemasVacinal().get(0).getObs());
        
        /*
         * Valide se o retorno do método vacinação possui o esquemaVacinal do
		 * pet preenchido com o vacina que foi pedida, o id, o serviço prestado e
		 *  o valor
         */
        System.out.println(response_2.toString());
        
        /*
         *Chame o método higienizar do petshop, e faça-o retornar no campo
		 *estado do animal, um valor referente ao serviço prestado ex: se
		 *chamou o método apenas pedindo para dar banho, o animal deverá
		 *estar limpo no retorno do método 
         */
        ResponseVO response_3 = petShop.higienizar(camila, gatos, Higiene.BANHO, helloKit.getNome().concat(
        		" receberá serviço de " + getServico(Higiene.BANHO)));
        System.out.println(helloKit.getNome().concat(" " + helloKit.getEstadoAnimal().name().toLowerCase()));
        
        /*
         * Valide se o retorno do método higienizar possui id, serviço, preço e se
		 * o estado do animal está equivalente ao serviço pedido
         **/
        System.out.println(response_3.toString());
        
        /*Chame os métodos verRemedio e verAlimentos*/
        petShop.verAlimentos();
        petShop.verRemedios();
        
        /*
         *Por último, passe para o método pagamentos, a lista de todos os ids
		 *do serviços utilizados mais pelo menos 1 remédio e 1 alimento e
    	 *valide se a soma dos valores do pedido do cliente está correta.
         */
        List<ResponseVO> responses = Arrays.asList(response_1, response_2, response_3);
        petShop.pagamento(responses);
        
        /*
         * repita o todos os fluxos feitos para o cliente com apenas um pet para
		 * o que tenha dois, fazendo a seguinte alterações:
		 * ○ no método atendimentoClinico coloque uma observação diferente
		 * para cada animal do cliente (cada animal do cliente deve receber uma
		 * vacina diferente para esse caso de testes)
         */
        ResponseVO response_4 = petShop.atendimentoClinico(eduardo, cachorros, " tomar ");
        cachorros.forEach(c -> System.out.println(c.getNome() + " " + c.getEsquemasVacinal().get(0).getObs()));
        
        /*
         * no método vacinação, vc deve vacinar cada animal conforme pedido
		 * no atendimentoClinico e deve checar no retorno o esquemaVacinal de
		 * cada animal e constatar a vacina correta em cada um
         */
        List<Vacina> vacinas_2 = new ArrayList<>();
        for(Animal cachorro : cachorros) {
        	vacinas_2.add(cachorro.getEsquemasVacinal().get(0).getVacina());
        }
        ResponseVO response_5 = petShop.vacinacao(eduardo, cachorros, vacinas_2, " vacinado com ");
        cachorros.forEach(c -> System.out.println(c.getNome() + " " + c.getEsquemasVacinal().get(0).getObs()));
        
        /*Chame os métodos verRemedio e verAlimentos*/
        petShop.verAlimentos();
        petShop.verRemedios();
        
        /*
         *	Por último, faça a mesma validação para o método pagamentos ( a
		 *  lista de todos os ids do serviços utilizados mais pelo menos 2 remédio
		 *	e 2 alimento e valide se a soma dos valores do pedido do cliente está
		 *	correta ) lembre se que se foi enviado dois animais para qualquer
		 *	serviço, o valor será o dobro do serviço feito apenas para um animal 
         */
        List<ResponseVO> responses_2 = Arrays.asList(response_4, response_5);
        petShop.pagamento(responses_2);
   }
    
   private static String getServico(Higiene higiene) {
	   switch(higiene) {
	   		case BANHO:
	   			return Higiene.BANHO.name().toLowerCase();
	   		case TOSA:
	   			return Higiene.TOSA.name().toLowerCase();
	   		case BANHO_E_TOSA:
	   			return Higiene.BANHO_E_TOSA.name().toLowerCase();
	   		default:
	   			return Higiene.BANHO_E_TOSA.name().toLowerCase();
	   }
   }
}