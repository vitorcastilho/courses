package com.course.application.service.curso;

import static com.course.application.mapper.CursoMapper.convertCursoInsertDtoToCurso;
import static com.course.application.mapper.CursoMapper.convertCursoUpdateDtoToCurso;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.course.application.dto.curso.CursoInsertDto;
import com.course.application.dto.curso.CursoResponseDto;
import com.course.application.dto.curso.CursoUpdateDto;
import com.course.domain.model.Curso;
import com.course.infrastructure.repository.CursoRepository;

@Service
public class CursoService implements ICursoService {

	@Autowired
	private CursoRepository cursoRepository;

	public ResponseEntity<List<CursoResponseDto>> listarTodos() {
		List<Curso> cursos = cursoRepository.findAll();
		List<CursoResponseDto> cursosDto = cursos.stream().map(curso -> new CursoResponseDto(curso))
				.collect(Collectors.toList());
		return ResponseEntity.ok(cursosDto);
	}

	public Optional<Curso> buscarPorId(Long id) {
		return cursoRepository.findById(id);
	}

	public Curso cadastrarNovoCurso(CursoInsertDto cursoDto) {
		return cursoRepository.save(convertCursoInsertDtoToCurso(cursoDto));
	}

	public Curso atualizaCurso(CursoUpdateDto cursoDto) {
		return cursoRepository.save(convertCursoUpdateDtoToCurso(cursoDto));
	}

	public void deletar(Long id) {
		cursoRepository.deleteById(id);
	}
}
