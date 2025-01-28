package com.course.application.service.curso;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.course.application.dto.curso.CursoInsertDto;
import com.course.application.dto.curso.CursoResponseDto;
import com.course.application.dto.curso.CursoUpdateDto;
import com.course.domain.model.Curso;

public interface ICursoService {

	ResponseEntity<List<CursoResponseDto>> listarTodos();

	Optional<Curso> buscarPorId(Long id);

	Curso cadastrarNovoCurso(CursoInsertDto cursoDto);
	
	Curso atualizaCurso(CursoUpdateDto cursoDto);

	void deletar(Long id);
}
