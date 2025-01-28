package com.course.application.dto.matricula;

import com.course.domain.model.Aluno;
import com.course.domain.model.Curso;

public class MatriculaUpdateDto {

	private Long id;
	private Aluno aluno;
	private Curso curso;
	private Double nota;

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
