package com.course.application.dto.curso;

import com.course.domain.model.Curso;

public class CursoResponseDto {

	private Long id;
	private String nome;
	private String descricao;

	public CursoResponseDto(Long id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public CursoResponseDto(Curso curso) {
		this.id = curso.getId();
		this.nome = curso.getNome();
		this.descricao = curso.getDescricao();
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
