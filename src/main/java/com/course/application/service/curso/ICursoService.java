package com.course.application.service.curso;

import java.util.List;

import com.course.application.dto.curso.CursoInsertDto;
import com.course.application.dto.curso.CursoResponseDto;
import com.course.application.dto.curso.CursoUpdateDto;

public interface ICursoService {

	List<CursoResponseDto> listarTodos();

	CursoResponseDto buscarPorId(Long id);

	Long cadastrarNovoCurso(CursoInsertDto cursoDto);

	CursoResponseDto atualizaCurso(CursoUpdateDto cursoDto);

	void deletar(Long id);
}
