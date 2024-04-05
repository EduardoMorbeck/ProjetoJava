import java.util.ArrayList;
import java.util.Scanner;

public class Turma {
    private String codigo;
    private String etapaEnsino;
    private int ano;
    private int limiteVagas;
    private int numMatriculados;
    private ArrayList<Aluno> alunos;
    
    public Turma(String codigo, String etapaEnsino, int ano, int limiteVagas, int numMatriculados) {
        this.codigo = codigo;
        this.etapaEnsino = etapaEnsino;
        this.ano = ano;
        this.limiteVagas = limiteVagas;
        this.numMatriculados = 0;
        this.alunos = new ArrayList<>();
    }
    
    public void matricularAluno(Aluno aluno) {
        if (numMatriculados < limiteVagas) {
            alunos.add(aluno);
            numMatriculados++;
            System.out.println("Aluno " + aluno.getNome() + "matriculado com sucesso na turma " + codigo);
        } else {
            System.out.println("Não foi possível matricular o aluno "+ aluno + "na turma " + codigo + ". Turma lotada.");
        }
    }

    public static Turma cadastrarTurma(Scanner scanner) {
        System.out.println("Digite o código da turma:");
        String codigo = scanner.nextLine();
        System.out.println("Digite a etapa de ensino (Infantil, Fundamental anos iniciais, Fundamental anos finais, Médio):");
        String etapaEnsino = scanner.nextLine();
        System.out.println("Digite o ano da turma:");
        int ano = scanner.nextInt();
        System.out.println("Digite o limite de vagas:");
        int limiteVagas = scanner.nextInt();
        System.out.println("Digite o número de matriculados");
        int numMatriculados = scanner.nextInt();
        

        return new Turma(codigo, etapaEnsino, ano, limiteVagas, numMatriculados);
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public String getEtapaEnsino() {
        return etapaEnsino;
    }
    
    public int getAno() {
        return ano;
    }
    
    public int getLimiteVagas() {
        return limiteVagas;
    }
    
    public int getNumMatriculados() {
        return numMatriculados;
    }
    
    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }
}
