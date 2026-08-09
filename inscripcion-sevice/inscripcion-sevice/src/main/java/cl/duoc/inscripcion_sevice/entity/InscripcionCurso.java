
package cl.duoc.inscripcion_sevice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "INSCRIPCION_CURSO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InscripcionCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "INSCRIPCION_ID", nullable = false)
    private Inscripcion inscripcion;

    @Column(name = "CURSO_ID", nullable = false)
    private Long cursoId;
}