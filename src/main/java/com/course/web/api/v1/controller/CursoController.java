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

import com.course.application.dto.curso.CursoInsertDto;
import com.course.application.dto.curso.CursoResponseDto;
import com.course.application.dto.curso.CursoUpdateDto;
import com.course.application.service.curso.ICursoService;
import com.course.domain.model.Curso;

@RestController
@RequestMapping(CursoController.API_URL)
public class CursoController {

	public static final String API_URL = "/cursos";

	@Autowired
	private ICursoService cursoService;

	@PostMapping
	public Curso criarCurso(@RequestBody CursoInsertDto cursoDto) {
		return cursoService.cadastrarNovoCurso(cursoDto);
	}

	@GetMapping
	public ResponseEntity<List<CursoResponseDto>> listarCursos() {
		return cursoService.listarTodos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Curso> buscarCursoPorId(@PathVariable Long id) {
		return cursoService.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Curso> atualizarCurso(@PathVariable Long id, @RequestBody CursoUpdateDto cursoDto) {
		return cursoService.buscarPorId(id).map(cursoExistente -> {
			cursoDto.setId(id);
			return ResponseEntity.ok(cursoService.atualizaCurso(cursoDto));
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarCurso(@PathVariable Long id) {
		cursoService.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
