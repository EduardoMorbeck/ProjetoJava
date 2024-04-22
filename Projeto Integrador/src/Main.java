import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ListaDeAlunos listaDeAlunos = new ListaDeAlunos(100);
    private static ArrayList<Turma> turmas = new ArrayList<>();
    public static void main(String[] args) throws ExcecaoDeAlunoJaExistente{
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("--------------------------------------------------------------");
            System.out.println("Menu:");
            System.out.println("1. Cadastrar aluno");
            System.out.println("2. Cadastrar turma");
            System.out.println("3. Matricular aluno em turma");
            System.out.println("4. Consultar alunos da escola em ordem alfabética de nome");
            System.out.println("5. Consultar turmas cadastradas");
            System.out.println("6. Consultar alunos matriculados em uma turma");
            System.out.println("7. Consultar número de alunos fora da idade prevista em uma etapa de ensino");
            System.out.println("8. Sair");
            System.out.println("Escolha uma opção:");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Digite o nome do aluno:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o CPF do aluno:");
                    String cpf = scanner.nextLine();
                    System.out.println("Digite o endereço do aluno:");
                    String endereco = scanner.nextLine();
                    System.out.println("Digite a data de nascimento do aluno (formato: dd/mm/aaaa):");
                    String dataNascimento = scanner.nextLine();
                    
                    Aluno aluno = new Aluno(nome, cpf, endereco, dataNascimento);
                    try {listaDeAlunos.incluirNoFim(aluno);} catch (ExcecaoDeAlunoJaExistente e) {
                        System.out.println("Não foi possível adicionar o aluno, " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("--------------------------------------------------------------");
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
                    

                    Turma turma = new Turma(codigo, etapaEnsino, ano, limiteVagas, numMatriculados);
                    turmas.add(turma);
                    break;

                    case 3:
                    try {
                        System.out.println("--------------------------------------------------------------");
                        System.out.println("Digite o CPF do aluno:");
                        String numeroCPF = scanner.nextLine();
                        Aluno alunoSelecionado = null;
                
                        for (Turma t : turmas) {
                            for (Aluno a : t.getAlunos()) {
                                if (a.getCpf().equals(numeroCPF)) {
                                    throw new ExcecaoDeAlunoJaExistente("Aluno já está cadastrado em outra turma.");
                                }
                            }
                        }
                
                        for (int i = 0; i < listaDeAlunos.tamanho(); i++) {
                            Aluno a = listaDeAlunos.get(i);
                            if (a.getCpf().equals(numeroCPF)) {
                                alunoSelecionado = a;
                                break;
                            }
                        }
                        if (alunoSelecionado == null) {
                            System.out.println("Aluno não encontrado.");
                        } else {
                            System.out.println("Digite o código da turma:");
                            String codigoTurma = scanner.nextLine();
                            Turma turmaSelecionada = null;
                            for (Turma t : turmas) {
                                if (t.getCodigo().equals(codigoTurma)) {
                                    turmaSelecionada = t;
                                    break;
                                }
                            }
                            if (turmaSelecionada == null) {
                                System.out.println("Turma não encontrada.");
                            } else {
                                turmaSelecionada.matricularAluno(alunoSelecionado);
                            }
                        }
                    } catch (ExcecaoDeAlunoJaExistente e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;                

                case 4:
                    System.out.println("--------------------------------------------------------------");
                    listaDeAlunos.ordenar();
                    System.out.println("Alunos da escola em ordem alfabética de nome:");
                    for (int i = 0; i < listaDeAlunos.tamanho(); i++) {
                        aluno = listaDeAlunos.get(i);
                        System.out.println(aluno.toString());
                    }
                    break;
                case 5:
                    consultarTurmas(turmas);
                    break;
                case 6:
                    consultarAlunosTurma(turmas, scanner);
                    break;
                case 7:
                    consultarAlunosForaIdade(turmas, scanner);
                    break;
                case 8:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void consultarTurmas(ArrayList<Turma> turmas) {
        for (Turma turma : turmas) {
            System.out.println(turma.toString() + ", Etapa de Ensino: " + turma.getEtapaEnsino());
        }
    }
    
    private static void consultarAlunosTurma(ArrayList<Turma> turmas, Scanner scanner) {
        System.out.println("Digite o código da turma:");
        String codigoTurma = scanner.nextLine();
        Turma turmaSelecionada = null;
        for (Turma t : turmas) {
            if (t.getCodigo().equals(codigoTurma)) {
                turmaSelecionada = t;
                break;
            }
        }
        if (turmaSelecionada != null) {
            System.out.println("Alunos matriculados na turma " + turmaSelecionada.getCodigo() + ":");
            for (Aluno aluno : turmaSelecionada.getAlunos()) {
                System.out.println(aluno.toString());
            }
        } else {
            System.out.println("Turma não encontrada.");
        }
    }
    
    private static void consultarAlunosForaIdade(ArrayList<Turma> turmas, Scanner scanner) {
    System.out.println("Digite a etapa de ensino:");
    String etapaEnsino = scanner.nextLine();
    int faixaEtariaMaxima = 0;
    if (etapaEnsino == "Infantil"){
        faixaEtariaMaxima = 6;
    } else if (etapaEnsino == "Fundamental anos iniciais"){
        faixaEtariaMaxima = 11;
    }else if (etapaEnsino == "Fundamental anos finais"){
        faixaEtariaMaxima = 15;
    }else if (etapaEnsino == "Médio"){
        faixaEtariaMaxima = 18;
    }

    int count = 0;
    for (Turma turma : turmas) {
        if (turma.getEtapaEnsino().equalsIgnoreCase(etapaEnsino)) {
            for (Aluno aluno : turma.getAlunos()) {
                if (aluno.getIdade() > faixaEtariaMaxima) {
                    count++;
                }
            }
        }
    }
    
    System.out.println("Número de alunos fora da idade prevista na etapa de ensino " + etapaEnsino + ": " + count);
}
}
