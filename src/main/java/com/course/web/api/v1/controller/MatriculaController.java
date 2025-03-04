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

import com.course.application.dto.matricula.MatriculaInsertDto;
import com.course.application.dto.matricula.MatriculaResponseDto;
import com.course.application.dto.matricula.MatriculaUpdateDto;
import com.course.application.service.matricula.IMatriculaService;
import com.course.domain.model.Matricula;

@RestController
@RequestMapping(MatriculaController.API_URL)
public class MatriculaController {

	public static final String API_URL = "/matriculas";

	@Autowired
	private IMatriculaService matriculaService;

	@PostMapping
	public Matricula criarMatricula(@RequestBody MatriculaInsertDto matriculaDto) {
		return matriculaService.cadastrarNovaMatricula(matriculaDto);
	}

	@GetMapping
	public ResponseEntity<List<MatriculaResponseDto>> listarMatriculas() {
		return ResponseEntity.ok(matriculaService.listarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Matricula> buscarMatriculaPorId(@PathVariable Long id) {
		return matriculaService.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Matricula> atualizarMatricula(@PathVariable Long id, @RequestBody MatriculaUpdateDto matriculaDto) {
		return matriculaService.buscarPorId(id).map(matriculaExistente -> {
			matriculaDto.setId(id);
			return ResponseEntity.ok(matriculaService.atualizarMatricula(matriculaDto));
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarMatricula(@PathVariable Long id) {
		matriculaService.deletar(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/cursos/{id}/media")
	public ResponseEntity<Double> calcularMediaNotasPorCurso(@PathVariable Long id) {
		Double media = matriculaService.calcularMediaNotasPorCurso(id);
		return ResponseEntity.ok(media);
	}
}
