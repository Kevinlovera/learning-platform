package cl.duoc.inscripcion_sevice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "INSCRIPCION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ESTUDIANTE", nullable = false)
    private String estudiante;

    @Column(name = "FECHA_INSCRIPCION")
    private LocalDate fechaInscripcion;

    @Column(name = "TOTAL", nullable = false)
    private Double total;
}
