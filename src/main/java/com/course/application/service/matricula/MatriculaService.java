package com.course.application.service.matricula;

import static com.course.application.mapper.MatriculaMapper.convertMatriculaUpdateDtoToMatricula;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.application.dto.matricula.MatriculaInsertDto;
import com.course.application.dto.matricula.MatriculaResponseDto;
import com.course.application.dto.matricula.MatriculaUpdateDto;
import com.course.application.mapper.MatriculaMapper;
import com.course.domain.model.Matricula;
import com.course.infrastructure.Exception.ResourceNotFoundException;
import com.course.infrastructure.Exception.ValidationException;
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

	public MatriculaResponseDto buscarPorId(Long id) {
		Matricula matricula = matriculaRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Matricula não encontrada com id: ".concat(id.toString()),
						"Matrícula não encontrada. Favor verificar o id fornecido."));
		return new MatriculaResponseDto(matricula);
	}

	public Long cadastrarNovaMatricula(MatriculaInsertDto matriculaDto) {
		Matricula matricula = matriculaRepository
				.save(MatriculaMapper.convertMatriculaInsertDtoToMatricula(matriculaDto));
		return matricula.getId();
	}

	public MatriculaResponseDto atualizarMatricula(MatriculaUpdateDto matriculaDto) {
		if (matriculaDto.getId() == null) {
			throw new ValidationException("O id da matrícula é obrigatório.",
					"Para atualizar a matrícula, é obrigatório informar o id da matrícula.");
		}
		matriculaRepository.findById(matriculaDto.getId())
				.orElseThrow(() -> new ResourceNotFoundException(
						"Matrícula não encontrado com id: ".concat(matriculaDto.getId().toString()),
						"Matrícula não encontrado. Favor verificar o id fornecido."));
		return new MatriculaResponseDto(matriculaRepository.save(convertMatriculaUpdateDtoToMatricula(matriculaDto)));
	}

	public void deletar(Long id) {
		matriculaRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Matricula não encontrada com id: ".concat(id.toString()),
						"Matrícula não encontrada. Favor verificar o id fornecido."));
		matriculaRepository.deleteById(id);
	}

	public List<MatriculaResponseDto> listarMatriculasPorAluno(Long alunoId) {
		List<Matricula> matriculas = matriculaRepository.findByAlunoId(alunoId);
		List<MatriculaResponseDto> matriculasDto = matriculas.stream()
				.map(matricula -> new MatriculaResponseDto(matricula)).collect(Collectors.toList());
		return matriculasDto;
	}

	public Double calcularMediaNotasPorCurso(Long cursoId) {
		return matriculaRepository.calcularMediaNotasPorCurso(cursoId);
	}
}
