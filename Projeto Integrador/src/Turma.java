public class Turma {
    private String codigo;
    private String etapaEnsino;
    private int ano;
    private int limiteVagas;
    private int numMatriculados;
    private ListaDeAlunos alunos;
    
    public Turma(String codigo, String etapaEnsino, int ano, int limiteVagas, int numMatriculados) {
        this.codigo = codigo;
        this.etapaEnsino = etapaEnsino;
        this.ano = ano;
        this.limiteVagas = limiteVagas;
        this.numMatriculados = 0;
        this.alunos = new ListaDeAlunos(limiteVagas);
    }
    
    public void matricularAluno(Aluno aluno) throws ExcecaoDeAlunoJaExistente {
        if (numMatriculados < limiteVagas) {
            alunos.incluirNoFim(aluno);
            numMatriculados++;
            System.out.println("Aluno " + aluno.toString() + " matriculado com sucesso na turma " + codigo);
        } else {
            System.out.println("Não foi possível matricular o aluno "+ aluno + " na turma " + codigo + ", turma lotada.");
        }
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
    
    public Iterable<Aluno> getAlunos() {
        return alunos.getAlunos();
    }

    @Override
    public String toString() {
        return "Turma: " + codigo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Turma turma = (Turma) obj;
        return codigo.equals(turma.codigo);
    }
}
