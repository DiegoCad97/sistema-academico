package br.edu.faex.academico.service;

import br.edu.faex.academico.model.Professor;
import br.edu.faex.academico.repository.ProfessorRepository;

import java.util.List;

public class ProfessorService {
    private ProfessorRepository repository;

    public ProfessorService(ProfessorRepository repository) {
        this.repository = repository;
    }

    public void cadastrar(Professor professor) {
        repository.salvar(professor);
    }

    public List<Professor> listar() {
        return repository.listar();
    }

    public Professor buscarPorId(Long id) {
        Professor professor = repository.buscarPorId(id);

        if (professor == null) {
            System.out.println("Professor não encontrado.");
            return null;
        }

        return professor;
    }
}