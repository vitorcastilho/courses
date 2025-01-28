package com.course.application.service.aluno;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.course.application.dto.aluno.AlunoInsertDto;
import com.course.application.dto.aluno.AlunoResponseDto;
import com.course.application.dto.aluno.AlunoUpdateDto;
import com.course.domain.model.Aluno;

public interface IAlunoService {

	ResponseEntity<List<AlunoResponseDto>> listarTodos();

	Optional<Aluno> buscarPorId(Long id);

	Aluno cadastrarNovoAluno(AlunoInsertDto alunoDto);
	
	Aluno atualizarAluno(AlunoUpdateDto alunoDto);

	void deletar(Long id);
}
