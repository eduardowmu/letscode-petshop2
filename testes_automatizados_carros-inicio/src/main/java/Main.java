import model.Carro;
import service.CarroService;
import service.CarroServiceImpl;

public class Main {

    /**
     *
     * Um carro tem os seguintes atributos:
     *  - cor
     *  - marca
     *  - modelo
     *  - ligado
     *  - velocidadeAtual
     *  - velocidadeMáxima
     *
     *  Enquanto o carro estiver desligado deve ser capaz de:
     *  - Ligar
     *  - Mostrar estado atual
     *
     * Enquanto o carro estiver ligado deve ser capaz de:
     * - Desligar
     * - Acelerar
     * - Frear
     * - Motrar estado atual
     *
     * Regras:
     *
     * - Só podemos realizar as ações como acelerar e frear com o carro ligado
     * - Só podemos desligar o carro quando ele parar totalmente (velocidadeAtual = 0)
     * - Não existe velocidade negativa
     * - O carro não pode passar de sua velocidade máxima
     *
     */

    public static void main(String[] args) {
        CarroService carroService = new CarroServiceImpl();

        Carro carro = new Carro("Azul", "Fiat", "Uno", 2015, false, 0, 150);
        carroService.ligar(carro);
        carroService.acelerar(carro, 10);
        System.out.println(carroService.estadoAtual(carro));

    }
}
