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

import com.course.application.dto.curso.CursoInsertDto;
import com.course.application.dto.curso.CursoResponseDto;
import com.course.application.dto.curso.CursoUpdateDto;
import com.course.application.service.curso.ICursoService;

@RestController
@RequestMapping(CursoController.API_URL)
public class CursoController {

	public static final String API_URL = "/cursos";

	@Autowired
	private ICursoService cursoService;

	@PostMapping
	public ResponseEntity<Long> criarCurso(@RequestBody CursoInsertDto cursoDto) {
		return new ResponseEntity<>(cursoService.cadastrarNovoCurso(cursoDto), CREATED);
	}

	@GetMapping
	public ResponseEntity<List<CursoResponseDto>> listarCursos() {
		return ResponseEntity.ok(cursoService.listarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<CursoResponseDto> buscarCursoPorId(@PathVariable Long id) {
		return ResponseEntity.ok(cursoService.buscarPorId(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<CursoResponseDto> atualizarCurso(@PathVariable Long id,
			@RequestBody CursoUpdateDto cursoDto) {
		cursoDto.setId(id);
		return ResponseEntity.ok(cursoService.atualizaCurso(cursoDto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarCurso(@PathVariable Long id) {
		cursoService.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
