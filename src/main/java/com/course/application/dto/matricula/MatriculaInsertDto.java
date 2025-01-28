package com.course.application.dto.matricula;

import com.course.domain.model.Aluno;
import com.course.domain.model.Curso;

public class MatriculaInsertDto {

	private Aluno aluno;
	private Curso curso;
	private Double nota;

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
