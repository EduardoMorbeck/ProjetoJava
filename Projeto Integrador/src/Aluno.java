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

    @Override
    public String toString() {
        return "Nome: " + nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Aluno aluno = (Aluno) obj;
        return cpf.equals(aluno.cpf);
    }
}
