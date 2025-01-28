package com.course.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.domain.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
