import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Veiculo meuVeiculo = null;
        int opcao = 0;

        do {
            System.out.println("\n--- SISTEMA DE GESTÃO DE VEÍCULOS ---");
            System.out.println("1. Cadastrar Veículo");
            System.out.println("2. Exibir Dados do Veículo");
            System.out.println("3. Abastecer");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o modelo: ");
                    String mod = scanner.nextLine();
                    System.out.print("Digite a placa: ");
                    String pla = scanner.nextLine();
                    System.out.print("Capacidade do tanque: ");
                    double cap = scanner.nextDouble();
                    meuVeiculo = new Veiculo(pla, mod, cap, 0);
                    System.out.println("Veículo cadastrado!");
                    break;

                case 2:
                    if (meuVeiculo != null) {
                        System.out.println(meuVeiculo.toString());
                    } else {
                        System.out.println("Nenhum veículo cadastrado.");
                    }
                    break;

                case 3:
                    if (meuVeiculo != null) {
                        System.out.print("Quantidade de litros: ");
                        double litros = scanner.nextDouble();
                        meuVeiculo.abastecer(litros);
                    } else {
                        System.out.println("Cadastre um veículo primeiro.");
                    }
                    break;

                case 4:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);

        scanner.close();
    }
}