import java.util.Arrays;

public class ListaDeAlunos {
    private Aluno[] alunos;
    private int tamanho;

    public ListaDeAlunos(int capacidade) {
        alunos = new Aluno[capacidade];
        tamanho = 0;
    }
    
    public void incluirNoInicio(Aluno aluno) throws ExcecaoDeAlunoJaExistente {
        if (tamanho < alunos.length) {
            for (int i = 0; i < tamanho; i++) {
                if (alunos[i].getCpf().equals(aluno.getCpf())) {
                    throw new ExcecaoDeAlunoJaExistente("Aluno já foi cadastrado.");
                }
            }
            
            alunos[0] = aluno;
            tamanho++;
        } else {
            System.out.println("Lista cheia. Não é possível adicionar mais alunos.");
        }
    }

    public void incluirNoFim(Aluno aluno) throws ExcecaoDeAlunoJaExistente {
        if (tamanho < alunos.length) {
            for (int i = 0; i < tamanho; i++) {
                if (alunos[i].getCpf().equals(aluno.getCpf())) {
                    throw new ExcecaoDeAlunoJaExistente("Aluno já foi cadastrado.");
                }
            }
            
            alunos[tamanho] = aluno;
            tamanho++;
        } else {
            System.out.println("Lista cheia. Não é possível adicionar mais alunos.");
        }
    }

    public void ordenar() {
        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho - i - 1; j++) {
                if (alunos[j].getNome().compareTo(alunos[j + 1].getNome()) > 0) {
                    Aluno temp = alunos[j];
                    alunos[j] = alunos[j + 1];
                    alunos[j + 1] = temp;
                }
            }
        }
    }

    public Aluno removerDoFim() {
        if (tamanho > 0) {
            Aluno alunoRemovido = alunos[tamanho - 1];
            alunos[tamanho - 1] = null;
            tamanho--;
            return alunoRemovido;
        } else {
            System.out.println("Lista vazia. Não há alunos para remover.");
            return null;
        }
    }

    public int tamanho() {
        return tamanho;
    }

    public Aluno get(int indice) {
        if (indice >= 0 && indice < tamanho) {
            return alunos[indice];
        } else {
            System.out.println("Índice inválido.");
            return null;
        }
    }

    public Iterable<Aluno> getAlunos() {
        return Arrays.asList(Arrays.copyOf(alunos, tamanho));
    }

}

