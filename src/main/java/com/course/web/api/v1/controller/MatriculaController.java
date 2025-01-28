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

import com.course.application.dto.matricula.MatriculaInsertDto;
import com.course.application.dto.matricula.MatriculaResponseDto;
import com.course.application.dto.matricula.MatriculaUpdateDto;
import com.course.application.service.matricula.IMatriculaService;

@RestController
@RequestMapping(MatriculaController.API_URL)
public class MatriculaController {

	public static final String API_URL = "/matriculas";

	@Autowired
	private IMatriculaService matriculaService;

	@PostMapping
	public ResponseEntity<Long> criarMatricula(@RequestBody MatriculaInsertDto matriculaDto) {
		return new ResponseEntity<>(matriculaService.cadastrarNovaMatricula(matriculaDto), CREATED);
	}

	@GetMapping
	public ResponseEntity<List<MatriculaResponseDto>> listarMatriculas() {
		return ResponseEntity.ok(matriculaService.listarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<MatriculaResponseDto> buscarMatriculaPorId(@PathVariable Long id) {
		return ResponseEntity.ok(matriculaService.buscarPorId(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<MatriculaResponseDto> atualizarMatricula(@PathVariable Long id,
			@RequestBody MatriculaUpdateDto matriculaDto) {
		matriculaDto.setId(id);
		return ResponseEntity.ok(matriculaService.atualizarMatricula(matriculaDto));
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
