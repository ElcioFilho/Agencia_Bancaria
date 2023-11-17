import javax.swing.JOptionPane;


public class Pessoa {
    public static boolean validarNome(Pessoa pessoa) {
        
        if ("0".equals(pessoa.getNome())) {
            return false; // Retorna false para indicar que a operação foi cancelada
        } else if (!(pessoa.getNome() != null && pessoa.getNome().matches("[a-zA-Z\\s]+"))) {
            JOptionPane.showMessageDialog(null, "Nome inválido. Por favor, insira um nome válido.");
            return false;
        }
        return true;
    }
    
    public static boolean validarCPF(Pessoa pessoa) {
        // Validar o CPF
        if ("0".equals(pessoa.getCPF())) {
            JOptionPane.showMessageDialog(null, "Operação cancelada. Voltando ao menu de operações.");
            return false; // Retorna false para indicar que a operação foi cancelada
        } else if (pessoa.getCPF() == null || !pessoa.getCPF().matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            JOptionPane.showMessageDialog(null, "CPF inválido. Por favor, insira um CPF válido no formato XXX.XXX.XXX-XX.");
            return false;
        }
        return true;
    }
    
    public static boolean validarEmail(Pessoa pessoa) {
        // Validar o e-mail
        if ("0".equals(pessoa.getEmail())) {
            JOptionPane.showMessageDialog(null, "Operação cancelada. Voltando ao menu de operações.");
            return false; // Retorna false para indicar que a operação foi cancelada
        } else if (!pessoa.getEmail().matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")) {
            JOptionPane.showMessageDialog(null, "E-mail inválido. Por favor, insira um e-mail válido.");
            return false;
        }
        return true;
    }
    

    private static int counter = 1;

    private String nome;
    private String cpf;
    private String email;

    public Pessoa() {

    }

    public Pessoa(String Nome, String CPF, String email) {
        super();
        this.nome = Nome;
        this.cpf = CPF;
        this.email = email;
        counter += 1; 
        }

    public String getNome() {
        return nome;
    } 
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCPF() {
        return cpf;
    }
     public void setCPF(String cpf) {
            this.cpf = cpf;
            
    }
    
    

    
    
    
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        if (isValidEmailFormat(email)) {
            this.email = email;
        } else {
            System.out.println("Formato de e-mail incorreto. Por favor, insira um e-mail válido.");
        }
    }

    private boolean isValidEmailFormat(String email) {
        // Verifica se o e-mail possui o formato correto usando uma expressão regular
        return email.matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b");
    }
    public String toString() {
        return "\nNome: " + this.getNome() +
                "\nCPF: " + this.getCPF() +
                "\nemail: " + this.getEmail();
    }
}
