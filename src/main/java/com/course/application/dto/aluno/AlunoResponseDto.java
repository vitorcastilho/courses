package com.course.application.dto.aluno;

import com.course.domain.model.Aluno;

public class AlunoResponseDto {

	private Long id;
	private String nome;

	public AlunoResponseDto(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public AlunoResponseDto(Aluno aluno) {
		this.id = aluno.getId();
		this.nome = aluno.getNome();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
