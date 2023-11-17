    import java.util.ArrayList;
    import javax.swing.JOptionPane;
    
    public class AgenciaBancaria {
        
        static ArrayList<Conta> ContasBancarias;

        public static void main(String[] args) {
            ContasBancarias = new ArrayList<Conta>();
            operacoes();
        }

        public static void operacoes () {
            
            int operacao = 
            Integer.parseInt(JOptionPane.showInputDialog("--- Selecione uma operação ---" +
                            "|   Opção 1 - Criar Conta" +
                            "|   Opção 2 - Depositar" +
                            "|   Opção 3 - Sacar"   +
                            "|   Opção 4 - Transferir" +
                            "|   Opção 5 - Listar"+
                            "|   Opção 6 - Sair"));
            

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
                    JOptionPane.showMessageDialog
                    (null, "Obrigado por usar nossa agência, volte sempre <3");
                    System.exit(0);
                    
            
                default:
                    JOptionPane.showMessageDialog
                    (null, "Opção Inválida!");
                    operacoes();
                    break;
            }

        }

        public static void CriarConta() {
            Pessoa pessoa = new Pessoa();

            do {
                pessoa.setNome(JOptionPane.showInputDialog("Nome (ou 0 para cancelar):"));
                if (pessoa.getNome().equals("0")) {
                    JOptionPane.showMessageDialog
                    (null, "Operação cancelada. Voltando ao menu de operações.");
                    operacoes();
                     return;
                }
            }
            while (!Pessoa.validarNome(pessoa));
                do {
                pessoa.setCPF(JOptionPane.showInputDialog("CPF (ou 0 para cancelar):"));
                if (pessoa.getCPF().equals("0")) {
                    operacoes();
                     return;
                }
            } 
            while (!Pessoa.validarCPF(pessoa));

                do {
                pessoa.setEmail(JOptionPane.showInputDialog("Email (ou 0 para cancelar):"));
                if (pessoa.getEmail().equals("0")) {
                    operacoes();
                    return;
                
                } 
            } 
            while (!Pessoa.validarEmail(pessoa));

                
        

       


            Conta conta = new Conta(pessoa);

            ContasBancarias.add(conta);
            JOptionPane.showMessageDialog
                    (null, "Sua conta foi criada com sucesso!>");
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
            
            int numeroConta = Integer.parseInt
                (JOptionPane.showInputDialog(" Número da conta para o depósito: "));

            Conta conta = encontrarConta(numeroConta);

            if(conta != null) {
                Double valorDeposito = Double.parseDouble
                    (JOptionPane.showInputDialog(" Qual o valor deseja depositar? "));
                conta.depositar(valorDeposito);
                JOptionPane.showMessageDialog
                    (null, " Valor depositado com sucesso! ");
            }
            else {

                JOptionPane.showMessageDialog
                    (null, " Conta não encontrada! ");
            }
            operacoes();
        }

        public static void sacar() {
            int numeroConta = Integer.parseInt
                (JOptionPane.showInputDialog(" Número da conta para saque: "));
            
            Conta conta = encontrarConta(numeroConta);

            if(conta != null) {
                Double valorSaque = Double.parseDouble
                    (JOptionPane.showInputDialog(" Qual valor deseja sacar? "));

                conta.sacar(valorSaque);
            }
            else {
            JOptionPane.showMessageDialog
                    (null, " Conta não encontrada! ");
            }
            operacoes();
        }

        public static void transferir() {

            int numeroContaRemetente = Integer.parseInt
                (JOptionPane.showInputDialog(" Número da conta do remetente: "));

            Conta contaRemetente = encontrarConta(numeroContaRemetente);

                if(contaRemetente != null) {
                    int numeroContaDestinatario = Integer.parseInt
                        (JOptionPane.showInputDialog(" Número da conta do destinatário: "));    

                    Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

                if(contaDestinatario != null) {
                    Double valor = 
                        Double.parseDouble
                            (JOptionPane.showInputDialog(" Valor da transferência: "));

                    contaRemetente.transferir(contaDestinatario, valor);
                } else {
                    JOptionPane.showMessageDialog
                    (null, " Conta para deposito não encontrada! ");
                }
            }
                else {
                    JOptionPane.showMessageDialog
                    (null, " Conta para transferência não encontrada! ");
                
            }
            operacoes();
        }

        public static void listarContas() {
                if(ContasBancarias.size() > 0) {
                    for(Conta conta: ContasBancarias) {
                        JOptionPane.showMessageDialog(null, conta);
                    }
                }
                else {
                    JOptionPane.showMessageDialog
                        (null," Não há contas cadastradas! " );
            }
            
            operacoes();

        
        
    }
}


