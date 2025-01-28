package com.course.infrastructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.course.domain.model.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

	List<Matricula> findByAlunoId(Long alunoId);

    @Query("SELECT AVG(m.nota) FROM Matricula m WHERE m.curso.id = :cursoId")
    Double calcularMediaNotasPorCurso(@Param("cursoId") Long cursoId);
}
