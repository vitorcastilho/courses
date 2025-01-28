package com.course.application.service.aluno;

import java.util.List;

import com.course.application.dto.aluno.AlunoInsertDto;
import com.course.application.dto.aluno.AlunoResponseDto;
import com.course.application.dto.aluno.AlunoUpdateDto;
import com.course.application.dto.matricula.MatriculaResponseDto;

public interface IAlunoService {

	List<AlunoResponseDto> listarTodos();

	AlunoResponseDto buscarPorId(Long id);

	Long cadastrarNovoAluno(AlunoInsertDto alunoDto);

	AlunoResponseDto atualizarAluno(AlunoUpdateDto alunoDto);

	void deletar(Long id);
	
	List<MatriculaResponseDto> listarMatriculasPorAluno(Long alunoId);
}
