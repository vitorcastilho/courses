package com.course.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.domain.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
