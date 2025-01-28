package com.course.application.mapper;

import com.course.application.dto.aluno.AlunoInsertDto;
import com.course.application.dto.aluno.AlunoUpdateDto;
import com.course.domain.model.Aluno;

public class AlunoMapper {

	public static Aluno convertAlunoInsertDtoToAluno(AlunoInsertDto alunoDto) {
		Aluno aluno = new Aluno();
		aluno.setNome(alunoDto.getNome());
		return aluno;
	}

	public static Aluno convertAlunoUpdateDtoToAluno(AlunoUpdateDto alunoDto) {
		Aluno aluno = new Aluno();
		aluno.setId(alunoDto.getId());
		aluno.setNome(alunoDto.getNome());
		return aluno;
	}
}
