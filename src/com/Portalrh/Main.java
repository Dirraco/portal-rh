package com.Portalrh;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

/**
 * Classe principal do sistema.
 * Responsável apenas pela interação com o usuário
 * e por delegar as regras para a classe PortalRH.
 */
public class Main {

    public static void main(String[] args) {

        // Scanner para entrada de dados via terminal
        Scanner scanner = new Scanner(System.in);

        // Instância da camada de regra de negócio
        Portalrh portal = new Portalrh();

        int opcao;

        // Loop principal do sistema (menu)
        do {
            System.out.println("\n===== PORTAL RH =====");
            System.out.println("1 - Cadastrar funcionário");
            System.out.println("2 - Registrar ponto");
            System.out.println("3 - Listar funcionários");
            System.out.println("4 - Remover funcionário");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {

                case 1:
                    // Cadastro de funcionário

                    System.out.println("Digite o ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite o nome: ");
                    String nome = scanner.nextLine();

                    System.out.println("Escolha o tipo:");
                    System.out.println("1 - Gerente");
                    System.out.println("2 - Analista");
                    System.out.println("3 - Assistente");
                    System.out.println("4 - Coordenador");
                    System.out.println("5 - Estagiario");

                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    Funcionario funcionario = null;

                    // Polimorfismo: escolha da implementação concreta
                    switch (tipo) {
                        case 1 -> funcionario = new Gerente(id, nome);
                        case 2 -> funcionario = new Analista(id, nome);
                        case 3 -> funcionario = new Assistente(id, nome);
                        case 4 -> funcionario = new Coordenador(id, nome);
                        case 5 -> funcionario = new Estagiario(id, nome);
                        default -> {
                            System.out.println("Tipo inválido");
                            return;
                        }
                    }

                    portal.adicionarFuncionario(funcionario);
                    System.out.println("Funcionario cadastrado com sucesso!");
                    break;

                case 2:
                    // Registro de ponto

                    System.out.println("Digite o ID do funcionario: ");
                    int idFuncionario = scanner.nextInt();
                    scanner.nextLine();

                    funcionario = portal.buscarFuncionarioPortalId(idFuncionario);

                    if (funcionario == null) {
                        System.out.println("Funcionario não encontrado");
                        break;
                    }

                    if (!funcionario.podeBaterPonto()) {
                        System.out.println("Esse tipo de funcionario não pode bater ponto");
                        break;
                    }

                    try {
                        // Coleta de data
                        System.out.println("Ano: ");
                        int ano = scanner.nextInt();
                        System.out.println("Mês: ");
                        int mes = scanner.nextInt();
                        System.out.println("Dia: ");
                        int dia = scanner.nextInt();

                        LocalDate data = LocalDate.of(ano, mes, dia);

                        // Coleta horário entrada
                        System.out.println("Hora entrada: ");
                        int hEntrada = scanner.nextInt();
                        System.out.println("Minuto entrada: ");
                        int mEntrada = scanner.nextInt();

                        LocalTime entrada = LocalTime.of(hEntrada, mEntrada);

                        // Coleta horário saída
                        System.out.println("Hora saída: ");
                        int hSaida = scanner.nextInt();
                        System.out.println("Minuto saída: ");
                        int mSaida = scanner.nextInt();

                        LocalTime saida = LocalTime.of(hSaida, mSaida);

                        // Criação do registro
                        RegistroDePonto registro = new RegistroDePonto(data, entrada, saida);

                        // Delegação da regra para o Portal
                        portal.registrarPonto(idFuncionario, registro);

                    } catch (Exception e) {
                        System.out.println("Erro ao registrar ponto: " + e.getMessage());
                    }

                    break;

                case 3:
                    portal.listarFuncionario();
                    break;

                case 4:
                    System.out.println("Digite o ID do funcionario que deseja remover: ");
                    int idRemover = scanner.nextInt();
                    scanner.nextLine();

                    portal.removerFuncionario(idRemover);
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}