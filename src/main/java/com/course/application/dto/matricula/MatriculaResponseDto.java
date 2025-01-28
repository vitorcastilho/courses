package com.course.application.dto.matricula;

import com.course.domain.model.Aluno;
import com.course.domain.model.Curso;
import com.course.domain.model.Matricula;

public class MatriculaResponseDto {

	private Long id;
	private Aluno aluno;
	private Curso curso;
	private Double nota;

	public MatriculaResponseDto(Long id, Aluno aluno, Curso curso, Double nota) {
		this.id = id;
		this.aluno = aluno;
		this.curso = curso;
		this.nota = nota;
	}

	public MatriculaResponseDto(Matricula matricula) {
		this.id = matricula.getId();
		this.aluno = matricula.getAluno();
		this.curso = matricula.getCurso();
		this.nota = matricula.getNota();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}
}
