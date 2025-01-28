package com.course.application.service.aluno;

import static com.course.application.mapper.AlunoMapper.convertAlunoInsertDtoToAluno;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.application.dto.aluno.AlunoInsertDto;
import com.course.application.dto.aluno.AlunoResponseDto;
import com.course.application.dto.aluno.AlunoUpdateDto;
import com.course.domain.model.Aluno;
import com.course.infrastructure.Exception.ResourceNotFoundException;
import com.course.infrastructure.Exception.ValidationException;
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

	public AlunoResponseDto buscarPorId(Long id) {
		Aluno aluno = alunoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado com id: ".concat(id.toString()),
						"Aluno não encontrado. Favor verificar o id fornecido."));
		return new AlunoResponseDto(aluno);
	}

	public Long cadastrarNovoAluno(AlunoInsertDto alunoDto) {
		Aluno aluno = alunoRepository.save(convertAlunoInsertDtoToAluno(alunoDto));
		return aluno.getId();
	}

	public AlunoResponseDto atualizarAluno(AlunoUpdateDto alunoDto) {
		if (alunoDto.getId() == null) {
			throw new ValidationException("O id do aluno é obrigatório.",
					"Para atualizar o aluno, é obrigatório informar o id do aluno.");
		}
		Aluno aluno = alunoRepository.findById(alunoDto.getId())
				.orElseThrow(() -> new ResourceNotFoundException(
						"Aluno não encontrado com id: ".concat(alunoDto.getId().toString()),
						"Aluno não encontrado. Favor verificar o id fornecido."));
		aluno.setNome(alunoDto.getNome());
		return new AlunoResponseDto(alunoRepository.save(aluno));
	}

	public void deletar(Long id) {
		alunoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado com id: ".concat(id.toString()),
						"Aluno não encontrado. Favor verificar o id fornecido."));
		alunoRepository.deleteById(id);
	}
}
