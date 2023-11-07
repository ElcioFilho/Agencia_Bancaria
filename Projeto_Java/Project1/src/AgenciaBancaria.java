import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {
    
    static Scanner input = new  Scanner(System.in);
    static ArrayList<Conta> ContasBancarias;

    public static void main(String[] args) {
        ContasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    public static void operacoes () {
        
        System.out.println("------------------------------------------------------");
        System.out.println("-------------Bem Vindos a nossa Agência---------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione uma operação que deseja realizar *****");
        System.out.println("------------------------------------------------------");
        System.out.println("|   Opção 1 - Criar Conta   |");
        System.out.println("|   Opção 2 - Depositar     |");
        System.out.println("|   Opção 3 - Sacar         |");   
        System.out.println("|   Opção 4 - Transferir    |");
        System.out.println("|   Opção 5 - Listar        |");
        System.out.println("|   Opção 6 - Sair          |");
        
        int operacao = input.nextInt();

        switch (operacao) {
            case 1:
                CriarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listarContas();
                break;
            case 6:
                System.out.println("Obrigado por usar nossa agência, volte sempre <3");
                System.exit(0);
                
        
            default:
                System.out.println("Opção Inválida!");
                operacoes();
                break;
        }

    }


    public static void CriarConta() {

        input.nextLine();
        System.out.println("\nNome (ou 0 para cancelar): ");
        String nome = input.nextLine();
            if (nome.equals("0")) {
                operacoes();
        return;
    }

        String cpf;
        while (true) {
            System.out.println("\nCPF (no formato ###.###.###-##) ou 0 para cancelar: ");
            cpf = input.next();

                if (cpf.equals("0")) {
                    operacoes();
            return;
         }

                if (cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
                    break;      }
                else {
                    System.out.println("Formato de CPF incorreto. Por favor, tente novamente.");
                    }
    }

        String email;
        while (true) {
            System.out.println("\nEmail (ou 0 para cancelar): ");
            email = input.next();

                if (email.equals("0")) {
                    operacoes();
                return;
        }

                if (email.matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")) {
                    break;      }
                else {
                    System.out.println("Formato de e-mail incorreto. Por favor, tente novamente.");
        }
    }



        Pessoa pessoa = new Pessoa(nome, cpf, email);
        Conta conta = new Conta(pessoa);

        ContasBancarias.add(conta);
        System.out.println("Sua conta foi criada com sucesso!");

        operacoes();

    }

    
    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if(ContasBancarias.size() > 0) {
            for (Conta c: ContasBancarias) {
                if (c.getNumeroConta() == numeroConta) {
                conta = c;
                break;
                }
            }
        }
        return conta;
    }   

    public static void depositar() {
        System.out.println(" Numero da Conta: ");
        int numeroConta = input.nextInt();
        Conta conta = encontrarConta(numeroConta);

        if(conta != null) {
            System.out.println(" Qual o valor deseja depositar? ");
            Double valorDeposito = input.nextDouble();
            conta.depositar(valorDeposito);
            System.out.println(" Valor depositado com sucesso! ");
        }
        else {
            System.out.println( " Conta não encontrada! ");
        }
        operacoes();
    }

    public static void sacar() {
        System.out.println("Numero da Conta: ");
        int numeroConta = input.nextInt();
        Conta conta = encontrarConta(numeroConta);

        if(conta != null) {
            System.out.println(" Qual o valor deseja sacar? ");
            Double valorSaque = input.nextDouble();
            conta.sacar(valorSaque);
        }
        else {
            System.out.println( " Conta não encontrada! ");
        }
        operacoes();
    }

    public static void transferir() {
        System.out.println("Numero da Conta do Remetente: ");
        int numeroContaRemetente = input.nextInt();

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

            if(contaRemetente != null) {
                System.out.println("Número da conta do destinatário: ");
                int numeroContaDestinatario = input.nextInt();

                Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if(contaDestinatario != null) {
                System.out.println("Valor da transferência: ");
                Double valor = input.nextDouble();

                contaRemetente.transferir(contaDestinatario, valor);
            }
        }
        operacoes();
     }

    public static void listarContas() {
            if(ContasBancarias.size() > 0) {
                for(Conta conta: ContasBancarias) {
                    System.out.println(conta);
                 }
            }
            else {
                System.out.println("Não há  contas cadastradas!");
                
        }
        
        operacoes();

    }
    
}


