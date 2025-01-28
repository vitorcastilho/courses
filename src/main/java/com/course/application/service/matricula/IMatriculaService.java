package com.course.application.service.matricula;

import java.util.List;

import com.course.application.dto.matricula.MatriculaInsertDto;
import com.course.application.dto.matricula.MatriculaResponseDto;
import com.course.application.dto.matricula.MatriculaUpdateDto;

public interface IMatriculaService {

	List<MatriculaResponseDto> listarTodos();

	MatriculaResponseDto buscarPorId(Long id);

	Long cadastrarNovaMatricula(MatriculaInsertDto matriculaDto);

	MatriculaResponseDto atualizarMatricula(MatriculaUpdateDto matriculaDto);

	void deletar(Long id);

	List<MatriculaResponseDto> listarMatriculasPorAluno(Long alunoId);

	Double calcularMediaNotasPorCurso(Long cursoId);
}
