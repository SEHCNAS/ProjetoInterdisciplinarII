package ProjetoInterdisciplinar_II;
/*Sistema de venda para concessionária (carro, caminhão, moto)*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Veiculo> ListaVeiculos = new ArrayList<Veiculo>();
    static String RetonaTipoVeiculo(int IdentificadorVeiculo){
        String TipoVeiculo = switch (IdentificadorVeiculo) {
            case 1 -> "Moto";
            case 2 -> "Carro";
            case 3 -> "Caminhao";
            default -> throw new IllegalStateException("Unexpected value: " + IdentificadorVeiculo);
        };
        return TipoVeiculo;
    }

    static void ListaVeiculos(List<Veiculo> ListaVeiculos){
        int Contador = 0;
        for(Veiculo Veiculo : ListaVeiculos)
        {
            System.out.printf("%d - %s%n", Contador, Veiculo.RetornaDadosVeiculo());
            Contador++;
        }
    }

    public static void main(String[] args){
        //Declaração de variaveis
        int MenuEscolha, TipoVeiculo;
        Veiculo Veiculo;
        /*List<Veiculo> ListaVeiculos = new ArrayList<Veiculo>();*/
        Scanner sc = new Scanner(System.in);

        //Inicialização de variaveis
        MenuEscolha = 1;
        TipoVeiculo = 0;

        //Mensagem com as opções do menu
        System.out.println("""
                Opções disponiveis.
                 1 - Ver lista de veiculos cadastrados
                 2 - Cadastrar novo veiculo\s
                 3 - Editar Registro
                 0 - Sair""");

        while (MenuEscolha > 0){

            System.out.println("Digite o numero correspondente a opção que deseja acessar: ");
            MenuEscolha = sc.nextInt();

            switch (MenuEscolha) {

                case 1: /*Lista de veiculos cadastrados*/
                    /*System.out.println("Opção 1");*/

                    if (ListaVeiculos.isEmpty()){
                        System.out.println("Ainda não foi cadastrado nenhum item para venda!");
                    }else {
                        ListaVeiculos(ListaVeiculos);
                    }
                    break;

                case 2: /*Cadastro de novos veiculos*/

                    Veiculo = new Veiculo();

                    System.out.println("Digite a marca do veiculo: ");
                    Veiculo.setMarca(sc.next());

                    System.out.println("Digite o Modelo do veiculo: ");
                    Veiculo.setModelo(sc.next());

                    System.out.println("Digite o estado do veiculo: ");
                    Veiculo.setEstado(sc.next());

                    System.out.println("Digite a cor do veiculo: ");
                    Veiculo.setCor(sc.next());

                    System.out.println("Digite o numero referente ao tipo do veiculo (1)-MOTO, (2)-CARRO e (3)-CAMINHÃO: "); /*Colocar enum*/
                    while((TipoVeiculo != 1) && (TipoVeiculo != 2) && (TipoVeiculo != 3) ) {
                        TipoVeiculo = sc.nextInt();

                    }

                    Veiculo.setTipoVeiculo(RetonaTipoVeiculo(TipoVeiculo));

                    System.out.println("Digite o valor do veiculo: ");
                    Veiculo.setValor(sc.nextDouble());

                    System.out.println("Digite a kilometragem do veiculo: ");
                    Veiculo.setKilometragem(sc.nextDouble());

                    System.out.println("Digite a quantidade de veiculos disponiveis: ");
                    Veiculo.setQuantidadeDisponivel(sc.nextInt());

                    ListaVeiculos.add(Veiculo);
                    break;

                case 0:
                    MenuEscolha = 0;
                    break;
                default:
                    System.out.println("Opção invalida tente novamente!");
            }
        }
    }
}

