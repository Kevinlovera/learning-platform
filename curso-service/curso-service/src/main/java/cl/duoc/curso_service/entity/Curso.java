package cl.duoc.curso_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CURSO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "INSTRUCTOR", nullable = false)
    private String instructor;

    @Column(name = "DURACION", nullable = false)
    private String duracion;

    @Column(name = "COSTO", nullable = false)
    private Double costo;
}