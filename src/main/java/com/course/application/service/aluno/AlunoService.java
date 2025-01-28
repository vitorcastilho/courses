package com.course.application.service.aluno;

import static com.course.application.mapper.AlunoMapper.convertAlunoInsertDtoToAluno;
import static com.course.application.mapper.AlunoMapper.convertAlunoUpdateDtoToAluno;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.application.dto.aluno.AlunoInsertDto;
import com.course.application.dto.aluno.AlunoResponseDto;
import com.course.application.dto.aluno.AlunoUpdateDto;
import com.course.domain.model.Aluno;
import com.course.infrastructure.repository.AlunoRepository;

@Service
public class AlunoService implements IAlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	public List<AlunoResponseDto> listarTodos() {
		List<Aluno> alunos = alunoRepository.findAll();
		List<AlunoResponseDto> alunosDto = alunos.stream().map(aluno -> new AlunoResponseDto(aluno))
				.collect(Collectors.toList());
		return alunosDto;
	}

	public Optional<Aluno> buscarPorId(Long id) {
		return alunoRepository.findById(id);
	}

	public Aluno cadastrarNovoAluno(AlunoInsertDto alunoDto) {
		return alunoRepository.save(convertAlunoInsertDtoToAluno(alunoDto));
	}

	public Aluno atualizarAluno(AlunoUpdateDto alunoDto) {
		return alunoRepository.save(convertAlunoUpdateDtoToAluno(alunoDto));
	}

	public void deletar(Long id) {
		alunoRepository.deleteById(id);
	}
}
