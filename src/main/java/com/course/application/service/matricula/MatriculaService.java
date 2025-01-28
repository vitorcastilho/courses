package com.course.application.service.matricula;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.application.dto.matricula.MatriculaInsertDto;
import com.course.application.dto.matricula.MatriculaResponseDto;
import com.course.application.dto.matricula.MatriculaUpdateDto;
import com.course.application.mapper.MatriculaMapper;
import com.course.domain.model.Matricula;
import com.course.infrastructure.repository.MatriculaRepository;

@Service
public class MatriculaService implements IMatriculaService {

	@Autowired
	private MatriculaRepository matriculaRepository;

	public List<MatriculaResponseDto> listarTodos() {
		List<Matricula> matriculas = matriculaRepository.findAll();
		List<MatriculaResponseDto> matriculasDto = matriculas.stream()
				.map(matricula -> new MatriculaResponseDto(matricula)).collect(Collectors.toList());
		return matriculasDto;
	}

	public Optional<Matricula> buscarPorId(Long id) {
		return matriculaRepository.findById(id);
	}

	public Matricula cadastrarNovaMatricula(MatriculaInsertDto matriculaDto) {
		return matriculaRepository.save(MatriculaMapper.convertMatriculaInsertDtoToMatricula(matriculaDto));
	}

	public Matricula atualizarMatricula(MatriculaUpdateDto matriculaDto) {
		return matriculaRepository.save(MatriculaMapper.convertMatriculaUpdateDtoToMatricula(matriculaDto));
	}

	public void deletar(Long id) {
		matriculaRepository.deleteById(id);
	}

	public List<Matricula> listarMatriculasPorAluno(Long alunoId) {
		return matriculaRepository.findByAlunoId(alunoId);
	}

	public Double calcularMediaNotasPorCurso(Long cursoId) {
		return matriculaRepository.calcularMediaNotasPorCurso(cursoId);
	}
}
