package com.course.application.service.curso;

import static com.course.application.mapper.CursoMapper.convertCursoInsertDtoToCurso;
import static com.course.application.mapper.CursoMapper.convertCursoUpdateDtoToCurso;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.application.dto.curso.CursoInsertDto;
import com.course.application.dto.curso.CursoResponseDto;
import com.course.application.dto.curso.CursoUpdateDto;
import com.course.domain.model.Curso;
import com.course.infrastructure.Exception.ResourceNotFoundException;
import com.course.infrastructure.Exception.ValidationException;
import com.course.infrastructure.repository.CursoRepository;

@Service
public class CursoService implements ICursoService {

	@Autowired
	private CursoRepository cursoRepository;

	public List<CursoResponseDto> listarTodos() {
		List<Curso> cursos = cursoRepository.findAll();
		List<CursoResponseDto> cursosDto = cursos.stream().map(curso -> new CursoResponseDto(curso))
				.collect(Collectors.toList());
		return cursosDto;
	}

	public CursoResponseDto buscarPorId(Long id) {
		Curso curso = cursoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado com id: ".concat(id.toString()),
						"Curso não encontrado. Favor verificar o id fornecido."));
		return new CursoResponseDto(curso);
	}

	public Long cadastrarNovoCurso(CursoInsertDto cursoDto) {
		Curso curso = cursoRepository.save(convertCursoInsertDtoToCurso(cursoDto));
		return curso.getId();
	}

	public CursoResponseDto atualizaCurso(CursoUpdateDto cursoDto) {
		if (cursoDto.getId() == null) {
			throw new ValidationException("O id do curso é obrigatório.",
					"Para atualizar o curso, é obrigatório informar o id do curso.");
		}
		cursoRepository.findById(cursoDto.getId())
				.orElseThrow(() -> new ResourceNotFoundException(
						"Curso não encontrado com id: ".concat(cursoDto.getId().toString()),
						"Curso não encontrado. Favor verificar o id fornecido."));

		return new CursoResponseDto(cursoRepository.save(convertCursoUpdateDtoToCurso(cursoDto)));
	}

	public void deletar(Long id) {
		cursoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado com id: ".concat(id.toString()),
						"Curso não encontrado. Favor verificar o id fornecido."));
		cursoRepository.deleteById(id);
	}
}
