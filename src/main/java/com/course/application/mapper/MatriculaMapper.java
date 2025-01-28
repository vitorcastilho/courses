package com.course.application.mapper;

import com.course.application.dto.matricula.MatriculaInsertDto;
import com.course.application.dto.matricula.MatriculaUpdateDto;
import com.course.domain.model.Matricula;

public class MatriculaMapper {

	public static Matricula convertMatriculaInsertDtoToMatricula(MatriculaInsertDto matriculaDto) {
		Matricula matricula = new Matricula();
		matricula.setAluno(matriculaDto.getAluno());
		matricula.setCurso(matriculaDto.getCurso());
		matricula.setNota(matriculaDto.getNota());
		return matricula;
	}

	public static Matricula convertMatriculaUpdateDtoToMatricula(MatriculaUpdateDto matriculaDto) {
		Matricula matricula = new Matricula();
		matricula.setId(matriculaDto.getId());
		matricula.setAluno(matriculaDto.getAluno());
		matricula.setCurso(matriculaDto.getCurso());
		matricula.setNota(matriculaDto.getNota());
		return matricula;
	}

}
