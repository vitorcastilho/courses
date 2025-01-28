package com.course.application.mapper;

import com.course.application.dto.curso.CursoInsertDto;
import com.course.application.dto.curso.CursoUpdateDto;
import com.course.domain.model.Curso;

public class CursoMapper {

	public static Curso convertCursoInsertDtoToCurso(CursoInsertDto cursoDto) {
		Curso curso = new Curso();
		curso.setNome(cursoDto.getNome());
		curso.setDescricao(cursoDto.getDescricao());
		return curso;
	}

	public static Curso convertCursoUpdateDtoToCurso(CursoUpdateDto cursoDto) {
		Curso curso = new Curso();
		curso.setId(cursoDto.getId());
		curso.setNome(cursoDto.getNome());
		curso.setDescricao(cursoDto.getDescricao());
		return curso;
	}
}
