package com.course.web.api.v1.controller;

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
import com.course.application.service.aluno.IAlunoService;
import com.course.application.service.matricula.MatriculaService;
import com.course.domain.model.Aluno;
import com.course.domain.model.Matricula;

@RestController
@RequestMapping(AlunoController.API_URL)
public class AlunoController {

	public static final String API_URL = "/alunos";

	@Autowired
	private IAlunoService alunoService;

	@Autowired
	private MatriculaService matriculaService;

	@PostMapping
	public Aluno criarAluno(@RequestBody AlunoInsertDto alunoDto) {
		return alunoService.cadastrarNovoAluno(alunoDto);
	}

	@GetMapping
	public ResponseEntity<List<AlunoResponseDto>> listarAlunos() {
		return alunoService.listarTodos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Aluno> buscarAlunoPorId(@PathVariable Long id) {
		return alunoService.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Aluno> atualizarAluno(@PathVariable Long id, @RequestBody AlunoUpdateDto alunoDto) {
		return alunoService.buscarPorId(id).map(alunoExistente -> {
			alunoDto.setId(id);
			return ResponseEntity.ok(alunoService.atualizarAluno(alunoDto));
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarAluno(@PathVariable Long id) {
		alunoService.deletar(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}/cursos")
	public ResponseEntity<List<Matricula>> listarCursosDoAluno(@PathVariable Long id) {
		List<Matricula> matriculas = matriculaService.listarMatriculasPorAluno(id);
		return ResponseEntity.ok(matriculas);
	}
}
