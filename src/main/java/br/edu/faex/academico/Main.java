package br.edu.faex.academico;

import br.edu.faex.academico.controller.AlunoController;
import br.edu.faex.academico.controller.ProfessorController;
import br.edu.faex.academico.model.Aluno;
import br.edu.faex.academico.model.Professor;
import br.edu.faex.academico.repository.AlunoRepository;
import br.edu.faex.academico.repository.ProfessorRepository;
import br.edu.faex.academico.service.AlunoService;
import br.edu.faex.academico.service.ProfessorService;

public class Main {

    public static void main(String[] args) {

        // =========================
        // MÓDULO ALUNO
        // =========================

        Aluno aluno1 = new Aluno(
                "Aleandro Ribeiro de Lima",
                "aleandro.lima@faex.edu.br"
        );

        Aluno aluno2 = new Aluno(
                "Maria Helena de Lima",
                "maria.lima@faex.edu.br"
        );

        aluno1.setId(1L);
        aluno2.setId(2L);

        AlunoRepository alunoRepository = new AlunoRepository();
        AlunoService alunoService = new AlunoService(alunoRepository);
        AlunoController alunoController = new AlunoController(alunoService);

        alunoController.cadastrar(aluno1);
        alunoController.cadastrar(aluno2);

        System.out.println("===== ALUNOS =====");

        for (Aluno aluno : alunoController.listar()) {
            System.out.println("ID: " + aluno.getId());
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("E-mail: " + aluno.getEmail());
            System.out.println("Ativo: " + aluno.isAtivo());
            System.out.println("-------------------------");
        }

        // Busca aluno pelo ID
        Aluno aluno = alunoController.buscarPorId(2L);

        if (aluno != null) {
            System.out.println("Aluno encontrado!");
            System.out.println("ID: " + aluno.getId());
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("E-mail: " + aluno.getEmail());
        } else {
            System.out.println("Aluno não encontrado.");
        }


        // =========================
        // MÓDULO PROFESSOR
        // =========================

        Professor professor1 = new Professor(
                "João da Silva",
                "joao.silva@faex.edu.br"
        );

        Professor professor2 = new Professor(
                "Carlos Oliveira",
                "carlos.oliveira@faex.edu.br"
        );

        professor1.setId(1L);
        professor2.setId(2L);

        ProfessorRepository professorRepository = new ProfessorRepository();
        ProfessorService professorService = new ProfessorService(professorRepository);
        ProfessorController professorController = new ProfessorController(professorService);

        professorController.cadastrar(professor1);
        professorController.cadastrar(professor2);

        System.out.println("\n===== PROFESSORES =====");

        for (Professor professor : professorController.listar()) {
            System.out.println("ID: " + professor.getId());
            System.out.println("Nome: " + professor.getNome());
            System.out.println("E-mail: " + professor.getEmail());
            System.out.println("Ativo: " + professor.isAtivo());
            System.out.println("-------------------------");
        }

        // Busca professor pelo ID
        Professor professor = professorController.buscarPorId(2L);

        if (professor != null) {
            System.out.println("Professor encontrado!");
            System.out.println("ID: " + professor.getId());
            System.out.println("Nome: " + professor.getNome());
            System.out.println("E-mail: " + professor.getEmail());
        } else {
            System.out.println("Professor não encontrado.");
        }
    }
}