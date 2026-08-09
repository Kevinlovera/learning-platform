package cl.duoc.inscripcion_sevice.repository;
import cl.duoc.inscripcion_sevice.entity.Inscripcion;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

}
