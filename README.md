# ProjetoJava
Projeto da faculdade de análise e desenvolvimento de sistemas, que envolve a criação de um sistema para cadastramento e consulta de alunos e turmas, através de uma interface de caracteres, onde os dados são solicitados. O projeto foi criado com Java e utilizando conceitos da Programação Orientada a Objeto.


# Sobre o projeto
As opções da interface são:
1. Cadastrar aluno
2. Cadastrar turma
3. Matricular aluno em turma
4. Consultar alunos da escola em ordem alfabética de nome
5. Consultar turmas cadastradas
6. Consultar alunos matriculados em uma turma
7. Consultar número de alunos fora da idade prevista em uma etapa de ensino
8. Sair

Há uma previsão da faixa de idade para alunos cursando uma determinada etapa de ensino:
● infantil : idade menor do que 6 anos
● fundamental anos iniciais: entre 6 e 11 anos
● fundamental anos finais: entre 11 e 15 anos
● médio : entre 15 e 18 anos

Foi usado um ArrayList para armazenar os objetos da Classe Turma, mas por pedido do professor, os objetos da Classe Aluno deviam ser armazenados em uma lista implementada pelo próprio aluno, e criada a classe ListaDeAlunos para usar uma estrutura como array.

Sobrescrever os métodos “toString” e “equals” para as classes Aluno e Turma.

Usar o mecanismo de exceção para tratar duas situações especificas. No caso foi criada a exceção ExcecaoDeAlunoJaExistente, que é usada para verificar se o mesmo CPF já foi usado para o cadastramento de um aluno no sistema, ou para matricular o aluno em uma turma.


