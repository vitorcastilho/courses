package com.course.web.api.v1.controller;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.application.dto.aluno.AlunoInsertDto;
import com.course.application.dto.aluno.AlunoResponseDto;
import com.course.application.dto.aluno.AlunoUpdateDto;
import com.course.application.dto.matricula.MatriculaResponseDto;
import com.course.application.service.aluno.IAlunoService;

@RestController
@RequestMapping(AlunoController.API_URL)
public class AlunoController {

	public static final String API_URL = "/alunos";

	@Autowired
	private IAlunoService alunoService;

	@PostMapping
	public ResponseEntity<Long> criarAluno(@RequestBody AlunoInsertDto alunoDto) {
		return new ResponseEntity<>(alunoService.cadastrarNovoAluno(alunoDto), CREATED);
	}

	@GetMapping
	public ResponseEntity<List<AlunoResponseDto>> listarAlunos() {
		return ResponseEntity.ok(alunoService.listarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<AlunoResponseDto> buscarAlunoPorId(@PathVariable Long id) {
		return ResponseEntity.ok(alunoService.buscarPorId(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<AlunoResponseDto> atualizarAluno(@PathVariable Long id,
			@RequestBody AlunoUpdateDto alunoDto) {
		alunoDto.setId(id);
		return ResponseEntity.ok(alunoService.atualizarAluno(alunoDto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarAluno(@PathVariable Long id) {
		alunoService.deletar(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}/cursos")
	public ResponseEntity<List<MatriculaResponseDto>> listarCursosDoAluno(@PathVariable Long id) {
		return ResponseEntity.ok(alunoService.listarMatriculasPorAluno(id));
	}
}
