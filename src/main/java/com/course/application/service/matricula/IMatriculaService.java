package com.course.application.service.matricula;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.course.application.dto.matricula.MatriculaInsertDto;
import com.course.application.dto.matricula.MatriculaResponseDto;
import com.course.application.dto.matricula.MatriculaUpdateDto;
import com.course.domain.model.Matricula;

public interface IMatriculaService {

	ResponseEntity<List<MatriculaResponseDto>> listarTodos();
	
	Optional<Matricula> buscarPorId(Long id);
	
	Matricula cadastrarNovaMatricula(MatriculaInsertDto matriculaDto);
	
	Matricula atualizarMatricula(MatriculaUpdateDto matriculaDto);
	
	void deletar(Long id);
	
	List<Matricula> listarMatriculasPorAluno(Long alunoId);
	
	Double calcularMediaNotasPorCurso(Long cursoId);
}
