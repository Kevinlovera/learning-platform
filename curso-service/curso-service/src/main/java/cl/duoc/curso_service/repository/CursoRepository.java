package cl.duoc.curso_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.duoc.curso_service.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

}
