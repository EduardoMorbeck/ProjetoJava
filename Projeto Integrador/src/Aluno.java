import java.util.Scanner;

public class Aluno {
    private String nome;
    private String cpf;
    private String endereco;
    private String dataNascimento;
    
    public Aluno(String nome, String cpf, String endereco, String dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
    }

    public static Aluno cadastrarAluno(Scanner scanner) {
        System.out.println("Digite o nome do aluno:");
        String nome = scanner.nextLine();
        System.out.println("Digite o CPF do aluno:");
        String cpf = scanner.nextLine();
        System.out.println("Digite o endereço do aluno:");
        String endereco = scanner.nextLine();
        System.out.println("Digite a data de nascimento do aluno (formato: dd/mm/aaaa):");
        String dataNascimento = scanner.nextLine();
        
        return new Aluno(nome, cpf, endereco, dataNascimento);
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    public String getDataNascimento() {
        return dataNascimento;
    }
    
    public int getIdade() {
        String[] partesData = dataNascimento.split("/");
        int anoNascimento = Integer.parseInt(partesData[2]);
        int anoAtual = 2024;
        return anoAtual - anoNascimento;
    }
}